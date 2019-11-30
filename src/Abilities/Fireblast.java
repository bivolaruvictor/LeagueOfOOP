package abilities;

import constants.LandMultipliers;
import constants.PyromancerConstants;
import constants.RaceMultiplier;
import player.Player;
import player.Pyromancer;
import player.Knight;
import player.Wizard;
import player.Rogue;
import terrain.TerrainType;

public class Fireblast extends Ability {
    public Fireblast(Player player) {
        super(player);
        setAbilityType(AbilityType.fireblast);
        setBaseDamage(PyromancerConstants.FIREBLAST_STARTING_DAMAGE);
        if (getGameMap().getMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.volcanic)) {
            setLandModifier(LandMultipliers.VOLCANIC_MULTIPLIER);
        }
    }

    public void interactWith(Knight player) {
        setRaceModifier(RaceMultiplier.PYROMANCER_ON_KNIGHT_FIREBLAST);
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.FIREBLAST_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
    }

    public void interactWith(Pyromancer player) {
        setRaceModifier(RaceMultiplier.PYROMANCER_ON_PYROMANCER_FIREBLAST);
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.FIREBLAST_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
    }

    public void interactWith(Wizard player) {
        setRaceModifier(RaceMultiplier.PYROMANCER_ON_WIZARD_FIREBLAST);
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.FIREBLAST_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
    }

    public void interactWith(Rogue player) {
        setRaceModifier(RaceMultiplier.PYROMANCER_ON_ROGUE_FIREBLAST);
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.FIREBLAST_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
    }
}
