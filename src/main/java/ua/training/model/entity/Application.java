package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private int id;
    private long cost;
    private long editionId;

    private List<Edition> editions = new ArrayList<>();


    public Application() {
    }

    public Application(int id, long cost, long editionId, List<Edition> editions) {
        this.id = id;
        this.cost = cost;
        this.editionId = editionId;
        this.editions = editions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Edition> getEditions() {
        return editions;
    }

    public void setEditions(List<Edition> editions) {
        this.editions = editions;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getEditionId() {
        return editionId;
    }

    public void setEditionId(long editionId) {
        this.editionId = editionId;
    }
}
