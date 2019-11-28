package player;

abstract class Player {
    private int hp;
    private PlayerType type;
    private int xp;
    private int level;

    Player() {
        xp = 0;
        level = 0;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
