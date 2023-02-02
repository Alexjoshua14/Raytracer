package com.avikdas.raytracer.scene;

import lombok.Value;

@Value
public class Sphere implements SceneObject {
    Vector3 center;
    float radius;
    Material material;

    public Sphere(Vector3 center, float radius, Material material) {
        this.center = center;
        this.radius = radius;
        this.material = material;
    }

    public Vector3 getCenter() {
        return this.center;
    }

    public float getRadius() {
        return this.radius;
    }

    public Material getMaterial() {
        return this.material;
    }
}
