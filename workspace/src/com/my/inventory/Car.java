package com.my.inventory;

public class Car {
	
	int iRegistrationNum;
	String sMake;
	String sModel;
	String sColour;
	boolean isActive;

	/*
	 * Constructors - overloaded to support various scenarios 
	 */
	public Car () {
		
	}
	
	public Car (int iRegistration, String sMake, String sModel, String sColour) {
		this.iRegistrationNum = iRegistration;
		this.sMake = sMake;
		this.sModel = sModel;
		this.sColour = sColour;
		this.isActive = true;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the iRegistrationNum
	 */
	public int getiRegistrationNum() {
		return iRegistrationNum;
	}

	/**
	 * @return the sMake
	 */
	public String getsMake() {
		return sMake;
	}

	/**
	 * @return the sModel
	 */
	public String getsModel() {
		return sModel;
	}

	/**
	 * @return the sColour
	 */
	public String getsColour() {
		return sColour;
	}

	/**
	 * @param iRegistrationNum the iRegistrationNum to set
	 */
	public void setiRegistrationNum(int iRegistrationNum) {
		this.iRegistrationNum = iRegistrationNum;
	}

	/**
	 * @param sMake the sMake to set
	 */
	public void setsMake(String sMake) {
		this.sMake = sMake;
	}

	/**
	 * @param sModel the sModel to set
	 */
	public void setsModel(String sModel) {
		this.sModel = sModel;
	}

	/**
	 * @param sColour the sColour to set
	 */
	public void setsColour(String sColour) {
		this.sColour = sColour;
	}
	
	
}
