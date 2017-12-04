package net.iizs.aor.model;

import net.iizs.aor.model.exception.NotAllowedByGameRuleException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Land {
    Land(Area area, String fullName, String shortName, int marketSize) {
        this.area = area;
        this.fullName = fullName;
        this.shortName = shortName;
        this.marketSize = marketSize;
        this.connected = new HashSet<>();
        // In-land 로 초기화한다.
        this.coast = null;
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
     * 마켓 사이즈
     */
    private int marketSize;

    /**
     * 육상으로 연결된 지역
     */
    private Set<Land> connected;

    /**
     * Coastal province인 경우, 연결된 해안을 표시
     */
    private Coast coast;

    public Area getArea() {
        return area;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getMarketSize() {
        return marketSize;
    }

    public void connect(Land land) throws NotAllowedByGameRuleException {
        if ( land.equals(this) ) {
            throw new NotAllowedByGameRuleException("Cannot connect same provinces.");
        }
        this.connected.add(land);
        land.connected.add(this);

        if ( this.isCoastal() && land.isCoastal() ) {
            this.getCoast().connect( land.getCoast() );
        }
    }

    public void connect(Sea sea) throws NotAllowedByGameRuleException {
        if ( ! this.isCoastal() ) {
            throw new NotAllowedByGameRuleException("Only coastal provice can be connected to sea.");
        }
        this.getCoast().connect( sea );
    }

    public Set<Land> getConnectedProvinces() {
        return Collections.unmodifiableSet(connected);
    }

    public boolean isConnectedTo(Land land) {
        return this.connected.contains(land);
    }

    public boolean isConnectedTo(Water water) {
        return ( this.isCoastal() && this.getCoast().isConnectedTo(water) );
    }

    public void makeCoastal() {
        this.coast = new Coast(this);
        // 이미 연결된 지역 중에 coastal provice 가 있다면, coast 끼리도 연결한다.
        for ( Land l : this.connected ) {
            if ( l.isCoastal() ) {
                this.coast.connect( l.getCoast() );
            }
        }
    }

    public boolean isCoastal() {
        return (coast != null);
    }

    public Coast getCoast() {
        return coast;
    }

    public abstract Set<Commodity> getCommodities();

    public abstract void support(Land land) throws NotAllowedByGameRuleException;

    // support()를 통해서만 불리도록 한다.
    protected abstract void addSatellite(Land land) throws NotAllowedByGameRuleException;

    // 이 도시를 지원하는 모든 위성도시를 반환한다.
    public abstract Set<Land> getSatellites();
}
