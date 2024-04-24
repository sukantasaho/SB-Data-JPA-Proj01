package com.main.repository;
import org.springframework.data.repository.CrudRepository;
import com.main.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> 
{

}
