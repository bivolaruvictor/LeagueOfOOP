package abilities;

import mechanics.GameMap;
import player.Player;
import player.Visitable;
import terrain.Terrain;

import java.util.ArrayList;

public abstract class Ability implements Visitor {
    private AbilityFactory abilityFactory;
    private int baseDamage;
    private int damage;
    private float landModifier;
    private float raceModifier;
    private AbilityType abilityType;
    private Integer casterLevel;
    private GameMap gameMap = GameMap.getInstance();


    public Ability(Player player) {
        landModifier = 1.0f;
        raceModifier = 1.0f;
    }

    public int getDamage() {
        return damage;
    }

    public float getLandModifier() {
        return landModifier;
    }

    public float getRaceModifier() {
        return raceModifier;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public AbilityType getAbilityType() {
        return abilityType;
    }

    public Integer getCasterLevel() {
        return casterLevel;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public AbilityFactory getAbilityFactory() {
        return abilityFactory;
    }

    public void setAbilityFactory(AbilityFactory abilityFactory) {
        this.abilityFactory = abilityFactory;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setLandModifier(float landModifier) {
        this.landModifier = landModifier;
    }

    public void setRaceModifier(float raceModifier) {
        this.raceModifier = raceModifier;
    }

    public void setAbilityType(AbilityType abilityType) {
        this.abilityType = abilityType;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setCasterLevel(Integer casterLevel) {
        this.casterLevel = casterLevel;
    }

    public void hurt(Player player) {
        player.setRecievedDamage(getDamage());
    }
}
