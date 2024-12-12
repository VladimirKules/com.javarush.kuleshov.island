import entities.map.GameMap;


public class StartGame {
    public static void main(String[] args) throws Exception {
        GameMap map = new GameMap();
        map.populateIsland();
        map.printMap();
        map.start();
    }
}
