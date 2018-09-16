import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.*;
class Show {
	String movieName;
	String dateTime;
	String[] seats;
	String seatString;
	Show(String movieName, String dateTime, String seats) {
		this.movieName = movieName;
		this.dateTime = dateTime;
		seats = seats.replace("[", "");
		seats = seats.replace("]", "");
		this.seats = seats.split(",");
		}
	String getSeats() {
		seatString = "[";
		for (int i = 0; i < seats.length; i++) {
			if (i == seats.length - 1) {
				seatString += seats[i];
			} else {
				seatString += seats[i] + ",";
			}
		}
		seatString += "]";
		return seatString;
	}

}