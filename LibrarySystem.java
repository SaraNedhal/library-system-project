/**
 *  ITCS214 Project
 *  Students Name(ID): Marya Mohammed 20192721 - Fatima Ahmed 20198905 - Sara Nedhal 20193686
 *  Section: 07
 * */

import java.util.LinkedList;

/**
 * defining Data members
 */
public class LibrarySystem {
    private LinkedList<Book> booksList;
    private LinkedList<LibMember> membersList;
    private int booksListSize;
    private int membersListSize;

    // default Constructor
    public LibrarySystem() {
        booksList = new LinkedList<>();
        booksListSize = 0;

        membersList = new LinkedList<>();
        membersListSize = 0;
    }

    /**
     * addBook method : this method adds a book in the library list, if the book exists already
     *   in the list it returns false else it adds the book to the list and returns true.
     */

    public boolean addBook(Book theBook) {
        for (int i = 0; i < booksListSize; i++)
            if (booksList.get(i).getAccessionNum() == theBook.getAccessionNum()) {
            System.out.println("The book that you have searched for is already exists in the library book list.");
            return false;
            }
        booksList.add(theBook);
            booksListSize++;
        System.out.println("The book is added successfully to the library book list. ");
        return true;
    }

    /**
     *
     * @param accNumber :Accession number
     * deleteBook method : this method deletes the book from the list. if the book is issued to another member
     *             then  the book will not be deleted and returns false else the book will be deleted
     *                  and it will return true
     */
    public boolean deleteBook(long accNumber){
        for (int i = 0 ; i < booksListSize; i++){
            if (booksList.get(i).getAccessionNum() == accNumber)
                if (booksList.get(i).getIssuedTo()!= null) {
                    System.out.println("This book is issued to a member therefore cannot be deleted");
                    return false;
                }
            else {
                booksList.remove(i);
                    System.out.println("The book is successfully deleted from the library list. ");
                    booksListSize--;
                    return true;
                }

        }
        System.out.println("The book is not found in the library book list");
        return false;
    }

    /**
     *
     * addMember method : this method adds a member to the list, if the member exists already in the list
     * the method will return false else the method will add the member  to the list and it will return true
     * */
    public boolean addMember(LibMember theMember){
        for (int i = 0 ; i < membersListSize; i++)
            if (membersList.get(i).getCprNum() == theMember.getCprNum()){
                System.out.println("The member is already exists in the library list.");
                return false;
            }

                membersList.add(theMember);
                 membersListSize++;
                System.out.println("The member is successfully added to the library list. ");
                return true;
    }

    /**
     *
     * deleteMember method : this method deletes the member from the list, if a book is issued to a member or
     * the member does not exist in the list then
     * the book will not be deleted and the method will return false else the book will be deleted and the
     * method will return true
     *
     */
    public boolean deleteMember(long cprNum){
        for (int i = 0 ; i< membersListSize; i++){
            if(membersList.get(i).getCprNum()== cprNum)
                if (membersList.get(i).getNo_Of_Books_Issued() != 0) {
                    System.out.println("This member cannot be deleted due to a book issued to the member.");
                    return false;
                } else { membersList.remove(i);
                    System.out.println("The member is successfully deleted from the library list.");
                    return true;
                }
        }
  System.out.println("The member that you have searched for is not found in the library list, ");
        System.out.print("please check the CPR member");
        return false;
    }

    /**
     *
     * searchBook method : this method searches for the book index in the library book list if it is found then
     * the method will return the book index else it will return -1 if the book is not found.
     *
     */
    public int searchBook(long accNumb){
        for (int i = 0 ; i< booksListSize; i++)
            if (booksList.get(i).getAccessionNum()== accNumb)
                return i;
          return -1;
    }

    /**
     * searchMember method : this method searches for the member index in the library member list if it
     * is found then the method will return the member index else it will return -1 if the member is not found.
     */
    public int searchMember(long cprNum){
        for (int i =0; i< membersListSize; i++)
            if (membersList.get(i).getCprNum()== cprNum)
                return i;
            return -1;
    }

    /**
     *
     * isEmptyBooksList() : this method returns true if the booksList is empty, else returns false.
     */
    public boolean isEmptyBooksList(){
        return booksListSize == 0;
    }

    /**
     *
     * isEmptyMemberList() : this method returns true if the membersList is empty, else returns false.
     */
    public boolean isEmptyMemberList(){
        return membersListSize == 0;
    }

    /**
     *
     * sizeBooksList() : this method returns instance variable booksListSize
     */
    public int sizeBooksList(){
        return booksListSize;
    }

    /**
     *
     * sizeMemberList() : this method returns instance variable membersListSize.
     */
    public int sizeMemberList(){
        return membersListSize;
    }

    /**
     *
     * issueBook() method : this method  is used to issue books to the member it returns true if
     * 	The book exists in the Books list,the member exists in the membersList,
     * 	The Book is not issued to any member, The member has less than 10 books issued to the member
     * 	If the Book cannot be issued or the member or the book does not exist in the list
     * 	it return false.
     *
     */
    public boolean issueBook(long accNumb , long cprNumb ){
        int bookNum= searchBook(accNumb);
        int memberNum = searchMember(cprNumb);

        Book theBook = null;
        LibMember theMember = null
         ;

        if (bookNum != -1 && memberNum != -1){
            theBook= booksList.get(bookNum);
            theMember = membersList.get(memberNum);

            if (theBook.getIssuedTo()== null && theMember.getNo_Of_Books_Issued() < 10){
                theMember.Books_Issued[theMember.getNo_Of_Books_Issued() ]= theBook;
                theMember.No_Of_Books_Issued++;
                theBook.setIssuedTo(theMember);
                System.out.println("The book is successfully issued to the member.");
                return true;

            }
            else{
                System.out.println("This book cannot be issued.");
                return false;
            }

        } else {
         System.out.println("The book or the member that you have searched for is not found in the library list.");
         return false;
        }

        }

    /**
     *
     *returnBook() method : this method returns the book to the library system. it returns true if
     * The book exists in the Books list, The Book is issued to a member else return false if it is not
     * deleted from the library book list.
     *
     */
    public boolean returnBook(long accNumb){
        int bookNumb  = searchBook(accNumb);
        Book theBook= null;
        if (bookNumb!= -1){
            theBook= booksList.get(bookNumb);

            if (theBook.getIssuedTo() != null){
                LibMember theMember = theBook.getIssuedTo();

                if (theMember!= null){
                    for (int i =0 ; i< theMember.No_Of_Books_Issued; i++)
                        if (theMember.Books_Issued[i].equals(theBook)){
                            for (int v = i+1 ; v < theMember.No_Of_Books_Issued; v++)
                                theMember.Books_Issued[v-1] = theMember.Books_Issued[v];
                        }
                    theMember.No_Of_Books_Issued--;
                }
                theBook.setIssuedTo(null);
                System.out.println("This book is returned successfully to the library list. ");
                return true;
            }
        }

        System.out.println("This book cannot be returned  to the library list.");
        return false;
           }

    /**
     *
     * printBooksIssued() method : this method prints all the books details that has been issued
     * to the member.
     */
         public void printBooksIssued (long cprNum){
        int memberNumb =searchMember(cprNum);
        LibMember theMember = null;
        if (memberNumb != -1) {
            theMember = membersList.get(memberNumb);

            if (theMember.getNo_Of_Books_Issued() == 0)
                System.out.println("No books issued to this member.");
            else{
                System.out.println("Details about the book that has been issued to the "+ cprNum + " is: ");
                for (int i = 0 ; i< theMember.No_Of_Books_Issued; i++)
                    System.out.println(theMember.Books_Issued[i]);
            }

        }
        else System.out.println("The member does not exist in the library member list.");
         }

    /**
     * isBookIssued() method: this method . It returns true if the Book object exists in the
     * bookList and is issued to a member, else returns false.
     *
     */
    public boolean isBookIssued (long accNumb){
          int bookNumb =searchBook(accNumb);
          if (bookNumb != -1){
              Book theBook = booksList.get(bookNumb);
              if (theBook.getIssuedTo() != null){
                  System.out.println("The book that you have searched for is not available, and issued to a member.");
                  return true;
              }
              else {
                  System.out.println("The book that you have searched for is available, and not issued to a member.");
                  return false;
              }
          }
          else {
              System.out.println("The book that you have searched for is not in the library book list.");
              return false;
          }
      }




}


