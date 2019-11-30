package abilities;

import mechanics.GameMap;
import player.Player;
import terrain.Terrain;

import java.util.ArrayList;

public class Ability {
    private int baseDamage;
    private int damage;
    private float landModifier;
    private float raceModifier;
    private AbilityType abilityType;
    private Integer casterLevel;
    private ArrayList<ArrayList<Terrain>> gameMap = GameMap.getInstance().getMap();

    public Ability(Player player) {
        setCasterLevel(player.getLevel());
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

    public ArrayList<ArrayList<Terrain>> getGameMap() {
        return gameMap;
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

    public void interactWith(Player player) {

    }

    public void hurt(Player player) {
        player.setRecievedDamage(getDamage());
    }
}
