package abilities;

public class AbilityFactory {
    /**/
    public Ability getPlayerType(AbilityType abilityType) {
        if (abilityType == null) {
            return null;
        }
        if (abilityType.equals(AbilityType.ignite)) {
            return new Ignite();
        }
        if (abilityType.equals(AbilityType.fireblast)) {
            return new Fireblast();
        }
        if (abilityType.equals(AbilityType.execute)) {
            return new Execute();
        }
        if (abilityType.equals(AbilityType.slam)) {
            return new Slam();
        }
        if (abilityType.equals(AbilityType.drain)) {
            return new Drain();
        }
        if (abilityType.equals(AbilityType.deflect)) {
            return new Deflect();
        }
        if (abilityType.equals(AbilityType.backstab)) {
            return new Backstab();
        }
        if (abilityType.equals(AbilityType.paralysis)) {
            return new Paralysis();
        }
        return null;
    }
}
