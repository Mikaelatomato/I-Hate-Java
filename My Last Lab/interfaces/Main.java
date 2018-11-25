package interfaces;
import model.*;

import java.util.Scanner;

public class Main {

    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("||------------------------------------------------------------------------------||\n");
        System.out.print("||                         Welcome to CONDORICOSAS                              ||\n");
        System.out.print("||------------------------------------------------------------------------------||\n\n");
        System.out.print("Please type how much the base cost for miniroom should be: ");
        Double basecost = s.nextDouble();
        Building condoricosas = new Building(basecost);
        int floor;
        int column;
        int option;
        do {
            option = menuP();
            switch (option) {
                case 1:
                    condoricosas.drawBuilding();
                    System.out.print("\nSelect a null space to create the miniroom.\nFloor: ");
                    floor = s.nextInt();
                    System.out.print("Column: ");
                    column = s.nextInt();
                    System.out.print("ID: ");
                    String id = s.next();
                    condoricosas.newMiniroom(id, floor, column);
                    System.out.print("The miniroom has been successfully created\n");
                    break;
                case 2:
                    condoricosas.drawBuilding();
                    System.out.print("\nSelect a non-null miniroom to add servers to it.\nFloor: ");
                    floor = s.nextInt();
                    System.out.print("Column: ");
                    column = s.nextInt();
                    System.out.print("How many servers do you want to add?: ");
                    int number = s.nextInt();
                    condoricosas.getMinirooms()[floor-1][column-1].addNewServers(number);
                    break;
                case 3:
                    System.out.print("model.Enterprise's name: ");
                    String name = s.next();
                    System.out.print("model.Enterprise's nit: ");
                    String nit = s.next();
                    condoricosas.newEnterprise(name,nit);
                    System.out.print("The enterprise has been successfully added\n");
                    break;
                case 4:
                    condoricosas.drawBuilding();
                    condoricosas.availableRooms();
                    System.out.print("\nSelect a non-rented miniroom to rent it.\nFloor: ");
                    floor = s.nextInt();
                    System.out.print("Column: ");
                    column = s.nextInt();
                    System.out.print("Select the enterprise that will rent it: \n");
                    for (int i = 1; i <= condoricosas.getEnterprises().size(); i++){
                        System.out.print(i+"." + condoricosas.getEnterprises().get(i-1).getName()+"\n");
                    }
                    int index;
                    while (true){
                        try{
                            index = s.nextInt();
                            if (index >= 1 && index <= condoricosas.getEnterprises().size() ){
                                break;
                            } else{
                                System.out.print("invalid option\n");
                            }
                        } catch (Exception e){
                            System.out.print("invalid option\n");
                        }
                    }
                    System.out.print("How many servers is the enterprise going to use?: ");
                    int serverstouse = s.nextInt();
                    System.out.print("Day of rental: ");
                    int day = s.nextInt();
                    System.out.print("Month of rental: ");
                    int month = s.nextInt();
                    System.out.print("Year of rental: ");
                    int year = s.nextInt();
                    Enterprise e = condoricosas.getEnterprises().get(index-1);
                    condoricosas.getMinirooms()[floor-1][column-1].setEnterprise(e, serverstouse, year, month, day);
                    System.out.print("The miniroom was successfully asociated to this enterprise\n");
                    break;
                case 5:
                    condoricosas.drawBuilding();
                    condoricosas.availableRooms();
                    break;
                case 6:
                    condoricosas.cancelRent();
                    break;
                case 7:
                    System.out.print("Instructions: \n\n");
                    System.out.print("Letter L: turns off the first miniroom of each floor and all the minirooms of the first floor\n");
                    System.out.print("Letter Z: turns off the minirooms in the first and last floor, plus the minirooms in the reverse diagonal\n");
                    System.out.print("Letter X: turns off the minirooms in the reverse diagonal and the principal diagonal\n");
                    System.out.print("Letter O: turns off the minirooms in the first and last floor, with the minirooms that are on located on windows\n");
                    System.out.print("Letter C: turns off the first miniroom of each floor, plus the all minirooms in the first and last floor\n");
                    System.out.print("Letter T: turns off all the minirooms in the building\n");
                    System.out.print("Letter E: turns off all the minirooms in spiral by row\n");
                    System.out.print("Letter M: turns off all the minirooms in spiral by column\n");
                    System.out.print("Letter I: turns off all the minirooms in a selected column\n");
                    System.out.print("Letter P: turns off all the minirooms in a selected row\n");
                    System.out.print("\nHow would you like to turn off the minirooms?: ");
                    String optionoff = s.next();
                    if (optionoff.equalsIgnoreCase("L")){
                        condoricosas.turnOffAsL();
                    } else if (optionoff.equalsIgnoreCase("Z")){
                        condoricosas.turnOffAsZ();
                    } else if (optionoff.equalsIgnoreCase("X")){
                        condoricosas.turnOffAsX();
                    } else if (optionoff.equalsIgnoreCase("O")){
                        condoricosas.turnOffAsO();
                    } else if (optionoff.equalsIgnoreCase("C")){
                        condoricosas.turnOffAsC();
                    } else if (optionoff.equalsIgnoreCase("T")){
                        condoricosas.turnOffAsT();
                    } else if (optionoff.equalsIgnoreCase("E")){
                        condoricosas.turnOffAsE();
                    } else if (optionoff.equalsIgnoreCase("M")){
                        condoricosas.turnOffAsM();
                    } else if (optionoff.equalsIgnoreCase("I")){
                        System.out.print("Which column would you like to turn off?: ");
                        column = s.nextInt();
                        condoricosas.turnOffAsI(column-1);
                    } else if (optionoff.equalsIgnoreCase("P")){
                        System.out.print("Which row would you like to turn off?: ");
                        floor = s.nextInt();
                        condoricosas.turnOffAsP(floor-1);
                    } else {
                        System.out.print("invalid option");
                    }
                    condoricosas.drawBuilding();
                    break;
                case 8:
                    condoricosas.listedEnterprises();
                    break;
                case 9:
                    System.out.print(condoricosas.mostRentedEnterprise());
                    break;
                case 10:
                    condoricosas.turnOn();
                    break;
                case 11:
                    System.out.print("Enterprises: \n\n");
                    for (int i = 1; i <= condoricosas.getEnterprises().size(); i++){
                        System.out.print(i+"." + condoricosas.getEnterprises().get(i-1).getName()+ "\nDefaulter?: " + condoricosas.getEnterprises().get(i-1).isDefaulter()+ "\n");
                    }
                    System.out.print("Select an enterprise: ");
                    while (true){
                        try{
                            index = s.nextInt();
                            if (index >= 1 && index <= condoricosas.getEnterprises().size() ){
                                break;
                            } else{
                                System.out.print("invalid option\n");
                            }
                        } catch (Exception er){
                            System.out.print("invalid option\n");
                        }
                    }
                    condoricosas.getEnterprises().get(index-1).setDefaulter();
                    System.out.print("The enterprise: " + condoricosas.getEnterprises().get(index-1).getName() + " defaulter status has been changed to: " + condoricosas.getEnterprises().get(index-1).isDefaulter()+"\n");
            }
        } while (option != 0);
    }

    /**
     * Displays the menu
     * @return an int that refers to the user's option
     */

    public static int menuP(){
        System.out.print("\n-------------------------------------------------------------------\n");
        System.out.print("| | | | CONDORICOSAS MENU || pick an option | | | |\n");
        System.out.print("1. To create a miniroom\n");
        System.out.print("2. To add servers to a miniroom's RACK\n");
        System.out.print("3. To add a new client enterprise\n");
        System.out.print("4. To rent a miniroom to an enterprise\n");
        System.out.print("5. To list all the available minirooms\n");
        System.out.print("6. To cancel a miniroom rented to an enterprise\n");
        System.out.print("7. To turn off minirooms\n");
        System.out.print("8. To list all the minirooms rented to enterprises\n");
        System.out.print("9. To know the enterprise with the biggest number of minirooms rented\n");
        System.out.print("10. To turn on all the minirooms\n");
        System.out.print("11. To report an enterprise as defaulter or non defaulter\n\n");
        System.out.print("0. To leave CONDORICOSAS\n");
        System.out.print("-------------------------------------------------------------------\n");
        return s.nextInt();
    }
}
