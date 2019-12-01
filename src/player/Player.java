package player;

import abilities.AbilityFactory;
import abilities.Visitor;
import constants.PlayerConstants;
import mechanics.GameMap;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Visitable {
    private int round;
    private int hp;
    private PlayerType type;
    private int xp;
    private int level;
    private int xCoordinate;
    private int yCoordinate;
    private List<Character> moves;
    private Float terrainBonus;
    private Float raceBonus;
    private GameMap gameMap = GameMap.getInstance();
    private int recievedDamage;
    private int overtimeRounds;
    private int overtimeDamage;
    private int block;
    private AbilityFactory abilityFactory;
    private boolean isAlive;
    private int bruteDamage;

    Player() {
        round = 0;
        xp = 0;
        level = 0;
        xCoordinate = -1;
        yCoordinate = -1;
        moves = new ArrayList<>();
        terrainBonus = 1.0f;
        raceBonus = 1.0f;
        recievedDamage = 0;
        block = 0;
        abilityFactory = new AbilityFactory();
        isAlive = true;
        overtimeRounds = 0;
        overtimeDamage = 0;
    }

    public AbilityFactory getAbilityFactory() {
        return abilityFactory;
    }

    public void setAbilityFactory(AbilityFactory abilityFactory) {
        this.abilityFactory = abilityFactory;
    }

    /**/
    public void setType(PlayerType type) {
        this.type = type;
    }
    /**/
    public void setHp(int hp) {
        if (hp > 0) {
            this.hp = hp;
        } else {
            this.hp = hp;
            isDead();
        }
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

    public void setRound(int round) {
        this.round = round;
    }

    public boolean isAlive() {
        return isAlive;
    }

    void isDead() {
        isAlive = false;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Float getRaceBonus() {
        return raceBonus;
    }

    public void setRaceBonus(Float raceBonus) {
        this.raceBonus = raceBonus;
    }


    public int getBruteDamage() {
        return bruteDamage;
    }

    public void setBruteDamage(int bruteDamage) {
        this.bruteDamage = bruteDamage;
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
        return 0;
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

    public int getRound() {
        return round;
    }

    /**/
    public String typeToString() {
        switch (getType()) {
            case knight :
                return "K";
            case pyromancer:
                return "P";
            case wizard :
                return "W";
            case rogue :
                return "R";
        }
        return null;
    }

    public void accept(Visitor ability) {
    }

    public boolean fight(Player player) {
        if (this.getxCoordinate() == player.getxCoordinate()
        && this.getyCoordinate() == player.getyCoordinate()) {
            return true;
        }
        return false;
    }

    public void fightPlayer(Player player) {
    }

    public void addKilledXp(Player player) {
        addXp(Math.max(0, (PlayerConstants.XP_WINNING_BASE
                - (this.getLevel() - player.getLevel()) * PlayerConstants.XP_WINNING_MULTIPLYER)));
    }
    public void movePlayer() {
        if (getBlock() == 0) {
            switch (getMoves().get(getRound())) {
                case ('U'):
                    setxCoordinate(getxCoordinate() - 1);
                    break;
                case ('D'):
                    setxCoordinate(getxCoordinate() + 1);
                    break;
                case ('L'):
                    setyCoordinate(getyCoordinate() - 1);
                    break;
                case ('R'):
                    setyCoordinate(getyCoordinate() + 1);
                    break;
                default:
                    break;
            }
        }
    }

    public void recieveDamage() {
        setHp(getHp() - getRecievedDamage());
    }

    public void recieveOvertimeDamage() {
        if (getOvertimeRounds() > 0) {
            setHp(getHp() - getOvertimeDamage());
            setOvertimeRounds(getOvertimeRounds() - 1);
        }
    }

    public void addXp(int xP) {
        setXp(getXp() + xP);
        levelUp();
    }
    public void levelUp() {
        int oldLevel = getLevel();
        int newLevel = (getXp() - PlayerConstants.XP_LEVEL_UP_BASE) / PlayerConstants.XP_LEVEL_UP_MULTIPLYER + 1;
        if (newLevel != oldLevel) {
            setLevel(newLevel);
            setHp(getMaxHp());
        }
    }

    public String alive() {
        if (isAlive()) {
            return "alive";
        }
        return "dead";
    }
}
