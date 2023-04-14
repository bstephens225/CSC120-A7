/**
@author bethany stephens
*/

import java.util.ArrayList;
public class House extends Building{
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElev=false;
  
  public House(String name, String address, int nFloors, ArrayList<String> res, boolean dining, boolean elev) {
    super(name, address, nFloors);
    residents=res;
    hasDiningRoom=dining;
    hasElev=elev;
    System.out.println("You have built a house: 🏠");
  }

/**check if house has a dining room
 * @return boolean whether it has a dining room
*/
public boolean hasDiningRoom(){
  return hasDiningRoom;
}

/**check how many residents
 * @return int number of residents
*/
public int nResidents(){
  return residents.size();
}

/**move a person into the house
 * @param String person added to residents list
*/
public void moveIn(String name){
  residents.add(name);
}

/**move someone out
 * @param String person moving out
 * @return String person moving out
*/
public String moveOut(String name){
  if (isResident(name)){
    residents.remove(name);
  }else{
    throw new RuntimeException("this person does not live here)");
  }
  return name;
} // return the name of the person who moved out

/**check if person is a resident
 * @param String person's name
 * @return boolean is the person in the house
*/
public boolean isResident(String person){
  return residents.contains(person);
}
public void showOptions() {
  System.out.println("Available options at " + this.name + ":\n + moveOut() \n + moveIn() \n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
}

public void goToFloor(int floorNum) {
  if(hasElev==true){
    super.goToFloor(floorNum);
  }
  else if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
  }
  else if(floorNum>this.activeFloor+1||floorNum<this.activeFloor-1){
      throw new RuntimeException("Invalid floor number. No elevator. Go one floor at a time");
  }
}

public void goUp(int n) {
  this.goToFloor(this.activeFloor + n);
}
  

public void goDown(int n) {
  this.goToFloor(this.activeFloor + n);
}

  public static void main(String[] args) {
    ArrayList<String> firstFloor = new ArrayList<String>();
    firstFloor.add("bethany");
    firstFloor.add("kim");
    House Northrop=new House("northrop","upper elm",4,firstFloor,true,true);
    System.out.println(Northrop.isResident("bethany"));
    System.out.println(Northrop.isResident("hazel"));
    Northrop.moveIn("hazel");
    System.out.println(Northrop.nResidents());
    Northrop.moveOut("bethany");
    System.out.println(Northrop.isResident("bethany"));
    System.out.println(Northrop.isResident("hazel"));
    System.out.println(Northrop.nResidents());
  }

}