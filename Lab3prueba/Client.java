import java.util.Scanner;

public class Client {

    private String name;
    private String id;
    private String dir;
    private Double totalincome;
    private String email;
    private Date birthdate;
    private Scanner s = new Scanner(System.in);

    public Client() {
        System.out.print("\nClient's name: ");
        this.name = s.nextLine();
        System.out.print("\nClient's dir: ");
        this.dir = s.nextLine();
        System.out.print("\nClient's id: ");
        this.id = s.next();
        System.out.print("\nClient's totalincome: ");
        this.totalincome = s.nextDouble();
        System.out.print("\nClient's email: ");
        this.email = s.next();
        System.out.print("\nClient's birthday as day/month/year - 00/00/0000: ");
        String birthdate = s.next();
        this.birthdate = new Date(Integer.parseInt(birthdate.substring(0, 1)), Integer.parseInt(birthdate.substring(4, 5)), Integer.parseInt(birthdate.substring(7, 10)));
    }
}