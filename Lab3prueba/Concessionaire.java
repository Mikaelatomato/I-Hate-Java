import java.util.Scanner;
import java.util.ArrayList;

public class Concessionaire {

    private String name;
    private String dir;
    private String phone;
    private String nit;
    private Scanner s = new Scanner(System.in);


    public Concessionaire(){
        this.name = "CarrosParaTodos";
        System.out.print("\nConcessionaire's dir ");
        this.dir = s.nextLine();
        System.out.print("\nConcessionaire's phone ");
        this.phone = s.next();
        System.out.print("\nConcessionaire's nit: ");
        this.nit = s.next();
    }

}
