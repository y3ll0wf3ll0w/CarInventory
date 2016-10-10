package com.my.inventory;

import java.util.Scanner;


public class CarInventoryImpl {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CarInventory inventory = new CarInventory();
		Scanner scan = new Scanner(System.in);
		String input = "test";
		Car car;

		// Support for command line arguments
		while (args.length > 0 && !input.equals("q")) {
			try {
				if (args[0].equals("-c") || input.equals("a")) {		
					if (args.length == 5) {						
						car = new Car(Integer.parseInt(args[1]), args[2], args[3], args[4]);
					} else {
						car = userInput();
					}				
					inventory.addCarInfo(car);
				} else if (args[0].equals("-r") || input.equals("r")) {
					car = new Car();
					car.setiRegistrationNum(Integer.parseInt(args[1]));
					inventory.displayCarInfo(car);
				} else if (args[0].equals("-u") || input.equals("u")) {
					car = userInput();
					inventory.updateCarInfo(car);
				} else if (args[0].equals("-d") || input.equals("d")) {
					car = new Car();	
					car.setiRegistrationNum(Integer.parseInt(args[1]));				
					inventory.deleteCarInfo(car);
				} else if (args[0].equals("-l") || input.equals("l")) {
					inventory.getInfo();		
				} else {
					displayAPI();
				}
				
				inventory.displayUserMenu();
				input = scan.next();

				if (input.equals("a")) args[0] = "-c";
				if (input.equals("r")) args[0] = "-r";
				if (input.equals("u")) args[0] = "-u";
				if (input.equals("d")) args[0] = "-d";
				if (input.equals("l")) args[0] = "-l";
				
			} catch (Exception e) {
				System.out.println("Errors found! Please try again.");
				System.exit(0);
			}
		}
		
		while(!input.equals("q") && args.length == 0) {
			inventory.displayUserMenu();
			input = scan.next();
			
			if (input.equals("a")) {
				car = userInput();
				inventory.addCarInfo(car);
			} else if (input.equals("r")) {
				Scanner scan2 = new Scanner(System.in);
				car = new Car();					
				System.out.println("Registration Num >> ");
				car.setiRegistrationNum(scan2.nextInt());
				inventory.displayCarInfo(car);
			} else if (input.equals("u")) {
				car = userInput();
				inventory.updateCarInfo(car);
			} else if (input.equals("d")) {
				Scanner scan3 = new Scanner(System.in);
				car = new Car();					
				System.out.println("Registration Num >> ");
				car.setiRegistrationNum(scan3.nextInt());				
				inventory.deleteCarInfo(car);
			} else if (input.equals("l")) {
				inventory.getInfo();
			} 
		}
	}
	
	
	private static Car userInput() {
		Scanner scan = new Scanner(System.in);
		Car carInfo = new Car();
		
		System.out.println("Registration Num >> ");
		carInfo.setiRegistrationNum(scan.nextInt());
		
		System.out.println("Make >> ");
		carInfo.setsMake(scan.next());
		
		System.out.println("Model >> ");
		carInfo.setsModel(scan.next());
		
		System.out.println("Colour >> ");
		carInfo.setsColour(scan.next());
		
		carInfo.setActive(true);
		
		return carInfo;
	}
	
	private static void displayAPI() {
		System.out.println("CarInventory :: Please specify correct arguments!");
		System.out.println("CarInventoryImpl [-c -r -u -d -l]");
		System.out.println("-c <registrationNumber> <make> <model> <colour>  To add new CarInfo");
		System.out.println("-r <registrationNumber> To display a single Car Info data");
		System.out.println("-u <registrationNumber> To update a single Car Info data");
		System.out.println("-d <registrationNumber> To delete a single Car Info data");
		System.out.println("-l To List Car Inventory List");
		System.out.println();
		System.out.println();
	}

}
