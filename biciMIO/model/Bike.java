package model;
import model.User;
import java.util.Scanner;
/**
 * the class for the bikes
 */
public class Bike {

    /**
     * a bike has a plate that identifies it.
     * also, the bike may be available or not.
     * and a bike has an user (the user that's using it at that right moment)
     */

    private String plate;
    private String availability;
    private User user;
    private static Scanner s = new Scanner(System.in);

    /**
     * so, when you create a bike, all you need is its plate
     * and set its availability to yessss because its newwwwww and new things can be useeeeeeeeed.
     */
    public Bike(){
        System.out.print("Write the bike's plate that will identify it: ");
        this.plate = s.next();
        this.availability = "yes";
    }

    /**
     * with this you can change it's availability to "yes" or "not"
     * you know what it means.
     * @param Available :)
     */
   public void setAvailability(String Available){
        this.availability = Available;
   }

    /**
     * allows you to associate the bike to an user.
     * @param name that has a name
     * @param id that has an id.
     */
   public void setUser(){
       if (this.availability.equals("yes")){
           this.user = new User();
           this.availability = "no";
       } else {
           System.out.print("This bike can't be used (is damaged or in actual use by someone else");
       }

   }

    /**
     * did the user arrive? then you call this method :)
     */
   public void setNoUser(){
        this.user = null;
        this.availability = "yes";
   }

   public User getUser(){
       return this.user;

   }

    /**
     *
     * @return the bikes plate.
     */
   public String getPlate(){
        return plate;
   }

    /**
     *
     * @return is the bike available?
     */
   public String getAvailability(){
        return availability;
   }
}
