package net.iizs.aor.model;

import net.iizs.aor.model.exception.NotAllowedByGameRuleException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Satellite extends Land {
    public Satellite(Area area, String fullName, String shortName, int marketSize) {
        super(area, fullName, shortName, marketSize);

        this.supports = new HashSet<>();
    }

    /**
     * 이 province 가 지원하는 province들. 위성도시인 경우에만 유효함
     */
    private Set<Land> supports;

    @Override
    public Set<Commodity> getCommodities() {
        return Collections.emptySet();
    }

    @Override
    public void support(Land land) throws NotAllowedByGameRuleException {

        if ( land instanceof Satellite ) {
            throw new NotAllowedByGameRuleException("Satellites cannot be supported by other provinces.");
        }

        this.connect(land);

        this.supports.add(land);
        land.addSatellite(this);
    }

    @Override
    protected void addSatellite(Land land) throws NotAllowedByGameRuleException {
        throw new NotAllowedByGameRuleException("Satellites cannot be supported by other provinces.");
    }

    @Override
    public Set<Land> getSatellites() {
        return Collections.emptySet();
    }

}
