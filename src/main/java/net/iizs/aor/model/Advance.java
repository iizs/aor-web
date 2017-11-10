package net.iizs.aor.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 진보를 표현한다.
 */
public class Advance {
    private Advance(String shortName, String fullName, AdvanceCategory category, int points, int credits, Set<Advance> prerequisites) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.category = category;
        this.points = points;
        this.credits = credits;
        this.prerequisites = prerequisites;
    }

    public Advance(String shortName, String fullName, AdvanceCategory category, int points, int credits) {
        this(shortName, fullName, category, points, credits, Collections.emptySet());
    }

    public Advance(String shortName, String fullName, AdvanceCategory category, int points, int credits, Advance... prerequisites) {
        this(shortName, fullName, category, points, credits, Collections.unmodifiableSet(new HashSet<Advance>( Arrays.asList( prerequisites ))));
    }

    public Advance(String shortName, String fullName, AdvanceCategory category, int points, int credits, Advance prerequisite) {
        this(shortName, fullName, category, points, credits, Collections.singleton(prerequisite) );
    }

    /**
     * 이 진보를 표현하는 짧은 이름
     */
    private String shortName;

    /**
     * 이 진보의 전체 이름
     */
    private String fullName;

    /**
     * 이 진보가 속한 분류
     */
    private AdvanceCategory category;

    /**
     * 이 진보를 얻었을 때 획득하는 점수
     */
    private int points;

    /**
     * 이 진보를 얻기위해 필요한 비용
     */
    private int credits;

    /**
     * 이 진보를 얻기전에 획득해야 하는 진보
     */
    private Set<Advance> prerequisites;

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public AdvanceCategory getCategory() {
        return category;
    }

    public int getPoints() {
        return points;
    }

    public int getCredits() {
        return credits;
    }

    public Set<Advance> getPrerequisites() {
        return prerequisites;
    }
}
