package net.iizs.aor;

import net.iizs.aor.model.*;
import net.iizs.aor.model.exception.NotAllowedByGameRuleException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

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

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void ProvinceTest() throws NotAllowedByGameRuleException {
        Capital A = new Capital(Area.I, "Seoul", "Seo", 4, Commodity.IVORY, Commodity.GOLD);
        Province B = new Province(Area.I, "Incheon", "Ico", 3, Commodity.WINE);
        Province C = new Province(Area.I, "Suwon", "Suw", 3, Commodity.CLOTH);
        Satellite a = new Satellite(Area.I, "Pangyo", "Pan", 1);
        Satellite b = new Satellite(Area.I, "Gwacheon", "Gwa", 1);

        A.connect(B);
        A.connect(C);
        a.support(A);
        a.support(C);
        b.support(A);
        b.support(B);

        assertEquals(true, A.isConnectedTo(B));
        assertEquals(true, A.isConnectedTo(C));
        assertEquals(false, B.isConnectedTo(C));
        assertEquals(true, a.isConnectedTo(A));
        assertEquals(false, a.isConnectedTo(B));
        assertEquals(true, a.isConnectedTo(C));

        assertEquals(2, A.getCommodities().size());
        assertEquals(4, A.getConnectedProvinces().size());
        assertEquals(2, A.getSatellites().size());

        assertEquals(1, B.getCommodities().size());

        // connect A and B again
        A.connect(B);
        assertEquals(4, A.getConnectedProvinces().size());

        // support a to A again
        a.support(A);
        assertEquals(2, A.getSatellites().size());

        // try to support a satellite
        try {
            a.support(b);
            fail("NotAllowedByGameRuleException expteced");
        } catch (NotAllowedByGameRuleException e) {
            // works as expected
        }

        // a capital tries to support other province or satellite
        try {
            A.support(b);
            fail("NotAllowedByGameRuleException expteced");
        } catch (NotAllowedByGameRuleException e) {
            // works as expected
        }

        // a province tries to support other province or satellite
        try {
            B.support(b);
            fail("NotAllowedByGameRuleException expteced");
        } catch (NotAllowedByGameRuleException e) {
            // works as expected
        }

        // Connect self
        try {
            A.connect(A);
            fail("NotAllowedByGameRuleException expteced");
        } catch (NotAllowedByGameRuleException e) {
            // works as expected
        }
    }

    @Test
    public void WaterTest() throws NotAllowedByGameRuleException {
        Capital A = new Capital(Area.I, "Seoul", "Seo", 4, Commodity.CLOTH);
        Province B = new Province(Area.I, "Incheon", "Ico", 3, Commodity.WINE);
        Province C = new Province(Area.I, "Songdo", "Son", 3, Commodity.GOLD);
        A.connect(B);
        C.connect(B);

        assertEquals(null, B.getCoast() );
        assertEquals( false, B.isCoastal() );

        B.makeCoastal();
        Coast CoastB = B.getCoast();

        assertEquals(0, CoastB.getConnected().size() );

        C.makeCoastal();
        Coast CoastC = C.getCoast();
        assertEquals( 1, CoastB.getConnected().size() );
        assertEquals( 1, CoastC.getConnected().size() );
        //assertEquals( true, CoastC.co);

        Province D = new Province(Area.I, "Oido", "Oid", 2);
        D.makeCoastal();
        Coast CoastD = D.getCoast();

        D.connect(C);
        assertEquals(2, CoastC.getConnected().size());

        Sea WestSea = new Sea(Area.I, "WestSea", "Wes" );
        B.connect(WestSea);
        CoastC.connect(WestSea);
        D.connect(WestSea);

        assertEquals(2, CoastB.getConnected().size() );
        assertEquals(3, CoastC.getConnected().size() );
        assertEquals(2, CoastD.getConnected().size() );

        // Connect in-land to a sea
        try {
            A.connect(WestSea);
            fail("NotAllowedByGameRuleException expteced");
        } catch (NotAllowedByGameRuleException e) {
            // works as expected
        }

        assertEquals(false, WestSea.isConnectedTo(A));
        assertEquals(true, WestSea.isConnectedTo(B));
        assertEquals(true, WestSea.isConnectedTo(C));
        assertEquals(true, WestSea.isConnectedTo(D));

        assertEquals(false, A.isConnectedTo(WestSea));
        assertEquals(false, A.isConnectedTo(CoastB));
        assertEquals(true, B.isConnectedTo(WestSea));
        assertEquals(true, C.isConnectedTo(WestSea));
        assertEquals(true, D.isConnectedTo(WestSea));

        // 자기 자신의 Coast와는 연결되지 않은 것으로 간주함 (같은 지역으로 간주해야 하므로)
        assertEquals( false, B.isConnectedTo(CoastB));
    }


}


