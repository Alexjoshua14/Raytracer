package com.alexjoshua14.raytracer.scene;

import com.alexjoshua14.raytracer.tracer.*;
import java.util.Optional;
import java.lang.Math;
import lombok.Value;

@Value
public class Sphere implements SceneObject {
    private Vector3 center;
    private float radius;
    private Material material;

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

    public Color getColor() {
        return this.material.getKAmbient();
    }

    public Vector3 surfaceNormal(Vector3 point) {
        return point.minus(center).normalized();
    }

    public Optional<Float> getT(Ray ray) {
        Vector3 centerPrime = ray.getOrigin().minus(center);

        double a = ray.getDirection().dot(ray.getDirection());
        double b = 2 * centerPrime.dot(ray.getDirection());
        double c = centerPrime.dot(centerPrime) - radius * radius;

        double disc = Math.pow(b, 2) - ( 4 * a * c);

        //If discriminant is negative then t can't be a real number and 
        //therefore the ray does not intersect this object
        if (disc < 0) { 
            return Optional.empty();
        }

        double sqrt = Math.sqrt(disc);

        float t1 = (float) ((- b + sqrt) / (2 * a));
        float t2 = (float) ((-b - sqrt) / (2 * a));
        
        //The lowest t value that is still positive denotes where the ray hits our object
        //Any negative values indicate a hit behind the beginning of the ray
        //  generally meaning a hit behind the camera
        float minT;

        minT = Math.min(t1, t2);

        return minT > 0 ?
            Optional.of(minT) :
            Optional.empty();
    }
}
