//Author @Jared
//I am very tired today so I won't actually write my comments till sunday or so. Hopefully I just remember my line of thought when I come back to fix it up.
//Note: It's 3am now and I'm dead tired. It took me all day to remember how to even set this stuff up. I can probably fix this mess in the morning. Most of my setup today was git rather than actually writing this
    import java.util.Arrays;
        public final class ResizeableArrayBag<T> implements BagInterface<T> {
            private int entries;
            private T[] bag;
            private static final int DEFAULT_CAPACITY = 1;
            private static final int MAX_CAPACITY = 500;

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
                //don't remember if it's = or == ask in the morning
             }
             public void clear(){

             }
             public int getFrequencyOf(T anEntry){
                 
             }
             public T[] toArray(){
                 
             }
             public boolean contains(T anEntry){
                //if an anEntry is being used can't we just return that if it's >= 0
                return anEntry >= 0;
                
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