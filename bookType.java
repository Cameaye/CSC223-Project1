/**
 * The {@code bookType} class represents a book with details such as title, author,
 * publisher, year of publication, ISBN-13, price, and number of copies.
 * <p>
 * It provides constructors for creating default or fully defined books,
 * along with getter and setter methods to access and modify book details.
 * </p>
 */
public class bookType{

    /** The title of the book. */
    private String title;

    /** The author of the book. */
    private String author;

    /** The publisher of the book. */
    private String publisher;

    /** The year the book was published. */
    private int yearPublished;

    /** The ISBN-13 identifier of the book. */
    private String isbn13;

    /** The price of the book. */
    private double price;

    /** The number of copies available for the book. */
    private int numCopies;

    /*
        Constructors: Includes default and fully defined
    */

    /**
     * Default constructor.
     * <p>
     * Initializes all fields to default values:
     * empty strings for text fields, and -1 for numeric fields.
     * </p>
     */
    public bookType(){
        title = "";
        author = "";
        publisher = "";
        yearPublished = -1;
        isbn13 = "";
        price = -1;
        numCopies = -1;
    }

    /**
     * Fully defined constructor.
     *
     * @param title         the title of the book
     * @param author        the author of the book
     * @param publisher     the publisher of the book
     * @param yearPublished the year the book was published
     * @param isbn13        the ISBN-13 of the book
     * @param price         the price of the book
     * @param numCopies     the number of copies available
     */
    public bookType(String title, String author, String publisher, int yearPublished, String isbn13, double price, int numCopies){

        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.isbn13 = isbn13;
        this.price = price;
        this.numCopies = numCopies;
    }


    // ----------------- Getters -----------------

    /**
     * Gets the title of the book.
     *
     * @return the book's title
     */
    public String getTitle(){
        return title;
    }

    /**
     * Gets the author of the book.
     *
     * @return the book's author
     */
    public String getAuthor(){
        return author;
    }


    /**
     * Gets the publisher of the book.
     *
     * @return the book's publisher
     */
    public String getPublisher(){
        return publisher;
    }


    /**
     * Gets the year the book was published.
     *
     * @return the year of publication
     */
    public int getYearPublished(){
        return yearPublished;
    }


    /**
     * Gets the ISBN-13 of the book.
     *
     * @return the ISBN-13
     */
    public String getISBN13(){
        return isbn13;
    }

    /**
     * Gets the price of the book.
     *
     * @return the price
     */
    public double getPrice(){
        return price;
    }

    /**
     * Gets the number of copies available for the book.
     *
     * @return the number of copies
     */
    public int getNumCopies(){
        return numCopies;
    }

    // ----------------- Setters -----------------

    /**
     * Sets the title of the book.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the author of the book.
     *
     * @param author the new author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the publisher of the book.
     *
     * @param publisher the new publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Sets the year the book was published.
     *
     * @param yearPublished the new year of publication
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Sets the ISBN-13 of the book.
     *
     * @param isbn13 the new ISBN-13
     */
    public void setISBN13(String isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     * Sets the price of the book.
     *
     * @param price the new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the number of copies available for the book.
     *
     * @param numCopies the new number of copies
     */
    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    // ----------------- Other Methods -----------------

    /**
     * Prints the details of the book in a formatted output.
     */
   public void printBookDetails(){
    System.out.println("Title: " + title + "\t Author: " + author + "\t Publisher: " + publisher);
    System.out.println("Year Published: " + yearPublished + "\t ISBN13: " + isbn13);
    System.out.println("Price: " + price + "\t Copies: " + numCopies);
   }


    /*
     * Placeholder for future toString override.
     */


}