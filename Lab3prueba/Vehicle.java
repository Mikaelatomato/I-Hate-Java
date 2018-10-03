import java.util.Scanner;

public class Vehicle {

    private String model;
    private String brand;
    private Double price;
    private String reference;
    private String color;
    private Scanner s = new Scanner(System.in);
    /**
     * i'm missing available quantity, will check it later.
     */

    public Vehicle(){
        System.out.print("\nVehicle's model: ");
        this.model = s.nextLine();
        System.out.print("\nVehicle's brand: ");
        this.brand = s.nextLine();
        System.out.print("\nVehicle's price: ");
        this.price = s.nextDouble();
        System.out.print("\nVehicle's reference: ");
        this.reference = s.nextLine();
        System.out.print("\nVehicle's color : ");
        this.color = s.nextLine();
    }
}
