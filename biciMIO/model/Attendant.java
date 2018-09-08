package model;
import java.util.Scanner;
/**
 * the class for the attendant (person who'll be in charge of an specific bikestation)
 */
public class Attendant {

    /**
     * pretty much the same
     * the attendant has an name (if her/his parents gave him/her one).
     * and identification.
     * and a rut.
     */

    private String name;
    private String id;
    private String rut;
    private static Scanner s = new Scanner(System.in);

    public Attendant(){
        System.out.print("Write the attendant's name: ");
        this.name = s.next();
        System.out.print("Write the attendant's identification: ");
        this.id = s.next();
        System.out.print("Write the attendant's rut: ");
        this.rut = s.next();

    }


    public String getName(){
        return this.name;
    }

    public String getId() {
        return id;
    }

    public String getRut() {
        return rut;
    }

    public void updateName(String newname){
        this.name = newname;
    }
    public void updateId(String newid){
        this.id = newid;
    }

    public void updateRut(String newrut){
        this.rut = newrut;
    }
}
