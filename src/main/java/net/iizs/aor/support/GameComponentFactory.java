package net.iizs.aor.support;

import net.iizs.aor.model.Advance;
import net.iizs.aor.model.Commodity;
import net.iizs.aor.model.HistoryCard;

import java.util.Collection;

public interface GameComponentFactory {
    public Collection<HistoryCard> getHistoryCards();

    public Collection<Commodity> getCommodities();

    public Collection<Advance> getAdvances();

    public Advance getAdvance(String key);
}
