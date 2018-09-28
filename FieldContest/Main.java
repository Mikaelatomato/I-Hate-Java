import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Contest contest = new Contest();

        int a = 1;

        while (a <= 3){
            System.out.print("Type the field's " + a + " name: ");
            String name = s.next();
            System.out.print("Type the field's " + a + " width: ");
            Double width = s.nextDouble();
            System.out.print("Type the field's " + a + " height: ");
            Double height = s.nextDouble();
            System.out.print("\n");
            if (a == 0){
                contest.createFieldOne(name, width, height);
                a++;
                continue;
            } else if (a == 1){
                contest.createFieldTwo(name, width, height);
                a++;
                continue;
            } else {
                contest.createFieldThree(name, width, height);
                a++;
            }

        }
        System.out.print(contest.searchBiggestField());


    }
}
