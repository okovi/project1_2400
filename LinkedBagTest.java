/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD
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
=======
package project1_2400;


/**
 *
 * @author Drake
 * @param <T>
 */
public class LinkedBagTest<T> {
    private BagInterface<T> Bag1;
    private BagInterface<T> Bag2;
    private BagInterface<T> Bag3;
    // Method to test union
    LinkedBagTest(BagInterface<T> SentBag1, BagInterface<T> SentBag2) {
        Bag1 = SentBag1;
        Bag2 = SentBag2;
    }
    public String BagToString(int bagPicked) {
        if (bagPicked==1) {
            String bag1AsString = "";
            Object testArray[] = Bag1.toArray();
            for(int i=0; i<testArray.length; i++) {
                bag1AsString+=testArray[i] + " ";
            }
            return bag1AsString;            
        } if (bagPicked==2) {
            String bag2AsString = "";
            Object testArray[] = Bag2.toArray();
            for(int i=0; i<testArray.length; i++) {
                bag2AsString+=testArray[i] + " ";
            }
            return bag2AsString;
        } else {
            return "";
        }
    }
    public String UnionTest() {
        System.out.println("    Testing union in linked bag");
        String unionAsString = "";
        String bag1AsString = "";
        String bag1AsStringAfterUnion = "";
        String bag2AsString = "";
        String bag2AsStringAfterUnion = "";
        Object testArray[] = Bag1.toArray();
        for(int i=0; i<testArray.length; i++) {
            bag1AsString+=testArray[i] + " ";
        }
        testArray = Bag2.toArray();
        for(int i=0; i<testArray.length; i++) {
            bag2AsString+=testArray[i] + " ";
        }
        // Test intersection
        Bag3 = Bag1.union(Bag2);
        testArray = Bag3.toArray();
        // Test to array again
        for(int i=0; i<testArray.length; i++) {
            unionAsString+=testArray[i] + " ";
        }
        testArray = Bag1.toArray();
        for(int i=0; i<testArray.length; i++) {
            bag1AsStringAfterUnion+=testArray[i] + " ";
        }
        testArray = Bag2.toArray();
        for(int i=0; i<testArray.length; i++) {
            bag2AsStringAfterUnion+=testArray[i] + " ";
        }
        if (bag1AsString.equals(bag1AsStringAfterUnion)) {
            System.out.println("Success: Bag 1 contents were unaffected by union.");
        } else System.out.println("Failure: Bag 1 contents were affected by union.");
        if (bag2AsString.equals(bag2AsStringAfterUnion)) {
            System.out.println("Success: Bag 2 contents were unaffected by union.");
        } else System.out.println("Failure: Bag 2 contents were affected by union.");
        return unionAsString;
    }
    public String IntersectionTest() {
        System.out.println("    Testing intersection in linked bag");
        String intersectionAsString = "";
        String bag1AsString = "";
        String bag1AsStringAfterIntersection = "";
        String bag2AsString = "";
        String bag2AsStringAfterIntersection = "";
        Object testArray[] = Bag1.toArray();
        for(int i=0; i<testArray.length; i++) {
            bag1AsString+=testArray[i] + " ";
        }
        testArray = Bag2.toArray();
        for(int i=0; i<testArray.length; i++) {
            bag2AsString+=testArray[i] + " ";
        }
        // Test intersection
        Bag3 = Bag1.intersection(Bag2);
        testArray = Bag3.toArray();
        // Test to array again
        for(int i=0; i<testArray.length; i++) {
            intersectionAsString+=testArray[i] + " ";
        }
        testArray = Bag1.toArray();
        for(int i=0; i<testArray.length; i++) {
            bag1AsStringAfterIntersection+=testArray[i] + " ";
        }
        testArray = Bag2.toArray();
        for(int i=0; i<testArray.length; i++) {
            bag2AsStringAfterIntersection+=testArray[i] + " ";
        }
        if (bag1AsString.equals(bag1AsStringAfterIntersection)) {
            System.out.println("Success: Bag 1 contents were unaffected by intersection.");
        } else System.out.println("Failure: Bag 1 contents were affected by intersection.");
        if (bag2AsString.equals(bag2AsStringAfterIntersection)) {
            System.out.println("Success: Bag 2 contents were unaffected by intersection.");
        } else System.out.println("Failure: Bag 2 contents were affected by intersection.");
        return intersectionAsString;
    }
    public String DifferenceTest() {
        System.out.println("    Testing difference in linked bag");
        String differenceAsString = "";
        String bag1AsString = "";
        String bag1AsStringAfterDifference = "";
        String bag2AsString = "";
        String bag2AsStringAfterDifference = "";
        Object testArray[] = Bag1.toArray();
        for(int i=0; i<testArray.length; i++) {
            bag1AsString+=testArray[i] + " ";
        }
        testArray = Bag2.toArray();
        for(int i=0; i<testArray.length; i++) {
            bag2AsString+=testArray[i] + " ";
        }
        // Test intersection
        Bag3 = Bag1.difference(Bag2);
        testArray = Bag3.toArray();
        // Test to array again
        for(int i=0; i<testArray.length; i++) {
            differenceAsString+=testArray[i] + " ";
        }
        testArray = Bag1.toArray();
        for(int i=0; i<testArray.length; i++) {
            bag1AsStringAfterDifference+=testArray[i] + " ";
        }
        testArray = Bag2.toArray();
        for(int i=0; i<testArray.length; i++) {
            bag2AsStringAfterDifference+=testArray[i] + " ";
        }
        if (bag1AsString.equals(bag1AsStringAfterDifference)) {
            System.out.println("Success: Bag 1 contents were unaffected by difference.");
        } else System.out.println("Failure: Bag 1 contents were affected by difference.");
        if (bag2AsString.equals(bag2AsStringAfterDifference)) {
            System.out.println("Success: Bag 2 contents were unaffected by difference.");
        } else System.out.println("Failure: Bag 2 contents were affected by difference.");
        return differenceAsString;
    }
>>>>>>> e7f62215eacdd703a0b9d827a359c0ae878b0239
}
