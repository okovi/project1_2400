//Author @Jared
//COMMENTS ADDED AFTER COMPLETION OF CODE
//also realized I needed a way to check integrity for capacity oops
    import java.util.Arrays;
        public final class ResizeableArrayBag<T> implements BagInterface<T> {
            private int entries;
            private T[] bag;
            private static final int DEFAULT_CAPACITY = 5;
            private static final int MAX_CAPACITY = 500;
            private boolean integrityOk = false;

         
             public ResizeableArrayBag() { 
                 this(DEFAULT_CAPACITY);

             }
             public ResizableArrayBag(int initialCapacity) {
               checkCapacity(initialCapacity);
               T[] tempBag = (T[])new Object[initialCapacity]; 
                bag = tempBag;
                entries = 0;
                integrityOk = true;

             } 
             private void checkCapacity(int capacity) {
                if (capacity > MAX_CAPACITY)
                   throw new IllegalStateException("Tried to make a bag that's bigger than"+"the maximum of "+MAX_CAPACITY);

             } 
             private void doubleCapacity()	{
                int doubledLength = (bag.length*2);
               
                checkCapacity(doubledLength);
                bag = Arrays.copyOf(bag, doubledLength);

	          } 
             public void checkIntegrity() { 
                if(!integrityOk)
                    throw new SecurityException ("ArrayBag Corrupt") ; 

             }
             public boolean add(T newEntry){
                checkIntegrity();
                if(!(entries>=bag.length)) {
                    doubleCapacity();
                }
                bag[entries] = newEntry;
                entries++;
                
             }
             public int getCurrentSize(){
                return entries;
             }
             public T remove(){
                if(!isEmpty()) {
                     return null;
                 }
             }
             private int getIndex(T anEntry) {
                int index = 0;
                int location = -1;
                boolean found = false;
               while (!found && (index < numberOfEntries)) {
                     if ((anEntry == bag[index])) {
                         location = index;
                         return index;
                         found = true;
                     } 
                         index++;
               }
             }
             public boolean remove(T anEntry){
                 checkIntegrity();
                    T product = null;
		            if (!isEmpty() && anEntry >= 0) {
                        bag[anEntry] = product;          
                        int newEntry = (entries-1);
                        bag[anEntry] = bag[newEntry];  
                            bag[newEntry] = null;            
                            entries--;
		            }           
                    return product;

             }
             public boolean isEmpty(){
                return entries == 0;
               
             }
             public void clear(){
                bag[i] = null;
                entries = 0;

             }
             public int getFrequencyOf(T anEntry){
                checkIntegrity();
                int counter = 0;
                for(int i = 0; entries > i; i++) {
                    if(bag[i].equals(anEntry)) {
                        counter++;
                    }
                }
                return counter;

             }
             public T[] toArray(){
                checkIntegrity();
                T[] result = (T[])new Object[entries]; 
                for (int index = 0; entries > index; index++) {
                    result[index] = bag[index];
                 } 
                return result;

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
     
             public BagInterface<T> union(BagInterface<T> anotherBag) {
                 checkIntegrity();
                BagInterface<T>secondBag = new ResizableArrayBag<T>();
                T[]newArray = anotherBag.toArray();
                BagInterface<T>tempBag = new ResizeableArrayBag(newArray);
              }
             
             public BagInterface<T> intersection(BagInterface<T> anotherBag) { 
                checkIntegrity();
             }
         
             public BagInterface<T> difference(BagInterface<T> anotherBag) {
                checkIntegrity();
             }
           
         
    }
