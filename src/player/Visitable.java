package player;

import abilities.Visitor;

public interface Visitable {
    public void accept(Visitor v);
}
