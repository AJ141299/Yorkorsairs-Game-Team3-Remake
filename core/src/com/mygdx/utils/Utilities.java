package com.mygdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.utils.Constants.TILE_SIZE;

public final class Utilities {
    public static float vectorToAngle (Vector2 v) {
        return (float) Math.atan2(-v.x, v.y);
    }
    public static Vector2 angleToVector(Vector2 out, float angle) {
        out.x = -(float)Math.sin(angle);
        out.y = (float)Math.cos(angle);
        return out;
    }

    public static float tilesToDistance(float tiles){
        return TILE_SIZE * tiles;
    }

    public static Vector2 tilesToDistance(Vector2 tiles){
        return tiles.cpy().scl(TILE_SIZE);
    }

    public static int distanceToTiles(float dist){
        return (int) (dist / TILE_SIZE);
    }

    public static Vector2 distanceToTiles(Vector2 dist){
        return dist.cpy().scl(1.0f / TILE_SIZE);
    }

    /**
     * checks the proximity of point a to point b
     * @param a first point
     * @param b second point
     * @param radius min dist to be considered close
     * @return |dist(a, b)| < radius
     */
    public static boolean checkProximity(Vector2 a, Vector2 b, float radius) {
        final float d2 = radius * radius;
        final float d = Math.abs(a.dst2(b));
        return d < d2;
    }

    public static float angleBetween(Vector2 v, Vector2 w) {
        return MathUtils.atan2(w.y * v.x - w.x * v.y, w.x * v.x + w.y * v.y);
    }

    public static float scale(float x, float min0, float max0, float min1, float max1) {
        return (max1 - min1) * ((x - min0 * x) / (max0 * x - min0 * x)) + min1;
    }

    public static float scale(float x, Vector2 a, Vector2 b) {
        return (b.y - b.x) * ((x - a.x * x) / (a.y * x - a.x * x)) + b.x;
    }

    /**
     * @param x the vector to round
     * @return x modified for chaining
     */
    public static Vector2 round(Vector2 x) {
        x.x = Math.round(x.x);
        x.y = Math.round(x.y);
        return x;
    }
}
