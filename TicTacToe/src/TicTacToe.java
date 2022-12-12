import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {
        char[][] board = {{'-','-','-'}, {'-','-','-'}, {'-','-','-'}};
        /*
box selection
        String i = "100";
        while (!i.equals("0")) {
            Scanner scanner = new Scanner(System.in);
*/
        boolean random = startingPlayer();
            boxSelection(board, random);

//            System.out.println("Exit - press 1");
//            System.out.println("Play again - press 1");
//            i = scanner.nextLine();
        }


    public static boolean startingPlayer(){
        Random rand = new Random();
        boolean random = rand.nextBoolean();

        if (random){
            System.out.println("Player starts!");
        } else {
            System.out.println("Cpu first!");
        }
        return random;
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placeBox(char[][] board, int position, String user, boolean priority) {

        char symbol = ' ';

        if (priority) {
            if (user.equals("Player")) {
                symbol = 'O';
                playerPositions.add(position);
            } else if (user.equals("Computer")) {
                symbol = 'X';
                cpuPositions.add(position);
            }
        } else {
            if (user.equals("Player")) {
                symbol = 'X';
                playerPositions.add(position);
            } else if (user.equals("Computer")) {
                symbol = 'O';
                cpuPositions.add(position);
            }
        }
        switch (position) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
        }
    }

    public static void boxSelection(char[][] board, boolean priority) {

        while (true) {
            if (priority) {
                playersMove(board, true);
                String result = checkWinner();
                if (result.equals("Congratulations, you won") || result.equals("Computer won") || result.equals("Tie.")){
                    System.out.println(result);
                    break;
                }
                cpuMove(board, true);
                printBoard(board);
            } else {
               cpuMove(board, false);
               printBoard(board);
               String result = checkWinner();
                if (result.equals("Congratulations, you won") || result.equals("Computer won") || result.equals("Tie.")){
                    System.out.println(result);
                    break;
                }
               playersMove(board, false);
            }
            String result = checkWinner();

            if (result.equals("Congratulations, you won") || result.equals("Computer won") || result.equals("Tie.")){
                System.out.println(result);
                break;
            }
        }
    }

//    public static String winChecker(String result){
//
//
//        if (result.equals("Congratulations, you won") || result.equals("Computer won") || result.equals("Tie.")){
//            System.out.println(result);
//            return null;
//        }
//    }

    public static void playersMove(char[][] board, boolean priority){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Player's Move");
        System.out.println("Select the box");
        int playerPos = scanner.nextInt();
        while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){
            System.out.println("Position taken, try again");
            playerPos = scanner.nextInt();
        }
        System.out.println(playerPos);
        placeBox(board, playerPos, "Player", priority);
    }

    public static void cpuMove(char[][] board, boolean priority){
        Random rand = new Random();
        System.out.println("Computer's Move");
        int cpuPos = rand.nextInt(9) + 1;
        while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
            cpuPos = rand.nextInt(9) + 1;
        }
        placeBox(board, cpuPos, "Computer", priority);
    }

    public static String checkWinner() {

        List<Integer> topRow = Arrays.asList(1,2,3);
        List<Integer> midRow = Arrays.asList(4,5,6);
        List<Integer> bottomRow = Arrays.asList(7,8,9);
        List<Integer> leftCol = Arrays.asList(1,4,7);
        List<Integer> middleCol = Arrays.asList(2,5,8);
        List<Integer> rightCol = Arrays.asList(3,6,9);
        List<Integer> upDownCross = Arrays.asList(1,5,9);
        List<Integer> downUpCross = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(bottomRow);
        winning.add(leftCol);
        winning.add(middleCol);
        winning.add(rightCol);
        winning.add(upDownCross);
        winning.add(downUpCross);

        for (List l : winning){
            if (playerPositions.containsAll(l)){
                return "Congratulations, you won";
            } else if (cpuPositions.containsAll(l)){
                return "Computer won";
            } else if (playerPositions.size() + cpuPositions.size() == 9){
                return "Tie.";
            }
        }
        return "";
    }
}

