package player;

import constants.LandMultipliers;
import constants.WizardConstants;

public class Wizard extends Player {
    public Wizard() {
        super();
        setType(PlayerType.wizard);
        setHp(WizardConstants.WIZARD_STARTING_HP);
        setTerrainBonus(LandMultipliers.DESERT_MULTIPLIER);
    }
    @Override
    public int getMaxHp() {
        return WizardConstants.WIZARD_STARTING_HP
                + WizardConstants.WIZARD_HP_PER_LEVEL * getLevel();
    }
}
