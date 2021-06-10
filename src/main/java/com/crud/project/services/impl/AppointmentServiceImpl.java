package com.crud.project.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.project.entities.Appointment;
import com.crud.project.entities.Doctor;
import com.crud.project.entities.Patient;
import com.crud.project.repositories.AppointmentRepository;
import com.crud.project.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
	DoctorServiceImpl doctorServiceImpl;
	@Autowired
	PatientServiceImpl patientServiceImpl;

	public List<Appointment> getAppointments() {
		List<Appointment> listAppointmentsAppointments = new ArrayList<Appointment>();
		appointmentRepository.findAll().forEach(listAppointmentsAppointments::add);
		return listAppointmentsAppointments;
	}

	public String addAppointment(Appointment appointment) {
		Optional <Doctor> doctorOpt = doctorServiceImpl.findDoctorById(appointment.getIdDoctor());
		Optional <Patient> patientOpt = patientServiceImpl.findPatientById(appointment.getIdPatient());
			
		// check if doctor exists
		if (doctorOpt.isEmpty())
			return "Doctor not found. Try again.";
		// check if patient exist
		if (patientOpt.isEmpty())
			return "Patient not found. Try again.";

		Doctor doctorObj = doctorOpt.get();
		
		try {
			if(!isAvailable(appointment, doctorObj.getInitSch(), doctorObj.getEndSch()))
				return "Schedule not available. Try with another hour.";
		} catch (ParseException e) {
			e.printStackTrace();
			return "Something went wrong. Try again.";
		}
		appointmentRepository.save(appointment);
		return "Executed correctly.";
	}

	public String updateAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
		return "";
	}

	public void deleteAppointment(int id) {
		appointmentRepository.deleteById(id);
	}
	
	/**
	 * Check if desiredHour and desiredDate are not in the same hour of the stored 
	 * @param appointment = Appointment object.
	 * @param initSchDoctor = initial schedule's doctor.
	 * @param endSchDoctor = end schedule's doctor.
	 * @return = true if it's avalaible.
	 * @throws ParseException = Handle parse Strings to Date.
	 */
	public boolean isAvailable(Appointment appointment, String initSchDoctor, String endSchDoctor) 
			throws ParseException {		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date desiredDateParseDate = new Date();
		
		String desiredSchedule = appointment.getAssignedSchedule();
		String desiredDate = appointment.getAssignedDate();
		//convert desired dates to int to operate
		int desiredScheduleInt = Integer
				.parseInt(desiredSchedule.split(":")[0] + desiredSchedule.split(":")[1]);
		int initSchDoctorInt = Integer
				.parseInt(initSchDoctor.split(":")[0] + initSchDoctor.split(":")[1]);
		int endSchDoctorInt = Integer
				.parseInt(endSchDoctor.split(":")[0] + endSchDoctor.split(":")[1]);

		boolean onRange = false; // it will define if the desired hour is between the schedule's doctor.

		// if schedule's doctor starts at night
		if (initSchDoctorInt > endSchDoctorInt)
			onRange = !(initSchDoctorInt > desiredScheduleInt && endSchDoctorInt < desiredScheduleInt);
		else
			onRange = !(initSchDoctorInt > desiredScheduleInt || endSchDoctorInt < desiredScheduleInt);

		if (!onRange) // if desiredSchedule is not on range
			return onRange;
		
		AppointmentServiceImpl appointmentAux = new AppointmentServiceImpl();
		List <Appointment> listAppointments = appointmentAux.getAppointments();
		
		desiredDateParseDate = simpleDateFormat.parse(desiredDate);
		
		for (Appointment candidateAppointment : listAppointments) {
			int candidateAssignSchInt = Integer
					.parseInt(candidateAppointment.getAssignedSchedule().split(":")[0] + candidateAppointment.getAssignedSchedule().split(":")[1]);

			String candidateSchDate = candidateAppointment.getAssignedDate();

			Date candidateAssignDate = new Date();
			candidateAssignDate = simpleDateFormat.parse(candidateSchDate);
			// if they're the same day
			if (candidateAssignDate.compareTo(desiredDateParseDate) == 0) {
				if (abs(candidateAssignSchInt - desiredScheduleInt) < 100) // less than one hour
					return false;
			}
		}
		return true;
	}
}
