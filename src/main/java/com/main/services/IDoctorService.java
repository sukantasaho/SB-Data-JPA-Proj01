package com.main.services;

import java.util.List;
import java.util.Optional;

import com.main.entity.Doctor;

public interface IDoctorService 
{
	  
     public String createSingleDoctorRecord(Doctor doctor);
     public String  createMultipleDoctorRecords(List<Doctor> doctorList);
     public Optional<Doctor> getSingleDoctor(Integer id);
     public boolean doctorExistOrNot(Integer id);
     public List<Doctor> getAllDoctors();
     public List<Doctor> getAllDoctorByIds(List<Integer> ids);
     public Long countDoctorRecords();
     public String removeDoctorById(Integer id);
     public String removeDoctorByEntity(Doctor doctor);
     public String removeAllDoctorByIds(List<Integer> ids);
     
		 
     
    
}
