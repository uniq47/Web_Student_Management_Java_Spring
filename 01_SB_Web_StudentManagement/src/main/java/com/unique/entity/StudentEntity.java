package com.unique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "STUDENT")
public class StudentEntity {

	@Id
	@Column(name="SNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	 * // @GenericGenerator(name="myGenerator", strategy="increment")
	 * // @GeneratedValue(generator="mygenerator", strategy=GenerationType.AUTO)
	 */
	private int sno;
	@Column(name="SNAME")
	
	private String sname;
	@Column(name="SADD")
	
	private String sadd;
}
