package mechanics;
import player.Player;

import java.util.List;

public class Input {

    private List<Player> players;
    private GameMap gameMap;

    public Input() {
        players = null;
        gameMap = null;
    }

    public Input(List<Player> players, GameMap gameMap) {
        this.players = players;
        this.gameMap = gameMap;
    }

    /**/
    public List<Player> getPlayers() {
        return players;
    }

    /**/
    public GameMap getGameMap() {
        return gameMap;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = players != null && gameMap != null;
        boolean membersNotEmpty = players.size() > 0 && gameMap.getMap().size() > 0;
        return membersInstantiated && membersNotEmpty;
    }
}
