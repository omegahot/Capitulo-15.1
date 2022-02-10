package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number:");
		int number = sc.nextInt();
		System.out.print("Check-In: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out: ");
		Date checkOut = sdf.parse(sc.next());
		
		if (checkIn.after(checkOut)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Resevation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-In: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out: ");
			checkOut = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkIn, checkOut);
			
			if (error != null) {
				System.out.println(error);
			} 
			else {
				System.out.println("Resevation: " + reservation);
			}
			
			
		}
		
		sc.close();

	}

}
