package net.iizs.aor.model;

/**
 * 역사 카드에 대해서 정의한다. 역사 카드는 자원카드, 위인카드, 사건카드로 나뉜다.
 */
public abstract class HistoryCard {
    public HistoryCard(String fullName, String shortName, int epoch, boolean reshuffled, boolean shuffledLater) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.epoch = epoch;
        this.reshuffled = reshuffled;
        this.shuffledLater = shuffledLater;
    }

    /**
     * 역사 카드의 전체 이름
     */
    private String fullName;

    /**
     * 역사 카드의 짧은 이름
     */
    private String shortName;

    /**
     * 역사 카드가 최초로 등장하는 시대
     */
    private int epoch;

    /**
     * 시대가 변경될 때 재사용하는 카드이면 true, 버려지는 카드이면 false
     */
    private boolean reshuffled;

    /**
     * 게임 시작과 동시에 사용하는 카드이면 false, 나중에 섞는 카드이면 true.
     */
    private boolean shuffledLater;

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getEpoch() {
        return epoch;
    }

    public boolean isReshuffled() {
        return reshuffled;
    }

    public boolean isShuffledLater() {
        return shuffledLater;
    }

    @Override
    public String toString() {
        return "HistoryCard{\'" + fullName + '\'' + '@'+ epoch + '}';
    }
}
