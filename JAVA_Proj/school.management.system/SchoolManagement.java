import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolManagement {
    private static final List<Teacher> teacherList = new ArrayList<>();
    private static final List<Student> studentList = new ArrayList<>();
    private static int totalMoneyEarned = 0, totalMoneySpent = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("\n1: Add Teacher\n2: Add Student\n3: Pay Teacher Salary\n4: Pay Student Fee\n5: Display Details\n0: Exit");
            int choice = Integer.parseInt(br.readLine());
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter Teacher Name: ");
                    String tName = br.readLine();
                    System.out.print("Enter Teacher ID: ");
                    int tId = Integer.parseInt(br.readLine());
                    System.out.print("Enter Salary: ");
                    int salary = Integer.parseInt(br.readLine());
                    teacherList.add(new Teacher(tId, tName, salary));
                    break;

                case 2:
                    System.out.print("Enter Student Name: ");
                    String sName = br.readLine();
                    System.out.print("Enter Student ID: ");
                    int sId = Integer.parseInt(br.readLine());
                    System.out.print("Enter Grade: ");
                    int grade = Integer.parseInt(br.readLine());
                    System.out.print("Enter Fees Paid: ");
                    int feesPaid = Integer.parseInt(br.readLine());
                    Student student = new Student(sId, sName, grade);
                    student.payFees(feesPaid);
                    totalMoneyEarned += feesPaid;
                    studentList.add(student);
                    break;

                case 3:
                    System.out.print("Enter Teacher ID to Pay Salary: ");
                    int payId = Integer.parseInt(br.readLine());
                    for (Teacher teacher : teacherList) {
                        if (teacher.getId() == payId) {
                            totalMoneySpent += teacher.getSalary();
                            System.out.println("Salary Paid: $" + teacher.getSalary());
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to Pay Fee: ");
                    int feeId = Integer.parseInt(br.readLine());
                    System.out.print("Enter Fee Amount: ");
                    int feeAmount = Integer.parseInt(br.readLine());
                    for (Student s : studentList) {
                        if (s.getId() == feeId) {
                            s.payFees(feeAmount);
                            totalMoneyEarned += feeAmount;
                            System.out.println("Remaining Fee: $" + s.getRemainingFees());
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nTeachers:");
                    for (Teacher t : teacherList) System.out.println(t);
                    System.out.println("\nStudents:");
                    for (Student s : studentList) System.out.println(s);
                    System.out.println("\nSchool Financials:");
                    System.out.println("Total Money Earned: $" + totalMoneyEarned);
                    System.out.println("Total Money Spent: $" + totalMoneySpent);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

class Teacher {
    private final int id;
    private final String name;
    private final int salary;

    public Teacher(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: $" + salary;
    }
}

class Student {
    private final int id;
    private final String name;
    private final int grade;
    private int feesPaid = 0;
    private static final int TOTAL_FEES = 3000;

    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void payFees(int amount) {
        feesPaid += amount;
    }

    public int getRemainingFees() {
        return TOTAL_FEES - feesPaid;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade + ", Fees Paid: $" + feesPaid;
    }
}

