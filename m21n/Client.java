import java.util.Scanner;
class Food {
	private String foodItem;
	private String quantity;
	private String time;
	private String date;
	public Food(String i, String q, String d, String t) {
		this.foodItem = i;
		this.quantity = q;
		this.time = t;
		this.date = d;
	}
	public String getFoodItem() {
		return this.foodItem;
	}
	public String getQuantity() {
		return this.quantity;
	}
	public String getTime() {
		return this.time;
	}
	public String getDate() {
		return this.date;
	}
	public String toString() {
		System.out.println("Food");
		return "Date:" + getDate() +"\n" + "Time:" + getTime() +"\n"+ "Name:" + getFoodItem() + "\n" + "Quantity:" + getQuantity()+"\n";
	}
}
class Water {
	private String quantity;
	private String date;
	private String time;
	public Water(String qua, String d, String t) {
		this.quantity = qua;
		this.date = d;
		this.time = t;
	}
	public String getWaterQuantity() {
		return this.quantity;
	}
	public String getWaterDate() {
		return this.date;
	}
	public String getWaterTime() {
		return this.time;
	}
	public String toStringWater() {
		System.out.println("Water");
		return "Date:" + getWaterDate() +"\n"+ "Quantity:" + getWaterQuantity()+"\n";
	}
}
class PhysicalActivity {
	private String activityName;
	private String startTime;
	private String endTime;
	private String notes;
	private String date;
	public PhysicalActivity(String a, String notes, String d, String s,String e) {
		this.activityName = a;
		this.notes = notes;
		this.date = d;
		this.startTime = s;
		this.endTime = e;
	}
	public String getActivityName() {
		return this.activityName;
	}
	public String getStartTime() {
		return this.startTime;
	}
	public String getEndTime() {
		return this.endTime;
	}
	public String getNotes() {
		return this.notes;
	}
	public String getActivityDate() {
		return this.date;
	}
	public String toStringActivity() {
		System.out.println("PhysicalActivity");
		return "Name:" + getActivityName() + "\n"  + "Notes:" +getNotes() + "\n" + "Date:" +  getActivityDate() +"\n"+ "Starttime:"+ getStartTime() + "\n" +"Endtime:"+getEndTime()+"\n";
	}
}
class Weight {
	private String date;
	private String time;
	private String kg;
	private String fat;
	public Weight(String d,String t, String k, String f) {
		this.date = d;
		this.time = t;
		this.kg = k;
		this.fat = f;
	}
	public String getWeightDate() {
		return this.date;
	}
	public String getWeigthTime() {
		return this.time;
	}
	public String getKg() {
		return this.kg;
	}
	public String getFat() {
		return this.fat;
	}
	public String toStringWeight() {
		System.out.println("Weight");
		return "Date:" + getWeightDate() +"\n" + "Time" + getWeigthTime() + "\n" + "Weight:" + getKg() + "\n" + "Fat:"+ getFat()+"\n";
	}
}
class Sleep {
	private String date;
	private String start;
	private String end;
	public Sleep(String d, String s, String e) {
		this.date = d;
		this.start = s;
		this.end = e;
	}
	public String getSleepDate() {
		return this.date;
	}
	public String getSleepStart() {
		return this.start;
	}
	public String getSleepEnd() {
		return this.end;
	}
	public String toStringSleep() {
		System.out.println("Sleep");
		return "Date:" + getSleepDate()+"\n" +"Starttime:" + getSleepStart() + "\n" + "Endtime:" + getSleepEnd()+"\n";
	}
}
class DailyTracker {
	private List<Food>foodList;
	private List<Water>waterList;
	private List<PhysicalActivity>activityList;
	private List<Weight>weightList;
	private List<Sleep>sleepList;
	public DailyTracker() {
		foodList = new List<Food>();
		waterList = new List<Water>();
		activityList = new List<PhysicalActivity>();
		weightList = new List<Weight>();
		sleepList = new List<Sleep>();
	}
	public void addFood(Food item) {
		foodList.add(item);
		}
	public void addWater(Water waterObj) {
		waterList.add(waterObj);
	}
	public void addActivity(PhysicalActivity activityObj) {
		activityList.add(activityObj);
	}
	public void addWeight(Weight wtObj) {
		weightList.add(wtObj);
	}
	public void addSleep(Sleep obj) {
		sleepList.add(obj);
	}
	public void show() {
		if (foodList.size() == 0) {
			System.out.println("None");
			System.out.println();
		}
		for (int i = 0; i < foodList.size(); i++) {
			System.out.println(foodList.get(i).toString());
		}
	}
	public void showWater() {
		if (waterList.size() == 0) {
			System.out.println("None");
			System.out.println();
		}
		for (int i = 0; i < waterList.size(); i++) {
			System.out.println(waterList.get(i).toStringWater());
		}
	}
	public void showActivity() {
		if (activityList.size() == 0) {
			System.out.println("None");
			System.out.println();
		}
		for ( int i = 0; i < activityList.size(); i++) {
			System.out.println(activityList.get(i).toStringActivity());
		}
	}
	public void showSleep() {
		if (sleepList.size() == 0) {
			System.out.println("None");
			System.out.print("\n");
		}
		for (int i = 0; i < sleepList.size(); i++) {
			System.out.println(sleepList.get(i).toStringSleep());
		}
	}
	public void showWeight() {
		if (weightList.size() == 0) {
			System.out.println("None");
			System.out.println();
		}
		for (int i = 0; i < weightList.size(); i++) {
			System.out.println(weightList.get(i).toStringWeight());
		}
	}
	public void summary(String date) {
		System.out.println("Summary");
		for (int i = 0; i < foodList.size(); i++) {
			if (foodList.get(i).getDate().equals(date)) {
				System.out.println(foodList.get(i).toString());
			}
		}
		for (int i = 0; i < waterList.size(); i++) {
			if (waterList.get(i).getWaterDate().equals(date)) {
				System.out.println(waterList.get(i).toStringWater());
			}
		}
		for ( int i = 0; i < activityList.size(); i++) {
			if (activityList.get(i).getActivityDate().equals(date)) {
				System.out.println(activityList.get(i).toStringActivity());
			}
		}
		for (int i = 0; i < sleepList.size(); i++) {
			if (sleepList.get(i).getSleepDate().equals(date)) {
				System.out.println(sleepList.get(i).toStringSleep());
			}
		}
		for (int i = 0; i < weightList.size(); i++) {
			if (weightList.get(i).getWeightDate().equals(date)) {
				System.out.println(weightList.get(i).toStringWeight());
			}
		}
	}
	public void summary() {
		System.out.println("Summary");
		show();
		showWater();
		showActivity();
		showWeight();
		showSleep();
	}
}

class Client {
	private Client() {

	}
	public static void main(String[] args) {
		DailyTracker d = new DailyTracker();
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			String line = s.nextLine();
			String[] tokens = line.split(",");
			String[] check = tokens[0].split(" ");
			switch (check[0]) {
				case "Food":
				Food f = new Food(check[1], tokens[1], tokens[2], tokens[3]);
				d.addFood(f);
				break;
				case "Water":
				Water w = new Water(check[1], tokens[1],tokens[2]);
				d.addWater(w);
				break;
				case "PhysicalActivity":
				PhysicalActivity p = new PhysicalActivity(check[1], tokens[1], tokens[2], tokens[3], tokens[4]);
				d.addActivity(p);
				break;
				case "Weight":
				Weight wt = new Weight(check[1], tokens[1], tokens[2], tokens[3]);
				d.addWeight(wt);
				break;
				case "Sleep":
				Sleep sc = new Sleep(check[1], tokens[1], tokens[2]);
				d.addSleep(sc);
				break;
				case "Foodlog":
				d.show();
				break;
				case "Waterlog":
				d.showWater();
				break;
				case "PhysicalActivitylog":
				d.showActivity();
				break;
				case "Sleeplog":
				d.showSleep();
				break;
				case "Weightlog":
				d.showWeight();
				break;
				case "Summary":
				if (check.length == 1) {
					d.summary();
				} else {
				d.summary(check[1]);
			}
				break;
			}
		}

	}
}