package com.my.inventory;

import java.util.ArrayList;
import java.util.Iterator;

public class CarInventory {
	
	private ArrayList<Car> carListing  = new ArrayList<Car>();

	public void getInfo() {
		System.out.println("Car Inventory :: Listing");
		System.out.println("------------------------");
		System.out.println();
		System.out.format("%5s%10s%11s%15s","Registration","Make","Model","Colour"); 
		System.out.println();
		
		//carListing = op.readFromFile();
		if (carListing != null) {
			Iterator<Car> iterator = carListing.iterator();
			Car car = null;
			
			// Using iterator
			while (iterator.hasNext()) {
				car = iterator.next();
				if (car.isActive()) {
					System.out.format("%s%21s%15s%15s", 
							car.getiRegistrationNum(), car.getsMake(), car.getsModel(), car.getsColour());
					System.out.println();
				}
			}
		} else {
			System.out.println("No data available...");
		}		
		System.out.println();
		System.out.println("End of List!");
	}
	
	public boolean updateCarInfo(Car carInfo) {		
		boolean result = false;
		//implement update logic
		if (searchCarInfo(carInfo) == true) {
			int n = determineListNumber(carInfo);
			if (n != -1) {
				carListing.set(n, carInfo);
				result = true;
			}
		} else {
			System.out.println("Cannot update! Car Registration number does not exist.");
		}
		return result;
	}
	
	public boolean deleteCarInfo(Car carInfo) {	
		boolean result = false;
		//implement delete logic
		if (searchCarInfo(carInfo) == true) {
			int n = determineListNumber(carInfo);
			if (n != -1) {
				carListing.remove(n);
				result = true;
			}
		} else {
			System.out.println("Cannot delete! Car Registration number does not exist.");
		}
		return result;
	}
	
	public boolean addCarInfo(Car carInfo) {
		boolean result = true;
		//implement add logic
		if (searchCarInfo(carInfo) == false) {
			System.out.println("added");
			carListing.add(carInfo);
		} else {
			System.out.println("Cannot add! Car Registation number already exists.");
			result = false;
		}
		return result;
	}
	
	public boolean displayCarInfo(Car carInfo) {
		boolean result = false;
		
		if (carListing != null) {			
			System.out.println("Car Inventory :: Listing");
			System.out.println("------------------------");
			System.out.println();
			System.out.format("%5s%10s%11s%15s","Registration","Make","Model","Colour"); 
			System.out.println();
			
			Iterator<Car> iterator = carListing.iterator();
			Car car = null;
			
			// Using iterator
			while (iterator.hasNext()) {
				car = iterator.next();
				if (car.getiRegistrationNum() == carInfo.getiRegistrationNum()) {
					System.out.format("%s%21s%15s%15s", 
							car.getiRegistrationNum(), car.getsMake(), car.getsModel(), car.getsColour());
					System.out.println();
					result = true;
				}
			}
		}
		
		if (!result) {
			System.out.println("Cannot display info! Car Registration number does not exist.");
		}
		return result;
	}
	
	/**
	 * Check if Car model exists already
	 * @param carInfo
	 * @return
	 */
	private boolean searchCarInfo(Car carInfo) {
		boolean result = false;
		//implement search logic
		Iterator<Car> iterator = carListing.iterator();
		Car car = null;
		
		// Using iterator
		while (iterator.hasNext()) {
			car = iterator.next();
			if (car.getiRegistrationNum() == carInfo.getiRegistrationNum()) {
				result = true;
			}
		}
		
		return result;
	}
	
	private int determineListNumber(Car carInfo) {
		// Magic number! Assuming -1 is an invalid Car
		int listNumber = -1;
		Car carTemp;
		int i = 0;
		while (i < carListing.size()) {
			carTemp = carListing.get(i);
			if (carTemp.getiRegistrationNum() == carInfo.getiRegistrationNum()) {
				return i;
			}
			i++;
		}
		
		return listNumber;
	}
	
	public void displayUserMenu() {
		System.out.println("Car Inventory 1.0");
		System.out.println("-----------------");
		System.out.println("[a]dd new car info");
		System.out.println("[r]etrieve car info");
		System.out.println("[u]pdate existing car info");
		System.out.println("[d]elete existing car info");
		System.out.println("[l]ist car inventory");
		System.out.println("[q]uit program");
		System.out.println();
		System.out.println("? ");
	}
}
