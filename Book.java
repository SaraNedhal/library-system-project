
/**
 *  ITCS214 Project
 *  Students Name(ID): Marya Mohammed 20192721 - Fatima Ahmed 20198905 - Sara Nedhal 20193686
 *  Section: 07
 * */
import java.util.*;


/**
 * defining Data members
 */
public class Book{

    private String title;
    private String author1;
    private String author2;
    private String publisher;
    private int  yearPublication;
    private String isbn;
    private long accessionNum;
    private LibMember issuedTo;



    /** Default Class Constructor*/

    public Book()
    {
        title= "";
        author1= "";
        author2= "";
        publisher= "";
        yearPublication= 0;
        isbn="";
        accessionNum= 0;
    }

    /** Class Constructor with parameters */

    public Book(String t,String a1,String a2,String p,int yearP,String is,long accNum)
    {
        title=t;
        author1=a1;
        author2=a2;
        publisher=p;
        yearPublication=yearP;
        isbn=is;
        accessionNum=accNum;

    }

    /** Sets and Gets methods */

    public void setTitle(String t){title=t;}
    public String getTitle(){return title;}

    public void setAuthor1(String a1){author1=a1;}
    public void setAuthor2(String a2){author2=a2;}
    public String getAuthor1(){return author1;}
    public String getAuthor2(){return author2;}

    public void setPublisher(String p){publisher=p;}
    public String getPublisher(){return publisher;}

    public void setYearPublication(int yearP){yearPublication=yearP;}
    public int getYearPublication(){return yearPublication;}


    public void setIsbn(String isbn) {
        if(isbn.length()==13)      //Checking for validity
            this.isbn = isbn;

        else
            System.out.println("Invalid value for isbn.");
    }

    public String getIsbn() { return isbn; }

    public void setAccessionNum(long accNum) {
        if(accessionNum>=1001)     //checking for validity
            accessionNum = accNum;

        else
            System.out.println("Invalid value for accession number.");
    }


    public long getAccessionNum() { return accessionNum; }

    public void setIssuedTo(LibMember issuedTo) { this.issuedTo = issuedTo; }
    LibMember getIssuedTo() { return issuedTo; }








    /** return true if all attribitutes */
    public boolean equals(Book book)
    {
        return yearPublication == book.yearPublication &&
                accessionNum == book.accessionNum &&
                title.equals(book.title) &&
                author1.equals(book.author1) &&
                author2.equals(book.author2) &&
                publisher.equals(book.publisher) &&
                isbn.equals(book.isbn) &&
                issuedTo.equals(book.issuedTo);

    }

    /**
     *  toString() method to print all attributes
     */

    public String toString()
    {
        return ("\n Book details: \n title: "+title+"\n author1: "+author1+"\n author2: "+author2+
                "\n publisher: "+publisher+"\n year Publication: "+yearPublication+"\nisbn: "+isbn+
                "\naccession Num: "+accessionNum+"\nissuedTo: "+issuedTo.getCprNum());
    }




}
