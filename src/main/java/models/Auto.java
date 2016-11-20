package models;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class Auto {

    int id;

    String modelName;

    long distance;

    public Auto(int id, long distance, String modelName) {
        this.id = id;
        this.distance = distance;
        this.modelName = modelName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
