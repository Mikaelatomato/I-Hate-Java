package model;

import java.time.LocalDate;
import java.util.*;

public class Miniroom {

    public static Scanner s = new Scanner(System.in);
    private String id;
    private ArrayList<Server> rack = new ArrayList<>(8);
    private Boolean isOn;
    private Enterprise enterprise;
    private int serversUsed;
    private LocalDate rentDate;

    public Miniroom(String id){
        this.id = id;
        this.isOn = true;
    }

    /**
     * adds servers to the rack array
     * @param serversToAdd how many servers are going to be added
     * pos: add servers to the ....
     */

    public void addNewServers(int serversToAdd) {
        if (rack.size() < 8 && rack.size() + serversToAdd <= 7) {
            for (int i = 0; i < serversToAdd; i++){
                System.out.print("\nRam Memory for the " + (i+1) + " server: ");
                Double ramMemory = s.nextDouble();
                System.out.print("Cache Memory for the " + (i+1) + " server: ");
                Double cacheMemory = s.nextDouble();
                System.out.print("Processor Maker of the " + (i+1) + " server: ");
                String processorMaker = s.next();
                System.out.print("Number of processors of the " + (i+1) + " server: ");
                int numberOfProcessors = s.nextInt();
                System.out.print("Number of disks for the " + (i+1) + " server: ");
                int numberOfDisks = s.nextInt();
                System.out.print("Disk Capacity of the disks for the " + (i+1) + " server: ");
                Double disksCapacity = s.nextDouble();
                rack.add(new Server(ramMemory, cacheMemory, processorMaker, numberOfProcessors, numberOfDisks, disksCapacity));
            }
        } else if (rack.size() == 8 || rack.size() + serversToAdd >= 8 ) {
            throw new UnsupportedOperationException("\nThis rack already has eight(8) servers or you cant add that amount of servers, there's not space enough\n");
        }
    }

    /**
     * pos:changes the status to ON (true)
     */

    public void turnOn(){
        isOn = true;
    }

    /**
     * pos: changes the status to OFF (false)
     */

    public void turnOff(){
        isOn = false;
    }

    /**
     *
     * @return the miniroom id
     */

    public String getId(){
        return id;
    }

    /**
     *
     * @return the array called rack that contains the servers
     */
    public ArrayList<Server> getRack(){
        return rack;
    }

    /**
     *
     *
     * @param enterprise that will rent it
     * @param serversUsed how many servers will the enterprise use
     * @param year of rental
     * @param month of rental
     * @param day of rental
     *
     * pos: sets the enterprise of this miniroom
     */

    public void setEnterprise(Enterprise enterprise, int serversUsed, int year, int month, int day){
        if (enterprise.isDefaulter()){
            throw new UnsupportedOperationException("\nThis enterprise is a defaulter so this room can't be given to it\n");
        } else {
            this.enterprise = enterprise;
            this.serversUsed = serversUsed;
            this.rentDate = LocalDate.of(year, month, day);
        }
    }

    /**
     *
     * @return the enterprise that "owns" this miniroom.
     */
    public Enterprise getEnterprise(){
        return enterprise;
    }

    /**
     *
     * @return how many servers does the enterprise use.
     */

    public int getServersUsed(){
        return serversUsed;
    }

    /**
     * sets this miniroom to available again by making almost everything null again.
     */

    public void setNoEnterprise(){
        this.rack = new ArrayList<>();
        this.enterprise = null;
        this.rentDate = null;
        this.serversUsed = 0;
    }

    /**
     *
     * @return a boolean that'll say if the miniroom is on or not
     */

    public boolean isOn(){
        return isOn;
    }

    /**
     *
     * @return the total ram memory contained in the rack
     */

    public Double getTotalRamMemory(){
        Double total = 0.0;
        for (Server s : rack){
            total += s.getRamMemory();
        }
        return total;
    }

    /**
     *
     * @return the total disk capacity contained in the rack
     */

    public Double getTotalDiskCapacity(){
        Double total = 0.0;
        for (Server s : rack){
            total += s.getDiskCapacity();
        }
        return total;
    }
}
