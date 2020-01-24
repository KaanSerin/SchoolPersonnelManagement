import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class personnelManagement {
    public static void main(String[] args) {
        // the capacity of the array
        final int CAPACITY = 400;
        // initializing the scanner
        Scanner scan = new Scanner(System.in);

        // This object array will store the student, teacher, and the academicPersonnel objects
        Person[] people = new Person[CAPACITY];

        System.out.println("School staff Management System.");

        // The top of the people array
        int top = 0;

        // The input from the user
        int input = 0;

        // If the user enters -1, the loop will terminate
        while(input != -1){
            System.out.println("\nChoose operation:\n1)Add\n2)Search\n3)Delete");
            input = scan.nextInt();

            // Adding people
            if(input == 1){

                System.out.println("Add:\n1)Student\n2)Teacher\n3)Academic Personnel 4)Administrative Staff");
                input = scan.nextInt();

                // Adding a student object
                if(input == 1){
                    System.out.println("Enter the name, surname, age, studentNo, class of the student");

                    // The object is initialized and assigned to the [top] of the people array
                    people[top++] = new Student(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next());
                    // For testing
                    //people[top - 1].Print();
                    continue;
                }

                // Adding a teacher object
                else if(input == 2){
                    System.out.println("Enter the name, surname, age, personnelNo, taughSubject and the salary of the teacher");

                    // The object is initialized and assigned to the [top] of the people array
                    people[top++] = new Teacher(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next(),
                            scan.nextInt());
                    // For testing
                    //people[top - 1].Print();
                    continue;
                }

                // Adding an academic staff object
                else if(input == 3){
                    System.out.println("Enter the name, surname, age, personnelNo, position and the salary of the personnel");

                    // The object is initialized and assigned to the [top] of the people array
                    people[top++] = new AcademicPersonnel(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next(),
                            scan.nextInt());

                    // For testing
                    //people[top - 1].Print();

                    continue;
                }

                // Adding an administrative staff object
                else if(input == 4){
                    System.out.println("Enter the name, surname, age, personnelNo, position, department and the salary of admin staff");

                    // The object is initialized and assigned to the [top] of the people array
                    people[top++] = new AdministrativeStaff(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next(),
                            scan.next(), scan.nextInt());

                    // For testing
                    //people[top - 1].Print();

                    continue;
                }

                // Whe an invalid input is received
                else{
                    System.out.println("Invalid input!");
                    continue;
                }

            }

            // Search option is selected
            else if(input == 2){
                System.out.println("Search:\n1)By Name Surname\n2)Id Number");

                // Get the next input
                input = scan.nextInt();

                // Searching by name
                if(input == 1){
                    System.out.println("Enter the name and surname: ");
                    // Getting name and surname
                    String name = scan.next();
                    String surname = scan.next();

                    // object array for storing the potential results
                    Person[] searchResult = new Person[top];
                    int resultTop = 0;

                    // searching each element of the people object array until a null object is reached
                    for(int i = 0; i < top; i++){
                        if(people[i] == null) continue;

                        // if the name and surname is matching, copy the object to the searchResult array
                        if(people[i].getName().equals(name) && people[i].getSurname().equals(surname)){
                            searchResult[resultTop++] = people[i];
                        }
                    }

                    // No people were found, therefore no object was appended
                    if(resultTop == 0){
                        System.out.printf("No person by name %s %s could be found.\n", name, surname);
                    }

                    // If only 1 person was found, print it
                    else if(resultTop == 1){

                        // Calling the Print method of each object -- An example of Polymorphism
                        searchResult[0].Print();
                    }

                    // Multiple people were found, print them using a while loop
                    else{
                        for(int i = 0; i < resultTop; i++){

                            // Calling the Print method of each object -- An example of Polymorphism
                            searchResult[i].Print();
                        }
                    }

                    // Freeing up memory
                    searchResult = null;
                }

                // Searching by ID
                else if(input == 2){
                    System.out.println("Enter and id number: ");

                    // Getting name and surname
                    int idNo = scan.nextInt();

                    // object array for storing the potential results
                    Person[] searchResult = new Person[top];
                    int resultTop = 0;

                    // searching each element of the people object array until a null object is reached
                    for(int i = 0; i < top; i++){
                        if(people[i] == null) continue;

                        // if the name and surname is matching, copy the object to the searchResult array
                        if(people[i].getIdNo() == idNo){
                            searchResult[resultTop++] = people[i];
                            break;
                        }
                    }

                    // No people were found, therefore no object was appended
                    if(resultTop == 0){
                        System.out.printf("No person by idNo %d could be found.\n", idNo);
                    }

                    // If the person was found, print it
                    else{
                        // Calling the Print method of each object -- An example of Polymorphism
                        searchResult[0].Print();
                    }

                    // Freeing up memory
                    searchResult = null;
                }

//                else{
//                    System.out.println("Invalid option.");
//                    continue;
//                }
            }

            // Deleting people
            if(input == 3){
                System.out.println("Delete:\n1)By Name\n2)By ID Number");
                input = scan.nextInt();

                if(input == 1){
                    System.out.println("Enter the name and surname: ");

                    // Getting name and surname
                    String name = scan.next();
                    String surname = scan.next();

                    // searching each element of the people object array until a null object is reached
                    for(int i = 0; i < top; i++){
                        // if the name and surname is matching, copy the object to the searchResult array
                        if(people[i].getName().equals(name) && people[i].getSurname().equals(surname)){
                            people[i].Print();
                            System.out.println("Are you sure you want to delete this person? y/n");
                            String option = scan.next();
                            if(option.equals("y")){
                                people[i] = null;
                                System.out.println("Deleted the person.");
                            }
                            else{
                                System.out.println("Not deleted the person");
                                continue;
                            }
                        }
                    }

                }
                continue;
            }
            else{
                System.out.println("Invalid operation.");
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
        Random rand = new Random();

        // Generating a random id number for testing purposes
        idNo = rand.nextInt(99999);
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
    public static int noOfPersonnel;
    private int personnelNo;
    private String position;
    private int salary;

    // Constructor
    public AcademicPersonnel(String name, String surname, int age, int personnelNo,
                             String position, int salary) {
        super(name, surname, age);
        noOfPersonnel++;
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

    public void Print(){
        System.out.printf("%s %s is an academic personnel working at %s.\n", getName(), getSurname(), position);
    }
}

class Teacher extends AcademicPersonnel{
    // Encapsulated variables
    public static int noOfTeachers;
    private String taughtSubject;
    private String[] toughtClasses;

    // Constructor
    public Teacher(String name, String surname, int age, int personnelNo, String taughtSubject, int salary){
        super(name, surname, age, personnelNo, "Teaching staff", salary);
        noOfTeachers++;
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
        System.out.printf("%s %s is a teacher who teaches %s.\n idNo: \n", getName(), getSurname(), taughtSubject, getIdNo());
    }
}

class AdministrativeStaff extends AcademicPersonnel{
    public static int noOfAdministrativeStaff;
    private String department;

    // Constructor
    public AdministrativeStaff(String name, String surname, int age, int personnelNo, String position, String department,int salary){
        super(name, surname, age, personnelNo, position, salary);
        noOfAdministrativeStaff++;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void Print(){
        System.out.printf("%s %s is an administrative staff from %s department.\n idNo: %d\n", getName(), getSurname(), department, getIdNo());
    }
}

class Student extends Person{
    // Encapsulated instance variables
    public static int noOfStudents;
    private int studentNo;
    private String className;

    public Student(String name, String surname, int age, int studentNo, String className){
        super(name, surname, age);
        this.studentNo = studentNo;
        this.className = className;
        noOfStudents++;
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
        System.out.printf("%s %s is a student with student no %d from the class %s\n idNo: %d\n", getName(), getSurname(), studentNo, className, getIdNo());
    }
}