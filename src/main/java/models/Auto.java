package models;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class Auto {

    int id;

    String modelName;

    long distance;

    int userId;

    public Auto(int id, long distance, String modelName, int userId) {
        this.id = id;
        this.distance = distance;
        this.modelName = modelName;
        this.userId = userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
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
