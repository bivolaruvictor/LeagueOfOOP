package abilities;

import constants.KnightConstants;
import constants.LandMultipliers;
import constants.RaceMultiplier;
import player.*;
import terrain.TerrainType;

public class Execute extends Ability {
    public Execute(Player player) {
        super(player);
        setAbilityType(AbilityType.execute);
        setBaseDamage(KnightConstants.EXECUTE_STARTING_DAMAGE);
        setCasterLevel(player.getLevel());
        if (getGameMap().getMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.land)) {
            setLandModifier(LandMultipliers.LAND_MULTIPLIER);
        }
    }

    public int givenDamage(Player player) {
        return Math.round(KnightConstants.EXECUTE_HP_LIMIT_PERCENTAGE * (player.getMaxHp())
                + Math.min(KnightConstants.EXECUTE_HP_LIMIT_PERCENTAGE_RISE_PER_LEVEL
                * getCasterLevel(),  KnightConstants.EXECUTE_HP_MAXIMUM_PERCENTAGE));
    }

    public void interactWith(Knight player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_KNIGHT_EXECUTE);
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.EXECUTE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());
        if (givenDamage(player) >= player.getHp()) {
            player.setRecievedDamage(player.getHp());
        } else {
            player.setRecievedDamage(damageGiven);
        }
    }

    public void interactWith(Pyromancer player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_PYROMANCER_EXECUTE);
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.EXECUTE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());
    if (givenDamage(player)  >= player.getHp()) {
            player.setRecievedDamage(player.getHp());
        } else {
            player.setRecievedDamage(damageGiven);
        }
    }

    public void interactWith(Wizard player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_WIZARD_EXECUTE);
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.EXECUTE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());
        if (givenDamage(player)  >= player.getHp()) {
            player.setRecievedDamage(player.getHp());
        } else {
            player.setRecievedDamage(damageGiven);
        }
    }

    public void interactWith(Rogue player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_ROGUE_EXECUTE);
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.EXECUTE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());
        if (givenDamage(player)  >= player.getHp()) {
            player.setRecievedDamage(player.getHp());
        } else {
            player.setRecievedDamage(damageGiven);
        }
    }
}
