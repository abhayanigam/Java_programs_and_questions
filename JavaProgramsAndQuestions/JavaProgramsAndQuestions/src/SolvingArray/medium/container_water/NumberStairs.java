package SolvingArray.medium.container_water;

import java.util.ArrayList;

public class NumberStairs {
    public static void main(String[] args) {
        // Input 386 (must be exactly 3 digits)
        int input = 386;

        // Extract the individual digits from the input
        int upstairs = input / 100; // First digit
        int flatStairs = (input / 10) % 10; // Second digit
        int downstairs = input % 10; // Third digit

        // Create an ArrayList to store the parts of the stair pattern
        ArrayList<String> stairPattern = new ArrayList<>();

        // Add upstairs pattern (_|)
        for (int i = 0; i < upstairs; i++) {
            stairPattern.add("_|");
        }

        // Add flat stairs pattern (_)
        for (int i = 0; i < flatStairs; i++) {
            stairPattern.add("_");
        }

        // Add downstairs pattern (|_)
        for (int i = 0; i < downstairs; i++) {
            stairPattern.add("|_");
        }

        for (int i = 0; i <stairPattern.size(); i++) {
            System.out.println(stairPattern.get(i));
            for (int j = 1; j < i+1; j++) {
                System.out.print(" ");
            }
        }
    }
}
