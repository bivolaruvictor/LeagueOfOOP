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
            for (Player player: input.getPlayers()) {
                fs.writeWord(
                ("Player is " + player.typeToString() + " is located at ( "
                        + player.getxCoordinate() + ", "
                        + player.getyCoordinate() + " )"
                        + ", has HP " + player.getHp() + ", XP "
                        + player.getXp() + ", and his moves are " + player.getMoves().toString()));
                fs.writeNewLine();
            }
            for (int k = 0; k < input.getNumberOfRounds(); ++k) {
                for (Player player : input.getPlayers()) {
                    player.movePlayer();
                }
                for (int i = 0; i < input.getPlayers().size() - 1; ++i) {
                    for (int j = i + 1; j < input.getPlayers().size(); ++j) {
                        if (input.getPlayers().get(i).fight(input.getPlayers().get(j))) {
                            input.getPlayers().get(i).fightPlayer(input.getPlayers().get(j));
                            input.getPlayers().get(j).fightPlayer(input.getPlayers().get(i));
                            fs.writeNewLine();
                            for (Player player: input.getPlayers()) {
                                fs.writeWord(
                                        ("Player is " + player.typeToString() + " is located at ( "
                                                + player.getxCoordinate() + ", "
                                                + player.getyCoordinate() + " )"
                                                + ", has HP " + player.getHp() + ", XP "
                                                + player.getXp() + ", and his moves are " + player.getMoves().toString()));
                                fs.writeNewLine();
                            }
                        }
                    }
                }
            }
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
