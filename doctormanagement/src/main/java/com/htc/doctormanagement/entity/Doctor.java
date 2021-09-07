package com.htc.doctormanagement.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "doctordetails")
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7886283983058483798L;
	@Id
	private long doctorId;
	private String doctorName;
	private long appointmentId;
	private LocalDate appointmentDate;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(long doctorId, String doctorName, long appointmentId, LocalDate appointmentDate) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (appointmentId ^ (appointmentId >>> 32));
		result = prime * result + (int) (doctorId ^ (doctorId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (appointmentId != other.appointmentId)
			return false;
		if (doctorId != other.doctorId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", appointmentId=" + appointmentId
				+ ", appointmentDate=" + appointmentDate + "]";
	}
	

}
