package opgave02;

import java.util.Scanner;

public class Craps {

    private static int point = 0;//felt variabel der gemmer summen fra første kast og bruger den i continueGame metode

    public static void main(String[] args) {
        playCrabs(rollDice()); //metode der starter spillet
    }

    public static int[] rollDice() {
        int[] rolls = new int[2]; //array der gemmer terninge kast
        rolls[0] = (int) (Math.random() * 6 + 1); //terninger
        rolls[1] = (int) (Math.random() * 6 + 1);
        return rolls;
    }

    public static void playCrabs(int[] rolls) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tryk enter for at starte, nej for at stoppe ");
        String answer = scanner.nextLine(); //scanner der registrer user input for at slå terning


        int rollsSum = rolls[0] + rolls[1];
        if (rollsSum == 7 || rollsSum == 11) { //Win condition på første slag
            System.out.println("Du slog: " + rolls[0] + " og " + rolls[1] + " du vandt");
        } else if (rollsSum == 2 || rollsSum == 3 || rollsSum == 12) { //lose condtion på første slag
            System.out.println("Du slog: " + rolls[0] + " og " + rolls[1] + " du tabte");
        } else {
            point = rollsSum;
            System.out.println("du slog " + rolls[0] + " og " + rolls[1] + " du skal nu ramme " + rollsSum + " point");
            if (!continuegame(point)) ;
        } //metode for at fortsætte spillet hvis hverken win eller lose condition opfyldes retunere false hvis spillet skal stoppes


    }

    public static boolean continuegame(int point) { //metode for at fortsætte spillet
        Scanner scan = new Scanner(System.in); //scanner der tager user input kører spillet videre
        System.out.println("Tryk enter for at rulle videre ");
        String answer = scan.nextLine();

        while (answer == "") { //loop der slår terning hver gang der registrers user input
            int[] faces = rollDice(); //array som gemmer terningkast
            System.out.println("terning 1: " + faces[0]); //printer terning slag ud
            System.out.println("terning 2: " + faces[1]);

            int sum = faces[0] + faces[1]; //integer der gemmer summen af begge slag

            if (sum == point) { //win condtioin
                System.out.println("du har vundet ");
                return false;
            } else if (sum == 7) {//lose condition
                System.out.println("du har tabt ");
                return false;
            }
            System.out.println("tryk enter for at rulle ");
            answer = scan.nextLine();
        }
        return true;
    }
}
