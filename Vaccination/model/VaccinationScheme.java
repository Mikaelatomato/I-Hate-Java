package model;
import java.util.ArrayList;
import java.util.Scanner;

public class VaccinationScheme {
    /**
     * this is the exciting class for sure.
     * before moving on, i've been wondering, is there someone else that writes code better and faster than me on the class? if you know, let me know.
     * and now i wonder, who qualifies, checks these works? our pretty monitor (instructor) or is it always the teacher?
     * also, will we get the grades of the 1st lab before this one grades? who knows.
     *
     * excuse me.
     *
     * HEALTHY and NOHEALTHY for to classify the patient's status and, let the user use the methods for the patient owner of this scheme.
     * An arraylist 'vaccines' that contains all the vaccines.
     * An arraylist 'appliedvaccines' that contains all the applied vaccines that aren't anymore on the 'vaccines' array after being applied.
     * totalcost: means cost of all the vaccines together if a patient would get them all.
     * totalpayed: how much has a patient payed?
     * stratum, health, age: these ones are from the patient, and are very required here as you will see.
     * lastly, possible is used to keep track of how many vaccines had been applied and how many else can be applied, without this, the code wouldn't know what to do
     * when all the displayed vaccines were applied.
     */

    private ArrayList<Vaccine> vaccines = new ArrayList<Vaccine>();
    private ArrayList<Vaccine> appliedvaccines = new ArrayList<>();
    private final static int HEALTHY = 1;
    private final static int NOHEALTHY = 2;
    private float totalcost;
    private float totalpayed;
    private boolean compensation_box;
    private int stratum;
    private int health;
    private int age;
    private int possible = 0;
    private Scanner s = new Scanner(System.in);

    /**
     * the constructor, this params are from the patient that owns it.
     * @param stratum patients stratum for setting the prices of the vaccines
     * @param health this way he may be able to get vaccines or now
     * @param age what vaccines can the patient get with its age?
     * @param compesation_box will the patient get that juicy 15% discount? only this knows.
     */

    public VaccinationScheme(int stratum, int health, int age, boolean compesation_box) {
        this.health = health;
        this.age = age;
        this.totalcost = 0;
        this.stratum = stratum;
        this.compensation_box = compesation_box;
    }

    /**
     * the famous init method
     * sets all the vaccines that a Vaccination Scheme of 6 months should have.
     * also, sets the prices of the vaccines with the params that we got from the owner patient :)
     */

    public void init() {
        this.vaccines.add(new Vaccine("DOSIS UNICA: Tuberculosis B.C.G || ", 0));
        this.vaccines.add(new Vaccine("DOSIS UNICA: Hepatitis B || ", 0));
        if (this.age >= 2){
            this.vaccines.add(new Vaccine("PRIMERA DOSIS: Polio (Oral - IM) || ", 2));
            this.vaccines.add(new Vaccine("PRIMERA DOSIS: Pentavalente: Hepatitis B, Haemophilus,\nInfluenzae tipo B y Difteria, Tosferina, Tetano (DPT) || ", 2));
            this.vaccines.add(new Vaccine("PRIMERA DOSIS: Rotavirus || ", 2));
            this.vaccines.add(new Vaccine("PRIMERA DOSIS: Neumococo || ", 2));
            if (this.age >=4){
                this.vaccines.add(new Vaccine("SEGUNDA DOSIS: Polio (oral - IM) || ", 4));
                this.vaccines.add(new Vaccine("SEGUNDA DOSIS: Pentavalente: Hepatitis B, Haemophilus,\nInfluenzae tipo B y Difteria, Tosferina, Tetano (DPT) || ", 4));
                this.vaccines.add(new Vaccine("SEGUNDA DOSIS: Rotavirus || ", 4));
                this.vaccines.add(new Vaccine("SEGUNDA DOSIS: Neumococo || ", 4));
                if (this.age == 6){
                    this.vaccines.add(new Vaccine("TERCERA DOSIS: Polio (Oral - IM) || ", 6));
                    this.vaccines.add(new Vaccine("TERCERA DOSIS: Pentavalente: Hepatitis B, Haemophilus,\nInfluenzae tipo B y Difteria, Tosferina, Tetano (DPT) || ", 6));
                    this.vaccines.add(new Vaccine("PRIMERA DOSIS: Influenza || ", 6));
                }
            }
        }
        setPrices();
    }

    /**
     *
     * @return the vaccines array.
     */
    public ArrayList<Vaccine> getVaccines() {
        return vaccines;
    }

    /**
     * displays all the possible vaccines that can be applied to a patient and, how much would that cost.
     */

    public void possibleVaccines() {
        this.totalcost = 0;
        if (this.health == NOHEALTHY) {
            System.out.print("The patient isn't healthy, so no vaccine can be applied\n\n");
            return;
        } else {
            for (Vaccine v : this.vaccines) {
                for (int i = 0; i < vaccines.size(); i++)
                    if ((this.age >= v.getRequiredAge() && this.health == HEALTHY) && vaccines.get(i) == v) {
                        System.out.println("At index " + i + " The vaccine: " + v.getName() + " can be applied for a price of: " + v.getPrice() + "\n");
                        System.out.println("-------------------------------------------------------------------------------------------------------\n");
                        this.totalcost += v.getPrice();
                        if (possible < i ){
                            possible += 1;
                        }
                    }
            }
            System.out.print("The total cost for all the applicable vaccines is: " + totalcost + "\n\n");
        }
    }

    /**
     * have you seen this before? yea, if a patient gets healthy, its scheme should know it too :0
     * that's why when the patients "updateHealth();" method is called, this one is also.
     */
    public void updateHealth() {
        if (this.health == NOHEALTHY) {
            this.health = HEALTHY;
        } else {
            this.health = NOHEALTHY;
        }
    }

    /**
     * sets the price for every vaccine based on the lab2.pdf information.
     * the price is defined by : stratum.
     *  and every vaccine has a 15% discount if the patient has a compensation box.
     */
    public void setPrices() {
        for (Vaccine v : this.vaccines) {
            if (v.getName().equals("DOSIS UNICA: Tuberculosis B.C.G || ")) {
                v.updatePrice(0);
            } else if (v.getName().equals("DOSIS UNICA: Hepatitis B || ")) {
                v.updatePrice(0);
            } else if (v.getName().equals("PRIMERA DOSIS: Polio (Oral - IM) || ")) {
                v.updatePrice(0);
            } else if (v.getName().equals("PRIMERA DOSIS: Pentavalente: Hepatitis B, Haemophilus,\nInfluenzae tipo B y Difteria, Tosferina, Tetano (DPT) || ")) {
                v.updatePrice(0);
            } else if (v.getName().equals("PRIMERA DOSIS: Neumococo || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(94000);
                } else if (this.stratum == 3 || this.stratum == 4) {
                    v.updatePrice(154000);
                } else if (this.stratum == 5 || this.stratum == 6) {
                    v.updatePrice(194000);
                }
            } else if (v.getName().equals("PRIMERA DOSIS: Rotavirus || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(20000);
                } else if (this.stratum == 3 || this.stratum == 4) {
                    v.updatePrice(64000);
                } else if (this.stratum == 5 || this.stratum == 6) {
                    v.updatePrice(110000);
                }
            } else if (v.getName().equals("SEGUNDA DOSIS: Polio (Oral - IM) || ")) {
                v.updatePrice(0);
            } else if (v.getName().equals("SEGUNDA DOSIS: Pentavalente: Hepatitis B, Haemophilus,\nInfluenzae tipo B y Difteria, Tosferina, Tetano (DPT) || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(0);
                } else if (this.stratum == 3 || this.stratum == 4) {
                    v.updatePrice(0);
                } else if (this.stratum == 5 || this.stratum == 6) {
                    v.updatePrice(35000);
                }
            } else if (v.getName().equals("SEGUNDA DOSIS: Neumococo || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(94000);
                } else if (this.stratum == 3 || this.stratum == 4) {
                    v.updatePrice(154000);
                } else if (this.stratum == 5 || this.stratum == 6) {
                    v.updatePrice(194000);
                }
            } else if (v.getName().equals("SEGUNDA DOSIS: Rotavirus || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(15000);
                } else if (this.stratum == 3 || this.stratum == 4) {
                    v.updatePrice(59000);
                } else if (this.stratum == 5 || this.stratum == 6) {
                    v.updatePrice(105000);
                }
            } else if (v.getName().equals("PRIMERA DOSIS: Influenza || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(0);
                } else if (this.stratum >= 3 && this.stratum <= 6) {
                    v.updatePrice(50000);
                }
            } else if (v.getName().equals("TERCERA DOSIS: Polio (Oral - IM) || ")) {
                v.updatePrice(0);
            } else if (v.getName().equals("TERCERA DOSIS: Pentavalente: Hepatitis B, Haemophilus,\nInfluenzae tipo B y Difteria, Tosferina, Tetano (DPT) || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(0);
                } else if (this.stratum == 3 || this.stratum == 4) {
                    v.updatePrice(18000);
                } else if (this.stratum == 5 || this.stratum == 6) {
                    v.updatePrice(35000);
                }
            } if (this.compensation_box){
                v.updatePrice(v.getPrice() - (v.getPrice()*15)/100);
            }
        }
    }

    /**
     * Applies a vaccine to a patient, removing the vaccine from the 'vaccines' array, but also adding it to the 'appliedvaccines' one.
     * a patient can't get a vaccine of higher dose if the lower doses hadn't been applied.
     * also, if the patient isn't healthy he/she can't be vaccinated.
     * ("what about if the patient isn't healthy because he needs the vaccine to be it? will he die? that's so sad")
     */
    public void applyVaccine() {
        possibleVaccines();
        if (possible + 1 == appliedvaccines.size()){
            System.out.print("There aren't more vaccines to be applied\n\n");
            return;
        }
        while (true) {
            if (this.health == HEALTHY){
                System.out.print("\nWhich vaccine do you wanna apply to the patient?: ");
                int a = s.nextInt();
                int b = 0;
                if (a < 0 || a > possible){
                    System.out.print("Select the vaccine by index, look at it again :)\n");
                } else {
                    for (Vaccine v : vaccines){
                        if ((vaccines.get(a).getName().substring(0, 13).equals("SEGUNDA DOSIS") && (vaccines.get(a).getName().substring(16, 20).equals(v.getName().substring(16, 20)) && v.getName().substring(0, 13).equals("PRIMERA DOSIS"))
                                || (vaccines.get(a).getName().substring(0, 13).equals("TERCERA DOSIS") && vaccines.get(a).getName().substring(16, 20).equals(v.getName().substring(16, 20))) && v.getName().substring(0, 13).equals("SEGUNDA DOSIS"))){
                            b = 1;
                        }
                    }
                    if (b == 0){
                        appliedvaccines.add(getVaccines().get(a));
                        totalpayed += vaccines.get(a).getPrice();
                        vaccines.remove(a);
                        System.out.print("The vaccine was successfully applied\n\n");
                        break;
                    } else {
                        System.out.print("\nThat vaccine can't be applied, you must apply the previous dose first\nalso make sure that the vaccine select is listed above\n");
                    }
                }
            } else {
                System.out.print("The patient isn't healthy, so no vaccine can be applied.\n\n");
                break;
            }
        }
    }

    /**
     * Displays all the vaccines that had been applied to a patient and are on the 'appliedvaccines' array.
     * and how much has he payed :)
     */
    public void appliedVaccines(){
        System.out.print("The following vaccines had been applied to this patient: \n");
        for (Vaccine v : appliedvaccines){
            System.out.print(v.getName() + " for a price of: " + v.getPrice() + "\n");
            System.out.println("---------------------------------------------------------------------------------------------------------\n");
        }
        System.out.print("The total amount payed by the patient is: " + this.totalpayed + "\n\n");
    }

    /**
     *
     * @return how much has been payed.
     */
    public float getTotalPayed(){
        return totalpayed;
    }
}