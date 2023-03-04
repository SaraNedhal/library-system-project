/**
 *  ITCS214 Project
 *  Students Name(ID): Marya Mohammed 20192721 - Fatima Ahmed 20198905 - Sara Nedhal 20193686
 *  Section: 07
 **/

import java.util.*;


public class LibraryMain {



    public static void main(String[] args) {

        long aNum = 1001;
        LibrarySystem LSystem = new LibrarySystem();
        Scanner in = new Scanner(System.in);

        System.out.println("\n Welcome to the library" +
                " Please pick a service from 0-9 :\n");

        System.out.println("1- To Add a new member ");
        System.out.println("2- To Add a new book ");
        System.out.println("3- To Delete a member ");
        System.out.println("4- To Delete a book ");
        System.out.println("5- To Search for a book ");
        System.out.println("6- To Print details of all books issued to a member ");
        System.out.println("7- To Issue a book ");
        System.out.println("8- To Return a book ");
        System.out.println("9- To Search for a member ");
        System.out.println("0 - To exit program");
        System.out.println("10 - Check if the book is issued ");
        System.out.println("11 - Check books list size");
        System.out.println("12 - Check member list size");
        System.out.println();

        boolean Exit = false;


        while (!Exit) {
            int service = in.nextInt();

            switch (service) {
                // Exits the program if user enters exit.
                case 0:
                    Exit = true;
                    System.out.println("Thank you ! ");
                    break;
                // Adds a new member in linkedList membersList from class LibrarySystem
                case 1:
                    System.out.println("Enter full name of the member");
                    System.out.print("First Name :");
                    String firstName = in.next();
                    System.out.print("Last Name :");
                    String lastName = in.next();
                    System.out.println("Enter gender");
                    char gender = in.next().charAt(0);
                    System.out.println("Enter CPR number");
                    long cprNum = in.nextLong();
                    System.out.println("Enter telephone number");
                    String telephoneNum = in.next();
                    LibMember newMember = new LibMember(firstName, lastName, gender, cprNum, telephoneNum);
                    LSystem.addMember(newMember);
                    break;
                // Adds a new book in linkedList books from class LibrarySystem
                case 2:
                    System.out.println("Enter Title of the book ");
                    in.nextLine();
                    String title = in.nextLine();

                    System.out.println("Enter Author 1 ");
                    String author1 = in.nextLine();

                    System.out.println("Enter Author 2 ");
                    String author2 = in.nextLine();

                    System.out.println("Enter Publisher ");
                    String publisher = in.nextLine();

                    System.out.println("Enter Publication year");
                    int pyear = in.nextInt();

                    System.out.println("Enter ISBN of the book");
                    String isbn = in.next();

                    Book newBook = new Book(title, author1, author2, publisher, pyear, isbn, aNum);
                    if ((LSystem.addBook(newBook)))
                        aNum++;

                    break;

                // Delete a member
                case 3:
                    System.out.println("Enter CPR number of the member.");
                    long cpr = in.nextLong();
                    LSystem.deleteMember(cpr);
                    break;

                //Delete a book
                case 4:
                    System.out.println("Enter Accession number of the book.");
                    long anum = in.nextLong();
                    LSystem.deleteBook(anum);
                    break;

                //Search for a book
                case 5:
                    System.out.println("Enter Accession number of the book.");
                    anum = in.nextLong();
                    LSystem.isBookIssued(anum);


                    break;

                //Print details of all books issued to a member
                case 6:
                    System.out.println("Enter CPR Number of the member.");
                    cpr = in.nextLong();
                    LSystem.printBooksIssued(cpr);
                    break;

                //Issue a book
                case 7:
                    System.out.println("Enter Accession number of the book");
                    anum = in.nextLong();

                    System.out.println("Enter CPR number of the member");
                    cpr = in.nextLong();

                    LSystem.issueBook(anum,cpr);
                    break;

                //Return a book
                case 8:
                    System.out.println("Enter Accession number of the book.");
                    anum = in.nextLong();
                   LSystem.returnBook(anum);
                    break;
                //Search for a member
                case 9:
                    System.out.println("Enter cpr number of the member");
                    cpr=in.nextLong();
                    if (LSystem.searchMember(cpr) != -1 )
                        System.out.println("Member is found");
                    if (LSystem.searchMember(cpr) == -1)
                        System.out.println("member does not exist.");
                    break;

                   // Check the book is issued to another member
                case 10:
                    System.out.println("Enter Accession number of the book.");
                    long aNum10 = in.nextLong();
                    LSystem.isBookIssued(aNum10);
                    break;

                case 11:
                    System.out.println("Book list size is: " +LSystem.sizeBooksList());
                    break;

                case 12:
                    System.out.println("Member list size is: "+ LSystem.sizeMemberList());

                default:
                    System.out.println("Error Choose the right service ");
            }

            if (!Exit) {
                System.out.println();
                System.out.println( "\n Welcome to the library" + " Please pick a service from 0-9 :\n");
                System.out.println("1- To Add a new member ");
                System.out.println("2- To Add a new book ");
                System.out.println("3- To Delete a member ");
                System.out.println("4- To Delete a book ");
                System.out.println("5- To Search for a book ");
                System.out.println("6- To Print details of all books issued to a member ");
                System.out.println("7- To Issue a book ");
                System.out.println("8- To Return a book ");
                System.out.println("9- To Search for a member ");
                System.out.println("10 - Check if the book is issued ");
                System.out.println("11 - Check books list size");
                System.out.println("12 - Check member list size");
                System.out.println("0 - To exit program");


                System.out.println();
            }



        }


    }}


