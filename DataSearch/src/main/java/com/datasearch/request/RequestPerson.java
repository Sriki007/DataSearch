package com.datasearch.request;

import java.math.BigInteger;

/**
* Class to Request body Person.
* @author Srikanth Rp
*/
public class RequestPerson 
{
	/**
     * First Name of a Person.
     */
    private String firstName;
	
	/**
     * Last Name of a Person.
     */
    private String lastName;
	
	/**
     * Mobile number of person.
     */
	private BigInteger mobileNumber;
	
	/**
     * ID number of person.
     */
	private BigInteger idNumber;
	
	/**
     * Physical Address of a Person.
     */
    private final String physicalAddress;
    

	public RequestPerson(String firstName, String lastName, BigInteger mobileNumber, BigInteger idNumber,
			String physicalAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.idNumber = idNumber;
		this.physicalAddress = physicalAddress;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public BigInteger getMobileNumber() {
		return mobileNumber;
	}


	public BigInteger getIdNumber() {
		return idNumber;
	}


	public String getPhysicalAddress() {
		return physicalAddress;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public void setIdNumber(BigInteger idNumber) {
		this.idNumber = idNumber;
	}
}
