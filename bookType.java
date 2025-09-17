public class bookType{

    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private String isbn13;
    private double price;
    private int numCopies;


    /*
        Constructors: Includes default and fully defined
    */

   // Default constructor
    public bookType(){
        title = "";
        author = "";
        publisher = "";
        yearPublished = -1;
        isbn13 = "";
        price = -1;
        numCopies = -1;
    }

    // Fully defined
    public bookType(String title, String author, String publisher, int yearPublished, String isbn13, double price, int numCopies){

        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.isbn13 = isbn13;
        this.price = price;
        this.numCopies = numCopies;
    }


   /* 
    * Getters
    */

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getPublisher(){
        return publisher;
    }
    public int getYearPublished(){
        return yearPublished;
    }
    public String getISBN13(){
        return isbn13;
    }
    public double getPrice(){
        return price;
    }
    public int getNumCopies(){
        return numCopies;
    }

    /*
     * Setters
     */
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public void setYearPublished(int yearPublished){
        this.yearPublished = yearPublished;
    }
    public void setISBN13(String isbn13){
        this.isbn13 = isbn13;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setNumCopies(int numCopies){
        this.numCopies = numCopies;
    }


    /*
    * Print book details
    */

   public void printBookDetails(){
    System.out.println("Title: " + title + "\t Author: " + author + "\t Publisher: " + publisher);
    System.out.println("Year Published: " + yearPublished + "\t ISBN13: " + isbn13);
    System.out.println("Price: " + price + "\t Copies: " + numCopies);
   }

   /* Creating space for future toString override */

}