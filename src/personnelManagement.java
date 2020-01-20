import java.sql.SQLOutput;
import java.util.Scanner;

public class personnelManagement {
    public static void main(String[] args) {
        final int CAPACITY = 400;
        Scanner scan = new Scanner(System.in);
        Person[] people = new Person[CAPACITY];

        System.out.println("School staff Management System.");

        int top = 0;
        int input = 0;

        while(input != -1){
            System.out.println("Choose operation:\n1)Add\n2)Search\n3)Delete");
            input = scan.nextInt();
            if(input == 1){
                System.out.println("Add:\n1)Student\n2)Teacher\n3)Academic Personnel");
                input = scan.nextInt();
                if(input == 1){
                    System.out.println("Enter the name, surname, age, studentNo, class of the student");
                    people[top] = new Student(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next());
                    people[top].Print();
                    continue;
                }
                else if(input == 2){
                    System.out.println("Enter the name, surname, age, personnelNo, taughSubject and the salary the teacher");
                    people[top] = new Teacher(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next(),
                            scan.nextInt());
                    people[top].Print();
                    continue;
                }
            }
            else if(input == 2){
                System.out.println("Search:\n1)By Name\n2)Teacher\n3)Academic Personnel");
                continue;
            }
            if(input == 3){
                System.out.println("Delete:\n1)Student\n2)Teacher\n3)Academic Personnel");
                continue;
            }
            else{
                System.out.println("Invalid operation.");
                continue;
            }
        }
    }
}

class Person{
    // The encapsulated instance variables
    private String name;
    private String surname;
    private int age;
    private int idNo;
    private String adress;

    // Constructor
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    // Getters and setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public void Print(){
        System.out.printf("Name: %s\n Surname: %s\n Age: %d\n IdNo: %s\n Adress: %s\n", name,
                surname, age, idNo, adress);
    }
}

class AcademicPersonnel extends Person{
    // Encapsulated instance variables
    private int personnelNo;
    private String position;
    private int salary;

    // Constructor
    public AcademicPersonnel(String name, String surname, int age, int personnelNo,
                             String position, int salary) {
        super(name, surname, age);
        this.personnelNo = personnelNo;
        this.position = position;
        this.salary = salary;
    }

    // Getters and setters
    public int getPersonnelNo() {
        return personnelNo;
    }

    public void setPersonnelNo(int personnelNo) {
        this.personnelNo = personnelNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

class Teacher extends AcademicPersonnel{
    // Encapsulated variables
    private String taughtSubject;
    private String[] toughtClasses;

    // Constructor
    public Teacher(String name, String surname, int age, int personnelNo, String taughtSubject, int salary){
        super(name, surname, age, personnelNo, "Teaching staff", salary);
        this.taughtSubject = taughtSubject;
    }

    //Getters and Setters
    public String getTaughtSubject() {
        return taughtSubject;
    }

    public void setTaughtSubject(String taughtSubject) {
        this.taughtSubject = taughtSubject;
    }

    public String[] getToughtClasses() {
        return toughtClasses;
    }

    public void setToughtClasses(String[] toughtClasses) {
        this.toughtClasses = toughtClasses;
    }

    public void Print(){
        System.out.printf("%s %s is a teacher who teaches %s\n", getName(), getSurname(), taughtSubject);
    }
}

class AdministrativeStaff extends AcademicPersonnel{
    private String department;

    // Constructor
    public AdministrativeStaff(String name, String surname, int age, int personnelNo, String position, int salary){
        super(name, surname, age, personnelNo, position, salary);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

class Student extends Person{
    // Encapsulated instance variables
    private int studentNo;
    private String className;

    public Student(String name, String surname, int age, int studentNo, String className){
        super(name, surname, age);
        this.studentNo = studentNo;
        this.className = className;
    }
    // Getters and setters
    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void Print(){
        System.out.printf("%s %s is a student from the class %s\n", getName(), getSurname(), className);
    }
}