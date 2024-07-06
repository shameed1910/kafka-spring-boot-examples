package com.technotown.kafka.springbootkafka.model;

public class Location extends MessageMetaData {
    private int id;
    private String location;

   public Location(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Location(int id, String location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Location{" +
            "id=" + id +
            ", location='" + location + '\'' +
            '}';
    }
}
