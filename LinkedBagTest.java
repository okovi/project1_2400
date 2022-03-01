/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Drake
 */
public class LinkedBagTest {
    public static void main(String[] args){
        BagInterface<Integer> Bag1 = new LinkedBag<>();
        BagInterface<Integer> Bag2 = new LinkedBag<>();
        int value;
        for (int i=0; i<20; i++) {
            if(i%2==1) {
                value = i+20;
            } else value = i;
            Bag1.add(value);
        }
        // Test get current size
        System.out.println("Testing getCurrentSize");
        System.out.println("Expected: 20, given: " + Bag1.getCurrentSize());
        // Test is empty
        System.out.println("Testing isEmpty");
        System.out.println("Expected: false, given: " + Bag1.isEmpty());
        // Test contains
        System.out.println("Testing contains");
        System.out.println("Expected: true, given: " + Bag1.contains(8));
        // Test remove
        System.out.println("Testing remove(an element)");
        System.out.println("Expected: true, given: " + Bag1.remove(8));
        // Test contains again
        System.out.println("Testing contains again");
        System.out.println("Expected: false, given: " + Bag1.contains(8));
        // Test get current size
        System.out.println("Testing getCurrentSize again");
        System.out.println("Expected: 19, given: " + Bag1.getCurrentSize());
        // Test remove on first element
        System.out.println("Testing remove(an element) on last element");
        System.out.println("Expected: true, given: " + Bag1.remove(0));
        // Test contains again
        System.out.println("Testing contains again");
        System.out.println("Expected: false, given: " + Bag1.contains(0));
        // Test get current size
        System.out.println("Testing getCurrentSize");
        System.out.println("Expected: 18, given: " + Bag1.getCurrentSize());
        // Test remove on first element
        System.out.println("Testing remove(an element) on first element");
        System.out.println("Expected: true, given: " + Bag1.remove(39));
        // Test contains again
        System.out.println("Testing contains again");
        System.out.println("Expected: false, given: " + Bag1.contains(39));
        // Test get current size
        System.out.println("Testing getCurrentSize");
        System.out.println("Expected: 17, given: " + Bag1.getCurrentSize());
        Bag1.add(4);
        // Test get frequency of again
        System.out.println("Testing getFrequencyOf");
        System.out.println("Expected: 2, given: " + Bag1.getFrequencyOf(4));
        // Test get current size
        System.out.println("Testing getCurrentSize");
        System.out.println("Expected: 18, given: " + Bag1.getCurrentSize());
        // Test to array
        System.out.println("Testing toArray");
        Object testArray[] = Bag1.toArray();
        for(int i=0; i<testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
        System.out.println();
        for (int i=0; i<10; i++) {
            if(i%2==0) {
                value = i+25;
            } else value = i;
            Bag2.add(value);
        }
        // Test union
        //BagInterface<Integer> Bag3 = Bag1.union(Bag2);
        // Test to array again
       // System.out.println("Testing union and toArray");
       // testArray = Bag3.toArray();
        //for(int i=0; i<testArray.length; i++) {
        //    System.out.print(testArray[i] + " ");
       // }
       // System.out.println();
        System.out.println("Bag 2 contents:");
        testArray = Bag2.toArray();
        for(int i=0; i<testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
        System.out.println();
        System.out.println("Testing difference and toArray");
        // Test intersection
        BagInterface<Integer> Bag3 = Bag1.difference(Bag2);
        // Test to array again
        testArray = Bag3.toArray();
        for(int i=0; i<testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
        System.out.println();
        System.out.println("Bag 2 contents unaffected:");
        testArray = Bag2.toArray();
        for(int i=0; i<testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
        System.out.println();
        System.out.println("Testing intersection");
        // Test intersection
        Bag3 = Bag1.intersection(Bag2);
        // Test to array again
        testArray = Bag3.toArray();
        for(int i=0; i<testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
        System.out.println();
        System.out.println("Bag 2 contents unaffected:");
        testArray = Bag2.toArray();
        for(int i=0; i<testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
    }
}
