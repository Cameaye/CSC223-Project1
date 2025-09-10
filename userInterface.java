import java.util.ArrayList;
import bookType;
import java.util.Scanner;

public class userInterface{


    public static void main(String[] args){

        ArrayList<bookType> books = new ArrayList<bookType>();
        Scanner lineInput = new Scanner(System.in);



        boolean userInterfaceLoopCondition = true;
        int userInterfaceSelector;
        while(userInterfaceLoopCondition){
            System.out.println("Please enter the number with your desired functionality: ");
            System.println("1) Print all books in stock \n
                            2) Search Books by ISBN13 \n
                            3) Search Books by Author \n
                            4) Search Books by Title \n
                            -1) Exit");
            userInterfaceSelector = lineInput.nexInt();

            
            switch userInterfaceSelector{
                case 1:
                    printAllInStock(books);
                    break;
                case 2:
                    System.out.print("Please enter the ISBN13 you would like to search for: ")
                    String isbn = lineInput.next();
                    searchByISBN(books, isbn);
                    break;
                case 3:
                    System.out.print("Please enter the Author you would like to search for: ")
                    String author = lineInput.next();
                    searchByAuthor(books, author);
                    break;
                case 4:
                    System.out.print("Please enter the Title you would like to search for: ")
                    String title = lineInput.next();
                    searchByTitle(books, title);
                    break;
                case -1:
                    System.out.println("Thank you for using our service!");
                    userInterfaceLoopCondition = false;
                    break;
            }
        }
        
    }


    public static void printAllInStock(ArrayList<bookType> books){
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getNumCopies() > 0){
                books.get(i).printBookDetails();
            }
        }
    }

    public static void searchByISBN(ArrayList<bookType> books, String isbn13){
        boolean hasBook = false;
        for(int i = 0; i < books.size(); i++){
            if( (books.get(i).getISBN13()).equals(isbn13)){
                hasBook = true;
                books.get(i).printBookDetails();
            }
        }
        if(!hasBook){
            System.out.println("We're Sorry, it doesn't appear we have a book with that ISBN13.")

        }
    }

    public static void searchByAuthor(ArrayList<bookType> books, String author){
        boolean hasBook = false;
        for(int i = 0; i < books.size(); i++){
            if( (books.get(i).getAuthor()).equals(author)){
                hasBook = true;
                books.get(i).printBookDetails();
            }
        }
        if(!hasBook){
            System.out.println("We're Sorry, it doesn't appear we have a book by that author.")
        }
    }

    public static void searchByTitle(ArrayList<bookType> books, String title){
        boolean hasBook = false;
        for(int i = 0; i < books.size(); i++){
            if( (books.get(i).getTitle()).equals(title)){
                hasBook = true;
                books.get(i).printBookDetails();
            }
        }
        if(!hasBook){
            System.out.println("We're Sorry, it doesn't appear we have a book with that title.")
        }
    }

    public static void fileReader(String fileName, ArrayList<bookType> books){

    }



}