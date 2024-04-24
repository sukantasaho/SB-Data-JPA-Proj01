package com.main.services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.entity.Doctor;
import com.main.repository.DoctorRepository;

@Service("doctorService")
public class DoctorServiceImp implements IDoctorService 
{
	@Autowired
    private DoctorRepository docRepository;
	
	/* Before creating single record first checking is this record already exist or not if not than create */
	@Override
	public String createSingleDoctorRecord(Doctor doctor) 
	{ 
		 return docRepository.save(doctor).getDocId()+"  Record is inserted successfully";
	}

//	Creating Bulk of doctor records service
	@Override
	public String createMultipleDoctorRecords(List<Doctor> doctorList) 
	{
		   List<Doctor> dList = (List<Doctor>) docRepository.saveAll(doctorList);
		   List<Integer> idList = dList.stream().map(id->id.getDocId()).collect(Collectors.toList());
		   
		return "Bulk of doctor record is created with the following ids: "+idList;
	}

	@Override
	public Optional<Doctor> getSingleDoctor(Integer id) 
	{
		 return docRepository.findById(id);
	}

	@Override
	public boolean doctorExistOrNot(Integer id) 
	{
		 boolean isExist = false;
		 isExist = docRepository.existsById(id);
		 
		return isExist;
	}

	@Override
	public List<Doctor> getAllDoctors() 
	{
		
		return (List<Doctor>) docRepository.findAll();
	}

	@Override
	public List<Doctor> getAllDoctorByIds(List<Integer> ids) 
	{  
		
		return (List<Doctor>) docRepository.findAllById(ids);
	}

	@Override
	public Long countDoctorRecords()
	{
		 
		return docRepository.count();
	}

	@Override
	public String removeDoctorById(Integer id) 
	{
		     boolean isExist = docRepository.existsById(id);
		     String status = null;
		     if(isExist == true)
		     {
		    	 docRepository.deleteById(id);
		    	 status = "Record is deleted with the id-"+id;
		     }
		     else
		    	 status = "Record is not existed";
		     
		return status;
	}

	@Override
	public String removeAllDoctorByIds(List<Integer> ids) 
	{
		      List<Doctor> dList = (List<Doctor>) docRepository.findAllById(ids);
		      docRepository.deleteAllById(ids);
		      
		return dList.size()+"-no of records are deleted";
	}

	@Override
	public String removeDoctorByEntity(Doctor doctor) 
	{
		Optional<Doctor> opt = docRepository.findById(doctor.getDocId());
		if(opt.isPresent())
		{
			docRepository.delete(opt.get());
			
			return doctor.getDocId()+"-Doctor Found and Deleted";
		}
		else
		{
			return doctor.getDocId()+"-Doctor is not found";
		}
		 
	}
	
	
	
	
	

}
