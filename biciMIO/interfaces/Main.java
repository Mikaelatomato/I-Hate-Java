package interfaces;
import model.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * the main class, here you can work with all the different classes.
 * i would have loved to have a couple of hours more to finish it, but, this is what you get.
 *
 */

public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("|Lab 1| Welcome to biciMIO improvised interface |Lab 1| \n\n");
        ArrayList<BikeStation> bikestations = new ArrayList<>();
        ArrayList<Route> routes = new ArrayList<>();
        int option2;
        int option;
        int a;
        do {
            option = menup();
            switch (option) {
                case 1:
                    option2 = menu1();
                    if (option2 == 1) {
                        bikestations.add(new BikeStation());
                        int b = bikestations.size() - 1;
                        System.out.print("The bikestation: " + bikestations.get(b).getStationname() + " was successfully created\n\n");
                    } else if (option2 == 2) {
                        a = 0;
                        System.out.print("\nTo create a route, you must pick 2 different bikestations by their index, and they'll form a route\n\n" +
                                "Pick the first bikestation to create the route.\n");
                        while (a != bikestations.size()) {
                            System.out.print("\nAt index: " + a + " | " + bikestations.get(a).getStationname());
                            a += 1;
                        }
                        int bikestation1 = s.nextInt();
                        System.out.print("Pick the second bikestation to create the route.\n");
                        int bikestation2 = s.nextInt();
                        routes.add(new Route(bikestations.get(bikestation1), bikestations.get(bikestation2)));
                        int b = routes.size() - 1;
                        System.out.print("The route: ");
                        routes.get(b).displayRoute();
                        System.out.print(" was successfully created\n\n");
                    } else if (option2 == 3) {
                        break;
                    }
                    break;
                case 2:
                    a = 0;
                    while (a != bikestations.size()) {
                        System.out.print("\nAt index: " + a + " | " + bikestations.get(a).getStationname());
                        a += 1;
                    }
                    System.out.print("\nSelect a station to add a bike: ");
                    int b = s.nextInt();
                    bikestations.get(b).newBike();
                    int m = bikestations.get(b).getBikes().size() - 1;
                    System.out.print("The bike: " + bikestations.get(b).getBikes().get(m).getPlate() + " was succesfully created.\n\n");
                    break;
                case 3:
                    option2 = menu3();
                    a = 0;
                    while (a != bikestations.size()) {
                        System.out.print("\nAt index: " + a + " | " + bikestations.get(a).getStationname());
                        a += 1;
                    }
                    if (option2 == 1) {
                        System.out.print("\nSelect a station to add an attendant to it: \n");
                        int at = s.nextInt();
                        bikestations.get(at).setAttendant();
                        System.out.print("This bikestation is now in charge of: " + bikestations.get(at).getAttendant().getName() + " identified with the ID: " +
                                bikestations.get(at).getAttendant().getId() + " And the rut: " + bikestations.get(at).getAttendant().getRut() + "\n\n");
                    } else if (option2 == 2) {
                        System.out.print("\nSelect a station: \n");
                        int at = s.nextInt();
                        bikestations.get(at).displayBikes();
                        System.out.print("\nNow select a bike to give associate with an user: ");
                        int at2 = s.nextInt();
                        bikestations.get(at).getBikes().get(at2).setUser();
                        System.out.print("This bike is now associated to the user: " + bikestations.get(at).getBikes().get(at2).getUser().getName() + " identified with the ID: " +
                                bikestations.get(at).getBikes().get(at2).getUser().getId() + "\n\n");
                    } else if (option2 == 3) {
                        break;
                    }
                    break;
                case 4:
                    System.out.print("We are working on this, there's no time left :(\n\n");
                    break;
                 case 5:
                 option2 = menu5();
                 if (option2 == 1){
                     a = 0;
                     while (a != bikestations.size()) {
                         System.out.print("\nAt index: " + a + " | " + bikestations.get(a).getStationname());
                         a += 1;
                     }
                     System.out.print("\n\n");
                 } else if (option2 == 2) {
                     a = 0;
                     while (a != bikestations.size()) {
                         System.out.print("\nAt index: " + a + " | " + bikestations.get(a).getStationname());
                         a += 1;
                     }
                     System.out.print("\nSelect a station: \n");
                     int at = s.nextInt();
                     bikestations.get(at).displayBikes();
                     System.out.print("\n\n");
                 } else if (option2 == 3) {
                     a = 0;
                     while (a != routes.size()) {
                         System.out.print("\nAt index: " + a + " | " );
                         routes.get(a).displayRoute();
                         a += 1;
                     }
                     System.out.print("\n\n");
                 } else if (option2 == 4) {
                     a = 0;
                     while (a != bikestations.size()) {
                         System.out.print("\nAt index: " + a + " | " + bikestations.get(a).getStationname());
                         a += 1;
                     }
                     System.out.print("\nSelect a station: \n");
                     int at = s.nextInt();
                     bikestations.get(at).displayBikes();
                     System.out.print("\nNow select a bike to know about its user: ");
                     int at2 = s.nextInt();
                     System.out.print("This bike is associated to the user: " + bikestations.get(at).getBikes().get(at2).getUser().getName() + " identified with the ID: " +
                             bikestations.get(at).getBikes().get(at2).getUser().getId() + "\n\n");
                 } else if (option2 == 5){
                     a = 0;
                     while (a != bikestations.size()) {
                         System.out.print("\nAt index: " + a + " | " + bikestations.get(a).getStationname());
                         a += 1;
                     }
                     System.out.print("\nSelect a station: \n");
                     int at = s.nextInt();
                     bikestations.get(at).displayAttendant();
                     System.out.print("\n\n");
                 } else if (option2 == 6){
                     break;
                 } break;
                 case 6:
                     System.out.print("We are working on this, there's no time left :(\n\n");
                 break;
                case 7:
                    a = 0;
                    while (a != routes.size()) {
                        System.out.print("\nAt index: " + a + " | " );
                        routes.get(a).displayRoute();
                        a += 1;
                    }
                    System.out.print("\nSelect a route to calculate its distance: ");
                    b = s.nextInt();
                    System.out.print("\nThe distance between both stations is: " + new Distance(routes.get(b)).getDistance() + " kms");

            }
        } while (option != 0);
    }

    private static int menup() {
        System.out.print("\n\nOPTIONS 4 and 6 may be implemented in the future\n\n");
        System.out.print("| | | | Main Menu -  Pick an option | | | |\n");
        System.out.print("1. Create a Bikestation or a Route.\n");
        System.out.print("2. Add Bikes to a station\n");
        System.out.print("3. Give an attendant to a station OR a user to a bike\n");
        System.out.print("4. Modify an existing Bikestation, Attendant, bike's user\n");
        System.out.print("5. Display bikestations / routes / users / attendants / bikes info\n");
        System.out.print("6. Move a bike from a station to another\n");
        System.out.print("7. Calculate a route's Distance (you need to create a route before this)\n");
        System.out.print("0. To exit\n");
        return s.nextInt();
    }

    private static int menu1() {
        System.out.print("| | | | Creator's Menu| | | | |\n");
        System.out.print("1. To create a Bikestation\n");
        System.out.print("2. To create a Route (You need two bikestations to create one route\n");
        System.out.print("3. To comeback to the main menu.\n");
        return s.nextInt();
    }

    private static int menu3() {
        System.out.print("| | | | Giver's Menu | | | |\n");
        System.out.print("1.To give an attendant to an bikestation\n");
        System.out.print("2.To give an user to a bike\n");
        System.out.print("3.To comeback to the main menu\n");
        return s.nextInt();
    }
/**
 *
 *  I WAS WORKING ON THIS BUT I DONT HAVE TIME LEEEEEEEEEEEEEEFT :(((
 *
    private static int menu4() {
        System.out.print("| | | | Modifier's Menu | | | |\n");
        System.out.print("1.To modify a bikestation\n");
        System.out.print("2.To modify a attendant\n");
        System.out.print("3.To modify a bike's user\n");
        System.out.print("4.To comeback to the main menu.\n");
        return s.nextInt();
    }
    private static int submenu41(){
        System.out.print("1.To modify its name\n");
        System.out.print("2.To modify its capacity\n");
        System.out.print("3.To comeback to the main menu\n");
        return s.nextInt();
    }
    private static int submenu42(){
        System.out.print("1.To modify its name\n");
        System.out.print("2.To modify its ID\n");
        System.out.print("3.To modify its rut\n");
        System.out.print("4.To return to the main menu\n");
        return s.nextInt();
    }
    */
    private static int menu5(){
        System.out.print("| | | | Report's Menu | | | |\n");
        System.out.print("1. To get a list of all the bikestations\n");
        System.out.print("2. To get a list of all the bikes in a bikestation\n");
        System.out.print("3. To get a list of all the routes\n");
        System.out.print("4. To get information about a specific bike's user\n");
        System.out.print("5. To get information about a specific bikestation's attendant\n");
        System.out.print("6. To return to the main menu\n");
        return s.nextInt();

    }
}