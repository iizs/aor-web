package net.iizs.aor;

import net.iizs.aor.model.Advance;
import net.iizs.aor.model.AdvanceCategory;
import net.iizs.aor.model.Commodity;
import net.iizs.aor.model.HistoryCard;
import net.iizs.aor.support.GameComponentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameComponentTests {
    @Autowired
    private GameComponentFactory gameComponentFactory;

    @Test
    public void gameComponentFactoryTest() {

        Collection<Commodity> commodities = gameComponentFactory.getCommodities();
        assertEquals(12, commodities.size());
        assertEquals(true, commodities.contains(Commodity.CLOTH));

        Collection<Advance> advances = gameComponentFactory.getAdvances();
        assertEquals(26, advances.size() );

        int countScience = 0;
        for (Advance a : advances ) {
            if ( a.getCategory() == AdvanceCategory.SCIENCE ) { ++countScience; }
        }
        assertEquals( 4, countScience );

        for (int i=0; i<26; ++i ) {
            char k = (char)('A' + i);
            String key = Character.toString(k);
            Advance a = gameComponentFactory.getAdvance(key);
            assertEquals(key, a.getShortName());
        }

        Collection<HistoryCard> historyCards = gameComponentFactory.getHistoryCards();
        assertEquals( 64, historyCards.size() );

        int countShuffledLater = 0;
        int countReshuffled = 0;
        for ( HistoryCard h : historyCards ) {
            if ( h.isShuffledLater() ) { ++countShuffledLater; }
            if ( h.isReshuffled() ) { ++countReshuffled; }
        }
        assertEquals( 5, countShuffledLater );
        assertEquals( 40, countReshuffled );




    }
}
