package model;

public class Vaccine {

    private String name;
    private float price;
    private int requiredage;

    public Vaccine(String name, int requiredage){
        this.name = name;
        this.requiredage = requiredage;
    }

    public void updatePrice(float price){
        this.price = price;
    }


    public String getName(){
        return this.name;
    }
    public float getPrice() {
        return price;
    }

    public int getRequiredage(){
        return requiredage;
    }

}
