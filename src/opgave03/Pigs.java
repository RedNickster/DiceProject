package opgave03;

import java.util.Scanner;

public class Pigs {
    private static int player1Points = 0;
    private static int player2Points = 0;
    private static int pointMax = 100;

    private static double throwsCount1 = 0;
    private static double throwsCount2 = 0;

    private static double roundCount1 = 0;
    private static double roundCount2 = 0;

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Velkommen til play pigs.");
        System.out.println("Hvad skal i spille til?");
        pointMax = sc.nextInt();
        sc.nextLine();

        playPig();

        sc.close();
    }

    public static void playPig() {
        System.out.println("Tryk enter for at starte spillet.");
        System.out.println("==============================================================");
        sc.nextLine();
        System.out.println();

        int playerShift = 1;
        while (player1Points <= pointMax && player2Points <= pointMax) {

            //Hvis I tæller fra 0 playerShift = 0; kan I simplificere dette til
            //System.out.println("Spiller " + (playerShift + 1) + " ruller, tryk enter");
            if (playerShift % 2 == 1) {
                System.out.println("Spiller 1 ruller, tryk enter");
                playerXThrows(1);
            } else {
                System.out.println("Spiller 2 ruller, tryk enter");
                playerXThrows(2);
            }
            playerShift++;
        }

        if (player1Points >= pointMax) {
            System.out.println("Spiller 1 har vundet");
        } else {
            System.out.println("Spiller 2 har vundet");
        }
    }

    public static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    public static void updatePlayerPoints(int player, int points) {
        //Hvis I bruger et array til at holde styr på spiller point og tæller fra 0.
        // playerPoints[player] += points
        if (player == 1) {
            player1Points += points;
        } else if (player == 2) {
            player2Points += points;
        }

    }

    //Med de foregående hints kan I lave jeres pigs program om, så det kan håndterer et vilkårligt antal spiller?
    public static void playerXThrows(int player) {
        int roll = 0;
        int sum = 0;
        int amountOfThrows = 0;
        String answer = "";
        System.out.println("Tryk enter for at rulle, skriv \"næste\" for at stoppe din tur");
        System.out.println("==============================================================");

        while (!answer.equals("næste") && roll != 1) {

            roll = rollDie();
            sum += roll;
            amountOfThrows++;

            System.out.println("Du slog " + roll);

            if (roll != 1) {
                System.out.println("Dine samlede point er: " + sum);
                System.out.println("Tryk enter for næste kast");
                answer = sc.nextLine();
            } else {
                System.out.println("Du slog en 1'er, næste spillers tur");

            }
        }
        if (answer.equals("næste")) {
            System.out.println("Kalder opdater point");
            updatePlayerPoints(player, sum);
        } else if (roll == 1) {
            System.out.println("Du rullede 1, næste spillers tur");
        }
        updateThrowsAverage(player, amountOfThrows);
        printPoints();
        System.out.println();
        printThrowsAverage();
    }

    private static void printPoints() {
        System.out.println("==============================================================");
        System.out.println("Spiller 1 har " + player1Points + " point");
        System.out.println("Spiller 2 har " + player2Points + " point");
        System.out.println("==============================================================");
    }

    private static void updateThrowsAverage(int player, int roundThrows) {
        if (player == 1) {
            throwsCount1 += roundThrows;
            roundCount1++;
        } else if (player == 2) {
            throwsCount2 += roundThrows;
            roundCount2++;
        }
    }

    private static void printThrowsAverage() {
        if (throwsCount1 > 0 && roundCount1 > 0) {
            double average1 = throwsCount1 / roundCount1;
            System.out.println("Player 1 average throws: " + average1);
        }

        if (throwsCount2 > 0 && roundCount2 > 0) {
            double average2 = throwsCount2 / roundCount2;
            System.out.println("Player 2 average throws: " + average2);
        }
        System.out.println("==============================================================");
    }
}
