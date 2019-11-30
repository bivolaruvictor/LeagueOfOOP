package abilities;

import constants.LandMultipliers;
import constants.PyromancerConstants;
import constants.RaceMultiplier;
import constants.WizardConstants;
import player.*;
import terrain.TerrainType;

public class Deflect extends Ability {
    private float deflectPercentage;
    private int casterDamage;
    public Deflect(Player player) {
        super(player);
        setAbilityType(AbilityType.deflect);
        setDeflectPercentage(Math.min(WizardConstants.DEFLECT_STARTING_PERCENTAGE
                + WizardConstants.DRAIN_PERCENTAGE_ADDED_PER_LEVEL
                * player.getLevel(), WizardConstants.DEFLECT_MAXIMUM_PERCENTAGE));
        if (getGameMap().getMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.dessert)) {
            setLandModifier(LandMultipliers.DESERT_MULTIPLIER);
        }
        setCasterDamage(player.getRecievedDamage());
    }

    public float getDeflectPercentage() {
        return deflectPercentage;
    }

    public int getCasterDamage() {
        return casterDamage;
    }

    public void setCasterDamage(int casterDamage) {
        this.casterDamage = casterDamage;
    }

    public void setDeflectPercentage(float deflectPercentage) {
        this.deflectPercentage = deflectPercentage;
    }
    public void interactWith(Knight player) {
        setRaceModifier(RaceMultiplier.WIZARD_ON_KNIGHT_DEFLECT);
        int damageGiven = Math.round(getCasterDamage()
                * getDeflectPercentage() * getRaceModifier());
        player.setRecievedDamage(damageGiven);
    }

    public void interactWith(Pyromancer player) {
        setRaceModifier(RaceMultiplier.WIZARD_ON_PYROMANCER_DEFLECT);
        int damageGiven = Math.round(getCasterDamage()
                * getDeflectPercentage() * getRaceModifier());
        player.setRecievedDamage(damageGiven);
    }

    public void interactWith(Wizard player) {
        setRaceModifier(RaceMultiplier.WIZARD_ON_WIZARD_DEFLECT);
        int damageGiven = Math.round(getCasterDamage()
                * getDeflectPercentage() * getRaceModifier());
        player.setRecievedDamage(damageGiven);
    }

    public void interactWith(Rogue player) {
        setRaceModifier(RaceMultiplier.WIZARD_ON_ROGUE_DEFLECT);
        int damageGiven = Math.round(getCasterDamage()
                * getDeflectPercentage() * getRaceModifier());
        player.setRecievedDamage(damageGiven);
    }
}
