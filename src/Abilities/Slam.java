package abilities;

import constants.KnightConstants;
import constants.LandMultipliers;
import constants.PyromancerConstants;
import constants.RaceMultiplier;
import player.*;
import terrain.TerrainType;

public class Slam extends Ability {
    public Slam(Player player) {
        super(player);
        setAbilityType(AbilityType.slam);
        setBaseDamage(KnightConstants.SLAM_STARTING_DAMAGE);
        if (getGameMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.land)) {
            setLandModifier(LandMultipliers.LAND_MULTIPLIER);
        }
    }

    public void interactWith(Knight player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_KNIGHT_SLAM);
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.SLAM_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
        player.setBlock(1);
    }

    public void interactWith(Pyromancer player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_PYROMANCER_SLAM);
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.SLAM_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
        player.setBlock(1);
    }

    public void interactWith(Wizard player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_WIZARD_SLAM);
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.SLAM_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
        player.setBlock(1);
    }

    public void interactWith(Rogue player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_ROGUE_SLAM);
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.SLAM_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
        player.setBlock(1);
    }
}
