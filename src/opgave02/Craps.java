package opgave02;

import examples.RollTwoDice;

public class Craps {
    private static int comeOutRoll;
    private static int points = 0;

    public static void main(String[] args) {



        playCraps();
    }

    private static void playCraps() {
        comeOutRoll = RollTwoDice.rollDie() + RollTwoDice.rollDie();

        if (comeOutRoll == 7 || comeOutRoll == 11) {
            System.out.println("YOU WIN!!");
        } else if (comeOutRoll == 2 || comeOutRoll == 3 || comeOutRoll == 12) {
            System.out.println("YOU LOSE!!");
        } else {
            System.out.println("Dit Come Out Roll er: " + comeOutRoll);

            if (rollForPoint(comeOutRoll)) {
                System.out.println("Du vandt til Come Out Roll!");
            } else {
                System.out.println("Du tabte til Come Out Roll!");
            }
        }
    }

    private static boolean rollForPoint(int point) {
        int rollPoint = 0;

        while (true) {
            rollPoint = RollTwoDice.rollDie() + RollTwoDice.rollDie();
            System.out.println("Du rullede: " + rollPoint);
            if (rollPoint == point) {
                return true;
            } else if (rollPoint == 7) {
                return false;
            }
        }
    }
}
