package com.example.konnectorapp;

public class Data {
    private String description;

    private int imagePath;

    public Data(int imagePath, String description) {
        this.imagePath = imagePath;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getImagePath() {
        return imagePath;
    }
}
