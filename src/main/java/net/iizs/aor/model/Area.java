package net.iizs.aor.model;

/**
 * 지도에서 사용하는 Provice및 Water의 묶음
 */
public enum Area {
    I("I"),
    II("II"),
    III("III"),
    IV("IV"),
    V("V"),
    VI("VI"),
    VII("VII"),
    VIII("VIII"),
    FAR_EAST("Far East"),
    NEW_WORLD("New World");
    //ND("Not Defined")

    final private String name;

    private Area(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
