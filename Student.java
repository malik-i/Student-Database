import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String stuID;
    private String courses = null;
    private double tuitionBalance = 0;
    private static int costsPerCourse = 600; // static means that this property is not specific to any one object
    private static int id = 1000;

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getGradeYear(){
        return gradeYear;
    }

    public String getStuID(){
        return stuID;
    }

    public String getCourses(){
        return courses;
    }

    public double getTuitionBalance(){
        return tuitionBalance;
    }

    public int getCostsPerCourse(){
        return costsPerCourse;
    }


    // Constructor: prompts user to enter student's name and year
    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.println("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = in.nextInt();

        setStudentID();

        System.out.println(firstName + " " + lastName + " " + gradeYear + " " + stuID);

    }

    // Generate an ID
    private void setStudentID(){
        // Grade level + ID
        id++;
        this.stuID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll(){
        // Get inside a loop, user hits 0;
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine().toUpperCase();

            if (!course.equals("Q")) {
                courses = courses + "\n  " + course;
                tuitionBalance += costsPerCourse;
            } else{
                break;
            }
        }while(true);

        System.out.println("ENROLLED IN: " + courses);
        System.out.println("TUITION BALANCE: $" + tuitionBalance);
    }
    // View Balance
    public void viewBalance(){
        System.out.println("Your Remaining Balance is: $" + tuitionBalance);
    }

    // Pay tuition
    public void payTuition(){
        System.out.println("----- PAY TUITION -----");
        boolean fullyPaid = false;
        do {
            viewBalance();
            System.out.print("Enter Payment Amount, (-1 to Quit): $");
            Scanner in = new Scanner(System.in);
            float payment = in.nextFloat();
            tuitionBalance -= payment;
            viewBalance();
            if(tuitionBalance <= 0){
                fullyPaid = true;
                System.out.println("Congratulations! You're Account is Fully Paid!!");
                if(tuitionBalance < 0){
                    System.out.println("You over paid, here's your change: " + (tuitionBalance*-1));
                }
            } else if (payment == -1){
                break;
            } else{
                fullyPaid = false;
            }
        } while(fullyPaid == false);

    }

    // Show status
    public String showInfo(){
        System.out.println("----- Student Info -----");
        return "Name: " + firstName + " "+ lastName + "\n" +
                "Student ID: " + stuID + "\n" +
                "Courses: " +courses + "\n" +
                "Year: " + gradeYear + "\n" +
                "Tuition Balance: " + tuitionBalance + "\n";

    }
}
