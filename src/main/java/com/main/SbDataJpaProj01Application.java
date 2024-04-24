package com.main;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.main.entity.Doctor;
import com.main.services.IDoctorService;

@SpringBootApplication
public class SbDataJpaProj01Application 
{

	public static void main(String[] args) 
	{
		    ApplicationContext ctx = SpringApplication.run(SbDataJpaProj01Application.class, args);
		    IDoctorService service = ctx.getBean("doctorService", IDoctorService.class);
		    
		    //creating single doctor record by using CrudRepository save() method
			/*Doctor d = new Doctor();
			d.setDocName("Dr Burma");
			d.setIncome(33000f);
			d.setSpecialization("Surgery Specialist");
			System.out.println(service.createSingleDoctorRecord(d));*/
		    
		    
			/*Bulk record inserting*/
			
			Doctor d1 = new Doctor();
			d1.setDocName("FK Jena");
			d1.setIncome(43000f);
			d1.setSpecialization("Cycology");
			
			
			Doctor d2 = new Doctor();
			d2.setDocName("GK");
			d2.setIncome(23000f);
			d2.setSpecialization("Dermitology");
			
			
			Doctor d3 = new Doctor();
			d3.setDocName("HK Sahoo");
			d3.setIncome(56000f);
			d3.setSpecialization("Nurology");
			
			System.out.println(service.createMultipleDoctorRecords(List.of(d1,d2,d3)));
		    
		    //fetch single doctor record
			/*Optional<Doctor> d = service.getSingleDoctor(10042);
			if(d.isPresent())
			   System.out.println(d.get().getDocId()+"  "+d.get().getDocName()+"  "+d.get().getIncome()+"  "+d.get().getSpecialization());
			else
			 System.out.println("Doctor record is not exist");*/
		    
		    //checking doctor record is exist or not
			/*System.out.println( service.doctorExistOrNot(10042));*/
		    
		    //fetch multiple doctor records
			/*service.getAllDoctors().forEach(d->System.out.println(d.getDocId()+"  "+d.getDocName()+"  "+d.getIncome()));*/
		   
		    //fetch doctor records based on ids
			/*service.getAllDoctorByIds(List.of(10040,10041,10042,10043)).forEach(d->System.out.println(d.getDocId()+"  "+d.getDocName()));*/
		   
		    //count total doctor record
			/*System.out.println("Total Doctor Records : "+service.countDoctorRecords());*/
		    
		    //delete single record by passing id
			/*System.out.println( service.removeDoctorById(10089));*/
		    
		    //delete doctor record by entity
			/*Doctor d = new Doctor();
			d.setDocId(20001);
			d.setDocName("Dr Burma");
			d.setIncome(33000f);
			System.out.println(service.removeDoctorByEntity(d));*/
		    
		    //delete multiple doctor records
			/*System.out.println(service.removeAllDoctorByIds(List.of(1,2)));*/
		    
		    ((ConfigurableApplicationContext) ctx).close();
		    
	}

}
