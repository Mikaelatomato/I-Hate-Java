package model;

public class Vaccine {

    /**
     * the ugly ass girl that no one wants but is useful
     * that's the vaccine class, i didn't focus a lot on this one because it was a lot easier and faster to work everything just with the VaccinationScheme class.
     * a vaccine has a name (and doesn't have a 'disease' since that would be redundant)
     * also a price, that will be defined by the Vaccination Scheme based on the patient's information.
     * and a required age to be applied.
     */
    private String name;
    private float price;
    private int requiredage;

    /**
     * the constructor, pretty simple, also, it will just be used by the VaccinationScheme init.
     * (we won't create new vaccines)
     * @param name has a name.
     * @param requiredage and a required age.
     */
    public Vaccine(String name, int requiredage){
        this.name = name;
        this.requiredage = requiredage;
    }

    /**
     * the metod used to define its price
     * @param price the method setPrices(); will give this param.
     */
    public void updatePrice(float price){
        this.price = price;
    }


    /**
     *
     * @return the vaccines name
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     * @return the vaccines price
     */
    public float getPrice() {
        return price;
    }

    /**
     *
     * @return the required age for this vaccine.
     */
    public int getRequiredAge(){
        return requiredage;
    }

}
