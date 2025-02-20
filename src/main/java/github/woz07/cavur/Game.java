package github.woz07.cavur;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

/**
 * Game.java
 * The main entry point of the program that renders everything, contains all the logic.
 */
public class Game {
    public static void main(String[] args) {
        // 8 height x 6 width
        final int width  = 640;
        final int height = 480;
        final int block  = 80 ;

        String level =  "--------~" +
                        "-------E~" +
                        "----RRRR~" +
                        "--------~" +
                        "--RRRR--~" +
                        "P-------~" ;

        //---START[LEVEL-TO-BLOCKS-ARRAY-ALGO]---
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

        //---END[LEVEL-TO-BLOCKS-ARRAY-ALGO]---

        InitWindow(width, height, "Cavur");

        while (!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(RAYWHITE);

            //---START[DRAWING-BLOCKS-ALGO]---
            // The algorithm to draw the contents of BLOCKS to the window

            // We loop through the height (8) and width (6) of BLOCK
            // First we loop through the y-axis as that's what will increment and help us go downwards the BLOCK array
            for (int y = 0; y < height / block; y++) {
                for (int x = 0; x < width / block; x++) {
                    // We check if the current x and y coordinates equal 'R', which is a platform
                    // If so, we multiply x and y by block, as block is the standard size of everything in the game and draw it to the screen
                    if (BLOCKS[x][y] == 'R') {
                        DrawRectangle(x * block, y * block, 80, 80, BLACK);
                        continue;
                    }
                    // If x and y is the exit we do the same thing as platform but just change the colour
                    if (BLOCKS[x][y] == 'E') {
                        DrawRectangle(x * block, y * block, 80, 80, GREEN);
                        continue;
                    }
                    // Same thing done to player (P) as exit (E)
                    if (BLOCKS[x][y] == 'P') {
                        DrawRectangle(x * block, y * block, 80, 80, RED);
                    }
                    // We don't need to draw anything if it's empty (-)
                }
            }

            //---END[DRAWING-BLOCKS-ALGO]---

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