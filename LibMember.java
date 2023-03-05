/**
 *  ITCS214 Project
 *  Student Name: Sara Nedhal 
 *  Section: 07
 * */
import java.util.*;
public class LibMember
{

    //Data Member
    private String First_Name;
    private String Last_Name;
    private char Gender;
    private long cprNum;
    private String Telephone;
    Book [] Books_Issued = new Book [10];
     int No_Of_Books_Issued;


    //Constructor
    public LibMember()
    {
        First_Name = "";
        Last_Name = "";
        Gender = ' ';
        cprNum = 0;
        Telephone = "";
    }

    //Constructor & parameter
    public LibMember(String F, String L, char G , long C , String M)
    {
        First_Name = F;
        Last_Name = L;
        Gender = G;
        this.cprNum = C;
        Telephone = M;
    }

    //set and get methods
    public String getFirst_Name()
    {
        return First_Name;
    }

    public void setFirst_Name(String first_Name)
    {
        this.First_Name = first_Name;
    }

    public String getLast_Name()
    {
        return Last_Name;
    }

    public void setLast_Name(String last_Name)
    {
        this.Last_Name = last_Name;
    }

    public char getGender()
    {
        return Gender;
    }

    public void setGender(char gender)
    {
        this.Gender = gender;
    }

    public long getCprNum()
    {
        return cprNum;
    }

    public void setCprNum (long CPR)
    {
        this.cprNum = CPR;
    }

    public String getTelephone()
    {
        return Telephone;
    }

    public void setTelephone(String telephone)
    {
        this.Telephone = telephone;
    }

    public Book[] getBooks_Issued()
    {
        return Books_Issued;
    }

    public void setBooks_Issued(Book[] Books_Issued)
    {
        this.Books_Issued = Books_Issued;
    }

    public int getNo_Of_Books_Issued()
    {
        return No_Of_Books_Issued;
    }

    public void setNo_Of_Books_Issued(int no_Of_Books_Issued)
    {
        this.No_Of_Books_Issued = no_Of_Books_Issued;
    }


    //method equals
    public boolean Equals(LibMember other)
    {
       return  (this.First_Name == other.First_Name &&
                this.Last_Name == other.Last_Name &&
                this.Gender == other.Gender &&
                this.cprNum == other.cprNum &&
                this.Telephone == other.Telephone &&
                this.No_Of_Books_Issued == other.No_Of_Books_Issued);

    }
    // toString method
    public void ToString()
    {
        System.out.println("New member:\n"+
                "First Name: "+ First_Name +
                "\nLast Name: "+ Last_Name +
                "\nGender: "+ Gender +
                "\nCPR: "+ cprNum +
                "\nTelephone: "+ Telephone +
                "\n Books issued: " +Arrays.toString(Books_Issued)+
                "\nNumber of books issued: "+ No_Of_Books_Issued +"\n");

    }
}



