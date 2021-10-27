package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) throws FileNotFoundException {
		List<HotelReservation> reservationList = new ArrayList<HotelReservation>();
		File reservationFile = new File("C:\\Users\\Student\\workspace\\tblack-java\\module-1\\Assessment\\java\\data-files\\HotelInput.csv");
		try (Scanner readReservationFile = new Scanner(reservationFile)) {
			while (readReservationFile.hasNextLine()) {
				String line = readReservationFile.nextLine();
				String[] reservationParts = line.split(", ");
				HotelReservation singleReservation = new HotelReservation();
				singleReservation.setName(reservationParts[0]);
				int numNightsAsInt = Integer.parseInt(reservationParts[1]);
				singleReservation.setNumberOfNights(numNightsAsInt);
				reservationList.add(singleReservation);
				//System.out.println(numNightsAsInt);

			}

		} catch(FileNotFoundException e){
			throw e;
		}
		double grandTotal = 0.0;
		for(HotelReservation reservation : reservationList){
				grandTotal += reservation.getEstimatedTotal();
//				reservation.totalPerNight(reservation.getEstimatedTotal());
//				reservation.completeTotal(reservation.getNumberOfNights());
			//System.out.println("Your total is: " + reservation.getEstimatedTotal());

			System.out.println(reservation);
		}
		System.out.println("Grand Total is: " + grandTotal);
	}
}
