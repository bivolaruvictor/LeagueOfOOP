package player;

import constants.KnightConstants;
import constants.LandMultipliers;
import constants.RogueConstants;

public class Rogue extends Player {
    private int numberOfBackstabs;
    public Rogue() {
        super();
        setType(PlayerType.rogue);
        setHp(RogueConstants.ROGUE_STARTING_HP);
        setTerrainBonus(LandMultipliers.WOODS_MULTIPLIER);
        setNumberOfBackstabs(0);
    }

    public int getNumberOfBackstabs() {
        return numberOfBackstabs;
    }

    public void setNumberOfBackstabs(int numberOfBackstabs) {
        this.numberOfBackstabs = numberOfBackstabs;
    }

    @Override
    public int getMaxHp() {
        return RogueConstants.ROGUE_STARTING_HP
                + RogueConstants.ROGUE_HP_PER_LEVEL * getLevel();
    }
}
