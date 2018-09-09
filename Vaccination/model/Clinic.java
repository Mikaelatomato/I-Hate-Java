package model;
import java.util.ArrayList;
import java.util.Scanner;

public class Clinic {
    /**
     * So, i have an arraylist that contains the patients of an instance of this class.
     * also, an instance of the class may have a: nit, business name, dir, phone that identifies it.
     * + a totalgained, that's the money gained from the vaccines applied to the patients.
     * i use "patientcount" to keep the track of how many patients have been registered to the clinic and limit it from 3 to 5.
     */

    private ArrayList<Patient> patients = new ArrayList<Patient>();
    private int patientcount;
    private String nit;
    private String business_name;
    private String dir;
    private String phone;
    private float totalgained;
    private Scanner s = new Scanner(System.in);

    /**
     * constructor method, every clinic starts with 0 patients and no money gained from vaccines.
     */
    public Clinic(){
        this.totalgained = 0;
        this.patientcount = 0;
    }

    /**
     * init method that allows the user to create the clinic.
     */

    public void init(){
        System.out.print("Clinic's business name: ");
        this.business_name = s.nextLine();
        System.out.print("Clinic's nit: ");
        this.nit = s.nextLine();
        System.out.print("Clinic's dir: ");
        this.dir = s.nextLine();
        System.out.print("Clinic's phone: ");
        this.phone = s.nextLine();
    }

    /**
     * adds a new patient to the clinic :)
     * it's limited to 5 patients.
     */
    public void newPatient(){
        if (this.patientcount >= 0 && this.patientcount <= 4){
            this.patients.add(new Patient());
            this.patients.get(patientcount).getVaccinationScheme().init();
            this.patientcount +=1;
        } else {
            System.out.print ("This clinic can't have more patients.\n\n");
        }
    }

    /**
     * calculates the total amount gained from vaccines by getting the amount payed by every patient.
     */
    public void calculateTotalGain(){
        totalgained = 0;
        for (Patient p : patients){
            totalgained += p.getVaccinationScheme().getTotalPayed();
        }
    }

    /**
     * just
     * @return the total gained amount from vaccines
     */
    public float getTotalGained(){
        calculateTotalGain();
        return totalgained;
    }

    /**
     *
     * @param a is used for referring to a patient by index
     * @return the patient selected by the index "a"
     */
    public Patient getPatient(int a){
        return patients.get(a);
    }


    /**
     * displays on screen all the patients that are registered on the clinic
     */
    public void displayPatients(){
        for (int i = 0; i < patients.size(); i++){
            System.out.print("At index " +  i  + " || is the patient identified with the id: "+ this.patients.get(i).getId() + "\n");
            System.out.println("----------------------------------------------------------------------------------------\n");
        }
    }

    /**
     * the method used for getting all the information about a patient
     * here again, i use "a" for index, and "b" for option.
     */
    public void getPatientInfo(){
        displayPatients();
        System.out.print ("About which patient (select it by index) would you like to know?: ");
        int a = s.nextInt();
        String h;
        if (patients.get(a).getHealth() == 1){
            h = "healthy";
        } else {
           h = "no healthy";
        }
        String c;
        if (patients.get(a).isCompensation_box()){
            c = "yes";
        } else {
            c = "no";
        }
        System.out.print ("Patient's name: " + patients.get(a).getName() + "\nPatient's age: " + patients.get(a).getAge() +
                "\nPatient's stratum: "+ patients.get(a).getStratum() + "\nPatient's health status: " + h + "\nCompensation box: " + c + "\n\n");
        System.out.print("What else would you like to know about him: \n1.Vaccines that can be applied.\n2.Applied vaccines\n3.To leave\n");
        int b = s.nextInt();
        while (true){
            if (b == 1){
                patients.get(a).getVaccinationScheme().possibleVaccines();
                break;
            } else if (b == 2){
                patients.get(a).getVaccinationScheme().appliedVaccines();
                break;
            } else if (b == 3){
                break;
            } else {
                System.out.print("Select a valid option\n ");
            }
        }

    }

    /**
     *
     * @return the business_name
     */
    public String getBusiness_name(){
        return this.business_name;
    }

    /**
     * displays on screen the info about this clinic.
     */
    public void displayInfo(){
        System.out.print("||--------------------------------------------------------||\n");
        System.out.print("|| Business name: " + this.business_name + "\n");
        System.out.print("||--------------------------------------------------------||\n");
        System.out.print("|| Nit: " + this.nit + "\n");
        System.out.print("||--------------------------------------------------------||\n");
        System.out.print("|| Dir: " + this.dir + "\n");
        System.out.print("||--------------------------------------------------------||\n");
        System.out.print("|| Phone: " + this.phone + "\n");
        System.out.print("||--------------------------------------------------------||\n\n");
    }

    /**
     *
     * @return the patientcount which keeps track of how many patients are here.
     */
    public int getPatientCount(){
        return patientcount;
    }
}
