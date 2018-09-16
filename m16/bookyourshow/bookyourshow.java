/**
 * Class for book yourshow.
 */
public class BookyourShow {
    Show[] showslist;
    int size;
    /**
     * Constructs the object.
     */
    BookyourShow() {
        showslist = new Show[10];
        size = 0;
    }
    /**
     * Adds a show.
     *
     * @param      sh   The object
     */
    public void addAShow(final Show sh) {
        showslist[size] = sh;
        size++;
    }
    /**
     * Gets a show.
     *
     * @param      moviename  The moviename
     * @param      datetime   The datetime
     *
     * @return     A show.
     */
    public Show getAShow(final String moviename, final String datetime) {
        for (int i = 0; i < size; i++) {
            if (showslist[i] != null) {
                if (showslist[i].moviename.equals(moviename) && showslist[i].dateandTime.equals(datetime)) {
                    return showslist[i];
                }
            }
        }
        return null;
    }
    /**
     * { function_description }
     *
     * @param      moviename  The argmoviename
     * @param      datetime   The argdatetime
     * @param      obj           The object
     * @param      seats      The argseats
     */
    public void bookAShow(String moviename, String datetime, Patron obj, String[] seats) {
        if (size == 0) {
            System.out.println("No show");
            return;
        }
        if (getAShow(moviename, datetime) == null) {
            System.out.println("No show");
        }
        for (int i = 0; i < size; i++) {
            if (showslist[i] != null) {
                if (showslist[i].moviename.equals(moviename) && showslist[i].dateandTime.equals(datetime)) {
                    for (String seatnum : seats) {
                        for (int j = 0; j < showslist[i].seats.length; j++) {
                            if (showslist[i].seats[j].equals(seatnum)) {
                                showslist[i].seats[j] = "N/A";
                                showslist[i].booked[i] = obj;
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     *
     * @param      moviename  The moviename
     * @param      datetime   The datetime
     * @param      mobilenum     The mobilenum
     */
    public void printTicket(String moviename, String datetime, String mobilenum) {
        boolean res = false;
        for (int i = 0; i < size; i++) {
            if (showslist[i] != null) {
                if (showslist[i].moviename.equals(moviename) && showslist[i].dateandTime.equals(datetime)) {
                    for (int j = 0; j < showslist[i].booked.length; j++) {
                        if (showslist[i].booked[j] != null) {
                            if (showslist[i].booked[j].mobile.equals(mobilenum)) {
                                res = true;
                            }
                        }
                    }
                }
            }
        }
        if (res) {
            System.out.println(mobilenum + " " + moviename + " " + datetime);
        } else {
            System.out.println("Invalid");
        }
    }
    /**
     * Shows all shows.
     */
    public void showAll() {
        for (Show s : showslist) {
            if (s != null) {
                String res = s.moviename + "," + s.dateandTime + ",[";
                for (int i = 0; i < s.seats.length - 1; i++) {
                    res += s.seats[i] + ",";
                }
                res += s.seats[s.seats.length - 1] + "]";
                System.out.println(res);

            }
        }
    }
}