package player;

import constants.RogueConstants;

public class Rogue extends Player {
    public Rogue() {
        super();
        setType(PlayerType.rogue);
        setHp(RogueConstants.ROGUE_STARTING_HP);
    }
}
