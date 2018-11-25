package model;

public class Server {
    private Double ramMemory;
    private Double cacheMemory;
    private String processorMaker;
    private int processorsAmmount;
    private int disksAmmount;
    private Double disksCapacity;

    public Server(Double ramMemory, Double cacheMemory, String processorMaker, int processorsAmount, int disksAmount, Double disksCapacity){
        this.ramMemory = ramMemory;
        this.cacheMemory = cacheMemory;
        this.processorMaker = processorMaker;
        this.processorsAmmount = processorsAmount;
        this.disksAmmount = disksAmount;
        this.disksCapacity = disksCapacity;
    }

    /**
     *
     * @return the ram memory of this server
     */

    public Double getRamMemory(){
        return ramMemory;
    }

    /**
     *
     * @return the disk capacity of this server.
     */

    public Double getDiskCapacity(){
        return disksAmmount * disksCapacity;
    }
}

