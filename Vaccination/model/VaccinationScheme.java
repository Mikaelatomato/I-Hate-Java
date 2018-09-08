package model;
import java.util.ArrayList;
import java.util.Scanner;

public class VaccinationScheme {

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
    private Scanner s = new Scanner(System.in);

    public VaccinationScheme(int stratum, int health, int age, boolean compesation_box) {
        this.health = health;
        this.age = age;
        this.totalcost = 0;
        this.stratum = stratum;
        this.compensation_box = compesation_box;
    }


    public void init() {
        this.vaccines.add(new Vaccine("Tuberculosis B.C.G                    || ", 0));
        this.vaccines.add(new Vaccine("Hepatitis B                    || ", 0));
        this.vaccines.add(new Vaccine("PRIMERA DOSIS: Polio (Oral - IM)                    || ", 2));
        this.vaccines.add(new Vaccine("PRIMERA DOSIS: Pentavalente: Hepatitis B, Haemophilus, Influenzae tipo B y Difteria, Tosferina, Tetáno (DPT) || ", 2));
        this.vaccines.add(new Vaccine("PRIMERA DOSIS: Rotavirus                    || ", 2));
        this.vaccines.add(new Vaccine("PRIMERA DOSIS: Neumococo                    || ", 2));
        this.vaccines.add(new Vaccine("SEGUNDA DOSIS: Polio (oral - IM)                    || ", 4));
        this.vaccines.add(new Vaccine("SEGUNDA DOSIS: Pentavalente: Hepatitis B, Haemophilus, Influenzae tipo B y Difteria, Tosferina, Tetáno (DPT) || ", 4));
        this.vaccines.add(new Vaccine("SEGUNDA DOSIS: Rotavirus                    || ", 4));
        this.vaccines.add(new Vaccine("SEGUNDA DOSIS: Neumococo                    || ", 4));
        this.vaccines.add(new Vaccine("TERCERA DOSIS: Polio (Oral - IM)                    || ", 6));
        this.vaccines.add(new Vaccine("TERCERA DOSIS: Pentavalente: Hepatitis B, Haemophilus, Influenzae tipo B y Difteria, Tosferina, Tetáno (DPT) || ", 6));
        this.vaccines.add(new Vaccine("Influenza                                        || ", 6));
        setPrices();
    }

    public ArrayList<Vaccine> getVaccines() {
        return vaccines;
    }

    public void possibleVaccines() {
        this.totalcost = 0;
        if (this.health == NOHEALTHY) {
            System.out.print("The patient isn't healthy, so no vaccine can be applied\n\n");
            return;
        } else {
            for (Vaccine v : this.vaccines) {
                for (int i = 0; i < vaccines.size(); i++)
                    if ((this.age >= v.getRequiredage() && this.health == HEALTHY) && vaccines.get(i) == v) {
                        System.out.println("At index " + i + " The vaccine: " + v.getName() + " can be applied for a price of: " + v.getPrice() + "\n");
                        this.totalcost += v.getPrice();
                    }
            }
            System.out.print("The total cost for all the applicable is: " + totalcost + "\n\n");
        }
    }

    public void updateHealth() {
        if (this.health == NOHEALTHY) {
            this.health = HEALTHY;
        } else {
            this.health = NOHEALTHY;
        }
    }

    public void setPrices() {
        for (Vaccine v : this.vaccines) {
            if (v.getName().equals("Tuberculosis B.C.G                    || ")) {
                v.updatePrice(0);
            } else if (v.getName().equals("Hepatitis B                    || ")) {
                v.updatePrice(0);
            } else if (v.getName().equals("PRIMERA DOSIS: Polio (Oral - IM)                    || ")) {
                v.updatePrice(0);
            } else if (v.getName().equals("PRIMERA DOSIS: Pentavalente: Hepatitis B, Haemophilus, Influenzae tipo B y Difteria, Tosferina, Tetáno (DPT) || ")) {
                v.updatePrice(0);
            } else if (v.getName().equals("PRIMERA DOSIS: Neumococo                    || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(94000);
                } else if (this.stratum == 3 || this.stratum == 4) {
                    v.updatePrice(154000);
                } else if (this.stratum == 5 || this.stratum == 6) {
                    v.updatePrice(194000);
                }
            } else if (v.getName().equals("PRIMERA DOSIS: Rotavirus                    || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(20000);
                } else if (this.stratum == 3 || this.stratum == 4) {
                    v.updatePrice(64000);
                } else if (this.stratum == 5 || this.stratum == 6) {
                    v.updatePrice(110000);
                }
            } else if (v.getName().equals("SEGUNDA DOSIS: Polio (Oral - IM)                    || ")) {
                v.updatePrice(0);
            } else if (v.getName().equals("SEGUNDA DOSIS: Pentavalente: Hepatitis B, Haemophilus, Influenzae tipo B y Difteria, Tosferina, Tetáno (DPT) || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(0);
                } else if (this.stratum == 3 || this.stratum == 4) {
                    v.updatePrice(0);
                } else if (this.stratum == 5 || this.stratum == 6) {
                    v.updatePrice(35000);
                }
            } else if (v.getName().equals("SEGUNDA DOSIS: Neumococo                    || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(94000);
                } else if (this.stratum == 3 || this.stratum == 4) {
                    v.updatePrice(154000);
                } else if (this.stratum == 5 || this.stratum == 6) {
                    v.updatePrice(194000);
                }
            } else if (v.getName().equals("SEGUNDA DOSIS: Rotavirus                    || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(15000);
                } else if (this.stratum == 3 || this.stratum == 4) {
                    v.updatePrice(59000);
                } else if (this.stratum == 5 || this.stratum == 6) {
                    v.updatePrice(105000);
                }
            } else if (v.getName().equals("Influenza                                        || ")) {
                if (this.stratum == 1 || this.stratum == 2) {
                    v.updatePrice(0);
                } else if (this.stratum >= 3 && this.stratum <= 6) {
                    v.updatePrice(50000);
                }
            } else if (v.getName().equals("TERCERA DOSIS: Polio (Oral - IM)                    || ")) {
                v.updatePrice(0);
            } else if (v.getName().equals("TERCERA DOSIS: Pentavalente: Hepatitis B, Haemophilus, Influenzae tipo B y Difteria, Tosferina, Tetáno (DPT) || ")) {
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

    public void applyVaccine() {
        possibleVaccines();
        while (true) {
            if (this.health == HEALTHY){
                System.out.print("Which vaccine do you wanna apply to the patient?: ");
                int a = s.nextInt();
                int b = 0;
                for (Vaccine v : vaccines){
                    if ((vaccines.get(a).getName().substring(0, 13).equals("SEGUNDA DOSIS") && (vaccines.get(a).getName().substring(16, 20).equals(v.getName().substring(16, 20)) && v.getName().substring(0, 13).equals("PRIMERA DOSIS"))
                            || (vaccines.get(a).getName().substring(0, 13).equals("TERCERA DOSIS") && vaccines.get(a).getName().substring(16, 20).equals(v.getName().substring(16, 20))) && v.getName().substring(0, 13).equals("SEGUNDA DOSIS"))){
                        b = 1;
                    }
                }
                if (a >= 0 && a <= 12 && b == 0){
                    appliedvaccines.add(getVaccines().get(a));
                    totalpayed += vaccines.get(a).getPrice();
                    vaccines.remove(a);
                    System.out.print("The vaccine was successfully applied\n\n");
                    break;
                } else if (a < 0 || a > 13 && b == 0) {
                    System.out.print("Select the vaccine by index, look at it again :)\n");
                } else if (b == 1){
                    System.out.print("That vaccine can't be applied, you must apply the previous dose first\n");
                }
            } else {
                System.out.print("The patient isn't healthy, so no vaccine can be applied.\n\n");
                break;
            }
        }
    }

    public void appliedVaccines(){
        System.out.print("The following vaccines had been applied to this patient: \n");
        for (Vaccine v : appliedvaccines){
            System.out.print(v.getName() + " for a price of: " + v.getPrice() + "\n");
        }
        System.out.print("The total amount payed by the patient is: " + this.totalpayed + "\n\n");
    }

    public float getTotalpayed(){
        return totalpayed;
    }
}