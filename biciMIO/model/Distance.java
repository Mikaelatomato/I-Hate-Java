package model;
import model.Route;
/**
 * This is the class that calculates the distance between two stations, or better said, a route's distance.
 * the distance won't be exact and may be pretty bad, the formula that will be used only works with big distances.
 *
 */
public class Distance {

    /**
     * for this we need to consider:
     *  +the earth radius
     *  +both latitudes and longitudes
     *  +the difference between these latitudes and longitudes (dlat, dlon)
     *  +some weird mathematical formula called "the formula of Haversine" (what a weird name) which is represented by a, c and d.
     */

    private float earthradius;
    private float startlatitude;
    private float finislatitude;
    private float startlongitude;
    private float finishlongitude;
    private float dlon;
    private float dlat;
    private float a;
    private float c;
    private float d;

    /**
     *
     * @param route the route (start point - destination) that will give the values to calculate the distance
     */

    public Distance(Route route){
        startlatitude =  (float)Math.toRadians(route.getStation1().getLatitude());
        finislatitude =  (float)Math.toRadians(route.getStation2().getLatitude());
        startlongitude =  (float)Math.toRadians(route.getStation1().getLongitude());
        finishlongitude = (float)Math.toRadians(route.getStation2().getLongitude());
        earthradius = 6371;
    }

    /**
     *
     * @return the difference between both longitudes
     */
    public float getDlon(){
        dlon = this.startlongitude - this.finishlongitude;
        return dlon;
    }

    /**
     *
     * @return the difference between both latitudes
     */
    public float getDlat(){
        dlat = this.startlatitude - this.finislatitude;
        return dlat;
    }

    /**
     *
      * getA and getC are part of the formula.
     * then you may wonder "why is there a lot of (float), and that's because the Math.pow for example, only works with doubles
     * and i want it to work with float, that's why.
     *
     */
    public float getA(){
        getDlat();
        getDlon();
        a = (float)Math.pow(((Math.sin(dlat / 2))), 2) + (float)(Math.cos(startlatitude) *
                (float)Math.cos(finislatitude) * (float)Math.pow(((Math.sin(dlon / 2))), 2));
        return a;
    }
    public float getC(){
        getA();
        c = 2 * (float)Math.atan2(Math.sqrt(this.a), Math.sqrt(1- this.a));
        return c;
    }

    /**
     *
     * @return the distance in km :)
     */
    public float getDistance(){
        getC();
        d = earthradius * c;
        return d;
    }
}
