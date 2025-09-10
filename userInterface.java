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
        for(int i = 0; i < books.size(); i++){
            if( (books.get(i).getISBN13()).equals(isbn13)){
                books.get(i).printBookDetails();
            }
        }
    }

    public static void searchByAuthor(ArrayList<bookType> books, String author){

    }

    public static void searchByTitle(ArrayList<bookType> books, String title){

    }

    public static void fileReader(String fileName, ArrayList<bookType> books){

    }



}