package net.iizs.aor.model;

/**
 * 위인카드가 진보 할인을 적용하는 방법. 항상 일정한 경우(CONSISTENT), 특정 이벤트 발생 중에 할인이 변경되는
 * 경우(CHANGING_ON_EVENT), 특정 이벤트가 발생 후 할인이 변경되는 경우(CHANGED_AFTER_EVENT)가 있다.
 */
public enum LeaderDiscountType {
    CONSISTENT,
    CHANGING_ON_EVENT,
    CHANGED_AFTER_EVENT;
}
