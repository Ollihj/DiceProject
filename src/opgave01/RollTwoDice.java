package opgave01;

import java.util.Scanner;

public class RollTwoDice {
    private static int sum = 0;//felt variabel der gemmer sum
    private static int sameFaces = 0;//felt variable der gemmer antal kast med samme antal øjne
    private static int antalKast = 0;//felt variabel der gemmer antal kast
    private static int largest = 0;//felt variabel der gemmer det største kast
    private static int[] amountFace = new int[6];//felt variabel der gemmer hvor mange gange hvert antal øjne er blevet kastet i et array

    public static void main(String[] args) {
        playDice(rollDice());
        printStatistics();
    }

    public static int[] rollDice(){//metode der opretter to terninger og kaster
        int[] rolls = new int[2];//array der gemmer værdien af begge terningekast
        rolls[0] = (int) (Math.random() * 6 + 1);//terning 1
        rolls[1] = (int) (Math.random() * 6 + 1);//terning 2
        return rolls;//retunere array med terning kast
    }
    public static void playDice(int[] dice){//metode der starter spillet
        Scanner scanner = new Scanner(System.in);//scanner der tager i mod user input for at kaste terning
        System.out.println("Rul to terninger? (ja/nej)");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")){//condtion for at fortsætte spillet
            int[] faces = rollDice();

            System.out.println("die 1: " + faces[0]);
            System.out.println("die 2: " + faces[1]);

            updateStatistic(faces);//metode opdatere statistikker for spillet

            System.out.println("keep rolling?");
            answer = scanner.nextLine();//scanner der tager user input om hvorvidt mand vil fortsætte spillet
        }
    }
    public static void updateStatistic(int[] faces){//metode der opdatere statistikker
        sum += faces[0] + faces[1];//Opdatere summen af alle kast i et spil
        antalKast++;//opdatere antal kast i et spil

        if (faces[0] == faces[1]){//opdatere antal gange mand slår et kast hvor begge terninger har samme antal øjne
            sameFaces++;
        }
        int sumSingleThrow = faces[0] + faces[1];//integer der gemmer summen af det seneste kast
        for (int i = 0; i < faces.length; i++){//loop der gennemgår det seneste slag med det forhenværrrende slag
            if (sumSingleThrow > largest){//conditon for at finde ud af om det nye tal er større end det forhenværrende
                int sumSingleThrown = faces[0] + faces[1];
                largest = sumSingleThrown;//opdatere Largest til at være = med det nye største tal
            }
            amountFace[faces[i] -1]++;//opdatere antal gange hver side af en terning er blevet slået i et spil
        }



    }
    public static void printStatistics(){//metode der printer staistikker
        System.out.print("summen er: ");
        System.out.println(sum);
        System.out.print("samme øjne: ");
        System.out.println(sameFaces);
        System.out.print("antal kast: ");
        System.out.println(antalKast);
        System.out.print("største kast: ");
        System.out.println(largest);
        System.out.println("antal gange hver side er blevet rullet ");
        for (int i = 0; i<amountFace.length; i++){
            System.out.println("Number "+(i+1)+": "+amountFace[i]);
        }
    }
}
