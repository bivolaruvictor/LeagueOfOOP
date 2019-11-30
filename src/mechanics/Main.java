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
            fs.writeWord("BEGINNING : ");
            fs.writeNewLine();
            for (Player player: input.getPlayers()) {
                fs.writeWord(player.typeToString() + " " + player.getLevel()
                        + " " + player.getXp() + " " + player.getHp() + " "
                        + player.getxCoordinate() + " " + player.getyCoordinate());
                fs.writeNewLine();
            }
            fs.writeNewLine();
            fs.writeWord("-------------END BEGINNING--------------");
            for (int k = 0; k < input.getNumberOfRounds(); ++k) {
                for (Player player : input.getPlayers()) {
                    if (player.isAlive()) {
                        player.movePlayer();
                    }
                }
                for (int i = 0; i < input.getPlayers().size() - 1; ++i) {
                    fs.writeNewLine();
                    fs.writeWord("Round:  " + (input.getPlayers().get(i).getRound() - 1));
                    fs.writeNewLine();
                    input.getPlayers().get(i).recieveOvertimeDamage();
                    for (int j = i + 1; j < input.getPlayers().size(); ++j) {
                        input.getPlayers().get(j).recieveOvertimeDamage();
                        if (input.getPlayers().get(i).fight(input.getPlayers().get(j))
                                && input.getPlayers().get(i).isAlive()
                                && input.getPlayers().get(j).isAlive()) {
                            input.getPlayers().get(i).fightPlayer(input.getPlayers().get(j));
                            input.getPlayers().get(j).fightPlayer(input.getPlayers().get(i));
                            fs.writeNewLine();
                            for (Player player: input.getPlayers()) {
                                if (player.isAlive()) {
                                    fs.writeWord(player.typeToString() + " " + player.getLevel()
                                            + " " + player.getXp() + " " + player.getHp() + " "
                                            + player.getxCoordinate() + " " + player.getyCoordinate());
                                } else {
                                    fs.writeWord(player.typeToString() + " " + "dead");
                                }
                                fs.writeNewLine();
                            }
                            fs.writeNewLine();
                            fs.writeWord("-------------END ROUND    ------------");
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
