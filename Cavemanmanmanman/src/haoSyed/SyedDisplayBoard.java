package haoSyed;

public class SyedDisplayBoard {

	public static void displayBoard2(boolean flippedCardsBoard2[][], int[][] board2) {

        System.out.println("   |     1     |     2     |     3     |     4     ");
        for (int i = 0; i < 4; i++) {
            System.out.print(" " + (i + 1) + " ");
            for (int a = 0; a < 4; a++) {
                if (flippedCardsBoard2[i][a]) {
                    System.out.print("|     " + board2[i][a]+ "    ");
                    System.out.print(" ");
                }
                else
                    System.out.print("|     *     ");
            }
            System.out.println();
        }
        System.out.println();
    }

	public static void displayBoard1(boolean flippedCardsBoard1[][], int[][] board1) {

        System.out.println("   |     1     |     2     |     3     |     4     ");
        for (int i = 0; i < 4; i++) {
            System.out.print(" " + (i + 1) + " ");
            for (int a = 0; a < 4; a++) {
                if (flippedCardsBoard1[i][a]) {
                    System.out.print("|     " + board1[i][a]+ "    ");
                    System.out.print(" ");
                }
                else
                    System.out.print("|     ?     ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
