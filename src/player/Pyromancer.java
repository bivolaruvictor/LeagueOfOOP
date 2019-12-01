package player;

import abilities.*;
import constants.LandMultipliers;
import constants.PyromancerConstants;

import java.lang.reflect.Field;

public class Pyromancer extends Player {
    public Pyromancer() {
        super();
        setType(PlayerType.pyromancer);
        setHp(PyromancerConstants.PYROMANCER_STARTING_HP);
        setTerrainBonus(LandMultipliers.VOLCANIC_MULTIPLIER);
    }
    @Override
    public int getMaxHp() {
        return PyromancerConstants.PYROMANCER_STARTING_HP
                + PyromancerConstants.PYROMANCER_HP_PER_LEVEL * getLevel();
    }

    public void accept(Visitor ability) {
        ability.interactWith(this);
    }

    public void fightPlayer(Player player) {
        Fireblast fireblast = (Fireblast) getAbilityFactory().getAbilityType(AbilityType.fireblast, player);
        player.accept(fireblast);
        System.out.println(player.getType().toString() + " recieved from fireblast " + player.getRecievedDamage());
        player.recieveDamage();
        Ignite ignite = (Ignite) getAbilityFactory().getAbilityType(AbilityType.ignite, player);
        player.accept(ignite);
        System.out.println(player.getType().toString() + " recieved from ignite  " + player.getRecievedDamage());
        player.recieveDamage();
        this.setBruteDamage(player.getBruteDamage());
        super.fightPlayer(player);
    }
}
