package github.woz07;

import java.util.Arrays;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Game {
    public static void main(String[] args) {
        //8 height x 6 width
        final int width  = 640;
        final int height = 480;
        final int block  = 80 ;

        String level =  "--------~" +
                        "-------E~" +
                        "----RRRR~" +
                        "--------~" +
                        "--RRRR--~" +
                        "P-------~" ;

        //---START[ALGO]---
        // Takes a string of levels and then splits it up and stores it in a char array
        // called 'BLOCKS' which will essentially render the blocks, each character gets
        // its own x and y position in BLOCKS

        // We split the entire string line by line based of '~'
        String[] lines = level.split("~");
        char[][] BLOCKS = new char[width / block][height / block];

        // The actual updating
        // We can set 'y' to the increment as we go along each line
        for (int y = 0; y < lines.length; y++) {
            // We store the line into an array for processing reasons
            char[] array = lines[y].toCharArray();
            // We loop through of the values within the array
            // As we go along the x-axis we just add to the BLOCKS array with previous y variable
            for (int x = 0; x < array.length; x++) {
                BLOCKS[x][y] = array[x];
            }
        }

        // DEBUG -- Printing out BLOCKS
//        for (int y = 0; y < height / block; y++) {
//            for (int x = 0; x < width / block; x++) {
//                System.out.print(BLOCKS[x][y]);
//            }
//            System.out.println();
//        }

        //---END[ALGO]---

        InitWindow(width, height, "Cavur");

        while (!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(RAYWHITE);
            EndDrawing();
        }

        CloseWindow();
    }
}

/*

[-][-][-][-][-][-][-][-]~
[-][-][-][-][-][-][-][E]~
[-][-][-][R][R][R][R][-]~
[-][-][-][-][-][-][-][-]~
[-][-][R][R][R][R][-][-]~
[P][-][-][-][-][-][-][-]~

*/