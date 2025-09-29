package examples;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int rollSum = 0;
    private static int pair = 0;
    private static int maxSum = 0;
    private static int[] eyesCount = new int[6];

    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, rul to terninger.");
        printRules();
        System.out.println();

        //playOneDie();
        rollDice();

        System.out.println();
        System.out.println("Tak for at spille, rul to terninger.");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul to terninger");
        System.out.println("Spilleren ruller to terninger, så længde man lyster.");
        System.out.println("=====================================================");
    }

    private static int[] rollDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul en terninger? ('ja/nej') ");
        String answer = scanner.nextLine();
        int[] dice = new int[2];
        while (!answer.equals("nej")) {
            dice[0] = rollDie();
            dice[1] = rollDie();

            System.out.println("Du rullede: " + dice[0] + " og " + dice[1]);

            if (dice[0] < dice[1]) {
                System.out.println("Dit største tal er: " + dice[1]);
            } else {
                System.out.println("Dit største tal er: " + dice[0]);
            }
            System.out.println();

            updateStatistics(dice);

            System.out.print("Rul en terninger? ('ja/nej') ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
        return dice;
    }

    public static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static void updateStatistics(int[] dice) {
        rollCount++;
        rollSum += dice[0] + dice[1];

        if (dice[0] == dice[1]) {
            pair++;
        }

        int currentSum = dice[0] + dice[1];

        if (maxSum < currentSum) {
            maxSum = currentSum;
        }

        for (int i = 0; i < dice.length; i++){
            int eyes = dice[i];
            eyesCount[eyes - 1]++;
        }
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%24s %4d\n", "Antal rul:", rollCount);
        System.out.printf("%24s %4d\n", "Summen af alle rul:", rollSum);
        System.out.printf("%24s %4d\n", "Antal par rullet:", pair);
        System.out.printf("%24s %4d\n", "Største slag:", maxSum);

        System.out.println();

        for (int i = 0; i < eyesCount.length; i++){
            System.out.printf("%24s %4d\n", "Antal " + (i + 1) + "'ere rullet:", eyesCount[i]);
        }
    }

}
