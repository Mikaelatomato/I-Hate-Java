
public class FootballField {
    private String name;
    private Double width;
    private Double height;

    public FootballField(String name, Double width, Double height){
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public String giveName(){
        return this.name;
    }

    public Double calculateArea(){
        return this.height * this.width;
    }
}
