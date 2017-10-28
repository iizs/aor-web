package net.iizs.aor.model;

public enum Misery {
    MISERY_0(0), 
    MISERY_10(10), 
    MISERY_20(20), 
    MISERY_30(30), 
    MISERY_40(40),
    MISERY_50(50),
    MISERY_60(60),
    MISERY_70(70),
    MISERY_80(80),
    MISERY_90(90),
    MISERY_100(100),
    MISERY_125(125),
    MISERY_150(150),
    MISERY_175(175),
    MISERY_200(200),
    MISERY_250(250),
    MISERY_300(300),
    MISERY_350(350),
    MISERY_400(400),
    MISERY_450(450),
    MISERY_500(500),
    MISERY_600(600),
    MISERY_700(700),
    MISERY_800(800),
    MISERY_900(900),
    MISERY_1000(1000),
    MISERY_CHAOS(-1);

    final private int value;
    private static final Misery[] values = values();

    private Misery(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Misery next() {
        if ( this.equals( MISERY_CHAOS ) ) { return MISERY_CHAOS; }

        // MISERY_CHAOS 가 마지막 element 이므로 ArrayIndexOutOfBoundsException은 걱정하지 않아도 된다.
        return values[this.ordinal() + 1];
    }

    public Misery previous() {
        if ( this.equals( MISERY_0 ) ) { return MISERY_0; }
        if ( this.equals( MISERY_CHAOS ) ) { return MISERY_CHAOS; }

        // MISERY_0 가 첫번째 element 이므로 ArrayIndexOutOfBoundsException은 걱정하지 않아도 된다.
        return values[this.ordinal() - 1];
    }
}
