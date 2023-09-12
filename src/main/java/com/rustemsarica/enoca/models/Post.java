package com.rustemsarica.enoca.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	

	@Column(columnDefinition="text", nullable=false)
	private String text;
	
	@CreationTimestamp
	private LocalDateTime  createdAt;	
	
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id=id;		
	}
	
	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text=text;		
	}
	
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user=user;		
	}
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt=createdAt;		
	}

}
