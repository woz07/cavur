package github.woz07.cavur.entities;

/**
 * Entity.java
 * The abstract class that stores data for all moveable objects in game
 */
public abstract class Entity {
    int width;  // The width of entity
    int height; // The height of entity
    int posx;   // The x position
    int posy;   // The y position
    int velx;     // The velocity x
    int vely;     // The velocity y
    int speed;  // The speed of entity
}