public class Game {
    public static void main(String[] args){
        Map map = createMap();
        map.display();
    }
    public static Map createMap(){
        int random = (int) (Math.random() * 2);
        if (random == 0) {
            return new CityMap();
        } else {
            return new WildernessMap();
        }
    }

}
