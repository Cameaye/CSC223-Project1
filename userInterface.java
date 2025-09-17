import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



/*
Program name: userInterface.java
Author: Cameron Ayers
Date: 9/19/2025
Input: A text file provided by the user containing book data (title, ISBN13, publisher,
       year published, price, number of copies, author) and user choices via the console menu.
Output: Displays search results, book details, and confirmation of updates on the console.
Description: This program serves as a console-based interface for a book library system.
             It loads book information from a file into memory, then allows the user to:
             - Print all books or only those in stock
             - Search for books by ISBN, author, or title
             - Update stock quantities by ISBN, author, or title
             The program runs in a loop until the user chooses to exit.
*/

/**
 * The {@code userInterface} class provides a console-based interface for interacting
 * with a collection of {@code bookType} objects. Users can load book data from a file,
 * search for books by ISBN, author, or title, print book details, and update stock.
 */
public class userInterface{
        /*
     * main launches the application and manages the user interaction loop.
     * Signature: public static void main(String[] args)
     * Parameters:
     *   - args: String[] → command line arguments (not used in this program)
     * Return: none (void)
     * Preconditions: none
     * Postconditions: program runs until the user exits; books are loaded from a file
     *                 and users may search/print/update data interactively.
     */
    public static void main(String[] args){

        ArrayList<bookType> books = new ArrayList<>();
        Scanner lineInput = new Scanner(System.in);

        System.out.println("Welcome to the Robust Book Library, please enter the name of the file you would like to search through: ");
        String fileName = lineInput.nextLine();

        boolean userInterfaceLoopCondition = fileReader(fileName, books);
        int userInterfaceSelector;
        while(userInterfaceLoopCondition){
            System.out.println("Please enter the number with your desired functionality: ");
            System.out.println(" 1) Print all books in stock \n 2) Search Books by ISBN13 \n 3) Search Books by Author \n 4) Search Books by Title");
            System.out.println(" 5) Print all books \n 6) Update stock by Author \n 7) Update stock by ISBN13 \n 8) Update stock by title \n -1) Exit");
            userInterfaceSelector = lineInput.nextInt();
            lineInput.nextLine();

            
            switch (userInterfaceSelector) {
                case 1:
                    printAllInStock(books);
                    break;
                case 2:
                    System.out.print("Please enter the ISBN13 you would like to search for: ");
                    String isbn = lineInput.next();
                    searchByISBN(books, isbn);
                    break;
                case 3:
                    System.out.println("Please enter the Author you would like to search for: ");
                    String author = lineInput.nextLine();
                    searchByAuthor(books, author);
                    break;
                case 4:
                    System.out.println("Please enter the Title you would like to search for: ");
                    String title = lineInput.nextLine();
                    searchByTitle(books, title);
                    break;
                case 5:
                    printAll(books);
                    break;
                case 6:
                    System.out.print("Please enter the Author you would like to update the stock for: ");
                    String auth = lineInput.nextLine();
                    System.out.print("Please enter the quantity you would like to add: ");
                    int quantity = lineInput.nextInt();
                    restockByAuthor(books, auth, quantity);
                    System.out.println("Stock updated succesfully!");
                    break;
                case 7:
                    System.out.print("Please enter the ISBN13 you would like to update the stock for: ");
                    String isbn13 = lineInput.nextLine();
                    System.out.print("Please enter the quantity you would like to add: ");
                    int stock = lineInput.nextInt();
                    restockByISBN(books, isbn13, stock);
                    System.out.println("Stock updated succesfully!");
                    break;
                case 8:
                    System.out.print("Please enter the Title you would like to update the stock for: ");
                    String bookTitle = lineInput.nextLine();
                    System.out.print("Please enter the quantity you would like to add: ");
                    int stockQuantity = lineInput.nextInt();
                    restockByTitle(books, bookTitle, stockQuantity);
                    System.out.println("Stock updated succesfully!");
                    break;
                case -1:
                    System.out.println("Thank you for using our service!");
                    userInterfaceLoopCondition = false;
                    lineInput.close();
                    break;
                default:
                    System.out.println("Invalid Input! Please select a valid option or -1 to exit");
                    break;
            }
        }
        
    }


    /*
     * printAllInStock prints the details of all books currently in stock.
     * Signature: public static void printAllInStock(ArrayList<bookType> books)
     * Parameters:
     *   - books: ArrayList<bookType> → list of all books
     * Return: none (void)
     * Preconditions: books list must be initialized
     * Postconditions: prints all books where numCopies > 0
     */
    public static void printAllInStock(ArrayList<bookType> books){
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getNumCopies() > 0){
                books.get(i).printBookDetails();
            }
        }
    }

    /*
     * searchByISBN searches for books by their ISBN13.
     * Signature: public static void searchByISBN(ArrayList<bookType> books, String isbn13)
     * Parameters:
     *   - books: ArrayList<bookType> → list of all books
     *   - isbn13: String → ISBN13 code to search for
     * Return: none (void)
     * Preconditions: books list must be initialized
     * Postconditions: prints details of matching books, or message if none found
     */
    public static void searchByISBN(ArrayList<bookType> books, String isbn13){
        boolean hasBook = false;
        for(int i = 0; i < books.size(); i++){
            if( (books.get(i).getISBN13()).equals(isbn13)){
                hasBook = true;
                books.get(i).printBookDetails();
            }
        }
        if(!hasBook){
            System.out.println("We're Sorry, it doesn't appear we have a book with that ISBN13.");

        }
    }

    /*
     * searchByAuthor searches for books by their author.
     * Signature: public static void searchByAuthor(ArrayList<bookType> books, String author)
     * Parameters:
     *   - books: ArrayList<bookType> → list of all books
     *   - author: String → author name to search for
     * Return: none (void)
     * Preconditions: books list must be initialized
     * Postconditions: prints details of matching books, or message if none found
     */
    public static void searchByAuthor(ArrayList<bookType> books, String author){
        boolean hasBook = false;
        for(int i = 0; i < books.size(); i++){
            if( (books.get(i).getAuthor()).equals(author)){
                hasBook = true;
                books.get(i).printBookDetails();
            }
        }
        if(!hasBook){
            System.out.println("We're Sorry, it doesn't appear we have a book by that author.");
        }
    }

    /*
     * searchByTitle searches for books by their title.
     * Signature: public static void searchByTitle(ArrayList<bookType> books, String title)
     * Parameters:
     *   - books: ArrayList<bookType> → list of all books
     *   - title: String → title to search for
     * Return: none (void)
     * Preconditions: books list must be initialized
     * Postconditions: prints details of matching books, or message if none found
     */
    public static void searchByTitle(ArrayList<bookType> books, String title){
        boolean hasBook = false;
        for(int i = 0; i < books.size(); i++){
            if( (books.get(i).getTitle()).equals(title)){
                hasBook = true;
                books.get(i).printBookDetails();
            }
        }
        if(!hasBook){
            System.out.println("We're Sorry, it doesn't appear we have a book with that title.");
        }
    }

    /*
     * printAll prints all books regardless of stock.
     * Signature: public static void printAll(ArrayList<bookType> books)
     * Parameters:
     *   - books: ArrayList<bookType> → list of all books
     * Return: none (void)
     * Preconditions: books list must be initialized
     * Postconditions: prints details of every book in the list
     */
    public static void printAll(ArrayList<bookType> books){
        for(int i = 0; i < books.size(); i++){
            books.get(i).printBookDetails();
        }
    }

    /*
     * restockByAuthor increases stock for all books by a given author.
     * Signature: public static void restockByAuthor(ArrayList<bookType> books, String author, int restockQuantity)
     * Parameters:
     *   - books: ArrayList<bookType> → list of all books
     *   - author: String → author name whose books should be restocked
     *   - restockQuantity: int → quantity to add to stock
     * Return: none (void)
     * Preconditions: books list must be initialized
     * Postconditions: updates stock for matching books, or prints error if not found
     */
    public static void restockByAuthor(ArrayList<bookType> books, String author, int restockQuantity){
        boolean hasBook = false;
        for(int i = 0; i < books.size(); i++){
            if( (books.get(i).getAuthor()).equals(author)){
                hasBook = true;
                books.get(i).setNumCopies(restockQuantity + books.get(i).getNumCopies());
            }
        }
        if(!hasBook){
            System.out.println("We're Sorry, it doesn't appear we have a book by that author.");
        }
    }

    /*
     * restockByISBN increases stock for a book with a given ISBN.
     * Signature: public static void restockByISBN(ArrayList<bookType> books, String isbn, int restockQuantity)
     * Parameters:
     *   - books: ArrayList<bookType> → list of all books
     *   - isbn: String → ISBN13 whose book stock should be restocked
     *   - restockQuantity: int → quantity to add to stock
     * Return: none (void)
     * Preconditions: books list must be initialized
     * Postconditions: updates stock for matching book, or prints error if not found
     */
    public static void restockByISBN(ArrayList<bookType> books, String isbn, int restockQuantity){
        boolean hasBook = false;
        for(int i = 0; i < books.size(); i++){
            if( (books.get(i).getISBN13()).equals(isbn)){
                hasBook = true;
                books.get(i).setNumCopies(restockQuantity + books.get(i).getNumCopies());
            }
        }
        if(!hasBook){
            System.out.println("We're Sorry, it doesn't appear we have a book by that author.");
        }
    }

    /*
     * restockByTitle increases stock for a book with a given title.
     * Signature: public static void restockByTitle(ArrayList<bookType> books, String title, int restockQuantity)
     * Parameters:
     *   - books: ArrayList<bookType> → list of all books
     *   - title: String → title whose book stock should be restocked
     *   - restockQuantity: int → quantity to add to stock
     * Return: none (void)
     * Preconditions: books list must be initialized
     * Postconditions: updates stock for matching book, or prints error if not found
     */
    public static void restockByTitle(ArrayList<bookType> books, String title, int restockQuantity){
        boolean hasBook = false;
        for(int i = 0; i < books.size(); i++){
            if( (books.get(i).getTitle()).equals(title)){
                hasBook = true;
                books.get(i).setNumCopies(restockQuantity + books.get(i).getNumCopies());
            }
        }
        if(!hasBook){
            System.out.println("We're Sorry, it doesn't appear we have a book by that author.");
        }
    }

    /*
     * fileReader loads book data from a given file into the books list.
     * Signature: public static boolean fileReader(String fileName, ArrayList<bookType> books)
     * Parameters:
     *   - fileName: String → the name of the file containing book data
     *   - books: ArrayList<bookType> → list to populate with book records
     * Return: boolean → true if file was read successfully, false if an error occurred
     * Preconditions: file must exist and be formatted correctly (title, isbn, publisher, year, price, copies, author in sequence)
     * Postconditions: books list populated with book records if successful; program prints errors otherwise
     */
    public static boolean fileReader(String fileName, ArrayList<bookType> books){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String title;

            while ((title = reader.readLine()) != null) {
                String isbn = reader.readLine();
                String publisher = reader.readLine();
                int yearPublished = Integer.parseInt(reader.readLine().trim());
                double price = Double.parseDouble(reader.readLine().trim());
                int numCopies = Integer.parseInt(reader.readLine().trim());
                String author = reader.readLine();

                books.add(new bookType(title, author, publisher, yearPublished, isbn, price, numCopies));
            }
            System.out.println("All book data loaded successfully!");
            return true;
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            System.out.println("Error detected, exiting");
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
            System.out.println("Error detected, exiting");
            return false;
        }
    }
    



}