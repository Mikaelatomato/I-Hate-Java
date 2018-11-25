package model;

import java.util.ArrayList;
public class Enterprise {

    private String name;
    private String nit;
    private boolean isDefaulter;
    private Double debt;
    private ArrayList<Double> debtByRoom = new ArrayList<Double>();
    private ArrayList<ArrayList<Integer>> rooms = new ArrayList<ArrayList<Integer>>();

    public Enterprise(String name, String nit){
        this.name = name;
        this.nit = nit;
        this.isDefaulter = false;
        this.debt = 0.0;
    }

    /**
     *
     * @return a boolean that'll say if this enterprise is defaulter (true) or not (false)
     */

    public boolean isDefaulter(){
        return isDefaulter;
    }

    /**
     *
     * @return the enterprise's nit
     */

    public String getNit(){
        return nit;
    }

    /**
     *
     * @return the enterprise's name
     */

    public String getName(){
        return name;
    }

    /**
     * pre: debtByRoom isn't null
     * pos: sets the debt of this enterprise
     */

    public void setDebt(){
        for (int i = 0; i < debtByRoom.size(); i++){
            this.debt += debtByRoom.get(i);
        }
    }

    /**
     *
     * @return this enterprise's debt
     */

    public Double getDebt(){
        return  debt;
    }

    /**
     * pre : rooms isn't null
     * @return the pos of the minirooms rented to this enterprise
     */

    public ArrayList<ArrayList<Integer>> getRooms(){
        return rooms;
    }


    /**
     * pre : debtByRoom isn't null
     * @return an Array that contains the debt for each miniroom
     */
    public ArrayList<Double> getDebtByRoom(){
        return debtByRoom;
    }

    /**
     * pos: changes the status of 'isDefaulter' to its opposite
     */
    public void setDefaulter(){
        if (isDefaulter){
            this.isDefaulter = false;
        } else{
            this.isDefaulter = true;
        }
    }

}
