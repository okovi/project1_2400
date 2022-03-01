/**Author @Jared, with help from @Drake
COMMENTS ADDED AFTER COMPLETION OF CODE
also realized I needed a way to check integrity for capacity oops */
package project1_2400;
import java.util.Arrays;
        public final class ResizeableArrayBag<T> implements BagInterface<T> {
            private int entries;
            private T[] bag;
            private static final int DEFAULT_CAPACITY = 5;
            private static final int MAX_CAPACITY = 500;
            private boolean integrityOk = false;

<<<<<<< HEAD:ResizableArrayBag.java
            /** this is just the bag for default capacity */
             public ResizableArrayBag() { 
                 this(DEFAULT_CAPACITY);

             } //end default constructor
            /**this is a bag for an initial capacity*/
             public ResizableArrayBag(int initialCapacity) {
=======
/** this is just the bag for default capacity */
             public ResizeableArrayBag() { 
                 this(DEFAULT_CAPACITY);

             }
/**this is a bag for an initial capacity*/
             public ResizeableArrayBag(int initialCapacity) {
>>>>>>> 717c2cc8e5172a7539411005dcec8248663ac4f5:ResizeableArrayBag.java
               checkCapacity(initialCapacity);
               @SuppressWarnings("unchecked") //Eclipse said to do this, supresses warnings 
			T[] tempBag = (T[])new Object[initialCapacity]; 
                bag = tempBag;
                entries = 0;
                integrityOk = true;

             } //end constructor
            /**the method for checking capacity */
             private void checkCapacity(int capacity) {
                if (capacity > MAX_CAPACITY)
                   throw new IllegalStateException("Tried to make a bag that's bigger than the maximum of "+MAX_CAPACITY);

             } //end checkCapacity
            /** method for doubling capacity*/
             private void doubleCapacity() {
               int doubleLength = 2 * bag.length;
               checkCapacity(doubleLength);
               bag = Arrays.copyOf(bag, doubleLength);
         	} //end doubleCapacity
            /*checks integrity*/
             public void checkIntegrity() { 
                if(!integrityOk)
                    throw new SecurityException ("ArrayBag Corrupt") ; 

<<<<<<< HEAD:ResizableArrayBag.java
             }//end checkIntegrity
            /**@param contents
             * @return true 
             * method for grabbing the capacity and checking its contents*/
             public ResizableArrayBag(T[] contents) {
=======
             }
/** */
             public ResizeableArrayBag(T[] contents) {
>>>>>>> 717c2cc8e5172a7539411005dcec8248663ac4f5:ResizeableArrayBag.java
                checkCapacity(contents.length);
                bag = Arrays.copyOf(contents, contents.length);
                entries = contents.length;
                integrityOk = true;
             }//end ResizableArrayBag contents
            /**checks if array is full, returns result */
                private boolean isArrayFull() {
         	 return entries >= bag.length;
         	} //end return
            /** @return true
            * adds a new entry to this bag*/
             public boolean add(T newEntry){
         		checkIntegrity();
               if (isArrayFull()) {
                  doubleCapacity();
               } 
               bag[entries] = newEntry;
               entries++;
               return true;
         	} 
            /**gets current size */
             public int getCurrentSize(){
                return entries;
             }//returns size
            /**method to remove an entry */
             public T remove() {
                T test = removing(entries-1);
                return test;
             }
            /**@param anEntry
             * @return
             * checks if the index is found
             */
             private int getIndex(T anEntry) {
                int index = 0;
                int location = -1;
                boolean found = false;
               while (!found && (index < entries)) {
                     if ((anEntry == bag[index])) {
                         location = index;
                         found = true;
                     } 
                         index++;
               }
               return location;
             }//end getIndex
                /**@return
                 * checks for the indicated location and allows that array to be remove and returned
                 */
             //Was originally public boolean remove but I messed up and realized im supposed to be doing a private entry removal for remove
             private T removing(int Index)
         	{
         		T product = null;
         		if (!isEmpty() && (Index >= 0)) {
                  product = bag[Index];         
                  int nullindex = entries - 1;
                  bag[Index] = bag[nullindex]; 
                  bag[nullindex] = null;           
                  entries--;
         		}    
               return product;
         	} 
              /**@return return the removed
              * @param anEntry
             * removes an entry for the list */            
             public boolean remove(T anEntry) {

                 int index = getIndex(anEntry);

                 T result = removing(index);

                 return anEntry.equals(result);

           }//end remove
            /**checks if the bag is empty */             
             public boolean isEmpty(){
                return entries == 0;
               
             }//end isEmpty
             /** method to clear/remove all entries*/            
             public void clear(){
               if (!(entries == 0));
                entries = 0;
                remove();

             }//end clear
            /** @return
             * 
             */
             public int getFrequencyOf(T anEntry){
                checkIntegrity();
                int counter = 0;
                for(int i = 0; entries > i; i++) {
                    if(bag[i].equals(anEntry)) {
                        counter++;
                    }
                }
                return counter;

             }//end getFrequencyOf
            /**array with all entries in this bag
             * @return */
             public T[] toArray(){
                checkIntegrity();
                @SuppressWarnings("unchecked")//Eclipse said to do this not sure what it does yet
				T[] result = (T[])new Object[entries]; 
                for (int index = 0; entries > index; index++) {
                    result[index] = bag[index];
                 } 
                return result;

             }//end toArray
            /** method for checking if an index is contained*/
             public boolean contains(T anEntry){
                checkIntegrity();
                return getIndex(anEntry) >= 0;
             }//end contains
            /** method for joining two entries into one*/     
             public BagInterface<T> union(BagInterface<T> anotherBag) {
                 checkIntegrity();
                BagInterface<T>newBag = new ResizeableArrayBag<T>();
                T[]newArray1 = this.toArray();
                for (T contents : newArray1){  
                    newBag.add(contents);
                }
                T[]newArray2 = anotherBag.toArray();
                for (T contents:newArray2){  
                    newBag.add(contents);
                }
                return newBag;
              } //end union
            /** method for viewing overlapping entries   */        
             public BagInterface<T> intersection(BagInterface<T> anotherBag) { 
                checkIntegrity();
                BagInterface<T>newBag = new ResizeableArrayBag<T>();
                T[] temporaryArray = anotherBag.toArray();
                BagInterface<T>movingBag = new ResizeableArrayBag<T>(temporaryArray);
                T[]newArray = this.toArray();
                for(T contents:newArray){
                    if(movingBag.contains(contents)) {
                        movingBag.remove(contents);
                        newBag.add(contents);
                    }
                }
                return newBag;
             } //end intersection
            /** method for checking the difference of these bags   */
             public BagInterface<T> difference(BagInterface<T> anotherBag) {
                checkIntegrity();
                ResizeableArrayBag<T> newBag = new ResizeableArrayBag<T>();
                    for (int i = 0; entries > i; i++) {
                        T contents = bag[i];
                        if (!newBag.contains(contents)) {
                            int diff = getFrequencyOf(contents)- anotherBag.getFrequencyOf(contents);
                            for (int j = 0; j < diff; j++) {
                                  newBag.add(contents);
                            }
                        } 
                }
                    return newBag;
             } //end difference
           
    }

