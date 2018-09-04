import java.util.Scanner;
class StudentDetails{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        String rollnumber = s.nextLine();
        double marks1 = s.nextDouble();
        double marks2 = s.nextDouble();
        double marks3 =s.nextDouble();
        Student s1 =new Student(name, rollnumber, marks1, marks2, marks3);
    }
}
class Student{
    public Student(String name, String rollnumber, Double m1, Double m2, Double m3){
        double average = (m1+m2+m3)/3;
        System.out.println(average);
    }
}