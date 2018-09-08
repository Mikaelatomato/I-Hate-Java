package interfaces;
import model.*;

import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        clinic.init();
        int option;
        int a;
        System.out.print("\n\n| | Welcome to " + clinic.getBusiness_name() + ", you may (not) die here | |\n\n");
        do {
            option = menup();
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

    public static int menup(){
        System.out.print("| | | | Main Menu -  Pick an option | | | |\n");
        System.out.print("1. To register a new patient\n");
        System.out.print("2. To know about a patient\n");
        System.out.print("3. To update a patient's health status\n");
        System.out.print("4. To apply a vaccine to a patient\n");
        System.out.print("5. To know the total amount gained from vaccines in this clinic\n");
        System.out.print("6. To know more about this clinic\n");
        return s.nextInt();
    }
}

