package model;
import java.util.Scanner;

public class Patient {

    private String name;
    private int age;
    private String id;
    private int health;
    private int stratum;
    private boolean compensation_box;
    private static Scanner s = new Scanner(System.in);
    private VaccinationScheme vaccinationScheme;

    public Patient(){
        System.out.print("Write the patient's name: ");
        this.name = s.next();
        System.out.print("Write the patient's identification: ");
        this.id = s.next();
        while (true){
            System.out.print("Write the patient's age (months) : ");
            this.age = s.nextInt();
            if (this.age >= 0 && this.age <= 6){
                break;
            } else{
                System.out.print("invalid age, must be between 0 and 6\n");
            }
        }
        while (true){
            System.out.print("Write the patient's stratum: ");
            this.stratum = s.nextInt();
            if (this.stratum >= 1 && this.stratum <=6){
                break;
            } else {
                System.out.print("invalid stratum, must be between 1 and 6\n");
            }
        }
        System.out.print("Does the patient have a compesation box?: \n 1.Yes \n 2.No \n");
        if (s.nextInt() == 1){
            this.compensation_box = true;
        }
        System.out.print("Is the patient healthy?\n 1.Yes \n 2.No \n");
        this.health = s.nextInt();
        this.vaccinationScheme = new VaccinationScheme(this.stratum, this.health, this.age, this.compensation_box);
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getHealth(){
        return health;
    }


    public VaccinationScheme getVaccinationScheme(){
        return this.vaccinationScheme;
    }
    public void updateHealth(){
        if (this.health == 1){
            this.health = 2;
            getVaccinationScheme().updateHealth();
        } else if (this.health == 2){
            getVaccinationScheme().updateHealth();
            this.health = 1;
        }
    }

    public String getId(){
        return id;
    }
}
