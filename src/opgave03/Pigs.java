package opgave03;

import java.util.Scanner;

public class Pigs {
    private static int sumPlayer1 = 0;
    private static int sumPlayer2 = 0;
    private static boolean gameOver = false;
    private static boolean isPlayerOne = true;
    private static int roundPoints = 0;
    private static int winningPoints = 0;
    private static int totalRollsPlayer1 = 0;
    private static int totalRollsPlayer2 = 0;
    private static int turnsPlayer1 = 0;
    private static int turnsPlayer2 = 0;
    private static String currentplayer;

    public static void main(String[] args) {
        playPigs();

        System.out.println();

        printStatistics();
    }

    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static int[] rollTwoDice() {
        return new int[]{rollDie(), rollDie()};
    }

    private static void playPigs() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indtast antal point for at vinde: ");
        Scanner input = new Scanner(System.in);
        winningPoints = input.nextInt();

        while (!gameOver) {
            System.out.println("Tryk enter for at rulle terningerne, skriv 'nej' for at stoppe ");
            String answer = scanner.nextLine();

            if (!answer.equals("nej")) {
                int[] faces = rollTwoDice();
                int face1 = faces[0];
                int face2 = faces[1];

                if (isPlayerOne) {
                    totalRollsPlayer1++;
                } else {
                    totalRollsPlayer2++;
                }

                System.out.println((isPlayerOne ? "Spiller 1" : "Spiller 2") + " - kastede " + face1 + " og " + face2);

                if (face1 == 1 && face2 == 1) {
                    System.out.println((isPlayerOne ? "Spiller 1" : "Spiller 2") + " - kastede (1,1), du mister alle dine point!");
                    if (isPlayerOne) {
                        sumPlayer1 = 0;
                        isPlayerOne = false;
                        turnsPlayer1++;
                    } else {
                        sumPlayer2 = 0;
                        isPlayerOne = true;
                        turnsPlayer2++;
                    }
                    roundPoints = 0;
                } else if (face1 == 1 || face2 == 1) {
                    System.out.println("En af terningerne viste 1, din tur er slut, og du mister pointene fra denne runde.");
                    roundPoints = 0;
                    if (isPlayerOne) {
                        isPlayerOne = false;
                        turnsPlayer1++;
                    } else {
                        isPlayerOne = true;
                        turnsPlayer2++;
                    }
                } else {
                    roundPoints += face1 + face2;
                    if (isPlayerOne) {
                        System.out.println("Dine point denne tur er " + roundPoints);
                        System.out.println("Point i alt: " + sumPlayer1 + " (+" + roundPoints + ")");
                    } else {
                        System.out.println("Dine point denne tur er " + roundPoints);
                        System.out.println("Point i alt: " + sumPlayer2 + " (+" + roundPoints + ")");
                    }
                }

                if (winCondition()) {
                    gameOver = true;
                }
            } else {
                if (isPlayerOne) {
                    sumPlayer1 += roundPoints;
                    isPlayerOne = false;
                    turnsPlayer1++;
                } else {
                    sumPlayer2 += roundPoints;
                    isPlayerOne = true;
                    turnsPlayer2++;
                }
                roundPoints = 0; // Nulstil runde pointene
                System.out.println("Tur skiftet til " + (isPlayerOne ? "spiller 1" : "spiller 2"));
            }
        }
    }

    private static boolean winCondition() {
        if (sumPlayer1 >= winningPoints || roundPoints >= winningPoints) {
            System.out.println();
            System.out.println("Spiller 1 har vundet");
            return true;
        } else if (sumPlayer2 >= winningPoints || roundPoints >= winningPoints) {
            System.out.println();
            System.out.println("Spiller 2 har vundet");
            return true;
        }
        return false;
    }

    private static void printStatistics() {
        double averageRollsPlayer1 = (double) totalRollsPlayer1 / turnsPlayer1;
        double averageRollsPlayer2 = (double) totalRollsPlayer2 / turnsPlayer2;

        System.out.println("Statistik:");
        System.out.println("Spiller 1 - Gennemsnitlige kast pr. tur: " + averageRollsPlayer1);
        System.out.println("Spiller 2 - Gennemsnitlige kast pr. tur: " + averageRollsPlayer2);
    }
}
