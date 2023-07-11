package com.groupdocs.ui.viewer.demosapitests;

import java.util.Objects;

public class RotatePageResponse {
    private String data;
    private int angle;
    private double width;
    private double height;
    private int number;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RotatePageResponse that = (RotatePageResponse) o;
        return angle == that.angle && Double.compare(that.width, width) == 0 && Double.compare(that.height, height) == 0 && number == that.number && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, angle, width, height, number);
    }

    @Override
    public String toString() {
        return "PageDescriptionEntity{" +
                "data='" + data + '\'' +
                ", angle=" + angle +
                ", width=" + width +
                ", height=" + height +
                ", number=" + number +
                '}';
    }
}
