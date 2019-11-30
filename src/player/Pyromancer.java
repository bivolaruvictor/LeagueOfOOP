package player;

import abilities.Ability;
import abilities.Visitor;
import constants.LandMultipliers;
import constants.PyromancerConstants;

public class Pyromancer extends Player {
    public Pyromancer() {
        super();
        setType(PlayerType.pyromancer);
        setHp(PyromancerConstants.PYROMANCER_STARTING_HP);
        setTerrainBonus(LandMultipliers.VOLCANIC_MULTIPLIER);
    }
    @Override
    public int getMaxHp() {
        return PyromancerConstants.PYROMANCER_STARTING_HP
                + PyromancerConstants.PYROMANCER_HP_PER_LEVEL * getLevel();
    }

    public void accept(Visitor ability) {
        ability.interactWith(this);
    }
}
