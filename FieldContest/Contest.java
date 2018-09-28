
import java.util.ArrayList;

public class Contest {

    private ArrayList<FootballField> footballfields = new ArrayList<>();


    public Contest(){

    }

    public void createFieldOne(String name, double width, double height) {
        this.footballfields.add(new FootballField(name, width, height));
    }

    public void createFieldTwo(String name, double width, double height) {
        this.footballfields.add(new FootballField(name, width, height));
    }

    public void createFieldThree(String name, double width, double height) {
        this.footballfields.add(new FootballField(name, width, height));
    }

    public String searchBiggestField() {
        Double biggest = 0.0;
        int a = 0;
        for (int i = 0; i < footballfields.size(); i++){
            if (footballfields.get(i).calculateArea() > biggest){
                biggest = footballfields.get(i).calculateArea();
                a = i;
            }
        }
        return "The field with the biggest area is " + footballfields.get(a).giveName();
    }
}
