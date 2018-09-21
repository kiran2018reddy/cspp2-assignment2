import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
class User implements Comparable<User> {
	private String username;
	private ArrayList<String> userconnections;
	User(String name) {
		this.username = name;
		userconnections = new ArrayList<String>();
	}
	public String getusername() {
		return this.username;
	}
	public ArrayList<String> getconnections() {
		return this.userconnections;
	}
	public int compareTo(User emp) {
		return this.getusername().compareTo(emp.getusername());
	}
}
class Connections {
	ArrayList<User> Users = new ArrayList<User>();
	boolean checkuser(String user) {
		for (int i = 0; i < Users.size(); i++) {
			if (Users.get(i).getusername().equals(user)) {
				return true;
			}
		}
		return false;
	}
	void adduser(String newuser) {
		if (checkuser(newuser)) {
			System.out.println("User already present");
			return;
		}
		User newuserobj = new User(newuser);
		Users.add(newuserobj);
	}
	void addconnections(String user, String connection) {
		if (checkuser(user)) {
			for (int i = 0; i < Users.size(); i++) {
				if (Users.get(i).getusername().equals(user)) {
					if (Users.get(i).getconnections().contains(connection)) {
						System.out.println("You are already Connected");
						return;
					} else {
						Users.get(i).getconnections().add(connection);
						return;
					}
				}
			}
		} else {
			System.out.println("User not in the network");
		}

	}
	ArrayList<String> getuserconnections(String user) {
		for (int i = 0; i < Users.size(); i++) {
			if (Users.get(i).getusername().equals(user)) {
				return Users.get(i).getconnections();
			}
		}
		return null;
	}
	ArrayList<String> getcommonconnections(String user1, String user2) {
		ArrayList<String> commonconnections = new ArrayList<String>(getuserconnections(user1));
		commonconnections.retainAll(getuserconnections(user2));
		return commonconnections;
	}
	void displayingnetwork() {
		Collections.sort(Users);
		for (int i = 0; i < Users.size() - 1; i++) {
			System.out.print(Users.get(i).getusername() + ": ");
			System.out.print(Users.get(i).getconnections() + ", ");
		}
		System.out.print(Users.get(Users.size() - 1).getusername());
		System.out.print(Users.get(Users.size() - 1).getconnections());
		System.out.println();
	}

}
class Solution {
	Solution() {
	}
	public static void main(String[] args) {
		Connections connectionsobj = new Connections();
		try {
			File networkfile = new File("input002.txt");
			Scanner scan = new Scanner(networkfile);
			int createnumber = Integer.parseInt(scan.nextLine().split(" ")[1]);
			for (int z = 0; z < createnumber; z++) {
				String line = scan.nextLine();
				line = line.substring(0, line.length() - 1);
				String[] linesplits = line.split(" is connected to ");
				String[] tokensplits = linesplits[1].split(", ");
				// ArrayList<String> friends = new ArrayList<String>();
				connectionsobj.adduser(linesplits[0]);
				for (int l = 0; l < tokensplits.length; l++) {
					connectionsobj.addconnections(linesplits[0], tokensplits[l]);
				}
			}
			while (scan.hasNext()) {
				String line = scan.nextLine();
				String[] tokens = line.split(" ");
				switch (tokens[0]) {
				case "adduser":
					connectionsobj.adduser(tokens[1]);
					break;
				case "addConnections":
					if (!(connectionsobj.checkuser(tokens[2]))) {
						System.out.println("User not in the network");
						break;
					}
					connectionsobj.addconnections(tokens[1], tokens[2]);
					break;
				case "getConnections":
					if (!(connectionsobj.checkuser(tokens[1]))) {
						System.out.println("User not in the network");
						break;
					}
					System.out.println(connectionsobj.getuserconnections(tokens[1]));
					break;
				case "CommonConnections":
					System.out.println(connectionsobj.getcommonconnections(tokens[1], tokens[2]));
					break;
				case "Network":
					connectionsobj.displayingnetwork();
					break;
				default:
				}
			}
		} catch (IOException io) {
			System.out.println("File not found");
			return;
		}
	}
}