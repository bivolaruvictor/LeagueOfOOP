package player;

import abilities.Ability;
import mechanics.GameMap;
import terrain.Terrain;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private int hp;
    private PlayerType type;
    private int xp;
    private int level;
    private int xCoordinate;
    private int yCoordinate;
    private List<Character> moves;
    private Float terrainBonus;
    private ArrayList<ArrayList<Terrain>> gameMap = GameMap.getInstance().getMap();
    private int recievedDamage;
    private int overtimeRounds;
    private int overtimeDamage;
    private int block;

    Player() {
        xp = 0;
        level = 0;
        xCoordinate = -1;
        yCoordinate = -1;
        moves = new ArrayList<>();
        terrainBonus = 1.0f;
        recievedDamage = 0;
        block = 0;
    }
    /**/
    public void setType(PlayerType type) {
        this.type = type;
    }
    /**/
    public void setHp(int hp) {
        this.hp = hp;
    }
    /**/
    public void setLevel(int level) {
        this.level = level;
    }
    /**/
    public void setXp(int xp) {
        this.xp = xp;
    }
    /**/
    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    /**/
    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    /**/
    public void setStartingPosition(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    /**/
    public void setTerrainBonus(Float terrainBonus) {
    }

    public void setRecievedDamage(int recievedDamage) {
        this.recievedDamage = recievedDamage;
    }

    public void setOvertimeRounds(int overtimeRounds) {
        this.overtimeRounds = overtimeRounds;
    }

    public void setOvertimeDamage(int overtimeDamage) {
        this.overtimeDamage = overtimeDamage;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    /**/
    public void addMove(Character movement) {
        getMoves().add(movement);
    }
    /**/
    public int getxCoordinate() {
        return xCoordinate;
    }

    /**/
    public int getyCoordinate() {
        return yCoordinate;
    }

    /**/
    public List<Character> getMoves() {
        return moves;
    }

    /**/
    public PlayerType getType() {
        return type;
    }
    /**/
    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
    }
    /**/
    public int getXp() {
        return xp;
    }
    /**/
    public int getLevel() {
        return level;
    }
    /**/
    public Float getTerrainBonus() {
        return terrainBonus;
    }

    public int getRecievedDamage() {
        return recievedDamage;
    }

    public int getOvertimeRounds() {
        return overtimeRounds;
    }

    public int getOvertimeDamage() {
        return overtimeDamage;
    }

    public int getBlock() {
        return block;
    }

    /**/
    public String typeToString() {
        return getType().toString();
    }

    public void accept(Ability ability) {

    }
}
