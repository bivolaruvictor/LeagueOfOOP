package player;

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

    Player() {
        xp = 0;
        level = 0;
        xCoordinate = -1;
        yCoordinate = -1;
        moves = new ArrayList<>();
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
    /**/
    public int getXp() {
        return xp;
    }
    /**/
    public int getLevel() {
        return level;
    }

    /**/
    public String typeToString() {
        return getType().toString();
    }
}
