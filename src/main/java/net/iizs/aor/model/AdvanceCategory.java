package net.iizs.aor.model;

/**
 * 각 진보에 대한 분류. 과학, 종교, 상업, 통신, 탐험, Civic이 있다.
 */
public enum AdvanceCategory {
    SCIENCE("Science"),
    RELIGION("Religion"),
    COMMERCE("Commerce"),
    COMMUNICATION("Communication"),
    EXPLORATION("Exploration"),
    CIVICS("Civics");

    final private String name;

    private AdvanceCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
