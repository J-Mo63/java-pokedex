package com.upass;

public class Pokemon {
    private int id;
    private String name;
    private String type;
    private boolean isFound;

    Pokemon(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.isFound = false;
    }

    public void find() {
        isFound = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean getIsFound() {
        return isFound;
    }
}
