import java.util.List;
import java.util.Scanner;

public class LuckWarGame extends GameClass {

    private boolean gameOver = false;
    private Entity[] players;

    public LuckWarGame() {
        super();

    }

    @Override
    public void initializeGame(int numberOfPlayers) {
        players = new Entity[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Entity("Player " + (i + 1));
        }

    }
    @Override
    public boolean endOfGame() {
        //check if all players died
        this.gameOver = true;
        for (Entity player : players) {
            if (!player.isDead()) { //if one player still alive
                this.gameOver = false;
            }
        }
        return gameOver;
    }
    @Override
    public void playSingleTurn(int player) {
        System.out.println("Player " + (player + 1) + "'s turn");
        System.out.println("-------------------------------------");
        Entity currentPlayer = players[player];
        int damage = this.players[player].rollDice();
        System.out.println("Player " + (player + 1) + "'s damage is " + damage);
        System.out.println("Choose a player to attack (Number only): ");
        for (Entity entity : players) {
            if (entity.isDead()) {
                continue;
            }
            //if current player
            if(entity == currentPlayer) {
                continue;
            }
            System.out.println("Name: " + entity.getName() + " Health: " + entity.getHealth());
        }
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        while (choice < 0 || choice > this.players.length || choice == player) { //cant damage themselves
            System.out.println("Please enter a number between 1 and " + (this.players.length));
        }
        players[choice - 1].takeDamage(damage);



    }
    @Override
    public void displayWinner(){
        //last man standing
        Entity winner = null;
        for (Entity player : players) {
            if (player.isDead()) {
                continue;
            }
            winner = player;
        }
        //winner
        if(winner != null){
            System.out.println("Congragulations! "+ winner.getName() +" You win!");
        }
    }
}
