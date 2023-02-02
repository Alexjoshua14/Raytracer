package com.avikdas.raytracer.image;

import lombok.Value;

@Value
public class ImageColor {
    public static final int MAX = 0xff;

    int r;
    int g;
    int b;

    public ImageColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public float getR() {
        return this.r;
    }

    public float getG() {
        return this.g;
    }

    public float getB() {
        return this.b;
    }
}
