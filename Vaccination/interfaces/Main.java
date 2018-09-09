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
            option = menuP(clinic.getBusiness_name());
            switch (option) {
                case 1:
                    clinic.newPatient();
                    break;
                case 2:
                    if (clinic.getPatientCount() < 3) {
                        System.out.print("This clinic needs at least 3 patients to work, register " + (3 - clinic.getPatientCount()) + " more at least, please.\n\n");
                        break;
                    } else {
                        clinic.getPatientInfo();
                        break;
                    }
                case 3:
                    if (clinic.getPatientCount() < 3) {
                        System.out.print("This clinic needs at least 3 patients to work, register " + (3 - clinic.getPatientCount()) + " more, please.\n\n");
                        break;
                    } else {
                        clinic.displayPatients();
                        System.out.print("\nSelect a patient to update its health status: ");
                        a = s.nextInt();
                        if (a > clinic.getPatientCount() - 1) {
                            System.out.print("\nThat patient doesn't exist, comeback and try again, select it by index\n");
                            continue;
                        } else {
                            clinic.getPatient(a).updateHealth();
                            System.out.print("The patient is ");
                            if (clinic.getPatient(a).getHealth() == 1) {
                                System.out.print("healthy now\n\n");
                            } else {
                                System.out.print("not healthy now\n\n");
                            }
                        }
                    }
                    break;
                case 4:
                    if (clinic.getPatientCount() < 3) {
                        System.out.print("This clinic needs at least 3 patients to work, register " + (3 - clinic.getPatientCount()) + " more, please.\n\n");
                        break;
                    } else {
                        clinic.displayPatients();
                        System.out.print("\nSelect a patient to apply a vaccine: ");
                        a = s.nextInt();
                        if (a > clinic.getPatientCount() - 1){
                            System.out.print("\nThat patient doesn't exist, comeback and try again, select it by index\n");
                            continue;
                        } else {
                            clinic.getPatient(a).getVaccinationScheme().applyVaccine();
                            break;
                        }
                    }
                case 5:
                    if (clinic.getPatientCount() < 3) {
                        System.out.print("This clinic needs at least 3 patients to work, register " + (3 - clinic.getPatientCount()) + " more, please.\n\n");
                        break;
                    } else {
                        System.out.print("This clinic has gained a total amount of: " + clinic.getTotalGained() + " from vaccines.\n\n");
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
    public static int menuP(String c){
        System.out.print("-------------------------------------------------------------------\n");
        System.out.print("| | | | "+ c + " clinic menu -  Pick an option | | | |\n");
        System.out.print("1. To register a new patient\n");
        System.out.print("2. To know about a patient\n");
        System.out.print("3. To update a patient's health status\n");
        System.out.print("4. To apply a vaccine to a patient\n");
        System.out.print("5. To know the total amount gained from vaccines in this clinic\n");
        System.out.print("6. To know more about this clinic\n");
        System.out.print("0. To leave\n");
        return s.nextInt();
    }
}

