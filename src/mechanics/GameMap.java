package mechanics;

import terrain.Terrain;

import java.util.ArrayList;

public class GameMap {
    private static GameMap singleInstance = null;
    private int numRows;
    private int numColumns;

    private ArrayList<ArrayList<Terrain>> map;
    public GameMap() {
        map = new ArrayList<ArrayList<Terrain>>();
    }

    public GameMap(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        map = new ArrayList<ArrayList<Terrain>>(numRows);
        for (int i = 0; i < numRows; ++i) {
            map.add(new ArrayList<Terrain>(numColumns));
        }
    }

    /**/
    public ArrayList<ArrayList<Terrain>> getMap() {
        return map;
    }

    /**/
    public int getNumRows() {
        return numRows;
    }

    /**/
    public int getNumColumns() {
        return numColumns;
    }

//    public static GameMap getInstance() {
//        if (singleInstance == null) {
//            singleInstance = new GameMap();
//        }
//    }
}
