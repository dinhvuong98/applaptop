package com.example.applaptop.Model;

import java.io.Serializable;

public class LapTop implements Serializable {
    private int  id;
    private String name;
    private String cpu;
    private String ram;
    private String disk;
    private Double price;
    private int  preview;
    private String screen;
    private String type;

    public LapTop() {
    }

    public LapTop(int id, String name, String cpu, String ram, String disk, Double price, int preview, String screen, String type) {
        this.id = id;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.disk = disk;
        this.price = price;
        this.preview = preview;
        this.screen = screen;
        this.type = type;
    }

    public String getScreen() {
    return screen;
}

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getPreview() {
        return preview;
    }

    public void setPreview(int preview) {
        this.preview = preview;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
