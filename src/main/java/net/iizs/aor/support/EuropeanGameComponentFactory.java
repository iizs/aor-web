package net.iizs.aor.support;

import net.iizs.aor.model.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EuropeanGameComponentFactory implements GameComponentFactory {
    private Set<Commodity> commodities;
    private Set<Advance> advances;
    private Set<HistoryCard> historyCards;

    public EuropeanGameComponentFactory() {
        Commodity[] commoditiesArray = {
                Commodity.STONE,
                Commodity.WOOL,
                Commodity.TIMBER,
                Commodity.GRAIN,
                Commodity.CLOTH,
                Commodity.WINE,
                Commodity.METAL,
                Commodity.FUR,
                Commodity.SILK,
                Commodity.SPICE,
                Commodity.GOLD,
                Commodity.IVORY
        };
        this.commodities = Collections.unmodifiableSet(new HashSet<Commodity>(Arrays.asList(commoditiesArray)));

        // credits 는 https://boardgamegeek.com/filepage/11650/aoreurogamespdf 를 따름
        Advance A = new Advance("A", "The Heavens", AdvanceCategory.SCIENCE, 30, 20 );
        Advance B = new Advance("B", "Human Body", AdvanceCategory.SCIENCE, 60, 20 );
        Advance C = new Advance("C", "Laws of Matter", AdvanceCategory.SCIENCE, 90, 20 );
        Advance D = new Advance("D", "Enlightenment", AdvanceCategory.SCIENCE, 120, 20 );

        Advance E = new Advance("E", "Patronage", AdvanceCategory.RELIGION, 30, 10 );
        Advance F = new Advance("F", "Holy Indulgence", AdvanceCategory.RELIGION, 60, 20 );
        Advance G = new Advance("G", "Proselytism", AdvanceCategory.RELIGION, 90, 30 );
        Advance H = new Advance("H", "Cathedral", AdvanceCategory.RELIGION, 120, 20, F );

        // J, K 순서 확인 필요
        Advance I = new Advance("I", "Caravan", AdvanceCategory.COMMERCE, 20, 10 );
        Advance J = new Advance("J", "Improved Agriculture", AdvanceCategory.COMMERCE, 40, 10, I );
        Advance K = new Advance("K", "Wind / Watermill", AdvanceCategory.COMMERCE, 50, 10, J );
        Advance L = new Advance("L", "Interest & Profit", AdvanceCategory.COMMERCE, 80, 10, K );
        Advance M = new Advance("M", "Industry", AdvanceCategory.COMMERCE, 110, 0, L );

        Advance N = new Advance("N", "Written Record", AdvanceCategory.COMMUNICATION, 30, 30 );
        Advance O = new Advance("O", "Printed Word", AdvanceCategory.COMMUNICATION, 60, 20, N );
        Advance P = new Advance("P", "Master Art", AdvanceCategory.COMMUNICATION, 90, 10, O );
        Advance Q = new Advance("Q", "Renaissance", AdvanceCategory.COMMUNICATION, 120, 0, P );

        Advance R = new Advance("R", "Overland East", AdvanceCategory.EXPLORATION, 40, 20 );
        Advance S = new Advance("S", "Seaworthy Vessels", AdvanceCategory.EXPLORATION, 80, 20 );
        Advance T = new Advance("T", "Ocean Navigation", AdvanceCategory.EXPLORATION, 120, 20, A, S );

        Advance V = new Advance("V", "Urban Ascendancy", AdvanceCategory.CIVICS, 20, 20 );
        Advance W = new Advance("W", "Nationalism", AdvanceCategory.CIVICS, 60, 30 );
        Advance X = new Advance("X", "Institutional Research", AdvanceCategory.CIVICS, 100, 40 );
        Advance Y = new Advance("Y", "Cosmopolitan", AdvanceCategory.CIVICS, 150, 50, R );
        Advance Z = new Advance("Z", "Middle Class", AdvanceCategory.CIVICS, 170, 60, K );

        Advance U = new Advance("U", "New World", AdvanceCategory.EXPLORATION, 160, 0, V, T );

        Advance[] advancesArray = {
                A, B, C, D, E, F, G,
                H, I, J, K, L, M, N, O, P,
                Q, R, S, T, U,
                V, W, X, Y, Z
        };
        this.advances = Collections.unmodifiableSet(new HashSet<Advance>(Arrays.asList(advancesArray)));

        EventCard theCrusades = new EventCard("The Crusades", "E15_cru", 1, true, true, "Place one of your • markers anywhere within Area VI and remove any other markers in that Province. Gain one Misery. This card increases the credits for Walter the Penniless if he is also played this turn.Voided by Mongol Armies in Epoch 2 or 3 and becomes an unplayable Misery burden.");
        EventCard mongolArmies = new EventCard("Mongol Armies", "E21_mon", 2, false, false, "Collect $10 from the Bank. Marco Polo credits are doubled if played hereafter. The Crusades event becomes an unplayable Misery burden.");
        HistoryCard[] historyCardsArray = {
                new EventCard("Alchemist's Gold", "E11_A", 1, true, false, "A player of your choice must pay half of written cash to Banker. Penalty cannot exceed current cash. Cash already spent on Patronage defense is not vulnerable. Voided by Laws of Matter. If all players have Laws of Matter, this card becomes unplayable Misery burden."),
                new EventCard("Armor", "E12_arm", 1, false, false, "A temporary Arms advantage enhances your trading ventures. You win all Attack ties this turn (including War). Add 1 to your competition totals this turn on both offense and defense. Voided by Long Bow or Gunpowder. If voided, Armor becomes unplayable Misery burden."),
                new EventCard("Black Death", "E13_B", 2, true, false, "Select one Area to be hit by the plague. All \u007Fs in that area are returned to their respective Stocks. Then reduce all • markers of all players in that Area to a single \u007F per Province."),
                new EventCard("Civil War","E14_C",1, true, false, "A player of your choice is struck by Civil War. He gains one Misery. Any • in his Capital is reduced to a \u007F. He must lose his choice of half of his last recorded cash or half of his tokens. At start of the Expansion Phase, his Order of Play position becomes \"last\"."),
                theCrusades,
                new EventCard("Enlightened Ruler", "E16_rul", 1, true, false, "Play on yourself to void the effects of Mysticism, Religious Strife, Civil War, Revolutionary Uprisings, Rebellion, and Alchemist's Gold for the rest of the turn. This card will not void these effects if already inflicted."),
                new EventCard("Famine", "E17_fam", 1, true, false, "All players gain four spaces on the Misery Index minus one space for each Grain Province they dominate. Holding Improved Agriculture also reduces the penalty by one space."),
                new EventCard("Gunpowder", "E18_gun", 2, false, false, "A temporary Arms advantage enhances your trading ventures. You win all Attack ties this turn (including War). Add 1 to all your competition totals this turn on both offense and defense. Voids Armor and Stirrups and turns them into Misery burdens."),
                new EventCard("Long Bow", "E19_bow", 2, false, false, "A temporary Arms advantage enhances your trading ventures. You win all Attack ties this turn (including War). Add 1 to all your competition totals this turn on both offense and defense except against player currently using Gunpowder. Voids Armor and Stirrups and turns them into Misery burdens."),
                new EventCard("Mysticism Abounds", "E20_mys", 1, true, false, "All players gain four spaces on the Misery Index minus one space for each Science Advance held. This card becomes worthless Misery burden if all players own all four Sciences."),
                mongolArmies,
                new EventCard("Papal Decree", "E22_pap", 1, true, false, "You may ban the acquisition by all players of any Advance in one of the following three categories: Science, Religion, Exploration; Voided by Religious Strife played in same turn. When Religious Strife occurs in Epoch 3, this card becomes unplayable Misery burden."),
                new EventCard("Pirates / Vikings", "E23_vik", 1, true, false, "Reduce any • to a \u007F in any coastal Province of your choice. If played during Epoch II, reduce two •s. If played during Epoch III, reduce three •s." ),
                new EventCard("Rebellion", "E24_reb", 1, true, false, "Local conflict occurs in any Province of your choice except New World and foreign capitals. Any • in that Province is reduced to a \u007F."),
                new EventCard("Religious Strife", "E25_rel", 2, true, false, "All players increase Misery one space for each Religion Advance they hold. Voids Papal Decree if played in same turn. If played in Epoch 3, the Papal Decree card becomes an unplayable Misery burden."),
                new EventCard("Revolutionary Uprisings", "E26_rev", 1, true, false, "Each player gains one space on the Misery Index for each Commerce Advance he holds."),
                new EventCard("Stirrups", "E27_sti", 1, false, false, "A temporary Arms advantage enhances your trading ventures. You win all Attack ties this turn (including War). Add 1 to all your competition totals this turn on both offense and defense except against player currently using Armor. Voided by Long Bow or Gunpowder. If voided, Stirrups becomes unplayable Misery burden."),
                new EventCard("War!", "E28_war", 1, true, false, "Declare War on any player. Each player rolls one die. Nationalism and Military Advantages modify their owner's die roll by +1. Highest total gains one Misery, lowest total gains two Misery. The difference between the modified die rolls is the amount of supportable •s the loser must cede to the winner (loser's choice). If tied, both sides gain one Misery and continue resolution in each succeeding round of the Play Cards phase until one side wins."),
                new CommodityCard("Cloth / Wine", "C11_ClWi",1, false, Commodity.CLOTH, Commodity.WINE),
                new CommodityCard("Fur", "C12_Fu",1, false, Commodity.FUR),
                new CommodityCard("Gold / Ivory", "C13_GoIv", 1, false, Commodity.GOLD, Commodity.IVORY),
                new CommodityCard("Metal", "C14_Me", 1, false, Commodity.METAL),
                new CommodityCard("Silk", "C15_Si", 1, true, Commodity.SILK),
                new CommodityCard("Spice", "C16_Sp",1, true, Commodity.SPICE),
                new CommodityCard("Stone", "C17a_St", 1, false, Commodity.STONE),
                new CommodityCard("Stone", "C17b_St", 1, false, Commodity.STONE),
                new CommodityCard("Timber", "C18_Ti", 1, false, Commodity.TIMBER),
                new CommodityCard("Wool", "C19a_Wo", 1 , false, Commodity.WOOL),
                new CommodityCard("Wool", "C19b_Wo", 1 , false, Commodity.WOOL),
                new CommodityCard("Cloth", "C21_Cl", 2, false, Commodity.CLOTH),
                new CommodityCard("Grain", "C22a_Gr", 2, false, Commodity.GRAIN),
                new CommodityCard("Grain", "C22b_Gr", 2, false, Commodity.GRAIN),
                new CommodityCard("Metal", "C23_Me", 2, false, Commodity.METAL),
                new CommodityCard("Silk", "C24_Si", 2, false, Commodity.SILK),
                new CommodityCard("Spice", "C25_Sp",2, false, Commodity.SPICE),
                new CommodityCard("Timber", "C26a_Ti", 1, false, Commodity.TIMBER), // 이 카드의 epoch 는 의도적으로 1로 셋팅함
                new CommodityCard("Timber", "C26b_Ti", 2, false, Commodity.TIMBER),
                new CommodityCard("Wine", "C27_Wi", 2, false, Commodity.WINE),
                new CommodityCard("Cloth", "C31_Cl", 3, false, Commodity.CLOTH),
                new CommodityCard("Fur", "C32_Fu",3, false, Commodity.FUR),
                new CommodityCard("Gold", "C33_Go", 3, false, Commodity.GOLD),
                new CommodityCard("Metal", "C34_Me", 3, false, Commodity.METAL),
                new CommodityCard("Silk", "C35_Si", 3, false, Commodity.SILK),
                new CommodityCard("Spice", "C36_Sp",3, false, Commodity.SPICE),
                new CommodityCard("Wine", "C37_Wi", 3, false, Commodity.WINE),
                new LeaderCard("Charlemagne", "L11_W", 1, false, 20, W),
                new LeaderCard("Dionysus Exiguus", "L12_N", 1, false, 20, N),
                new LeaderCard("Rashid ad Din", "L13_NR", 1, true, 10, N, R),
                new LeaderCard("St. Benedict", "L14_EN", 1, false, 10, E, N),
                new LeaderCard("Walter the Penniless", "L15_R", 1, true, 20, theCrusades, 30, LeaderDiscountType.CHANGING_ON_EVENT, R),
                new LeaderCard("Christopher Columbus", "L21_TU", 2, false, 30, T, U),
                new LeaderCard("Desiderius Erasmus", "L22_OQ", 2, false, 20, O, Q),
                new LeaderCard("Ibn Majid", "L23_TY", 2, false, 20, T, Y),
                new LeaderCard("Johann Gutenberg", "L24_O", 2, false, 30, O),
                new LeaderCard("Marco Polo", "L25_RY", 2, false, 20, mongolArmies, 40, LeaderDiscountType.CHANGED_AFTER_EVENT, R, Y),
                new LeaderCard("William Caxton", "L26_O", 2, false, 20, O),
                new LeaderCard("Nicolaus Copernicus", "L27_AX", 2, false, 20, A, X),
                new LeaderCard("Prince Henry", "L28_TX", 2, false, 20, T, X),
                new LeaderCard("Andreas Vesalius", "L31_BD", 3, false, 20, B, D),
                new LeaderCard("Bartolome de Las Casas", "L32_Y", 3, false, 30, Y),
                new LeaderCard("Galileo Galilei", "L33_AQ", 3, false, 20, A, Q),
                new LeaderCard("Leonardo Da Vinci", "L34_BPQ", 3, false, 20, B, P, Q),
                new LeaderCard("Sir Isaac Newton", "L35_CD", 3, false, 20, C, D),
                new LeaderCard("Henry Oldenburg", "L36_D", 3, false, 30, D),
        };
        this.historyCards = Collections.unmodifiableSet(new HashSet<HistoryCard>(Arrays.asList(historyCardsArray)));

    }

    @Override
    public Set<HistoryCard> getHistoryCards() {
        return this.historyCards;
    }

    @Override
    public Set<Commodity> getCommodities() {
        return this.commodities;
    }

    @Override
    public Set<Advance> getAdvances() {
        return this.advances;
    }
}
