package model;
import model.Bike;
import model.Attendant;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * the bike stations class.
 */
public class BikeStation {
    /**
     * -capacity : how many bikes can this bikestation storage?
     * -bikecount: just to know how many bikes this bikestation actually has.
     * -stationname: the name for this bikestation.
     * -latitude: some weird thing that you can get on google.
     * -longitude: some as above.
     * -Attendant: person in charge.
     * -bikes: a collection of the bikes in the station.
     * -a =
     */

    private int capacity;
    private int bikecount;
    private String stationname;
    private double latitude;
    private double longitude;
    private Attendant attendant;
    private ArrayList<Bike> bikes = new ArrayList<>();
    private int a;
    private static Scanner s = new Scanner(System.in);

    /**
     *
     * @param stationname idk, the station's name maybe.
     * @param latitude latitude (check google maps if you need it)
     * @param longitude same as above.
     * @param capacity how many bikes can this station storage?
     */

    public BikeStation(){
        System.out.print("Station's name: ");
        this.stationname = s.next();
        System.out.print("Station's latitude: ");
        this.latitude = s.nextDouble();
        System.out.print("Station's longitude: ");
        this.longitude = s.nextDouble();
        System.out.print("Station's capacity: ");
        this.capacity = s.nextInt();
        bikecount = 0;
        a = 0;

    }

    /**
     *
     * @return bikeStation's latitude.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     *
     * @return bikeStation's longitude.
     */

    public double getLongitude() {
        return longitude;
    }

    /**
     * sets a person to be in charge of that station.
     * @param name his/her name
     * @param id his/her identification
     * @param rut his/her rut
     */
    public void setAttendant(){
        this.attendant = new Attendant();
    }

    public void setStationname(){
        System.out.print("new station's name: ");
        this.stationname = s.next();
    }

    public void setCapacity(){
        System.out.print("new station's capacity: ");
        this.capacity = s.nextInt();
    }

    /**
     * Displays who's in charge of the bikestation.
     */
    public void displayAttendant() {
        System.out.print("\n\nThe Bikestation: " + this.getStationname() + " is in charge of: "+ this.attendant.getName() + " with ID: " +
                this.attendant.getId() + " and rut: " + this.attendant.getRut());
    }

    /**
     *
     * @return the bikestation's attendant.
     */
    public Attendant getAttendant(){
        return this.attendant;
    }

    public void displayActualCapacity(){
        System.out.print("\n\nThis bikestation can storage: " + (capacity - bikecount) + " bikes more");
    }

    /**
     *
     * @return the bikestation's name.
     */
    public String getStationname(){
        return this.stationname;
    }

    /**
     * creates a new bike for the station
     * won't be able to create more if the capacity is reached.
     * @param plate for the new bike.
     */
    public void newBike(){
        if(bikecount != capacity) {
            bikes.add(new Bike());
            bikecount += 1;
        } else{
            System.out.print("\n\nThis bikestation can't storage more bikes!!");
        }
    }

    /**
     * allows to get the array of bikes and get and item from it with .get(index).method()
     */
    public ArrayList<Bike> getBikes(){
        return bikes;
    }

    /**
     * displays the bikes in the bikestation.
     */
    public void displayBikes(){
        a = 0;
        while (a != bikecount){
            System.out.print("\nAt index: " + a + " | bike | " +  this.bikes.get(a).getPlate());
            a += 1;
        }
    }

    /**
     * So, did a user leave the station with a bike to and headed to a new station?
     * this method allows you to make that "move" from this to another station.
     * or just if the
     * @param bikeStation where the bike is heading to.
     * @param index bike's index
     */
    public void moveBike(BikeStation bikeStation, int index){
        bikeStation.getBikes().add(this.bikes.get(index));
        this.bikes.remove(index);
        this.bikecount -= 1;
        bikeStation.bikecount += 1;
    }

}