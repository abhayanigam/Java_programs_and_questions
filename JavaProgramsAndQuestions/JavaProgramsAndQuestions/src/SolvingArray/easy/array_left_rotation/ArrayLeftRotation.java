package SolvingArray.easy.array_left_rotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayLeftRotation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        System.out.println("Enter the size of an array : ");
//        int size = input.nextInt();
//
//        System.out.println("Enter the index number for left rotation : ");
//        int index = input.nextInt();
//

//        LeftRotateUsingArray(input,size,index);
        LeftRoatateUsingArrayList(input,5,2);

        input.close();
    }

    private static void LeftRoatateUsingArrayList(Scanner input, int size, int index) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//
//        for (int i = 0; i < size; i++) {
//            System.out.println("Enter the element i " + (i+1) + " : ");
//            int e = input.nextInt();
//            arrayList.add(e);
//        }

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        LeftRotationUsingArrayList(arrayList,index);
    }

    private static void LeftRotationUsingArrayList(ArrayList<Integer> arrayList, int index) {
        int mod = index % arrayList.size();

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(" " + arrayList.get((mod+i)%arrayList.size()));
        }
    }

    private static void LeftRotateUsingArray(Scanner input, int size, int index) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter the element No. i " + (i+1) + " :");
            arr[i] = input.nextInt();
        }

        LeftRotation(arr,index);


    }

    private static void LeftRotation(int[] arr, int index) {
        int mod = index%arr.length;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[(mod + i) % arr.length]);
        }
    }
}
