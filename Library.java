/**
@author bethany stephens
*/
import java.util.Hashtable;

public class Library extends Building{
  private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors, Hashtable<String,Boolean> books) {
      super(name, address, nFloors);
      collection = books;
      System.out.println("You have built a library: 📖");
    }

    /**add a title to library collection
     * @param String book being added
    */
    public void addTitle(String title){
      collection.put(title,Boolean.valueOf(true));
    }

    /**removes a title from library collection
     * @param String book being removed
     * @return String book being removed
     * @throws RunTimeException if book is not in collection
    */
    public String removeTitle(String title){
      if(containsTitle(title)){
        collection.remove(title);
      }else{
        throw new RuntimeException("this title is not in the collection");
      }
      return title;
    } 

    /**checks out a title from library collection
     * @param String book being checked out
     * @throws RunTimeException if book is not available
    */
    public void checkOut(String title){
      if(isAvailable(title)){
        collection.replace(title, false);
      }else{
        throw new RuntimeException("this title is not available right now");
      }
    }

    /**returns a title to the library collection
     * @param String book being returned
     * @throws RunTimeException if book is not in collection
    */
    public void returnBook(String title){
      if(containsTitle(title)){
        collection.replace(title, true);
      }else{
        throw new RuntimeException("this title is not in the collection");
      }
    }

    /**returns true if the title is currently in the library collection, false otherwise
     * @param String book being checked for
     * @return boolean whether book is found
    */
    public boolean containsTitle(String title){
      if(collection.containsKey(title)){
        return true;
      }
      else{
        return false;
      }
    } 

    /**returns true if the title is currently available, false otherwise
     * @param String book being checked for
     * @return boolean whether book is available
     * @throws RunTimeException if book is not in collection
    */
    public boolean isAvailable(String title){
      if(containsTitle(title)){
        if(collection.get(title)){
          return true;
        }else{
          return false;
        }
      }
      else{
        throw new RuntimeException("this title is not in the collection");
      }
    } 
    
    /**prints out the entire collection in an easy-to-read way (including checkout status)
    */
    public void printCollection(){
      collection.forEach(
            (k, v) -> System.out.println("Book: " + k + ", Available: " + v));
    }

    /**show interactive options
  */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + returnBook() \n + removeTitle() \n + addTitle() \n + printCollection() \n + checkOut() \n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /**go up n floors on elevator
    * @param int n how many flights we ascend
    */
    public void goUp(int n) {
      this.goToFloor(this.activeFloor + n);
    }

    /**go down n floors on elevator
    * @param int n how many flights we descend
    */  
    public void goDown(int n) {
      this.goToFloor(this.activeFloor - n);
    }

    public static void main(String[] args) {
      Hashtable<String,Boolean> books = new Hashtable<>();
      Library neilson=new Library("neilson","seelye lawn",4, books);
      neilson.addTitle("Soc");
      neilson.addTitle("CK");
      neilson.printCollection();
      neilson.checkOut("Soc");
      neilson.printCollection();
      neilson.returnBook("Soc");
      neilson.printCollection();
      neilson.enter();
      neilson.goToFloor(2);
      neilson.goUp(1);
      
    }
  
  }