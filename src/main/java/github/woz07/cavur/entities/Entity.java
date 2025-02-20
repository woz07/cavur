package github.woz07.cavur.entities;

import com.raylib.Raylib;

/**
 * Entity.java
 * The abstract class that stores data for all moveable objects in game
 */
public abstract class Entity {
    public int width;           // The width of entity
    public int height;          // The height of entity
    public int posx;            // The x position
    public int posy;            // The y position
    public int velx;            // The velocity x
    public int vely;            // The velocity y
    public int speed;           // The speed of entity
    public Raylib.Color color;  // The color of entity

    public Entity() {}

    public Entity(int width, int height, int posx, int posy, int velx, int vely, int speed, Raylib.Color color) {
        this.width  = width;
        this.height = height;
        this.posx   = posx;
        this.posy   = posy;
        this.velx   = velx;
        this.vely   = vely;
        this.speed  = speed;
        this.color  = color;
    }
}