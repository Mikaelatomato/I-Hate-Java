package interfaces;
import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.*;


public class Main{

    private Scanner sc;
    private ArrayList<String> userSolutions = new ArrayList<>();


    public Main(){
        sc=new Scanner(System.in);

    }

    public static void main(String[] args) throws FileNotFoundException {
        Main m = new Main();
        m.menu();
    }

    public void menu(){
        welcome();
        whilePlaying(showMenuOptions());
    }

    public void welcome(){
        System.out.println("********************************************************************************************************************\n");
        System.out.println("*    WWWW                  WWWW    EEEEEEEE   LLL        CCCCCCCC    OOOOOOOOO    MMMMMM     MMMMMM    EEEEEEEE    *");
        System.out.println("*     WWW                 WWW      EEE        LLL        CCC         OOO   OOO    MMM  MMM MMM  MMM    EEE         *");
        System.out.println("*      WWW               WWW       EEE        LLL        CCC         OOO   OOO    MMM    MMM    MMM    EEE         *");
        System.out.println("*       WWW    WWWWW    WWW        EEEEEEEE   LLL        CCC         OOO   OOO    MMM           MMM    EEEEEEEE    *");
        System.out.println("*        WWW  WW   WW  WWW         EEE        LLL        CCC         OOO   OOO    MMM           MMM    EEE         *");
        System.out.println("*         WWWWW     WWWWW          EEEEEEEE   LLLLLLLL   CCCCCCCC    OOOOOOOOO    MMM           MMM    EEEEEEEE    *");
        System.out.println("********************************************************************************************************************\n");
    }

    public ArrayList<Integer> showMenuOptions(){
        ArrayList<Integer> options = new ArrayList<>();
        System.out.println("Choose the level you want to play ");
        System.out.println("1. Basic Level");
        System.out.println("2. Intermediate Level");
        System.out.println("3. Advanced Level ");
        int mode =sc.nextInt();
        options.add(mode);
        System.out.println("What kind of soup would you like to play ");
        System.out.println("1. Animals");
        System.out.println("2. Plants");
        System.out.println("3. Culture");
        System.out.println("4. Sports");
        System.out.println("5. Books");
        int type = sc.nextInt();
        options.add(type);
        System.out.print("This game's number in the world:  ");
        return options;

    }

    public void whilePlaying(ArrayList<Integer> options){
        AlphabetSoup a = new AlphabetSoup(options.get(0), options.get(1));
        a.init();
        a.setWords();
        a.setRandomLetters();
        a.drawAlphabetSoup();

        System.out.print("\n");

        while (a.getPartialSolutions().size() != 0){
            System.out.print("\nFor now you have found the next words: " + userSolutions + "\n" + (a.getPartialSolutions().size() - userSolutions.size()) + " more to go!! | | write 's' to surrender or 'r' to reload");
            System.out.print("\nWrite your answers here: ");
            String userguess = sc.next();
            if (a.getPartialSolutions().contains(userguess)){
                userSolutions.add(userguess);
                a.getPartialSolutions().remove(userguess);
            } else if (userguess.equals("s")){
                System.out.print("The words in soup were the next ones: " + a.getPartialSolutions());
                System.out.print("\n\nWrite anything to leave.");
                sc.next();
                System.out.print("See you next time ;)");
                System.exit(0);
            } else if (userguess.equals("r")){
                menu();
            }
        }
    }
}
