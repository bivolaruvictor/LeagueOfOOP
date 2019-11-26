package player;

import constants.KnightConstants;

public class Knight extends Player {
    public Knight() {
        super();
        setType(PlayerType.knight);
        setHp(KnightConstants.KNIGHT_STARTING_HP);
    }
}
