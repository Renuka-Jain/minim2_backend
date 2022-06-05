package edu.upc.dsa;

import edu.upc.dsa.models.Stats;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class StatsManagerImpl implements StatsManager {
    //logs
    final static Logger logger = Logger.getLogger(StatsManagerImpl.class);
    private List<Stats> StatsList;
    private static StatsManagerImpl instance;

    private StatsManagerImpl() {
        this.StatsList = new LinkedList<>();
    }
    //Singleton
    public static StatsManagerImpl getInstance() {
        //logger.info(instance);
        if (instance == null)
            instance = new StatsManagerImpl();
        //logger.info(instance);
        return instance;
    }

    @Override
    public List<Stats> getRanking() {
        List<Stats> orden = new LinkedList<>(this.StatsList);
        Collections.sort(orden, new Comparator<Stats>() {
            @Override
            public int compare(Stats o1, Stats o2) {
                return Integer.compare(o1.getScore(), o2.getScore());
            }
        });
        logger.info("Listado de partidas ordenadas por puntuacion ascendente: " + orden.toString());
        Collections.reverse(orden);
        return orden;
    }

    @Override
    public Stats addStat(Stats stat) {
        this.StatsList.add(stat);
        logger.info("partida añadida de: ");
        return stat;
    }

    @Override
    public int StatsListSize() {
        return this.StatsList.size();
    }
}
