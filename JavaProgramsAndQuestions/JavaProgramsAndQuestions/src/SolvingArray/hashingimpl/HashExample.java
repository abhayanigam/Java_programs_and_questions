package SolvingArray.hashingimpl;

import java.util.HashMap;

public class HashExample {
    public static void main(String[] args) {
        HashMap<Integer, String> student = new HashMap<>();

        student.put(1, "Abhaya");
        student.put(2, "Nigam");
        student.put(3, "Mumma");

        System.out.println("Student with ID 1 : " + student.get(1));
        System.out.println("Student with ID 1 : " + student.get(3));

        student.remove(3);
        System.out.println("Student with ID 1 : " + student);
    }
}
