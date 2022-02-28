//Author @Jared
//COMMENTS ADDED AFTER COMPLETION OF CODE
//also realized I needed a way to check integrity for capacity oops
    import java.util.Arrays;
        public final class ResizeableArrayBag<T> implements BagInterface<T> {
            private int entries;
            private T[] bag;
            private static final int DEFAULT_CAPACITY = 1;
            private static final int MAX_CAPACITY = 500;
            private boolean integrityOk = false;

             public ResizeableArrayBag() {
                 this(DEFAULT_CAPACITY);
             }
             public ResizeableArrayBag(int entries){
                 /* I'll ask about this tomorrow, I want to make a 
                 empty bag with the capacity of the given entry
                 */
             }
             public boolean add(T newEntry){

             }
             public int getCurrentSize(){
                 return entries;
             }
             public T remove(){

             }
             public boolean remove(T anEntry){

             }
             public boolean isEmpty(){
                return entries == 0;
               
             }
             public void clear(){
                bag[i] = null;
                entries = 0;
             }
             public int getFrequencyOf(T anEntry){
                 
             }
             public T[] toArray(){
                 
             }
             public boolean contains(T anEntry){
                 checkIntegrity();
               for (int i = 0; this.entries > i; i++ ) {
                        if(entries == anEntry) {
                            return true;
                        }
                        return false;
               }
                
             }
             //Realized I could just paste the bottom, for sure im working on this saturday morning
             public BagInterface<T> union(BagInterface<T> anotherBag){}
             /** Will return a new Bag filled it with all of the elements that were found in both the calling Bag and the Bag passed as an argument. Finds all the elements that were found in both multisets.
              * @param anotherBag The Bag that will be used to make an intersecton with the Bag that called this method
              * @return Returns the intersection of the Bag that called the method and the Bag in the argument that was passed in the method call. 
              */
             public BagInterface<T> intersection(BagInterface<T> anotherBag){}
             /** Will return a new Bag filled it with all of the elements that were exclusive to the Bag that is making the method call
              * @param anotherBag The Bag used to pull all elements from the Bag making the method call that were contained in the argument Bag.
              * @return The new Bag after the difference was taken
              */
             public BagInterface<T> difference(BagInterface<T> anotherBag){}
             // generically this is saying any implementation of this interface will have an instance method that is going to take in as an argument of type BagInterface and then will return one of the same type
         
         }
         

        }