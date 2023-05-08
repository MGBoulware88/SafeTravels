package com.gray.safetravels.models;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="expenses")
public class Expense {
	/*
	 ********************************
	 *************FIELDS*************
	 ********************************
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
	@NotBlank(message="Expense Name is required!")
	private String name;
	@NotNull
	@NotBlank(message="Vendor Name is required!")
	private String vendor;
	@NotNull
	@NotBlank(message="Amount is required!")
	@DecimalMin(value="0.01", message="Amount must be greater than 0!")
	private double amount;
	@NotNull
	@NotBlank(message="Description is required!")
	private String description;
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	/*
	 ********************************
	 **********CONSTRUCTORS**********
	 ********************************
	 */
	//Java Bean! --don't use please!!
	public Expense() {}
	//Use this one instead :)
	public Expense(String name, String vendor, double amount) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
	}
	/*
	 ********************************
	 ********GETTERS & SETTERS*******
	 ********************************
	 */
	@PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
}
