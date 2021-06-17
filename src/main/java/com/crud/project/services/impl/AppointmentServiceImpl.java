package com.crud.project.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.lang.Math.abs;
import java.util.ArrayList;
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
	
	/**
	 * Get all records in the database of the appointment table.
	 * @return = All rows registered.
	 */
	public List<Appointment> getAppointments() {
		List<Appointment> listAppointments = new ArrayList<>();
		appointmentRepository.findAll().forEach(listAppointments::add);
		return listAppointments;
	}
	
	/**
	 * Add a new appointment row to the appointment table of the database.
	 * It needs to check if the patient and doctor exists and if the appointment
	 * has the necessary requirements (isSamePatientSameDaySameDoctor).
	 * @param appointment = Appointment object with all the parameters of appointment entity.
	 * @return = String message with the transaction result.
	 */
	public String addAppointment(Appointment appointment) {
		Optional<Doctor> doctorOpt = doctorServiceImpl.findDoctorById(appointment.getIdDoctor());
		Optional<Patient> patientOpt = patientServiceImpl.findPatientById(appointment.getIdPatient());
			
		// check if doctor exists
		if (doctorOpt.isEmpty())
			return "Doctor not found. Try again.";
		// check if patient exist
		if (patientOpt.isEmpty())
			return "Patient not found. Try again.";
		// check if the patient is already registered with the same doctor in the same day
		if (isSamePatientSameDaySameDoctor(appointment))
			return "Patient already registered with the Doctor in the desired date. Try again.";
				
		var doctorObj = doctorOpt.get();
		
		try {
			if(!isAvailable(appointment, doctorObj.getInitSch(), doctorObj.getEndSch()))
				return "Schedule not available. Try with another hour.";
		} catch (ParseException e) {
			return "Something went wrong. Try again.";
		}
		appointmentRepository.save(appointment);
		return "Executed correctly.";
	}

	/**
	 * Update an appointment entity present in the database.
	 * @param appointment = Appointment entity containing all the information about a patient,
	 * a doctor and the date. 
	 */
	public void updateAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
	}
	/**
	 * 
	 */
	public void deleteAppointment(int id) {
		appointmentRepository.deleteById(id);
	}
	
	/**
	 * Check if desiredHour and desiredDate are between the work schedule's doctor and if
	 * the desiredHour has one hour of difference across all the hours stored in the appointment
	 * entity.  
	 * @param appointment = Appointment object that represent the data of an appointment between a doctor
	 * and a patient.
	 * @param initSchDoctor = initial work schedule's doctor.
	 * @param endSchDoctor = end work schedule's doctor.
	 * @return = true if desiredHour can be stored.
	 * @throws ParseException = Handle parse Strings to Date.
	 */
	public boolean isAvailable(Appointment appointment, String initSchDoctor, String endSchDoctor) 
			throws ParseException {		
		var pattern = "yyyy-MM-dd";
		var simpleDateFormat = new SimpleDateFormat(pattern);
		
		String desiredSchedule = appointment.getAssignedSchedule();
		String desiredDate = appointment.getAssignedDate();
		//convert desired dates to int to operate
		var desiredScheduleInt = Integer
				.parseInt(desiredSchedule.split(":")[0] + desiredSchedule.split(":")[1]);
		var initSchDoctorInt = Integer
				.parseInt(initSchDoctor.split(":")[0] + initSchDoctor.split(":")[1]);
		var endSchDoctorInt = Integer
				.parseInt(endSchDoctor.split(":")[0] + endSchDoctor.split(":")[1]);

		var onRange = false; // it will define if the desired hour is between the schedule's doctor.

		// if schedule's doctor starts at night
		if (initSchDoctorInt > endSchDoctorInt)
			onRange = !(initSchDoctorInt > desiredScheduleInt && endSchDoctorInt < desiredScheduleInt);
		else
			onRange = !(initSchDoctorInt > desiredScheduleInt || endSchDoctorInt < desiredScheduleInt);

		if (!onRange) // if desiredSchedule is not on range
			return onRange;
		
		List<Appointment> listAppointments = getAppointments();
		
		var desiredDateParseDate = simpleDateFormat.parse(desiredDate);
		
		for (Appointment candidateAppointment : listAppointments) {
			var candidateAssignSchInt = Integer
					.parseInt(candidateAppointment.getAssignedSchedule().split(":")[0] 
							+ candidateAppointment.getAssignedSchedule().split(":")[1]);

			String candidateSchDate = candidateAppointment.getAssignedDate();

			var candidateAssignDate = simpleDateFormat.parse(candidateSchDate);
			// if they're the same day
			if (candidateAssignDate.compareTo(desiredDateParseDate) == 0 
					&& isLessThanAnHour(candidateAssignSchInt, desiredScheduleInt)) 
					return false;
		}
		return true;
	}
	
	/**
	 * Check if the parameters have less than a hundred of difference (one hour).
	 * @param assignedSchedule = Schedule of the appointment stored. 
	 * @param desiredSchedule = Desired schedule of the appointment to evaluate. 
	 * @return = true if there's a less than 100 of difference.
	 */
	public boolean isLessThanAnHour(int assignedSchedule, int desiredSchedule) {
		return (abs(assignedSchedule - desiredSchedule) < 100);
	}
	
	/**
	 * Check if it exists a record with the same patient, same doctor
	 * in the same day.
	 * @param appointment = appointment = Appointment object that represent the data of an appointment between a doctor
	 * and a patient. 
	 * @return = true if a record was found.
	 */
	public boolean isSamePatientSameDaySameDoctor(Appointment appointment) {
		var idPatient = appointment.getIdPatient();
		var idDoctor = appointment.getIdDoctor();
		String date = appointment.getAssignedDate();
		return appointmentRepository.existsByIdPatientAndIdDoctorAndAssignedDate(idPatient, idDoctor, date);
	}
}