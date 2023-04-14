/** Cafe class
@author bethany stephens
*/

public class Cafe extends Building{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private int nPizza; // The number of slices remaining in inventory
    
    
    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors);
        nCoffeeOunces=coffee;
        nSugarPackets=sugar;
        nCreams=cream;
        nCups=cups;
        System.out.println("You have built a cafe: ☕");
    }
    //empty cafe constructor
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        nCoffeeOunces=0;
        nSugarPackets=0;
        nCreams=0;
        nCups=0;
        System.out.println("You have built a cafe: ☕");
    }
    //cafe/pizzeria constructor
    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups,int pizza) {
        super(name, address, nFloors);
        nCoffeeOunces=coffee;
        nSugarPackets=sugar;
        nCreams=cream;
        nCups=cups;
        nPizza=pizza;
        System.out.println("You have built a cafe: ☕");
    }

    /**sell a coffee/ remove ingredients from inventory
     * @param int ounces of coffee
     * @param int number of sugar packets
     * @param int number of splashes of cream
    */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        nCoffeeOunces-=size;
        this.nSugarPackets-=nSugarPackets;
        this.nCreams-=nCreams;
        nCups-=1;
        if(nCoffeeOunces<=0||this.nCreams<=0||this.nCreams<=0||nCups<=0){
            restock(100,100,100,10);
        }
    }
    /**restock inventory
     * @param int ounces of coffee
     * @param int number of sugar packets
     * @param int number of splashes of cream
     * @param int number of cups
    */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces=nCoffeeOunces;
        this.nSugarPackets=nSugarPackets;
        this.nCreams=nCreams;
        this.nCups=nCups;
    }

    /**show interactive options
    */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + sellCoffee() \n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }
    
    /**dont to floor because we don't have one, throw correct exception
     * @param int destination floor number
    */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        else if(floorNum!=1){
            throw new RuntimeException("Invalid floor number. You are only allowed on the ground floor");
        }
    }
    public static void main(String[] args) {
        Cafe compass=new Cafe("compass cafe","neilson library",2,70,30,10,15);
        compass.sellCoffee(12, 2, 3);
        compass.enter();
        compass.goToFloor(4);
    }
    
}
