package player;

import abilities.*;
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

    public void accept(Visitor ability) {
        ability.interactWith(this);
    }

    public void fightPlayer(Player player) {
        Drain drain = (Drain) getAbilityFactory().getAbilityType(AbilityType.drain, player);
        player.accept(drain);
        System.out.println(player.getType().toString() + " recieved from drain " + player.getRecievedDamage());
        player.recieveDamage();
        Deflect deflect = (Deflect) getAbilityFactory().getAbilityType(AbilityType.deflect, player);
        player.accept(deflect);
        System.out.println(player.getType().toString() + " recieved from deflect " + player.getRecievedDamage());
        player.recieveDamage();
        this.setBruteDamage(player.getBruteDamage());
        System.out.println();
        super.fightPlayer(player);
    }
}
