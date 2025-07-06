package model.search;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Search strategy list.
 */
public class SearchStrategyList {
    private List<ISearchStrategy> strategies;

    /**
     * Instantiates a new Search strategy list.
     */
    public SearchStrategyList() {
        strategies = new ArrayList<>();
    }

    /**
     * Gets strategies.
     *
     * @return the strategies
     */
    public List<ISearchStrategy> getStrategies() {
        return strategies;
    }

    /**
     * Sets strategies.
     *
     * @param strategies the strategies
     */
    public void setStrategies(List<ISearchStrategy> strategies) {
        this.strategies = strategies;
    }
}
