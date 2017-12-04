package net.iizs.aor.model;

import net.iizs.aor.model.exception.NotAllowedByGameRuleException;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Province
 */
public class Province extends Land {
    // 사용자가 이 형태의 생성자를 호출하는 것을 금지한다.
    private Province(Area area, String fullName, String shortName, int marketSize) {
        this(area, fullName, shortName, marketSize, (Set<Commodity>) null);
    }

    private Province(Area area, String fullName, String shortName, int marketSize, Set<Commodity> commodities) {
        super(area, fullName, shortName, marketSize);
        this.commodities = commodities;
        this.supported = Collections.emptySet(); // 위성도시의 지원을 받지 않는 도시도 있다.
    }

    public Province(Area area, String fullName, String shortName, int marketSize, Commodity... commodities) {
        this(area, fullName, shortName, marketSize, Collections.unmodifiableSet(new HashSet<Commodity>( Arrays.asList( commodities ))));
    }

    public Province(Area area, String fullName, String shortName, int marketSize, Commodity commodity) {
        this(area, fullName, shortName, marketSize, Collections.singleton(commodity));
    }

    /**
     * 자원
     */
    private Set<Commodity> commodities;

    /**
     * 이 province 를 지원하는 province들. 위성도시가 아닌 경우에만 유효함
     */
    private Set<Land> supported;

    @Override
    public Set<Commodity> getCommodities() {
        return commodities;
    }

    // 이 도시를 지원하는 모든 위성도시를 반환한다.
    @Override
    public Set<Land> getSatellites() {
        return this.supported;
    }

    @Override
    public void support(Land land) throws NotAllowedByGameRuleException {
        throw new NotAllowedByGameRuleException("Only satellites can support other provinces.");
    }

    @Override
    protected void addSatellite(Land land) throws NotAllowedByGameRuleException {
        if ( ! ( land instanceof Satellite ) ) {
            throw new NotAllowedByGameRuleException("Only satellites can support other provinces.");
        }

        if ( this.supported.equals( Collections.emptySet() )) {
            this.supported = new HashSet<>();
        }
        this.supported.add( land );
    }


}
