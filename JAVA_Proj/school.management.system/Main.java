package school.management.system;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * jsg.jishu
 * main function:
 * Keep track of the following
 *
 * School:
 * teachers
 * students
 * totalmoney earned by school (by Students)
 * total money spent (Teachers salary)
 *
 * Teacher: teacher id, their salary details
 *
 * Students: their id, and thier fee detailed and if they paid or not, and how much money is left to be paid.
 *
 * choice 5 displays all the info like the teacherList and thier respective Salary (if paid shows so)
 * and info of the student along with feepaid (if any)
 */
//public class Main {
//    public static void main(String[] args) {
//        Teacher lizzy = new Teacher(1,"Lizzy",500);
//        Teacher mellisa = new Teacher(2,"Mellisa",700);
//        Teacher vanderhorn = new Teacher(3,"Vanderhorn",600);
//
//        List<Teacher> teacherList = new ArrayList<>();
//        teacherList.add(lizzy);
//        teacherList.add(mellisa);
//        teacherList.add(vanderhorn);
//
//
//        Student tamasha = new Student(1,"Tamasha",4);
//        Student rakshith = new Student(2,"Rakshith Vasudev",12);
//        Student rabbi = new Student(3,"Rabbi",5);
//        List<Student> studentList = new ArrayList<>();
//
//        studentList.add(tamasha);
//        studentList.add(rabbi);
//        studentList.add(rakshith);
//
//
//
//
//        School ghs = new School(teacherList,studentList);
//
//        Teacher megan = new Teacher(6,"Megan", 900);
//
//        ghs.addTeacher(megan);
//
//
//        tamasha.payFees(5000);
//        rakshith.payFees(6000);
//        System.out.println("GHS has earned $"+ ghs.getTotalMoneyEarned());
//
//        System.out.println("------Making SCHOOL PAY SALARY----");
//        lizzy.receiveSalary(lizzy.getSalary());
//        System.out.println("GHS has spent for salary to " + lizzy.getName()
//        +" and now has $" + ghs.getTotalMoneyEarned());
//
//        vanderhorn.receiveSalary(vanderhorn.getSalary());
//        System.out.println("GHS has spent for salary to " + vanderhorn.getName()
//                +" and now has $" + ghs.getTotalMoneyEarned());
//
//
//        System.out.println(rakshith);
//
//        mellisa.receiveSalary(mellisa.getSalary());
//
//        System.out.println(mellisa);
//
//
//    }
//}
    public class Main{
        private static int i=0;
        private static int s[]=new int[i];
        private static List<Teacher> teacherList = new ArrayList<>();
        private static List<Student> studentList = new ArrayList<>();
        private static int id_t=0,id_s=0,salary=0,grade=0,fee_paid=0;
        private static String name;

        public static void main(String[]args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=1,c_t=0,c_s=0; //c_t confirm that choice 1 ran atleast once and same goes for c_s which checks for choice 2
        do{
            while(t==1)
            {
                System.out.println(" Enter:\n 0 to STOP\n 1 to input Teacher\n 2 to input Student\n" +
                        " 3 to Display Teacher info or to Pay SALARY to the teacher\n 4 to Display Student info or to make Student Pay fees\n 5 to display current details\n"+": ");
                int choice=Integer.parseInt(br.readLine());

                if(choice==0)
                {
                    System.out.println("\n---- PROGRAM TERMINATED ----\n");
                    t=0;
                }

                if(choice==1) {
                    c_t++;
                    System.out.println("\nEnter the NAME of the teacher:");
                    name = br.readLine();
                    int check=0,j=0;
                    do{
                        System.out.println("\nEnter the UNIQUE ID of the teacher:");
                        id_t = Integer.parseInt(br.readLine());
                        j++;int k=0;
                        if(j>0) {
                            for (Teacher teacher : teacherList) {
                                if (teacher.getID() == id_t) {
                                    System.out.println("ID not UNIQUE !!");
                                    k++;
                                    break;
                                }
                            }
                            if(k==0)
                            {
                                check=1;
                            }
                        }
                    }while(check==0);
                    System.out.println("\nEnter the SALARY of the teacher:");
                    salary = Integer.parseInt(br.readLine());
                    teacher_info(id_t, name, salary);
                }

                if(choice==2) {
                    c_s++;
                    System.out.println("\nEnter the NAME of the student:");
                    name = br.readLine();
                    int check=0,j=0;
                    while(check==0) {
                        System.out.println("\nEnter the UNIQUE ID of the student:");
                        id_s = Integer.parseInt(br.readLine());
                        j++;int k=0;
                        if(j>0) {
                            for (Student student : studentList) {
                                if (student.getID() == id_s) {
                                    System.out.println("ID not UNIQUE !!");
                                    k++;
                                    break;
                                }
                            }
                            if(k==0)
                            {
                                check=1;
                            }
                        }
                    }while(check==0);
                    System.out.println("\nEnter the GRADE of the student:");
                    grade=Integer.parseInt(br.readLine());
                    System.out.println("\nEnter the FEE PAID by the Student:");
                    fee_paid = Integer.parseInt(br.readLine());
                    student_info(id_s,name,grade,fee_paid);
                }

                if(choice==3){

                    System.out.println("The following are the names and Salary of the Teachers: ");
                    for(Teacher teacher: teacherList)
                    {
                        System.out.print("id: "+teacher.getID()+"Name: "+teacher.getName()+"'s salary is $");
                        System.out.println(teacher.getSalary());
                    }
                    System.out.println("\nEnter the id of the Teacher to pay Salary: ");
                    int id=Integer.parseInt(br.readLine());
                    for(Teacher teacher: teacherList)
                    {
                        if(teacher.getID()==id)
                        {
                            teacher.receiveSalary(teacher.getSalary());
                            School s=new School(teacherList,studentList);
                            s.updateTotalMoneySpent(teacher.getSalary());
                            System.out.println("Salaty paid SUCCESSFULLY");
                        }
                    }

                }

                if(choice==4)
                {
                    System.out.println("\nThe following are the names,ID,Grade and Fee paid of the Students: ");
                    for(Student student: studentList)
                    {
                        System.out.println(student.getName()+"'s ID is "+student.getID()+", Grade: "+student.getGrade()+
                                ", Fees Paid: "+student.getFeesPaid());
                    }
                    System.out.println("\n(FOR PARENTS ONLY)"+
                            "\nEnter the id of the Student to PAY THE FEES");
                    int id=Integer.parseInt(br.readLine());
                    int f=0,fee_s=0;
                    while(f==0) {
                        System.out.printf("\nTotal fee: 3000, Enter the fees you'll PAY:");
                        fee_s = Integer.parseInt(br.readLine());
                        if (fee_s > 3000 || fee_s < 0)
                        {
                            System.out.println("Please correctly input the fees! ");
                        }
                        else
                        {
                            f=1;
                        }
                    }
                        for(Student student: studentList)
                        {
                            if(student.getID()==id)
                            {
                                student.payFees(fee_s);
                                School s=new School(teacherList,studentList);
                                s.updateTotalMoneyEarned(fee_s);
                                System.out.println("Remaining fee to be paid: "+student.getRemainingFees());
                            }
                        }
                }

                if(choice==5 && c_t>0 && c_s>0)
                {
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("The informations are as follows: ");
                    System.out.println("\n");
                    for(Teacher teacher: teacherList)
                    {
                        System.out.println("Teacher info:");
                        System.out.printf("\nName: "+teacher.getName()+"\nRegistered ID: "+teacher.getID());
                        System.out.printf("\nSalary: "+teacher.getSalary()+", Salary earned: "+teacher.salaryEarned());
                        System.out.println("\n");
                    }
                    for(Student student: studentList)
                    {
                        System.out.println("\nStudent info:");
                        System.out.printf("\nName: "+student.getName()+"\nRegistered ID: "+student.getID());
                        System.out.printf("\nFees Paid to School: "+student.getFeesPaid());
                        System.out.println("\n");
                    }
                    School s=new School(teacherList,studentList);
                    System.out.println("\nSchool info:");
                    System.out.printf("\nTotal Money Spent: "+s.getTotalMoneySpent()+"\nTotal Money Earned: "
                            +s.getTotalMoneyEarned());
                    System.out.println("\n");
                    System.out.println("-------------------------------------------------------------------");

                }

                else if((choice==3 && c_t==0) || (choice==4 && c_s==0) || (choice==5 && c_t==0 && c_s==0))
                {
                    System.out.println("NO STUDENT or TEACHER details were inputted, Please input the required details first.\n");
                }

                else if(choice !=0 && choice !=1 && choice !=2 && choice !=3 && choice !=4 && choice !=5 ) {
                    System.out.println("INVALID INPUT\n");
                }

            }

        }while(t==1);
    }

    public static void teacher_info(int id,String name,int salary)
    {
        Teacher teacher=new Teacher(id,name,salary);
        teacherList.add(teacher);
    }

    public static void student_info(int id,String name,int grade,int fee_paid)
    {
        Student student=new Student(id,name,grade);
        studentList.add(student);
        student.payFees(fee_paid);
    }
}
