package com.rustemsarica.enoca.models;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String username;
	
	
	@CreationTimestamp
	private LocalDateTime  createdAt;
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id=id;		
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username=username;		
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
