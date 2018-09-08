package model;
import java.util.Scanner;
/**
 * A class for instancing users.
 */
public class User {

    /**
     * a user has a name and an id i guess.
     */

    private String name;
    private String id;
    private static Scanner s = new Scanner(System.in);

    public User(){
        System.out.print("User's name: ");
        this.name = s.next();
        System.out.print("User's identification: ");
        this.id = s.next();
    }

    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }

    /**
     * wanna update the user name because you wrote it bad?
     * @param newname for the user.
     */
    public void updateName(String newname){
        this.name = newname;
    }

    /**
     * wanna update the user id because you wrote it bad?
     * @param newid for the user.
     */
    public void updateId(String newid){
        this.id = newid;
    }
}
