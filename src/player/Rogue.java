package player;

import abilities.*;
import constants.KnightConstants;
import constants.LandMultipliers;
import constants.RogueConstants;

public class Rogue extends Player {
    private int numberOfBackstabs;
    public Rogue() {
        super();
        setType(PlayerType.rogue);
        setHp(RogueConstants.ROGUE_STARTING_HP);
        setTerrainBonus(LandMultipliers.WOODS_MULTIPLIER);
        setNumberOfBackstabs(0);
    }

    public int getNumberOfBackstabs() {
        return numberOfBackstabs;
    }

    public void setNumberOfBackstabs(int numberOfBackstabs) {
        this.numberOfBackstabs = numberOfBackstabs;
    }

    @Override
    public int getMaxHp() {
        return RogueConstants.ROGUE_STARTING_HP
                + RogueConstants.ROGUE_HP_PER_LEVEL * getLevel();
    }

    public void accept(Visitor ability) {
        ability.interactWith(this);
    }

    @Override
    public void fightPlayer(Player player) {
        Backstab backstab = (Backstab) getAbilityFactory().getAbilityType(AbilityType.backstab, player);
        player.accept(backstab);
        System.out.println(player.getType().toString() + " recieved from backstab " + player.getRecievedDamage());
        player.recieveDamage();
        Paralysis paralysis = (Paralysis) getAbilityFactory().getAbilityType(AbilityType.paralysis, player);
        player.accept(paralysis);
        System.out.println(player.getType().toString() + " recieved from paralysis " + player.getRecievedDamage());
        player.recieveDamage();
        this.setBruteDamage(player.getBruteDamage());
        super.fightPlayer(player);
    }
}
