package model;
import java.util.ArrayList;
import java.util.Scanner;

public class Clinic {

    private ArrayList<Patient> patients = new ArrayList<Patient>();
    private int patientcount;
    private String nit;
    private String business_name;
    private String dir;
    private String phone;
    private float totalgained;
    private Scanner s = new Scanner(System.in);

    public Clinic(){
        this.totalgained = 0;
        this.patientcount = 0;
    }

    public void init(){
        System.out.print("Clinic's business name: ");
        this.business_name = s.next();
        System.out.print("Clinic's nit: ");
        this.nit = s.next();
        System.out.print("Clinic's dir: ");
        this.dir = s.next();
        System.out.print("Clinic's phone: ");
        this.phone = s.next();
    }

    public void newpatient(){
        if (this.patientcount >= 0 && this.patientcount <= 5){
            this.patients.add(new Patient());
            this.patients.get(patientcount).getVaccinationScheme().init();
            this.patientcount +=1;
        } else {
            System.out.print ("This clinic can't have more patients.\n");
        }
    }

    public void calculateTotalGain(){
        totalgained = 0;
        for (Patient p : patients){
            totalgained += p.getVaccinationScheme().getTotalpayed();
        }
    }

    public float getTotalgained(){
        calculateTotalGain();
        return totalgained;
    }

    public Patient getPatient(int a){
        return patients.get(a);
    }


    public void displayPatients(){
        for (int i = 0; i < patients.size(); i++){
            System.out.print("At index " +  i  + " || is the patient identified with the id: "+ this.patients.get(i).getId() + "\n");
        }
    }
    public void getPatientinfo(){
        displayPatients();
        System.out.print ("About which patient (select it by index) would you like to know?: ");
        int a = s.nextInt();
        System.out.print ("Patient's name: " + patients.get(a).getName() + "\nPatient's age: " + patients.get(a).getAge() + "\n\n");
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

    public String getBusiness_name(){
        return this.business_name;
    }

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

    public int getPatientcount(){
        return patientcount;
    }
}
