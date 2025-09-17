import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class userInterface{


    public static void main(String[] args){

        ArrayList<bookType> books = new ArrayList<>();
        Scanner lineInput = new Scanner(System.in);

        System.out.println("Welcome to the Robust Book Library, please enter the name of the file you would like to search through: ");
        String fileName = lineInput.nextLine();

        fileReader(fileName, books);

        boolean userInterfaceLoopCondition = true;
        int userInterfaceSelector;
        while(userInterfaceLoopCondition){
            System.out.println("Please enter the number with your desired functionality: ");
            System.out.println(" 1) Print all books in stock \n 2) Search Books by ISBN13 \n 3) Search Books by Author \n 4) Search Books by Title");
            System.out.println(" 5) Print all books \n 6) Update stock by Author \n -1) Exit");
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
                    break;
                case -1:
                    System.out.println("Thank you for using our service!");
                    userInterfaceLoopCondition = false;
                    lineInput.close();
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
            System.out.println("We're Sorry, it doesn't appear we have a book with that ISBN13.");

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
            System.out.println("We're Sorry, it doesn't appear we have a book by that author.");
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
            System.out.println("We're Sorry, it doesn't appear we have a book with that title.");
        }
    }

    public static void printAll(ArrayList<bookType> books){
        for(int i = 0; i < books.size(); i++){
            books.get(i).printBookDetails();
        }
    }

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
    public static void fileReader(String fileName, ArrayList<bookType> books){
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
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        }
    }
    



}