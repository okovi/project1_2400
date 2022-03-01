/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_2400;

/**
 *
 * @author Drake
 */
public class BagDriver {
    public static void main(String[] args){
        BagInterface<Integer> Bag1 = new LinkedBag<>();
        BagInterface<Integer> Bag2 = new LinkedBag<>();
        int value;
        String test1Return;
        String test2Return;
        for (int i=0; i<20; i++) { // Initialize bag1
            if(i%2==1) {
                value = i+20;
            } else value = i;
            Bag1.add(value);
        }
        for (int i=0; i<10; i++) { // Initialize bag2
            if(i%2==0) {
                value = i+25;
            } else value = i;
            Bag2.add(value);
        }
        LinkedBagTest<Integer> test1 = new LinkedBagTest<>(Bag1, Bag2);
        LinkedBagTest<Integer> test2 = new LinkedBagTest<>(Bag1, Bag2); ////////////// Will be replaced with array
        System.out.println("Bag1 contents:");
        System.out.println(test1.BagToString(1));
        System.out.println(test2.BagToString(1));
        System.out.println("Bag2 contents:");
        System.out.println(test1.BagToString(2));
        System.out.println(test2.BagToString(2));
        System.out.println("Testing union method:");
        test1Return = test1.UnionTest();
        System.out.println(test1Return);
        test2Return = test2.UnionTest();
        System.out.println(test2Return);
        if (test1Return.equals(test2Return)) System.out.println("Array and Linked methods produced same union results");
        else System.out.println("Array and Linked methods produced different results");
        System.out.println("Testing intersection method:");
        test1Return = test1.IntersectionTest();
        System.out.println(test1Return);
        test2Return = test2.IntersectionTest();
        System.out.println(test2Return);
        if (test1Return.equals(test2Return)) System.out.println("Array and Linked methods produced same intersection results");
        else System.out.println("Array and Linked methods produced different results");
        System.out.println("Testing difference method:");
        test1Return = test1.DifferenceTest();
        System.out.println(test1Return);
        test2Return = test2.DifferenceTest();
        System.out.println(test2Return);
        if (test1Return.equals(test2Return)) System.out.println("Array and Linked methods produced same difference results");
        else System.out.println("Array and Linked methods produced different results");
        
    }
}
