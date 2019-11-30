package abilities;

import constants.LandMultipliers;
import constants.PyromancerConstants;
import constants.RaceMultiplier;
import constants.RogueConstants;
import player.*;
import terrain.TerrainType;

public class Backstab extends Ability {
    private float critical;
    public Backstab(Player player) {
        super(player);
        setAbilityType(AbilityType.backstab);
        setBaseDamage(RogueConstants.BACKSTAB_STARTING_DAMAGE);
        critical = 1.0f;
        if (getGameMap().getMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.woods)) {
            setLandModifier(LandMultipliers.WOODS_MULTIPLIER);
            Rogue dummy = (Rogue) player;
            if (dummy.getNumberOfBackstabs() - 1 % RogueConstants.BACKSTAB_CRITICAL_CHARGE == 0) {
                setCritical(RogueConstants.BACKSTAB_CRITICAL_MULTIPLYER);
            }
        }
    }

    public float getCritical() {
        return critical;
    }

    public void setCritical(float critical) {
        this.critical = critical;
    }

    public void interactWith(Knight player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_KNIGHT_BACKSTAB);
        int damageGiven = Math.round((getBaseDamage()
                + RogueConstants.BACKSTAB_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier() * getCritical());

        player.setRecievedDamage(damageGiven);
    }

    public void interactWith(Pyromancer player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_PYROMANCER_BACKSTAB);
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.FIREBLAST_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier() * getCritical());

        player.setRecievedDamage(damageGiven);
    }

    public void interactWith(Wizard player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_WIZARD_BACKSTAB);
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.FIREBLAST_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier() * getCritical());

        player.setRecievedDamage(damageGiven);
    }

    public void interactWith(Rogue player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_ROGUE_BACKSTAB);
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.FIREBLAST_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier() * getCritical());

        player.setRecievedDamage(damageGiven);
    }
}
