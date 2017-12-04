package net.iizs.aor.model;

public class Coast extends Water {
    /**
     * 해안인 경우, 어느 Province 의 해안인지 표시
     */
    private Land coastOf;

    Coast(Land land) {
        super(land.getArea(), land.getFullName(), land.getShortName());
        this.coastOf = land;
    }

    public Land getCoastOf() {
        return this.coastOf;
    }
}
