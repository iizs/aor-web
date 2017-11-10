package net.iizs.aor.model;

/**
 * 이벤트카드.
 */
public class EventCard extends HistoryCard {
    public EventCard(String fullName, String shortName, int epoch, boolean reshuffled, boolean shuffledLater, String description) {
        super(fullName, shortName, epoch, reshuffled, shuffledLater);
        this.description = description;
    }

    /**
     * 이벤트카드의 효과에 대한 설명
     */
    private String description;

    public String getDescription() {
        return description;
    }
}
