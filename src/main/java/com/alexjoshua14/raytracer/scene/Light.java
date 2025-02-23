package com.alexjoshua14.raytracer.scene;

import lombok.Value;

@Value
public class Light {
    private Vector3 position;
    private Color intensitySpecular;
    private Color intensityDiffuse;

    public Light(Vector3 position, Color intensitySpecular, Color intensityDiffuse) {
        this.position = position;
        this.intensitySpecular = intensitySpecular;
        this.intensityDiffuse = intensityDiffuse;
    }

    public Vector3 getPosition() {
        return this.position;
    }

    public Color getIntensitySpecular() {
        return this.intensitySpecular;   
    }

    public Color getIntensityDiffuse() {
        return this.intensityDiffuse;   
    }

    public Vector3 lightVector(Vector3 intersectionPoint) {
        return position.minus(intersectionPoint).normalized();
    }
}
