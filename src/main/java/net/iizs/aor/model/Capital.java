package net.iizs.aor.model;

public class Capital extends Province {
    // 사용자가 이 형태의 생성자를 호출하는 것을 금지한다.
    private Capital(Area area, String fullName, String shortName, int marketSize) {
        super(area, fullName, shortName, marketSize, (Commodity) null);
    }

    public Capital(Area area, String fullName, String shortName, int marketSize, Commodity... commodities) {
        super(area, fullName, shortName, marketSize, commodities );
    }

    public Capital(Area area, String fullName, String shortName, int marketSize, Commodity commodity) {
        super(area, fullName, shortName, marketSize, commodity );
    }
}
