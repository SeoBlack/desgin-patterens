import java.util.Scanner;

public class Game {
    static boolean gameOver = false;
    static void main(String[] args) {
        Character player = new Character("Sorin");

        System.out.println("================================");
        System.out.println("Welcome " + player.getName());
        System.out.println("================================");
        while (!gameOver) {
            checkLevel(player);
            checkStatus(player);

            System.out.println("here is your current status");
            System.out.println("Name: " + player.getName() + " XP: " + player.getXp() + " Level: " + player.getLevel() + " Health: " + player.getHealth());
            System.out.println("================================");
            System.out.println("Choose your action: ");
            System.out.println(" 1. Train" + " 2. Meditate" + " 3. Fight" +  " 4. Quit");
            System.out.print(":");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    player.state.train();
                    break;
                case  2:
                    player.state.meditate();
                    break;
                case  3:
                    player.state.fight();
                    break;
            }

            checkHealth(player);
            checkXp(player);



        }
    }
     static void checkStatus(Character player) {
        if (player.state instanceof GameOverState|| player.state instanceof MasterState) {
            gameOver = true;
        }

    }
    static  void checkXp(Character player) {
        //each 5 xp is 1 level
        //so 0 lvl 0
        //5xp lvl 1
        //10 xp lvl 2
        int newLevel = player.getXp() / 5;
        if(player.getLevel() != newLevel){
            player.setLevel(newLevel);
            System.out.println("new level Reached " + player.getLevel());


        }

    }
    static void checkLevel(Character player) {
        //from level 0-10 : Novice
        //from level 11-20: intermediate
        //from level 21-30: Expert
        //from level 31: Master
        if(player.getLevel() == 0 ){
            if(player.state instanceof NoviceState) return; //already a Novice
            player.setState(new NoviceState(player));
        }

        if(player.getLevel() >= 11 &&  player.getLevel() <= 20 ){
            if(player.state instanceof IntermediateState) return;

            player.setState(new IntermediateState(player));
            System.out.println("Congratulations! You reached Intermediate");
        }
        if(player.getLevel() >= 21 &&  player.getLevel() <= 30 ){
            if(player.state instanceof ExpertState) return;
            player.setState(new ExpertState(player));
            System.out.println("Congratulations! You reached Expert");
        }
        if(player.getLevel() >= 31){
            if(player.state instanceof MasterState) return;
            player.setState(new MasterState(player));
            System.out.println("Congratulations! You reached Master");
            gameOver = true;
        }

    }
    static void checkHealth(Character player){
        if(player.getHealth() <= 0){
            player.setState(new GameOverState(player));
        }
    }

}
