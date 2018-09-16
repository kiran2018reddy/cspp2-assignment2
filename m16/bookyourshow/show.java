/**
 * Class for show.
 */
public class Show {
	String moviename;
	String dateandTime;
	String[] seats;
	Patron[] booked;
	/**
	 * Constructs the object.
	 *
	 * @param      argmoviename    The argmoviename
	 * @param      argdateandTime  The argdateand time
	 * @param      argseats        The argseats
	 */
	Show(final String argmoviename, final String argdateandTime, final String[] argseats) {
		moviename = argmoviename;
		dateandTime = argdateandTime;
		seats = argseats;
		booked = new Patron[argseats.length];
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return moviename + "," + dateandTime;
	}
}