import java.util.*;

class Person {
    String name;
    String dob;
    String address;
    String phoneNumber;

    public Person(String name, String dob, String address, String phoneNumber) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}

class Student extends Person {
    int regno;
    int year;
    String department;

    public Student(String name, int regno, int year, String department, String dob, String address, String phoneNumber) {
        super(name, dob, address, phoneNumber);
        this.regno = regno;
        this.year = year;
        this.department = department;
    }
}

class Teacher extends Person {
    int empId;
    String department;
    String qualification;

    public Teacher(String name, int empId, String dob, String department, String qualification, String address, String phoneNumber) {
        super(name, dob, address, phoneNumber);
        this.empId = empId;
        this.department = department;
        this.qualification = qualification;
    }
}

class StudentsDetails {
    private List<Student> students;

    public StudentsDetails() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int regno, int year, String department, String dob, String address, String phoneNumber) {
        Student newStudent = new Student(name, regno, year, department, dob, address, phoneNumber);
        students.add(newStudent);
        System.out.println("\nStudent added: " + newStudent.name);
    }

    public void removeStudent(int regno) {
        boolean removed = false;
        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext();) {
            Student student = iterator.next();
            if (student.regno == regno) {
                iterator.remove();
                System.out.println("\nStudent removed ");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("\nStudent not found.");
        }
    }
public List<Student> getStudents() {
    return this.students;
}

    public void printStudents() {
        System.out.println("List of Students:");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-15s %-10s %-15s %-15s %-15s %-15s\n", "Name", "Register No", "Year", "Department", "DoB", "Address", "Phone No");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (Student student : students) {
            System.out.printf("%-20s %-15d %-10d %-15s %-15s %-15s %-15s\n",
                    student.name, student.regno, student.year, student.department, student.dob, student.address, student.phoneNumber);
        }
    }
}
class Mark {
    int[] arr;
  int rno;
    public Mark(int rno, int[] arr) {
        this.rno=rno;
        this.arr = arr;
    }

 public void addMarks(StudentsDetails studentsManager) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("\nEnter the Register No. of the student: ");
    int rno = scanner.nextInt();
    boolean found = false;
    for (Student student : studentsManager.getStudents()) {
        if (student.regno == rno) {
            found = true;
            System.out.println("\nEnter marks for student " + student.name + ":");
            int[] marks = new int[5];
            for (int i = 0; i < 5; i++) {
                System.out.print("Enter mark for subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
            }
            this.rno = rno;
            this.arr = marks;
            System.out.println("\nMarks added for student with Register No. " + rno);
            break;
        }
    }

    if (!found) {
        System.out.println("\nStudent with Register No. " + rno + " not found.");
    }
}


public void displayMarks(StudentsDetails studentsManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the Register No. of the student: ");
        int rno = scanner.nextInt();
        boolean found = false;

        for (Student student : studentsManager.getStudents()) {
            if (student.regno == rno) {
                found = true;
                System.out.println("\nMarks for student with Register No. " + rno + ":");
                System.out.println("----------------------------");
                System.out.printf("%-10s %-10s\n", "Subject", "Marks");
                System.out.println("----------------------------");
                
                for (int i = 0; i < arr.length; i++) {
                    System.out.printf("%-10d %-10d\n", (i + 1), arr[i]);
                }
                System.out.println("-------------------------------------------------");
                break;
            }
        }

        if (!found) {
            System.out.println("\nStudent with Register No. " + rno + " not found.");
        }
    }

}

class TeachersDetails {
    private List<Teacher> teachers;

    public TeachersDetails() {
        this.teachers = new ArrayList<>();
    }

    public void addTeacher(String name, int empId, String dob, String department, String qualification, String address, String phoneNumber) {
        Teacher newTeacher = new Teacher(name, empId, dob, department, qualification, address, phoneNumber);
        teachers.add(newTeacher);
        System.out.println("\nTeacher added: " + newTeacher.name);
    }

    public void removeTeacher(int empId) {
        boolean removed = false;
        for (Iterator<Teacher> iterator = teachers.iterator(); iterator.hasNext();) {
            Teacher teacher = iterator.next();
            if (teacher.empId == empId) {
                iterator.remove();
                System.out.println("\nTeacher removed ");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("\nTeacher not found.");
        }
    }

    public void printTeachers() {
        System.out.println("\nList of Teachers");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Name", "Employee ID", "DoB", "Department", "Qualification", "Address", "Phone No");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        for (Teacher teacher : teachers) {
            System.out.printf("%-20s %-15d %-15s %-15s %-15s %-15s %-15s\n",
                    teacher.name, teacher.empId, teacher.dob, teacher.department, teacher.qualification, teacher.address, teacher.phoneNumber);
        }
    }
}

class CollegeFeesStructure {
    private static final String[] departments = {"CSE", "EEE", "ECE", "Civil", "MECH"};
    private static final double[][] fees = {
        // Tuition Fee, Lab Fee, Examination Fee
        {12000.0, 1500.0, 1000.0}, // Computer Science
        {11500.0, 1300.0, 950.0},  // EEE
        {11000.0, 1200.0, 900.0},  // Electronics
        {11800.0, 1400.0, 980.0},  // Civil
        {12500.0, 1600.0, 1100.0}  // Mechanical
    };

    public static void displayDepartmentFees(String department) {
        int index = -1;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i].equalsIgnoreCase(department)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("-----------------------------------");
            System.out.println("Fees structure for " + departments[index] + " Department");
            System.out.println("-----------------------------------");
            System.out.println("Tuition Fee      : Rs." + fees[index][0]);
            System.out.println("Lab Fee          : Rs." + fees[index][1]);
            System.out.println("Examination Fee  : Rs." + fees[index][2]);
        } else {
            System.out.println("Department not found!");
        }
    }

    public static void dept() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------");
        System.out.println("Department List");
        System.out.println("-------------------");
        for (String department : departments) {
            System.out.println(department);
        }
        System.out.print("Enter the department name:");
        String department = scanner.nextLine();
        displayDepartmentFees(department);
    }
}

public class Cms {
	static Mark m = new Mark(0, new int[5]);
	static StudentsDetails studentsManager = new StudentsDetails();
    static TeachersDetails teachersManager = new TeachersDetails();
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int choice;
    do {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("  College Management System");
        System.out.println("------------------------------");
        System.out.println("1. Teacher Management");
        System.out.println("2. Student Management");
        System.out.println("3. Fees details");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        try {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showTeacherOptions(teachersManager, scanner);
                    break;
                case 2:
                    showStudentOptions(studentsManager, scanner);
                    break;
                case 3:
                    CollegeFeesStructure.dept();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer choice.");
            scanner.nextLine(); // Clear the buffer
            choice = 0; // Reset choice to loop again
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            choice = 0; // Reset choice to loop again
        }
    } while (choice != 4);

    scanner.close();
}


    private static void showTeacherOptions(TeachersDetails teachersManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("----------------------------");
            System.out.println("   Teacher Management");
            System.out.println("----------------------------");
            System.out.println("1. Add Teacher");
            System.out.println("2. Remove Teacher");
            System.out.println("3. Print Teachers");
            System.out.println("4. Add student marks");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTeacher(teachersManager, scanner);
                    break;
                case 2:
                    removeTeacher(teachersManager, scanner);
                    break;
                case 3:
                    teachersManager.printTeachers();
                    break;
				case 4:
					m.addMarks(studentsManager);
				    break;
                case 5:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 5);
    }

    private static void showStudentOptions(StudentsDetails studentsManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("----------------------------");
            System.out.println("    Student Management");
            System.out.println("----------------------------");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Print Students");
            System.out.println("4. View marks");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(studentsManager, scanner);
                    break;
                case 2:
                    removeStudent(studentsManager, scanner);
                    break;
                case 3:
                    studentsManager.printStudents();
                    break;
				case 4:
					m.displayMarks(studentsManager);
					break;
                case 5:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 5);
    }

    private static void addTeacher(TeachersDetails teachersManager, Scanner scanner) {
        System.out.println("\nEnter details for the new Teacher:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Employee ID: ");
        int empId = scanner.nextInt();
        System.out.print("Date of Birth: ");
        String dob = scanner.next();
        System.out.print("Department: ");
        String department = scanner.next();
        System.out.print("Qualification: ");
        String qualification = scanner.next();
        System.out.print("Address: ");
        String address = scanner.next();
        System.out.print("Phone no: ");
        String phoneNumber = scanner.next();
        teachersManager.addTeacher(name, empId, dob, department, qualification, address, phoneNumber);
    }

    private static void removeTeacher(TeachersDetails teachersManager, Scanner scanner) {
        System.out.print("\nEnter Employee ID of teacher to remove: ");
        int removeId = scanner.nextInt();
        teachersManager.removeTeacher(removeId);
    }

    private static void addStudent(StudentsDetails studentsManager, Scanner scanner) {
        System.out.println("\nEnter details for the new Student:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Register No: ");
        int regno = scanner.nextInt();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Department: ");
        String department = scanner.next();
        System.out.print("DoB: ");
        String dob = scanner.next();
        System.out.print("Address: ");
        String address = scanner.next();
        System.out.print("Phone no: ");
        String phoneNumber = scanner.next();
        studentsManager.addStudent(name, regno, year, department, dob, address, phoneNumber);
    }

    private static void removeStudent(StudentsDetails studentsManager, Scanner scanner) {
        System.out.print("\nEnter Register no. of Student to remove: ");
        int removeId = scanner.nextInt();
        studentsManager.removeStudent(removeId);
    }
}

