package model;
import java.util.Scanner;

public class Patient {
    /**
     * WELL, a patient can be identified by: an id, a name, an age (in months), a stratum.
     * Also, a patient may have a compensation box (which will give him a 15% discount on vaccines)
     * He may be sick or not, (healthy or not)
     * and surely, he'll have a vaccination scheme.
     */

    private String name;
    private int age;
    private String id;
    private int health;
    private int stratum;
    private boolean compensation_box;
    private static Scanner s = new Scanner(System.in);
    private VaccinationScheme vaccinationScheme;


    /**
     * so, this is the constructor, and surely you will ask me "WHY YOU DIDN'T DO A INIT METHOD FOR THIS SHIT; BRO THIS SH*T SO LONG",
     * you can find the reason on the clinic class, exactly at the newpatient(); method, it's easier for me this way.
     * i don't know how to work with exceptions on java and i'm too lazy to learn, surely it's not so easy as it's on python, so, this is all i can do to make it
     * the safest possible.
     *
     * i just find out a problem.
     * the "s.nextLine();" that seems to not be doing anything, actually stops the method from skipping the "this.name = s.nextLine();"
     * if you remove the "s.nextLine()" that's at the beginning, you'll see what i'm talking about, (SO, IT'S INTENTIONAL, I PUT IT THERE SO THE CODE WORKS CORRECTLY
     * THE FIRST TIME THE USER CREATES A PATIENT HE'LL HAVE TO PUT ITS NAME TWICE")
     * i was looking for a solution, and this is all i found.
     */
    public Patient() {
        System.out.print("Write the patient's name: ");
        s.nextLine();
        this.name = s.nextLine();
        System.out.print("Write the patient's identification: ");
        this.id = s.nextLine();
        while (true) {
            System.out.print("Write the patient's age (in months) : ");
            this.age = s.nextInt();
            if (this.age >= 0 && this.age <= 6) {
                break;
            } else {
                System.out.print("invalid age, must be between 0 and 6\n");
            }
        }
        while (true) {
            System.out.print("Write the patient's stratum: ");
            this.stratum = s.nextInt();
            if (this.stratum >= 1 && this.stratum <= 6) {
                break;
            } else {
                System.out.print("invalid stratum, must be between 1 and 6\n");
            }
        }
        while (true) {
            int a;
            System.out.print("Does the patient have a compesation box?: \n 1.Yes \n 2.No \n");
            a = s.nextInt();
            if (a == 1) {
                this.compensation_box = true;
                break;
            } else if (a == 2) {
                this.compensation_box = false;
                break;
            } else {
                System.out.print("invalid option, try again\n");
            }
        }
        while (true) {
            System.out.print("Is the patient healthy?\n 1.Yes \n 2.No \n");
            this.health = s.nextInt();
            if (this.health == 1 || this.health == 2) {
                break;
            } else {
                System.out.print("invalid option\n");
            }
        }
        this.vaccinationScheme = new VaccinationScheme(this.stratum, this.health, this.age, this.compensation_box);
        System.out.print("Patient registered successfully\n\n");
    }

    /**
     * do i need to explain this obvious methods?
     * @return the patients name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the patients age
     */
    public int getAge(){
        return age;
    }

    /**
     *
     * @return the patients health status
     */

    public int getHealth(){
        return health;
    }

    /**
     *
     * @return its vaccination scheme so you can use it.
     */

    public VaccinationScheme getVaccinationScheme(){
        return this.vaccinationScheme;
    }

    /**
     * updates its health, on the vaccination scheme class this would mean from: healthy to not healthy, and the same thing on the other way.
     */
    public void updateHealth(){
        if (this.health == 1){
            this.health = 2;
            getVaccinationScheme().updateHealth();
        } else if (this.health == 2){
            getVaccinationScheme().updateHealth();
            this.health = 1;
        }
    }

    /**
     *
     * @return the patient's id
     */
    public String getId(){
        return id;
    }

    public int getStratum(){
        return this.stratum;
    }
    public boolean isCompensation_box(){
        return this.compensation_box;
    }
}
