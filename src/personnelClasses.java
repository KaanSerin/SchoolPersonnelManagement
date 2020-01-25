import java.util.Random;

class Person{
    // The encapsulated instance variables
    public static int numberOfPeople;
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
        System.out.printf("%s %s is a teacher who teaches %s.\n idNo: %d\n", getName(), getSurname(), taughtSubject, getIdNo());
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