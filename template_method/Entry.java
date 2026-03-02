import java.util.Scanner;

public class Entry {
    public static void main (String[] args) {
GameClass game = new LuckWarGame();
        Scanner input = new Scanner(System.in);
        System.out.println("Number of players: ");
        int numOfPlayers = input.nextInt();
        if (numOfPlayers < 1) {
            System.out.println("Please enter a number between 1 and 10");
            System.exit(0);
        }
        System.out.println("Instructions");
        System.out.println("------------------");
        System.out.println("turn based game, each player starts with 100 health, on each turn, a  player rolls the dice and chooses another player to attack, the damage is determined by the dice number.SImPle!!!");

        game.play(numOfPlayers);





    }
}
