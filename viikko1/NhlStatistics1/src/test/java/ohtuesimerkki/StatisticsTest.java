package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lauri
 */
public class StatisticsTest {
    
    public StatisticsTest() {
    }
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    } 

    @Test
    public void pelaajaLoytyy() {
        Player player = stats.search("Kurri");
        assertEquals(90, player.getPoints());
    }

    @Test
    public void pelaajaEiLoydy() {
        Player player = stats.search("Haapakoski");
        assertEquals(null, player);
    }

    @Test
    public void joukkue() {
        List<Player> teams = stats.team("EDM");
        assertEquals(3, teams.size());
    }

    @Test
    public void tahtipeelajat() {
        List<Player> players = stats.topScorers(2);
        assertEquals(2, players.size());
    }
    
}
