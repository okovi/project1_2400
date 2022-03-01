/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_2400;


/**
 *
 * @author Drake
 * @param <T>
 */
public class ArrayBagTest<T> {
    private BagInterface<T> Bag1;
    private BagInterface<T> Bag2;
    private BagInterface<T> Bag3;
    ArrayBagTest(BagInterface<T> SentBag1, BagInterface<T> SentBag2) {
        Bag1 = SentBag1;
        Bag2 = SentBag2;
    }
    /* BagToString: This will convert a bag to a string for quick outputting.
     */
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
    /* UnionTest: This will test the union method of a bag, returns the union as a string
     */
    public String UnionTest() {
        System.out.println("    Testing union in array bag");
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
    /* IntersectionTest: This will test the intersection method of a bag, returns the intersection as a string
     */
    public String IntersectionTest() {
        System.out.println("    Testing intersection in array bag");
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
    /* DifferenceTest: This will test the difference method of a bag, returns the difference as a string
     */
    public String DifferenceTest() {
        System.out.println("    Testing difference in array bag");
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
}
