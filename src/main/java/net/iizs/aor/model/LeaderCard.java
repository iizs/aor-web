package net.iizs.aor.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 위인카드
 */
public class LeaderCard extends HistoryCard {
    private LeaderCard(String fullName, String shortName, int epoch, boolean shuffledLater, int discount, EventCard event, int discountOnEvent, LeaderDiscountType discountType, Set<Advance> advances ) {
        super(fullName, shortName, epoch, false, shuffledLater);
        this.discount = discount;
        this.advances = advances;
        this.event = event;
        this.discountOnEvent = discountOnEvent;
        this.discountType = discountType;
    }

    public LeaderCard(String fullName, String shortName, int epoch, boolean shuffledLater, int discount, EventCard event, int discountOnEvent, LeaderDiscountType discountType, Advance... advances ) {
        this(fullName, shortName, epoch, shuffledLater, discount, event, discountOnEvent, discountType, Collections.unmodifiableSet(new HashSet<Advance>( Arrays.asList( advances ))));
    }

    public LeaderCard(String fullName, String shortName, int epoch, boolean shuffledLater, int discount, EventCard event, int discountOnEvent, LeaderDiscountType discountType, Advance advance ) {
        this(fullName, shortName, epoch, shuffledLater, discount, event, discountOnEvent, discountType, Collections.singleton( advance ));
    }

    public LeaderCard(String fullName, String shortName, int epoch, boolean shuffledLater, int discount, Advance... advances ) {
        this(fullName, shortName, epoch, shuffledLater, discount, null, discount, LeaderDiscountType.CONSISTENT, Collections.unmodifiableSet(new HashSet<Advance>( Arrays.asList( advances ))));
    }

    public LeaderCard(String fullName, String shortName, int epoch, boolean shuffledLater, int discount, Advance advance ) {
        this(fullName, shortName, epoch, shuffledLater, discount, null, discount, LeaderDiscountType.CONSISTENT, Collections.singleton( advance ));
    }

    /**
     * 이 위인이 할인해 주는 비용
     */
    private int discount;

    /**
     * 이 위인이 할인해 주는 진보들
     */
    private Set<Advance> advances;

    /**
     * 이 위인이 영향을 받는 이벤트
     */
    private EventCard event;

    /**
     * 해당 이벤트에 따라 적용하는 할인 비용
     */
    private int discountOnEvent;

    /**
     * 할인 적용 방법
     */
    private LeaderDiscountType discountType;

    public int getDiscount() {
        return discount;
    }

    public Set<Advance> getAdvances() {
        return advances;
    }

    public EventCard getEvent() {
        return event;
    }

    public int getDiscountOnEvent() {
        return discountOnEvent;
    }

    public LeaderDiscountType getDiscountType() {
        return discountType;
    }
}
