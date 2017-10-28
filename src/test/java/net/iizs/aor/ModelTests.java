package net.iizs.aor;

import net.iizs.aor.model.Misery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelTests {
    @Test
    public void miseryTest() {
        assertEquals(Misery.MISERY_10, Misery.MISERY_0.next());
        assertEquals(Misery.MISERY_20, Misery.MISERY_10.next());
        assertEquals(Misery.MISERY_125, Misery.MISERY_100.next());
        assertEquals(Misery.MISERY_200, Misery.MISERY_175.next());
        assertEquals(Misery.MISERY_250, Misery.MISERY_200.next());
        assertEquals(Misery.MISERY_900, Misery.MISERY_800.next());
        assertEquals(Misery.MISERY_1000, Misery.MISERY_900.next());
        assertEquals(Misery.MISERY_CHAOS, Misery.MISERY_1000.next());
        // Chaos Out 이 후로 미저리를 증가시킬 수 없다.
        assertEquals(Misery.MISERY_CHAOS, Misery.MISERY_CHAOS.next());

        // 0 아래로 미저리를 감소시킬 수 없다.
        assertEquals(Misery.MISERY_0, Misery.MISERY_0.previous());
        assertEquals(Misery.MISERY_0, Misery.MISERY_10.previous());
        assertEquals(Misery.MISERY_90, Misery.MISERY_100.previous());
        assertEquals(Misery.MISERY_150, Misery.MISERY_175.previous());
        assertEquals(Misery.MISERY_175, Misery.MISERY_200.previous());
        assertEquals(Misery.MISERY_700, Misery.MISERY_800.previous());
        assertEquals(Misery.MISERY_800, Misery.MISERY_900.previous());
        assertEquals(Misery.MISERY_900, Misery.MISERY_1000.previous());
        // Chaos Out 된 플레이어는 되돌아올 수 없다
        assertEquals(Misery.MISERY_CHAOS, Misery.MISERY_CHAOS.previous());
    }
}

