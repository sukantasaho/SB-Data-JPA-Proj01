package com.main.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Jpa_Doctor_Info")
@Data
public class Doctor 
{
	 @Id
	 @SequenceGenerator(name="gen2", sequenceName = "DOCID_SEQ1", initialValue = 20000, allocationSize = 1)
	 @GeneratedValue(generator = "gen2", strategy = GenerationType.SEQUENCE)
	 @Column(name="DOC_ID")
	 private Integer docId;
	 
	 @Column(name="DOC_NAME")
     private String docName;
	 
	 @Column(name="INCOME")
     private Float income;
	 
	 @Column(name="SPECIALIZATION")
     private String specialization;
}
