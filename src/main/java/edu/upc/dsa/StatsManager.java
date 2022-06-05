package edu.upc.dsa;

import edu.upc.dsa.models.Stats;

import java.util.List;

public interface StatsManager {
    public List<Stats> getRanking();
    public Stats addStat(Stats stat);
    public int StatsListSize();
}
