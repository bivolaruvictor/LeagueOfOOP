package abilities;

import constants.LandMultipliers;
import constants.PyromancerConstants;
import constants.RaceMultiplier;
import constants.RogueConstants;
import player.*;
import terrain.TerrainType;

public class Paralysis extends Ability {
    private int blockMovement;
    public Paralysis(Player player) {
        super(player);
        setBlockMovement(RogueConstants.PARALYSIS_EFFECT_ALL_TERRAIN);
        setAbilityType(AbilityType.paralysis);
        setBaseDamage(RogueConstants.PARALYSIS_STARTING_DAMAGE);
        if (getGameMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.woods)) {
            setLandModifier(LandMultipliers.WOODS_MULTIPLIER);
            setBlockMovement(RogueConstants.PARALYSIS_EFFECT_WOODS);
        }
    }

    public int getBlockMovement() {
        return blockMovement;
    }

    public void setBlockMovement(int blockMovement) {
        this.blockMovement = blockMovement;
    }

    public void interactWith(Knight player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_KNIGHT_PARALISYS);
        int damageGiven = Math.round((getBaseDamage()
                + RogueConstants.PARALYSIS_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
        player.setBlock(getBlockMovement());
    }

    public void interactWith(Pyromancer player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_PYROMANCER_PARALISYS);
        int damageGiven = Math.round((getBaseDamage()
                + RogueConstants.PARALYSIS_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
        player.setBlock(getBlockMovement());
    }

    public void interactWith(Wizard player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_WIZARD_PARALISYS);
        int damageGiven = Math.round((getBaseDamage()
                + RogueConstants.PARALYSIS_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
        player.setBlock(getBlockMovement());
    }

    public void interactWith(Rogue player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_ROGUE_PARALISYS);
        int damageGiven = Math.round((getBaseDamage()
                + RogueConstants.PARALYSIS_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
        player.setBlock(getBlockMovement());
    }
}
