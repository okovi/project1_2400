/**
 * @author Francisco Serrano 
 */
public class LinkedBag<T> implements BagInterface<T> { 
    private final LinkedBag<T> baglinked; 
    private Node<T> firstNode; 
    private int numberofEntries=0;
    private boolean integrityOK=false; 

    LinkedBag() { 
        integrityOK=true;
        firstNode=null;
        baglinked=this;
    }
    class Node<T> { 
        private T  data; 
        private Node next;
        /** Creates a node with element and next Node to point to. Increments numofEntries, next pointer for firstNode will reference itself,then we move firstNode pointer to the Node we just created.
         * @param data The element that is being stored in the node
         * @param next The next Node that it will point to in the chain */
        Node(T data , Node next) {
            this.data=data;
            this.next=next; // new element points to head 
            numberofEntries++;
            firstNode=this; // firstNode is maintained/updated 
        }
        /** Used when you want to create nodes to compare against a node in our linkedbag or if you wanted to add to end of link, other instantiations are to add into a LinkedBag
         * @param data The element that is being stored in the node. */
        Node(T data) { 
            this.data=data;
            this.next=null;
        }
        Node() { //to instatiated the default constructor of linkedbag
            this.data=null; 
            this.next=null;  
        }
    }
    /** To ensure a more secure implementation*/
    public void checkIntegrity() { 
        if(!integrityOK)
            throw new SecurityException ("LinkedBag is corrupt") ; 
    }
    /** Number of nodes are in the LinkedBag. */
    public int getCurrentSize(){ 
        checkIntegrity();
        return numberofEntries;
    }
    /** Will check if the LinkedBag recieving the method call is empty. Returns true if empty, false otherwise.*/
    public boolean isEmpty(){
        checkIntegrity();  
        if(numberofEntries==0 || firstNode==null) // handles null case this way
            return true; 
        return false;
    }
    /** Checks that the head node had a data field equivalent to the argument that was passed. */
    public boolean add(T newEntry){
        checkIntegrity();
        Node(newEntry,firstNode); // constructor takes care of adding to first
        if (newEntry==firstNode.data)
            return true; 
        else 
            return false;
    } 
/**
 * Removes and returns the first element in the linkedbag. 
 * @return
 */
    public T remove(){ 
        checkIntegrity();
        if(isEmpty() || firstNode==null) // empty or bad call cases
            return null;
        T removed=firstNode.data; 
        if(numberofEntries==1) { // one element case
            firstNode=null;
            numberofEntries--;
            return removed;   
        } else {
            firstNode=firstNode.next; 
            numberofEntries--;
            return removed;
        }
    }
    /** Iterates through the LinkedBag, stops when element is found and removed or until whole
     *  bag was intererated through
     * @return True if element is found and removed, otherwise false. */
    public boolean remove(T anEntry) {
        checkIntegrity();
        Node<T> current=firstNode; // using two pointers to go through linked bag 
        Node<T> previous=null;
        boolean found= false; 
        if(isEmpty()|| anEntry==null) 
            return found;
        while(current!=null){ // handles last element removal : need to handle the case where it is only one element 
            if(current.data==anEntry){
                found=true;
                if(current.next==null && numberofEntries>1) {  // last element case
                    previous.next=null;
                    return found;
                }
                if(current.next==null && numberofEntries==1) { // only element case
                    current=previous;
                    return found;
                }
                previous.next=current.next;
                numberofEntries--; 
                return found;
            }
            previous=current; // maintain previous and current as you iterate
            current=current.next;      
        }
        return found; 
    }
    /** Moves head pointer to reference null, so the Bag will get garbage collected . */
    public void clear() {
        checkIntegrity(); 
        firstNode=null; // pointers move to null so all bag gets collected
        numberofEntries=0;
    }

    /** Iterates through the LinkedBag and records the anount of times an element was found inside of it. 
     * @param anEntry This is the target element we are looking for occurances of.
     * @return Returns the number of occurances of an element within a LinkedBag. */
    public int getFrequencyOf(T anEntry){
        checkIntegrity();
        Node<T> current=firstNode;
        int count=0;
        while (current!=null){ 
            if(current.data==anEntry)
                count++; 
        current=current.next;
        }
        return count;
    }
    /** Loops through the LinkedBag until the first instance of the entry is found or until the last element with a next pointer to null. */
    public boolean contains(T anEntry) { 
        checkIntegrity();
        Node<T> current=firstNode;
        while(current!=null) { 
            if(current.data==anEntry)
                return true;
            current=current.next;
        }
        return false;
    } 
    /** Loops through the LinkedBag and copies over the values into a fixed-size array. */
    public T[] toArray() {
        checkIntegrity();
        Node<T> current=firstNode;
        @SuppressWarnings ("unchecked")
        T[] LinkBagArray= (T[]) new Object[numberofEntries];
        for(int i=0;i<numberofEntries-1; i++) { 
            LinkBagArray[i]= current.data;
            current=current.next;
        }
        return LinkBagArray;

    }
    /** Will get an Array of each LinkedBag, then loop through each array to add every element into the new LinkedBag.
     * @param anotherBag The parameter for the LinkedBag that will get passed as an argument when other LinkedBag makes the method call. 
     * @return Returns a new LinkedBag with all elements in either the LinkedBag making the method call or the LinkedBag that gets passed as an argument. 
     */
    // think I can get around the for
    @Override
    public LinkedBag<T> union(LinkedBag<T> anotherBag) {
        checkIntegrity();
        anotherBag.checkIntegrity();
        LinkedBag<T> unionBag = new LinkedBag();
        T[] bag1= this.toArray();
        T[] bag2= anotherBag.toArray();
        for(T elementA: bag1) 
            unionBag.add(elementA); 
        for(T elementB: bag2) 
            unionBag.add(elementB);
        return unionBag;
    }
    /** 
     * 
     * @param anotherBag
     * @return
     */
    @Override
    public LinkedBag<T> intersection(LinkedBag<T> anotherBag) { 
        checkIntegrity();
        anotherBag.checkIntegrity();
        LinkedBag<T> duplicateBag = new LinkedBag(); // add duplicate to bag and test against so we can use getFrequency of freely
        LinkedBag<T> intersectionBag = new LinkedBag();
        if (this.isEmpty() || this==null) // explicit handle of empty and null cases 
            return intersectionBag;
        Node<T> current1=this.firstNode;
        // use larger bag as stopping condition for loop  
        int numOfElem=(this.numberofEntries<anotherBag.numberofEntries) ? (this.numberofEntries):(anotherBag.numberofEntries); 
        for (int i=0;i<numOfElem-1;i++) {
            if (!duplicateBag.contains(current1.data)) { 
                int freqA=anotherBag.getFrequencyOf(current1.data);// check if element is in other bag 
                int freqB=this.getFrequencyOf(current1.data); 
                int intersect = (freqA>freqB)? (freqB) : (freqA); // pick lower frequency 
                for (int j=0; j<intersect-1;j++) // add in a loop
                    intersectionBag.add(current1.data);
                duplicateBag.add(current1.data);
            }
            current1=current1.next;
        }
        return intersectionBag;
    }
    @Override
    public LinkedBag<T> difference(LinkedBag<T> anotherBag){
        checkIntegrity();
        LinkedBag<T> differenceBag = new LinkedBag();
        LinkedBag<T> duplicateBag = new LinkedBag();
        if (this.isEmpty() || this==null) // explicit handle of empty and null cases 
            return differenceBag;
        Node<T> current1=this.firstNode;
        for (int i=0; i<this.numberofEntries-1;i++) { // unique elem for calling bag, stopping condition is anchored by calling bag
            int freqA=anotherBag.getFrequencyOf(current1.data);
            int freqB=this.getFrequencyOf(current1.data);
            if (!duplicateBag.contains(current1.data)&& freqB>freqA) {
                int instances= freqB-freqA; 
                for(int j=0; j<instances-1;j++) 
                    differenceBag.add(current1.data);
                duplicateBag.add(current1.data); 
            }
            current1=current1.next; 
        }
        return differenceBag;
    
    
    
    }
    
    
    
    
    
    
    
    
    
    }
    
    
    