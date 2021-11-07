package com.practicestream.beans;

public class Color {

    private final Long id;
    private final String coloritem;
    private final Long colorprice;

    public Color(Long id, String coloritem, Long colorprice) {
        this.id = id;
        this.coloritem = coloritem;
        this.colorprice = colorprice;
    }

    public Long getId() {
        return id;
    }

    public String getColoritem() {
        return coloritem;
    }

    public Long getColorprice() {
        return colorprice;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", coloritem='" + coloritem + '\'' +
                ", colorprice=" + colorprice +
                '}';
    }
}
