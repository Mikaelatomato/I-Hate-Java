package model;
import model.BikeStation;
/**
 * a class for new routes.
 */
public class Route {
    /**
     * stations that are part of the route.
     * Why only two? well, if a user wants to go to a different station, firstly he has to go to the closes one and
     * renovate his usage of the bike.
     */
    private BikeStation station1;
    private BikeStation station2;


    public Route(BikeStation station1, BikeStation station2){
        this.station1 = station1;
        this.station2 = station2;
    }

    /**
     * if you want to know the route, it'll just display it.
     */
    public void displayRoute(){
        System.out.print(this.station1.getStationname() + " to " + this.station2.getStationname());
    }

    /**
     *
     * @return those will be used to calculate the distance (i don't know how to encapsulate or whatever to make them just be one)
     */
    public BikeStation getStation1(){
        return station1;
    }

    public BikeStation getStation2() {
         return station2;
    }

}
