package mechanics;

import java.io.IOException;
import fileio.FileSystem;
import player.Player;

public final class Main {
    private Main() {
        //to trick checkstyle
    }

    public static void main(final String[] args) {
        Loader loader = new Loader(args[0], args[1]);
        Input input = loader.load();
        try {
            FileSystem fs = new FileSystem(args[0], args[1]);
            fs.writeWord("AAAAA");
            for (Player player: input.getPlayers()) {
                fs.writeWord(
                ("Player is " + player.typeToString() + " is located at ( "
                        + player.getxCoordinate() + ", "
                        + player.getyCoordinate() + " )"
                        + ", has HP " + player.getHp() + ", XP "
                        + player.getXp() + ", and his moves are" + player.getMoves().toString()));
                fs.writeNewLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
