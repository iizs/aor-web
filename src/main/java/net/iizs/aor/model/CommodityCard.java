package net.iizs.aor.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 자원카드. 여러 자원을 제공하는 경우에는, 하나를 선택해서 사용해야 한다
 */
public class CommodityCard extends HistoryCard {
    private CommodityCard(String fullName, String shortName, int epoch, boolean shuffledLater, Set<Commodity> commodities) {
        super(fullName, shortName, epoch, true, shuffledLater);
        this.commodities = commodities;
    }

    public CommodityCard(String fullName, String shortName, int epoch, boolean shuffledLater, Commodity... commodities) {
        this(fullName, shortName, epoch, shuffledLater, Collections.unmodifiableSet(new HashSet<Commodity>( Arrays.asList( commodities ))));
    }

    public CommodityCard(String fullName, String shortName, int epoch, boolean shuffledLater, Commodity commodity) {
        this(fullName, shortName, epoch, shuffledLater, Collections.singleton(commodity));
    }

    /**
     * 이 카드에서 제공하는 자원들
     */
    private Set<Commodity> commodities;

    public Set<Commodity> getCommodities() {
        return commodities;
    }
}
