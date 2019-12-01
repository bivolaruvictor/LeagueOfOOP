package player;

import abilities.*;
import constants.KnightConstants;
import constants.LandMultipliers;

public class Knight extends Player {

    public Knight() {
        super();
        setType(PlayerType.knight);
        setHp(KnightConstants.KNIGHT_STARTING_HP);
        setTerrainBonus(LandMultipliers.LAND_MULTIPLIER);
    }

    @Override
    public int getMaxHp() {
        return KnightConstants.KNIGHT_STARTING_HP
                + KnightConstants.KNIGHT_HP_PER_LEVEL * getLevel();
    }

    public void accept(Visitor ability) {
        ability.interactWith(this);
    }

    @Override
    public void fightPlayer(Player player) {
        Execute execute = (Execute) getAbilityFactory().getAbilityType(AbilityType.execute, player);
        player.accept(execute);
        System.out.println(player.getType().toString() + " recieved from execute " + player.getRecievedDamage());
        player.recieveDamage();
        Slam slam = (Slam) getAbilityFactory().getAbilityType(AbilityType.slam, player);
        player.accept(slam);
        System.out.println(player.getType().toString() + " recieved from slam " + player.getRecievedDamage());
        player.recieveDamage();
        this.setBruteDamage(player.getBruteDamage());
        super.fightPlayer(player);
    }
}
