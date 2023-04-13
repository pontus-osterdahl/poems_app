package com.example.poems_app.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    
    @Column(unique = true)
    private String email; 
    
    private byte[] storedHash;
    private byte[] storedSalt;
    
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getStoredHash() {
		return storedHash;
	}
	public void setStoredHash(byte[] storedHash) {
		this.storedHash = storedHash;
	}
	public byte[] getStoredSalt() {
		return storedSalt;
	}
	public void setStoredSalt(byte[] storedSalt) {
		this.storedSalt = storedSalt;
	}
    
}
