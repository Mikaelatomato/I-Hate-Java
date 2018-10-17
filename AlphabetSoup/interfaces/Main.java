package interfaces;
import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

/**
 * @version 0.00001 alpha
 *
 * @author Jean Alvarez (github.com/mikaelatomato)
 *
 * patch list:
 *
 * fixed some bugs and added new ones.
 */
public class Main{

    private ArrayList<String> userSolutions = new ArrayList<>();
    final static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws FileNotFoundException {
        Main m = new Main();
        welcome();
        m.menu();
    }

    public void menu(){
        userSolutions = new ArrayList<>();
        whilePlaying(showMenuOptions());
    }

    /**
     * So, i wanted to do a good fucking looking art here, but, i'm lazy, and i'm not good at that tbh, so...")
     * this method just prints this.
     *
     */

    public static void welcome() {
        System.out.print("Let's play together! | Letter (Alphabet) Soup\n\n");
    }

    /**
     * This method takes the 'options' for the letter soup that is going to be generated.
     * @return an array containing the values to create a letter soup.
     */
    public ArrayList<Integer> showMenuOptions(){
        ArrayList<Integer> options = new ArrayList<>();
        while (true){
            try{
                System.out.println("\nChoose the level you want to play ");
                System.out.println("1. Basic Level");
                System.out.println("2. Intermediate Level");
                System.out.println("3. Advanced Level ");
                int mode =sc.nextInt();
                if (mode > 0 && mode <= 3){
                    options.add(mode);
                    break;
                } else {
                    System.out.print("That level doesn't exist, try again.\n\n");
                }

            } catch (Exception e){
                System.out.print("Invalid option.\n\n");
                sc.next();
            }
        }
        while (true){
            try{
                System.out.println("What kind of soup would would you like to play? ");
                System.out.println("1. Animals");
                System.out.println("2. Plants");
                System.out.println("3. Culture");
                System.out.println("4. Sports");
                System.out.println("5. Books");
                int type = sc.nextInt();
                if (type > 0 && type <=5 ){
                    options.add(type);
                    break;
                } else {
                    System.out.print("That kind of soup doesn't exist, try again.\n\n");
                }

            } catch (Exception e){
                System.out.print("Invalid option.\n\n");
                sc.next();
            }

        }
        return options;

    }

    /**
     * This method starts the game.
     *
     * pre: showMenuOptions was ran and we have a correct array of options to be used.
     *
     * pos: this keeps running while the player plays and takes care of him.
     *
     * @param options takes the options array and uses it to create the letter soup.
     *
     */

    public void whilePlaying(ArrayList<Integer> options){
        AlphabetSoup a = new AlphabetSoup(options.get(0), options.get(1));
        a.init();
        a.setWords();
        a.setRandomLetters();
        a.drawAlphabetSoup();

        System.out.print("\n");

        while (a.getPartialSolutions().size() != 0){
            System.out.print("\nFor now you have found the next words: " + userSolutions + "\n" + a.getPartialSolutions().size() + " more to go!! | | write 's' to surrender or 'r' to reload");
            System.out.print("\nWrite your answers here: ");
            String userguess = sc.next();
            if (a.getPartialSolutions().contains(userguess)){
                userSolutions.add(userguess);
                a.getPartialSolutions().remove(userguess);
            } else if (userguess.equals("s")){
                System.out.print("\n\nYou have surrendered :(\n");
                System.out.print("The remaining words in soup were the next ones: " + a.getPartialSolutions() +"\nand you had: " + userSolutions);
                System.out.print("\n\nWrite anything to leave.");
                sc.next();
                System.out.print("See you next time ;)");
                System.exit(0);
            } else if (userguess.equals("r")){
                menu();
            }
            } if (a.getPartialSolutions().size() == 0){
            System.out.print("\n\n¡¡¡¡¡¡¡¡¡¡¡¡YOU HAVE WON!!!!!!!!!!!!\n\n");
            System.out.print("Press 'r' to reload a new game, or press 'l' to leave");
            String useroption = sc.next();
            if (useroption.equals("r")){
                menu();
            } else if (useroption.equals("l")){
                System.exit(0);
            }
        }
    }
}
