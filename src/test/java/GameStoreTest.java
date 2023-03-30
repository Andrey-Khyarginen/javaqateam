import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void addGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddGameIfZero() {

        GameStore store = new GameStore();
        Game game = new Game("Нетология Баттл Онлайн", "Аркады", store);

        assertFalse(store.containsGame(game));
    }

    @Test
    public void shouldAddGamesIfSeveral() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Dota2", "Moba");

        assertTrue(store.containsGame(game));
        assertTrue(store.containsGame(game2));
    }

    @Test
    public void shouldAddPlayerTimeFirstTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Player1", 1);
        int expected = 1;
        int actual = store.playedTime.get("Player1");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddPlayerTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Player1", 1);
        store.addPlayTime("Player1", 2);
        int expected = 3;
        int actual = store.playedTime.get("Player1");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayer1() {
        GameStore store = new GameStore();
        store.addPlayTime("Player1", 1);
        String expected = "Player1";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shoulLongestTimePlayer() {
        GameStore store = new GameStore();
        store.addPlayTime("Player1", 1);
        store.addPlayTime("Player2", 3);
        store.addPlayTime("Player3", 2);
        String expected = "Player2";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldWithoutPlayers() {
        GameStore store = new GameStore();
        String expected = null;
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Player1", 1);
        store.addPlayTime("Player2", 3);
        store.addPlayTime("Player3", 2);
        int expected = 6;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTimeIfFirstPlayer() {
        GameStore store = new GameStore();
        store.addPlayTime("Player1", 1);
        int expected = 1;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayTimeWithoutPlayers() {
        GameStore store = new GameStore();
        int expected = 0;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }
}