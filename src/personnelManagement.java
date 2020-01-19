public class personnelManagement {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Person{
    // The encapsulated instance variables
    private String name;
    private String surname;
    private int age;
    private int idNo;
    private String adress;

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

class Student extends Person{
    
    // The encapsulated instance variables
    private int studentNo;
    private String className;

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
}