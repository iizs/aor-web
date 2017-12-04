package net.iizs.aor.model;

import net.iizs.aor.model.exception.NotAllowedByGameRuleException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 해안, 바다 지역에 대한 정의
 */
public abstract class Water {
    protected Water(Area area, String fullName, String shortName) {
        this.area = area;
        this.fullName = fullName;
        this.shortName = shortName;
        this.connected = new HashSet<>();
    }

    /**
     * 속한 area
     */
    private Area area;

    /**
     * 전체 이름
     */
    private String fullName;

    /**
     * 짧은 이름
     */
    private String shortName;

    /**
     * 해상으로 연결된 지역
     */
    private Set<Water> connected;

    public Area getArea() {
        return area;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public Set<Water> getConnected() {
        return Collections.unmodifiableSet(connected);
    }

    public Land getCoastOf() {
        return null;
    }

    public void connect(Water water) {
        this.connected.add( water );
        water.connected.add( this );
    }

    public boolean isConnectedTo(Water water) {
        return this.connected.contains(water);
    }

    public boolean isConnectedTo(Land land) {
        return land.isConnectedTo(this);
    }


}
