package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Building {

    public static Scanner s = new Scanner(System.in);
    private int floors = 7;
    private int miniroomsByFloor = 50;
    private Miniroom[][] minirooms;
    private Double baseCostForRoom;
    private ArrayList<Enterprise> enterprises = new ArrayList<>();
    private Double totalpayed = 0.0;

    public Building(Double baseCostForRoom) {
        minirooms = new Miniroom[floors][miniroomsByFloor];
        this.baseCostForRoom = baseCostForRoom;
    }

    /**
     * Creates a new miniroom on a null space of the building.
     * pre: minirooms[][] isn't null.
     * @param id the id for the new miniroom
     * @param floor the floor for the miniroom
     * @param column the column for the miniroom
     */
    public void newMiniroom(String id, int floor, int column) {
        if (minirooms[floor - 1][column - 1] == null) {
            minirooms[floor - 1][column - 1] = new Miniroom(id);
        }
        else {
            System.out.print("This space isn't null, try again\n");
        }
    }

    /**
     * pre : minirooms[][] isn't null
     * @return the minirooms array.
     */
    public Miniroom[][] getMinirooms() {
        return minirooms;
    }

    /**
     * turns on all the minirooms in the building
     * pre: minirooms[][] isn't null
     * pos: changes the status of each non-null miniroom to ON
     *
     *
     */
    public void turnOn() {
        for (int row = 0; row < floors; row++) {
            for (int col = 0; col < miniroomsByFloor; col++) {
                if (minirooms[row][col] != null) {
                    minirooms[row][col].turnOn();
                    System.out.print("The miniroom at the floor " + (row + 1) + " and column " + (col + 1) + " with the id: " + minirooms[row][col].getId() + " has been turned on\n");
                }
            }
        }
    }

    /**
     * Displays all the available minirooms in the building.
     * pre: minirooms[][] isn't null
     */
    public void availableRooms() {
        for (int row = 0; row < floors; row++) {
            for (int col = 0; col < miniroomsByFloor; col++) {
                Double cost = baseCostForRoom;
                if (minirooms[row][col] != null && minirooms[row][col].getEnterprise() == null) {
                    System.out.print("model.Miniroom available at floor " + (row + 1) + " and column " + (col + 1) + "\n");
                    if (col == 0 || col == 49) {
                        cost -= this.baseCostForRoom * 0.10;
                        System.out.print("Windowed?: yes\n");
                    } else {
                        System.out.print("Windowed?: no\n");
                    }
                    if (row == 0) {
                        cost -= this.baseCostForRoom * 0.15;
                    }
                    if (row >= 3) {
                        cost += this.baseCostForRoom * 0.25;
                    }
                    System.out.print("The cost for this room would be: " + cost + "\n\n");
                }
            }
        }
    }

    /**
     * we already know what this does, don't we?
     * pre: minirooms[][] isn't null
     */

    public void turnOffAsL() {
        for (int row = 0; row < floors; row++) {
            if (minirooms[row][0] != null) {
                minirooms[row][0].turnOff();
                System.out.print("The miniroom at the floor " + (row + 1) + " and column 1 with the id: " + minirooms[row][0].getId() + " has been turned off\n");
            }
        }
        for (int col = 0; col < miniroomsByFloor; col++) {
            if (minirooms[0][col] != null) {
                minirooms[0][col].turnOff();
                System.out.print("The miniroom at the floor 1 and column " + (col + 1) + " with the id: " + minirooms[0][col].getId() + " has been turned off\n");
            }
        }
    }

    /**
     * we already know what this does, don't we?
     * pre: minirooms[][] isn't null
     */

    public void turnOffAsZ() {
        for (int col = 0; col < miniroomsByFloor; col++) {
            if (minirooms[0][col] != null) {
                minirooms[0][col].turnOff();
                System.out.print("The miniroom at the floor 1 and column " + (col + 1) + " with the id: " + minirooms[0][col].getId() + " has been turned off\n");
            }
        }
        for (int col = 0; col < miniroomsByFloor; col++) {
            if (minirooms[6][col] != null) {
                minirooms[6][col].turnOff();
                System.out.print("The miniroom at the floor 7 and column " + (col + 1) + " with the id: " + minirooms[6][col].getId() + " has been turned off\n");
            }
        }
        int col = 0;
        for (int row = 6; row >= 0; row--) {
            if (minirooms[row][col] != null) {
                minirooms[row][col].turnOff();
                System.out.print("The miniroom at the floor " + (row + 1) + " and column " + (col + 1) + " with the id: " + minirooms[row][col].getId() + " has been turned off\n");

            }
            col += 7;
        }
    }

    /**
     * we already know what this does, don't we?
     * pre: minirooms[][] isn't null
     */

    public void turnOffAsX() {
        int col = 0;
        for (int row = 6; row >= 0; row--) {
            if (minirooms[row][col] != null) {
                minirooms[row][col].turnOff();
                System.out.print("The miniroom at the floor " + (row + 1) + " and column " + (col + 1) + " with the id: " + minirooms[row][col].getId() + " has been turned off\n");
            }
            col += 7;
        }
        col = 0;
        for (int row = 0; row < floors; row++) {
            if (minirooms[row][col] != null) {
                minirooms[row][col].turnOff();
                System.out.print("The miniroom at the floor " + (row + 1) + " and column " + (col + 1) + " with the id: " + minirooms[row][col].getId() + " has been turned off\n");
            }
            col += 7;
        }
    }

    /**
     * we already know what this does, don't we?
     * pre: minirooms[][] isn't null
     */

    public void turnOffAsO() {
        for (int row = 0; row < floors; row++) {
            if (minirooms[row][0] != null) {
                minirooms[row][0].turnOff();
                System.out.print("The miniroom at the floor " + (row + 1) + " and column 1 with the id: " + minirooms[row][0].getId() + " has been turned off\n");
            }
            if (minirooms[row][49] != null) {
                minirooms[row][49].turnOff();
                System.out.print("The miniroom at the floor " + (row + 1) + " and column 50 with the id: " + minirooms[row][50].getId() + " has been turned off\n");

            }
        }
        for (int col = 0; col < miniroomsByFloor; col++) {
            if (minirooms[0][col] != null) {
                minirooms[0][col].turnOff();
                System.out.print("The miniroom at the floor 1 and column " + (col + 1) + " with the id: " + minirooms[0][col].getId() + " has been turned off\n");

            }
            if (minirooms[6][col] != null) {
                minirooms[6][col].turnOff();
                System.out.print("The miniroom at the floor 7 and column " + (col + 1) + " with the id: " + minirooms[6][col].getId() + " has been turned off\n");
            }
        }
    }

    /**
     * we already know what this does, don't we?
     * pre: minirooms[][] isn't null
     */

    public void turnOffAsC() {
        for (int row = 0; row < floors; row++) {
            if (minirooms[row][0] != null) {
                minirooms[row][0].turnOff();
                System.out.print("The miniroom at the floor " + (row + 1) + " and column 1 with the id: " + minirooms[row][0].getId() + " has been turned off\n");
            }
        }
        for (int col = 0; col < miniroomsByFloor; col++) {
            if (minirooms[0][col] != null) {
                minirooms[0][col].turnOff();
                System.out.print("The miniroom at the floor 1 and column " + (col + 1) + " with the id: " + minirooms[0][col].getId() + " has been turned off\n");
            }
            if (minirooms[6][col] != null) {
                minirooms[6][col].turnOff();
                System.out.print("The miniroom at the floor 7 and column " + (col + 1) + " with the id: " + minirooms[6][col].getId() + " has been turned off\n");

            }
        }
    }

    /**
     * we already know what this does, don't we?
     * pre: minirooms[][] isn't null
     */

    public void turnOffAsT() {
        for (int row = 0; row < floors; row++) {
            for (int col = 0; col < miniroomsByFloor; col++) {
                if (minirooms[row][col] != null) {
                    minirooms[row][col].turnOff();
                    System.out.print("The miniroom at the floor " + (row + 1) + " and column " + (col + 1) + " with the id: " + minirooms[row][col].getId() + " has been turned off\n");
                }
            }
        }
    }

    /**
     * we already know what this does, don't we?
     * pre: minirooms[][] isn't null
     */

    public void turnOffAsE() {
        for (int row = 0; row < floors; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < miniroomsByFloor; col++) {
                    if (minirooms[row][col] != null) {
                        minirooms[row][col].turnOff();
                        System.out.print("The miniroom at the floor " + (row + 1) + " and column " + (col + 1) + " with the id: " + minirooms[row][col].getId() + " has been turned off\n");
                    }
                }
            } else {
                for (int col = 49; col >= 0; col--) {
                    if (minirooms[row][col] != null) {
                        minirooms[row][col].turnOff();
                        System.out.print("The miniroom at the floor " + (row + 1) + " and column " + (col + 1) + " with the id: " + minirooms[row][col].getId() + " has been turned off\n");
                    }
                }
            }
        }
    }

    /**
     * we already know what this does, don't we?
     * pre: minirooms[][] isn't null
     */

    public void turnOffAsM() {
        int startRow = 0;
        int startColumn = 0;
        int lastRow = floors - 1;
        int lastColumn = miniroomsByFloor - 1;
        int temp;
        int count = 0;
        int middle = 0;
        for (int i = 0; i <= floors; i++) {
            middle += i;
        }
        middle = (middle / floors) - 1;

        while (count < (floors * miniroomsByFloor)) {

            if (startRow != middle && lastRow != middle) {
                for (temp = startRow; temp <= lastRow; temp++) {
                    if (minirooms[temp][startColumn] != null) { //column down
                        minirooms[temp][startColumn].turnOff();
                        System.out.print("The miniroom at the floor " + (temp + 1) + " and column " + (startColumn + 1) + " with the id: " + minirooms[temp][startColumn].getId() + " has been turned off\n");

                    }
                    count++;
                }
            }

            for (temp = ++startColumn; temp <= lastColumn; temp++) {
                if (temp == 47 && lastRow == middle) {
                    if (minirooms[lastRow][temp + 1] != null) {
                        minirooms[lastRow][temp + 1].turnOff();
                        System.out.print("The miniroom at the floor " + (lastRow + 1) + " and column " + (temp + 2) + " with the id: " + minirooms[lastRow][temp + 1].getId() + " has been turned off\n");
                    }
                }
                if (minirooms[lastRow][temp] != null) {              //row right
                    minirooms[lastRow][temp].turnOff();
                    System.out.print("The miniroom at the floor " + (lastRow + 1) + " and column " + (temp + 1) + " with the id: " + minirooms[lastRow][temp].getId() + " has been turned off\n");

                }
                count++;
                if (count == miniroomsByFloor * floors) {
                    break;
                }
            }

            if (startRow != middle && lastRow != middle) {
                for (temp = --lastRow; temp >= startRow; temp--) {
                    if (minirooms[temp][lastColumn] != null) {      //column up
                        minirooms[temp][lastColumn].turnOff();
                        System.out.print("The miniroom at the floor " + (temp + 1) + " and column " + (lastColumn + 1) + " with the id: " + minirooms[temp][lastColumn].getId() + " has been turned off\n");

                    }
                    count++;
                }
            }

            if (startRow != 3 && lastRow != 3) {
                for (temp = --lastColumn; temp >= startColumn; temp--) {
                    if (minirooms[startRow][temp] != null) {         //row left
                        minirooms[startRow][temp].turnOff();
                        System.out.print("The miniroom at the floor " + (startRow + 1) + " and column " + (temp + 1) + " with the id: " + minirooms[startRow][temp].getId() + " has been turned off\n");
                    }
                    count++;
                }
                startRow++;
            }
        }
    }

    /**
     * we already know what this does, don't we?
     * pre: minirooms[][] isn't null
     * @param column  is the column that'll be turned off
     */


    public void turnOffAsI(int column) {
        for (int row = 0; row < floors; row++) {
            if (minirooms[row][column - 1] != null) {
                minirooms[row][column - 1].turnOff();
                System.out.print("The miniroom at the floor " + (row + 1) + " and column " + (column) + " with the id: " + minirooms[row][column - 1].getId() + " has been turned off\n");
            }
        }
    }
    /**
     * we already know what this does, don't we?
     * pre: minirooms[][] isn't null
     * @param row is the row that'll be turned off.
     */

    public void turnOffAsP(int row) {
        for (int col = 0; col < miniroomsByFloor; col++) {
            if (minirooms[row - 1][col] != null) {
                minirooms[row - 1][col].turnOff();
                System.out.print("The miniroom at the floor " + (row) + " and column " + (col + 1) + " with the id: " + minirooms[row - 1][col].getId() + " has been turned off\n");
            }
        }
    }

    /**
     * creates a new enterprise for this building
     * @param name the enterprise's name.
     * @param nit the enterprise's nit
     */

    public void newEnterprise(String name, String nit) {
        this.enterprises.add(new Enterprise(name, nit));
    }

    /**
     *
     * pre: enterprises isn't null
     * @return an String that refers to the enterprise with the biggest number of minirooms rented.
     */
    public String mostRentedEnterprise() {
        int count = 0;
        Enterprise en = enterprises.get(0);
        for (Enterprise e : enterprises) {
            if (e.getRooms().size() > count) {
                count = e.getRooms().size();
                en = e;
            }
        }
        return en.getName();
    }

    /**
     * pre: minirooms[][] and enterprises aren't null
     * pos: sets the debt of each enterprise.
     */

    public void setDebtToEnterprises() {
        boolean flag = false;
        for (int row = 0; row < floors; row++) {
            for (int col = 0; col < miniroomsByFloor; col++) {
                if (minirooms[row][col] != null && minirooms[row][col].getEnterprise() != null) {
                    for (int i = 0; i < minirooms[row][col].getEnterprise().getRooms().size(); i++) {
                        if (minirooms[row][col].getEnterprise().getRooms().get(i).get(0) != row && minirooms[row][col].getEnterprise().getRooms().get(i).get(1) != col) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    }
                    if (!flag) {
                        minirooms[row][col].getEnterprise().getRooms().add(new ArrayList<>());
                        minirooms[row][col].getEnterprise().getRooms().get(minirooms[row][col].getEnterprise().getRooms().size() - 1).add(row);
                        minirooms[row][col].getEnterprise().getRooms().get(minirooms[row][col].getEnterprise().getRooms().size() - 1).add(col);
                        Double debt = baseCostForRoom;
                        if ((minirooms[row][col].getRack().size() / minirooms[row][col].getServersUsed()) > 2) {
                            debt += this.baseCostForRoom * 0.15;
                        }
                        if (col == 0 || col == 49) {
                            debt -= this.baseCostForRoom * 0.10;
                        }
                        if (row == 0) {
                            debt -= this.baseCostForRoom * 0.15;
                        }
                        if (row >= 3) {
                            debt += this.baseCostForRoom * 0.25;
                        }
                        minirooms[row][col].getEnterprise().getDebtByRoom().add(debt);
                    }
                }
            }
        }
        for (Enterprise e : enterprises) {
            e.setDebt();
        }
    }

    /**
     * Displays all the minirooms in the building
     * pre: minirooms[][] isn't null
     */

    public void drawBuilding() {
        System.out.print("\nGuide for newbies: \n[nu]: null\n[nr]: not rented\n[r ]: rented\n\n");
        System.out.print("        ");
        for (int i = 1; i <= miniroomsByFloor; i++) {
            if (i < 10) {
                System.out.print(i + "          ");
            } else {
                System.out.print(i + "         ");
            }
        }
        for (int row = 0; row < floors; row++) {
            System.out.print("\n");
            System.out.print((row + 1) + "  ");
            for (int col = 0; col < miniroomsByFloor; col++) {
                if (minirooms[row][col] == null) {
                    System.out.print(" [nu][...] ");
                } else if (minirooms[row][col] != null && minirooms[row][col].getEnterprise() == null) {
                    System.out.print(" [nr]");
                    if (minirooms[row][col].isOn()) {
                        System.out.print("[on ] ");
                    } else {
                        System.out.print("[off] ");
                    }
                } else if (minirooms[row][col] != null && minirooms[row][col].getEnterprise() != null) {
                    System.out.print(" [r ]");
                    if (minirooms[row][col].isOn()) {
                        System.out.print("[on ] ");
                    } else {
                        System.out.print("[off] ");
                    }
                }
            }
            System.out.print((row + 1) + "  ");
        }
        System.out.print("\n");
    }

    /**
     * pre: enterprises and minirooms[][] aren't null
     * pos: creates a list of all the enterprises with some info.
     */
    public void listedEnterprises() {
        setDebtToEnterprises();
        for (Enterprise e : enterprises) {
            Double totalRam = 0.0;
            Double totalDiskCapacity = 0.0;
            int usedServers = 0;
            for (int i = 0; i < e.getRooms().size(); i++) {
                totalRam += minirooms[e.getRooms().get(i).get(0)][e.getRooms().get(i).get(1)].getTotalRamMemory();
                totalDiskCapacity += minirooms[e.getRooms().get(i).get(0)][e.getRooms().get(i).get(1)].getTotalDiskCapacity();
                usedServers += minirooms[e.getRooms().get(i).get(0)][e.getRooms().get(i).get(1)].getServersUsed();
            }
            System.out.print("\nmodel.Enterprise name: " + e.getName() + "\nmodel.Enterprise nit: " + e.getNit() + "\nDefaulter?: "
                    + e.isDefaulter() + "\nRented minirooms: " + e.getRooms().size() + "\nTotal servers used: " + usedServers +
                    "\nTotal memory ram used: " + totalRam + "\nTotal disk capacity used: " + totalDiskCapacity + "\nDebt: " + e.getDebt());
        }
        System.out.print("\nTotal Payed by enterprises: " + totalpayed);
    }

    /**
     * cancels the rent of an enterprise.
     * pre: enterprises and minirooms[][] aren't null
     * pos: changes the status of a miniroom(or various) and the enterprise associated to it
     */

    public void cancelRent() {
        System.out.print("Select the enterprise: \n\n");
        for (Enterprise e : enterprises) {
            for (int i = 1; i <= enterprises.size(); i++) {
                System.out.print(i + "." + e.getName() + "\n");
            }
        }
        int en = 0;
        while (true) {
            try {
                en = s.nextInt();
                if (en >= 1 && en <= enterprises.size()) {
                    break;
                } else {
                    System.out.print("Invalid option\n");
                }
            } catch (Exception e) {
                System.out.print("Invalid option\n");
            }
        }
        System.out.print("Would you like to cancel one or ALL the minirooms for this enterprise?: \n1.Just one\n2.ALL\n");
        int option;
        while (true) {
            try {
                option = s.nextInt();
                if (option == 1 || option == 2) {
                    break;
                } else {
                    System.out.print("Invalid option\n");
                }
            } catch (Exception e) {
                System.out.print("Invalid option\n");
            }
        }
        if (option == 2) {
            totalpayed += enterprises.get(en - 1).getDebt();
            for (int i = 0; i < enterprises.get(en - 1).getRooms().size(); i++) {
                System.out.print("\nmodel.Miniroom at the floor " + (enterprises.get(en - 1).getRooms().get(i).get(0) + 1)
                        + " and column " + (enterprises.get(en - 1).getRooms().get(i).get(1) + 1) +
                        "\nTotal Memory Ram: " + minirooms[enterprises.get(en - 1).getRooms().get(i).get(0)][enterprises.get(en - 1).getRooms().get(i).get(1)].getTotalRamMemory() +
                        "\nTotal Disk Capacity: " + minirooms[enterprises.get(en - 1).getRooms().get(i).get(0)][enterprises.get(en - 1).getRooms().get(i).get(1)].getTotalDiskCapacity());
                minirooms[enterprises.get(en - 1).getRooms().get(i).get(0)][enterprises.get(en - 1).getRooms().get(i).get(1)].setNoEnterprise();
                System.out.print("\nThis miniroom is now available\n");
            }
        } else {
            System.out.print("Select the miniroom that you want to cancel:\n");
            for (int i = 0; i < enterprises.get(en - 1).getRooms().size(); i++) {
                System.out.print("\n" + (i + 1) + ".model.Miniroom at: floor " + (enterprises.get(en - 1).getRooms().get(i).get(0) + 1)
                        + " and column " + (enterprises.get(en - 1).getRooms().get(i).get(1) + 1) +"\nTotal Memory Ram: " + minirooms[enterprises.get(en - 1).getRooms().get(i).get(0)][enterprises.get(en - 1).getRooms().get(i).get(1)].getTotalRamMemory() +
                        "\nTotal Disk Capacity: " + minirooms[enterprises.get(en - 1).getRooms().get(i).get(0)][enterprises.get(en - 1).getRooms().get(i).get(1)].getTotalDiskCapacity());
            }
            int miniroomtocancel;
            while (true) {
                try {
                    miniroomtocancel = s.nextInt();
                    if (miniroomtocancel >= 1 || miniroomtocancel <= enterprises.get(en - 1).getRooms().size()) {
                        break;
                    } else {
                        System.out.print("Invalid option\n");
                    }
                } catch (Exception e) {
                    System.out.print("Invalid option\n");
                }
            }
            totalpayed += enterprises.get(en - 1).getDebtByRoom().get(miniroomtocancel-1);
            enterprises.get(en - 1).getRooms().remove(miniroomtocancel-1);
            enterprises.get(en - 1).getDebtByRoom().remove(miniroomtocancel-1);
            System.out.print("This minorrom is now available\n");
        }
    }

    /**
     *
     * @return the enterprises array.
     */
    public ArrayList<Enterprise> getEnterprises(){
        return this.enterprises;
    }
}
