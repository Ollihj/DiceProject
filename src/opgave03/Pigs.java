package opgave03;

import java.util.Scanner;

public class Pigs {
    private static int sumPlayer1 = 0;
    private static int SumPlayer2 = 0;
    private static boolean gameOver = false;
    private static boolean isPlayerOne = true;


    public static void main(String[] args) {

    }
    private static int rollDie() {
        int rolls = 0;
        rolls = (int) (Math.random() * 6 + 1);
        return rolls;
    }
    private static void playPigs(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("press enter to roll, no to stop ");
        String answer = scanner.nextLine();

        while (gameOver !=true){

            if (!answer.equals("no")){
                int face = rollDie();
                int tempsum = face;

                if (face == 1){
                    System.out.println("you rolled 1 your turn is over ");
                    System.out.println();
                    tempsum =0;
                }
            }
        }


    }
    private static boolean winCondtion(){
        if ((sumPlayer1 ==100)){
            System.out.println("player 1 has won");
            return true;
        }else if(SumPlayer2==100){
            System.out.println("player 2 has won");
        }
        return false;
    }
}
