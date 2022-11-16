/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author gunes
 */
public class Test {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {

    // Make the two lists
    List<Integer> list1 = Arrays.asList(1, 2, 3, 8, 5, 12);
    List<Integer> list2 = Arrays.asList(2, 3, 1, 0, 5);
    // Prepare a union
    Set<Integer> union = new HashSet<Integer>(list1);
    union.addAll(list2);
    // Prepare an intersection
    Set<Integer> intersection = new HashSet<Integer>(list1);
    intersection.retainAll(list2);
    // Subtract the intersection from the union
    union.removeAll(intersection);
    // Print the result
    for (Integer n : union) {
        System.out.println(n);
    }
}
    
}
