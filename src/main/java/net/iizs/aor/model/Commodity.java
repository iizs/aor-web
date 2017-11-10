package net.iizs.aor.model;

/**
 * 자원 정보
 */
public class Commodity {
    public Commodity(String shortName, String fullName, int unitPrice, int diceRoll) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.unitPrice = unitPrice;
        this.diceRoll = diceRoll;
    }

    /**
     * 자원의 짧은 이름
     */
    private String shortName;

    /**
     * 자원의 전체 이름
     */
    private String fullName;

    /**
     * 자원의 단위 가격
     */
    private int unitPrice;

    /**
     * 자원과 관련된 주사위 값. 공급 부족/과잉 결정에 사용함
     */
    private int diceRoll;

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getDiceRoll() {
        return diceRoll;
    }

    public static final Commodity STONE = new Commodity("St", "Stone", 1, 2);
    public static final Commodity WOOL = new Commodity("Wo", "Wool", 2, 3);
    public static final Commodity TIMBER = new Commodity("Ti", "Timber",3, 4);
    public static final Commodity GRAIN = new Commodity("Gr", "Grain", 4, 5);
    public static final Commodity CLOTH = new Commodity("Cl", "Cloth", 5, 6);
    public static final Commodity WINE = new Commodity("Wi", "Wine", 5, 7);
    public static final Commodity METAL = new Commodity("Me", "Metal", 6, 8);
    public static final Commodity FUR = new Commodity("Fu", "Fur", 7, 9);
    public static final Commodity SILK = new Commodity("Si", "Silk", 8, 10);
    public static final Commodity SPICE = new Commodity("Sp","Spice", 9, 11);
    public static final Commodity GOLD = new Commodity("Go", "Gold", 10, 12);
    public static final Commodity IVORY = new Commodity("Iv", "Ivory", 10, 12);

}

