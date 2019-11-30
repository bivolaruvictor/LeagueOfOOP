package abilities;

import player.*;

public interface Visitor {
    public void interactWith(Knight knight);
    public void interactWith(Pyromancer pyromancer);
    public void interactWith(Wizard wizard);
    public void interactWith(Rogue rogue);
}
