package com.kenfukuyama.examples.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//Domain Model
@Entity // realted to databases
@Table(name="expenses") // table name books
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long id;
	
    @NotNull
    @Size(min = 5, max = 200)
    private String title;
    
    @NotNull
    @Size(min = 5, max = 200,  message = "has to be more than 5 characters")
    private String vendor;
    
    @NotNull
    @Size(min = 1, max = 200,  message = "Descritptionj cant be empty")
    private String description;
    
    @NotNull
    @Min(0)
    private Float amount;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // empty public constructor
    public Expense() {
    }
    
    public Expense(String title, String vendor, String description, Float amount) {
    	this.title = title;
    	this.vendor = vendor;
    	this.description = description;
    	this.amount = amount;
    }
    
    // getter and setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}
    
    
	// before it created
    @PrePersist 
    protected void onCreate(){
        this.createdAt = new Date();
    }
    // before it updates, null at first
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	

}
