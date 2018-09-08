package interfaces;
import model.*;
import java.util.Scanner;

/**
 * check my poor work at my: github.com/mikaelatomato
 */
public class Main {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        clinic.init();
        int option;
        int a;
        System.out.print("||------------------------------------------------------------------------------||\n");
        System.out.print("|| Welcome to " + clinic.getBusiness_name() + ", you may (not) die here | |\n");
        System.out.print("||------------------------------------------------------------------------------||\n\n");
        do {
            option = menup(clinic.getBusiness_name());
            switch (option) {
                case 1:
                    clinic.newpatient();
                    break;
                case 2:
                    if (clinic.getPatientcount() < 3) {
                        System.out.print("This clinic needs at least 3 patients to work, register " + (3 - clinic.getPatientcount()) + " more at least, please.\n\n");
                        break;
                    } else {
                        clinic.getPatientinfo();
                        break;
                    }
                case 3:
                    if (clinic.getPatientcount() < 3) {
                        System.out.print("This clinic needs at least 3 patients to work, register " + (3 - clinic.getPatientcount()) + " more, please.\n\n");
                        break;
                    } else {
                        clinic.displayPatients();
                        System.out.print("\nSelect a patient to update its health status: ");
                        a = s.nextInt();
                        clinic.getPatient(a).updateHealth();
                        System.out.print("The patient is ");
                        if (clinic.getPatient(a).getHealth() == 1) {
                            System.out.print("healthy now\n\n");
                        } else {
                            System.out.print("not healthy now\n\n");
                        }
                    }
                    break;
                case 4:
                    if (clinic.getPatientcount() < 3) {
                        System.out.print("This clinic needs at least 3 patients to work, register " + (3 - clinic.getPatientcount()) + " more, please.\n\n");
                        break;
                    } else {
                        clinic.displayPatients();
                        System.out.print("\nSelect a patient to apply a vaccine: ");
                        a = s.nextInt();
                        clinic.getPatient(a).getVaccinationScheme().applyVaccine();
                        break;
                    }
                case 5:
                    if (clinic.getPatientcount() < 3) {
                        System.out.print("This clinic needs at least 3 patients to work, register " + (3 - clinic.getPatientcount()) + " more, please.\n\n");
                        break;
                    } else {
                        System.out.print("This clinic has gained a total amount of: " + clinic.getTotalgained() + " from vaccines.\n\n");
                        break;
                    }
                case 6:
                    clinic.displayInfo();
            }
        } while (option != 0);
    }

    /**
     * this is the menu
     * @return it returns a value for the switch case.
     * you can know how much a patient has paid on the option 2, actually, you can know everything about him, if you wonder where that option is.
     */
    public static int menup(String c){
        System.out.print("-------------------------------------------------------------------\n");
        System.out.print("| | | | "+ c + " clinic menu -  Pick an option | | | |\n");
        System.out.print("1. To register a new patient\n");
        System.out.print("2. To know about a patient\n");
        System.out.print("3. To update a patient's health status\n");
        System.out.print("4. To apply a vaccine to a patient\n");
        System.out.print("5. To know the total amount gained from vaccines in this clinic\n");
        System.out.print("6. To know more about this clinic\n");
        System.out.print("0. To leave");
        return s.nextInt();
    }
}

