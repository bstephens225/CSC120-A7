import java.util.ArrayList;
import java.util.Hashtable;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Burton Hall", "46 College Ln, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Sabin Reed Hall", "44 College Ln, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Dr, Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Dewey Hall", "Neilson Drive, Northampton, MA 01063", 3));

        //libraries
        Hashtable<String,Boolean> books = new Hashtable<>();
        myMap.addBuilding(new Library("Neilson", "7 Neilson Drive, Northampton, MA 01063", 4,books));

        //houses
        ArrayList<String> northropRes = new ArrayList<String>();
        myMap.addBuilding(new House("Northrop", "49 Elm Street, Northampton, MA 01060", 4,northropRes,true));
        ArrayList<String> parsonsRes = new ArrayList<String>();
        myMap.addBuilding(new House("Parsons", "Parsons House, 24 Henshaw Ave, Northampton, MA 01060", 5,parsonsRes,false));
        ArrayList<String> gillettRes = new ArrayList<String>();
        myMap.addBuilding(new House("Gillett", "47 Elm Street, Northampton, MA 01060", 5,gillettRes,true));

        //cafes
        myMap.addBuilding(new Cafe("Compass Cafe","Neilson Library",2,70,30,10,15));
        myMap.addBuilding(new Cafe("Campus Cafe","Smith College Campus Center, 100 Elm St, Northampton, MA 01063",1,70,30,10,15));
        System.out.println(myMap);
        
    }
    
}
