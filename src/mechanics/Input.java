package mechanics;
import player.Player;
import terrain.Terrain;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private List<Player> players;
    private GameMap gameMap;
    private int numberOfRounds;

    public Input() {
        players = null;
        gameMap = null;
        numberOfRounds = -1;
    }

    public Input(List<Player> players, GameMap gameMap, int numberOfRounds) {
        this.players = players;
        this.gameMap = gameMap;
        this.numberOfRounds = numberOfRounds;
    }

    /**/
    public List<Player> getPlayers() {
        return players;
    }

    /**/
    public GameMap getGameMap() {
        return gameMap;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = players != null && gameMap != null;
        boolean membersNotEmpty = players.size() > 0 && gameMap.getMap().size() > 0;
        return membersInstantiated && membersNotEmpty;
    }
}
