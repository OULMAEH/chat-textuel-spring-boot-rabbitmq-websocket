package com.chat.User;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRole;
	
	private String role;

	/**
	 * @param idRole
	 * @param role
	 */
	public Role(long idRole, String role) {
		super();
		this.idRole = idRole;
		this.role = role;
	}

	/**
	 * 
	 */
	public Role() {
		super();
	}

	/**
	 * @return the idRole
	 */
	public long getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole the idRole to set
	 */
	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
