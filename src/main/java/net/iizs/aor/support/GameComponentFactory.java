package net.iizs.aor.support;

import net.iizs.aor.model.Advance;
import net.iizs.aor.model.Commodity;
import net.iizs.aor.model.HistoryCard;

import java.util.Set;

public interface GameComponentFactory {
    public Set<HistoryCard> getHistoryCards();

    public Set<Commodity> getCommodities();

    public Set<Advance> getAdvances();
}
