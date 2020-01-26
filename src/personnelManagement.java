import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
            TODO: 1) Decrementing the numberOf... for every deletion ✓
                  2) Deleting by ID Number ✓
                  3) Invalid input handling -- being worked on
                  4) Debug found bugs -- fixed as found
                  5) Format the code so it is easier to read -- being worked on
             */

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

            // Catching potential errors from the user input
            try {
                input = scan.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input.\nYou should enter a number!");
                break;
            }

            // Adding people
            if(input == 1){

                System.out.println("Add:\n1)Student\n2)Teacher\n3)Academic Personnel 4)Administrative Staff");

                // Catching potential errors from the user input
                try {
                    input = scan.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("Invalid input.\nYou should enter a number!");
                    break;
                }

                // Adding a student object
                if(input == 1){
                    System.out.println("Enter the name, surname, age, studentNo, class of the student");

                    // The object is initialized and assigned to the [top] of the people array
                    people[top++] = new Student(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next());

                    // For testing
                    System.out.printf("Added person with the ID Number: %d\n", people[top - 1].getIdNo());
                    continue;
                }

                // Adding a teacher object
                else if(input == 2){
                    System.out.println("Enter the name, surname, age, personnelNo, taughSubject and the salary of the teacher");

                    // The object is initialized and assigned to the [top] of the people array
                    people[top++] = new Teacher(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next(),
                            scan.nextInt());
                    // For testing
                    System.out.printf("Added person with the ID Number: %d\n", people[top - 1].getIdNo());
                    continue;
                }

                // Adding an academic staff object
                else if(input == 3){
                    System.out.println("Enter the name, surname, age, personnelNo, position and the salary of the personnel");

                    // The object is initialized and assigned to the [top] of the people array
                    people[top++] = new AcademicPersonnel(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next(),
                            scan.nextInt());

                    // For testing
                    System.out.printf("Added person with the ID Number: %d\n", people[top - 1].getIdNo());

                    continue;
                }

                // Adding an administrative staff object
                else if(input == 4){
                    System.out.println("Enter the name, surname, age, personnelNo, position, department and the salary of admin staff");

                    // The object is initialized and assigned to the [top] of the people array
                    people[top++] = new AdministrativeStaff(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next(),
                            scan.next(), scan.nextInt());

                    // For testing
                    System.out.printf("Added person with the ID Number: %d\n", people[top - 1].getIdNo());

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
                continue;
            }

            // Deleting people
            if(input == 3){
                System.out.println("Delete:\n1)By Name\n2)By ID Number");
                input = scan.nextInt();

                // Deleting by name
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
                                if(people[i] instanceof Student){
                                    Student.noOfStudents--;
                                    continue;
                                }
                                if(people[i] instanceof Teacher){
                                    Teacher.noOfTeachers--;
                                }
                                if(people[i] instanceof AdministrativeStaff){
                                    AdministrativeStaff.noOfAdministrativeStaff--;
                                }
                                if(people[i] instanceof AcademicPersonnel){
                                    AcademicPersonnel.noOfPersonnel--;
                                }
                                // Decrementing the numberOfs
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

                // Deleting by ID
                if(input == 2){
                    System.out.println("The ID Number: ");

                    // Getting the ID Number
                    int idNo = scan.nextInt();

                    // searching each element of the people object array until a null object is reached
                    for(int i = 0; i < top; i++){
                        //
                        if(people[i].getIdNo() == idNo){
                            // Printing the found person
                            people[i].Print();

                            System.out.println("Are you sure you want to delete this person? y/n");
                            String option = scan.next();
                            if(option.equals("y")){

                                // Decrementing the numberOfs
                                if(people[i] instanceof Student){
                                    Student.noOfStudents--;
                                }
                                if(people[i] instanceof Teacher){
                                    Teacher.noOfTeachers--;
                                }
                                if(people[i] instanceof AdministrativeStaff){
                                    AdministrativeStaff.noOfAdministrativeStaff--;
                                }
                                if(people[i] instanceof AcademicPersonnel){
                                    AcademicPersonnel.noOfPersonnel--;
                                }
                                people[i] = null;
                                System.out.println("Deleted the person.");
                            }

                            // When user enters anything other then y
                            else{
                                System.out.println("Not deleted the person");
                                continue;
                            }
                        }
                    }
                }

                continue;
            }

            // If the user input is invalid
            else if(input != -1){
                System.out.println("Invalid operation.");
            }

        }

        //End of the loop. For testing purposes, the number of students, teachers, academic staff, and administrative staff is printed
        System.out.printf("Number of students: %d\n", Student.noOfStudents);
        System.out.printf("Number of teachers: %d\n", Teacher.noOfTeachers);
        System.out.printf("Number of academic personnel: %d\n" , AcademicPersonnel.noOfPersonnel);
        System.out.printf("Number of administrative staff: %d\n", AdministrativeStaff.noOfAdministrativeStaff);

    }
}