/**
 * @author Francisco Serrano, debugging/rewritten methods by Drake Fafard
 */
<<<<<<< HEAD
=======
package project1_2400;
>>>>>>> e7f62215eacdd703a0b9d827a359c0ae878b0239
public class LinkedBag<T> implements BagInterface<T> { 
	private Node<T> firstNode;
    private int numberofEntries=0;
    private boolean integrityOK=false; 
    LinkedBag() { 
        integrityOK=true;
        firstNode=null;
    }
    class Node<T> { 
        private T  data; 
        private Node next;
        /** Creates a node with element and next Node to point to. Increments numofEntries, next pointer for firstNode will reference itself,then we move firstNode pointer to the Node we just created.
         * @param data The element that is being stored in the node
         * @param next The next Node that it will point to in the chain */
        Node(T data, Node next) {
            this.data=data;
            this.next=next; // if you pass firstNode, this is the first part of the add
            numberofEntries++;
        }
        /** If you don't want to add to the LinkedBag, create node with only data member. Next it set to pull
         * @param data The element that is being stored in the node. */
        Node(T data) { 
            this.data=data;
            this.next=null;
        }
        /**Default Node Constructor */
        Node() {
            this.data=null; 
            this.next=null;  
        }
    }
    /** To ensure a more secure implementation*/
    public void checkIntegrity() { 
        if(!integrityOK)
            throw new SecurityException("LinkedBag is corrupt") ; 
    }
    /**To get how many elements are inside the LinkedBag
     * @return Returns the amount of elements in the LinkedBag*/
    public int getCurrentSize(){ 
        checkIntegrity();
        return numberofEntries;
    }
    /** Will check if the LinkedBag recieving the method call is empty.
     * @return Returns true if empty, false otherwise.*/
    public boolean isEmpty(){
        checkIntegrity();  
        if(numberofEntries==0 || firstNode==null) // handles null case this way
            return true; 
        return false;
    }
    /** Checks that the head node had a data field equivalent to the argument that was passed.
     * @return True when element is successfully added to LinkedBag, false otherwise*/
	@SuppressWarnings("unchecked")
    public boolean add(T newEntry){
        checkIntegrity();
        firstNode = new Node(newEntry,firstNode); // constructor takes care of adding to first 
        if (newEntry==firstNode.data)
            return true; 
        else 
            return false;
    } 

    /** Removes the firstNode in the LinkedBag. If there is only one element, then instead we will 
     * @return Returns null when LinkedBag is empty or when the firstNode pointer is null. Returns the data member of node removed otherwise
     */
	@SuppressWarnings("unchecked")
    public T remove(){ 
        checkIntegrity();
        if(isEmpty() || firstNode==null) // empty or bad call cases
            return null;
        T removed=firstNode.data; // catches single element in bag case 
        firstNode=null;
        numberofEntries--;
        return removed;   
    }
    @SuppressWarnings("unchecked")
    /** Iterates through the LinkedBag, stops when element is found and removed or until whole bag was intererated through
     * @return True if element is found and removed, otherwise false.*/
    public boolean remove(T anEntry) {
        checkIntegrity();
        Node<T> current=firstNode; // using two pointers to go through linked bag 
        Node<T> previous=null;
        boolean found= false; 
        if(isEmpty()|| anEntry==null) 
            return found;
        while(current!=null){ 
            if(current.data==anEntry){
                found=true;
                if(current.next==null && numberofEntries>1) {  // last element case
                    previous.next=null;
                } else if(current.next==null && numberofEntries==1) { // only element case
                    firstNode=null;
                } else { // current.next is not null and number of entries is above 1
                    if (current!=firstNode) { // Where current is not the first node
                        previous.next=current.next;
                    }
                    else {
                        firstNode=current.next; // When current is first, the next one will be first
                    }
                }
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

    /** Iterates through the LinkedBag and records the amount of times an element was found inside of it. 
     * @param anEntry This is the target element we are looking for occurances of.
     * @return Returns the number of occurances of an element within a LinkedBag. */
    @SuppressWarnings("unchecked")
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
	@SuppressWarnings("unchecked")
    /** Loops through the LinkedBag until the first instance of the entry is found or until the last element with a next pointer to null.
     * @return True when the entry was found within the LinkedBag, false otherwise*/
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
    @SuppressWarnings("unchecked")
    /** Loops through the LinkedBag and adds it to the Array
     * @return Returns an array filled with the elements inside of the LinkedBag that calls the method
     */
    public T[] toArray() {
        checkIntegrity();
        Node<T> current=firstNode;
        T[] LinkBagArray= (T[]) new Object[numberofEntries];
        for(int i=0;i<numberofEntries; i++) { 
            LinkBagArray[i]= current.data;
            current=current.next;
        }
        return LinkBagArray;
    }
    /** Will get an Array of each LinkedBag, then loop through each array to add every element into the new LinkedBag.
     * @param anotherBag The parameter for the LinkedBag that will get passed as an argument when other LinkedBag makes the method call. 
     * @return Returns a new LinkedBag with all elements in either the LinkedBag making the method call or the LinkedBag that gets passed as an argument.*/
    public BagInterface<T> union(BagInterface<T> anotherBag) {
        checkIntegrity();
        BagInterface<T> unionBag = new LinkedBag<>();
        T[] bag1= this.toArray();
        T[] bag2= anotherBag.toArray();
        for(T elementA: bag1) 
            unionBag.add(elementA); 
        for(T elementB: bag2) 
            unionBag.add(elementB);
        return unionBag;
    }
    @SuppressWarnings("unchecked")
    /** Creates a new LinkedBag out of calling bag and bag passed as a parameter, filling the new bag with all the elements that they share.  
     * @param anotherBag One of the two bags used to fill the thirdbag,  Intersection
     * @return Returns LinkedBag filled with elements common to both anotherBag and the LinkedBag that called the method*/
    public BagInterface<T> intersection(BagInterface<T> anotherBag) { 
        checkIntegrity();
        BagInterface<T> intersectionBag = new LinkedBag<>();
        BagInterface<T> duplicateBag = new LinkedBag<>();
        if (this.isEmpty() || this==null) // explicit handle of empty and null cases 
            return intersectionBag;
        Object bagArray2[] = anotherBag.toArray();
        T element;
        for(int i=0; i<anotherBag.getCurrentSize(); i++) { // dump bag passed as an argument into our duplicateBag to hold temporarily
            element = (T)bagArray2[i];
            duplicateBag.add(element);
        }
        Node<T> currentNodeB1=this.firstNode; // pointer to iterate through calling bag
        for(int i=0; i<numberofEntries; i++) {
            if (duplicateBag.contains(currentNodeB1.data)) { // when our current element in calling bag is found in our dump into duplicateBag, remove it and add it to the intersectionBag 
                duplicateBag.remove(currentNodeB1.data);
                intersectionBag.add(currentNodeB1.data);
            }
            currentNodeB1 = currentNodeB1.next; 
        }
        return intersectionBag;
    }
	@SuppressWarnings("unchecked")
    /** Create a new LinkedBag, fill it with all the items that are unique to the calling LinkedBag in relation to the LinkedBag that is passed as an argument.
     * @param anotherBag The LinkedBag that we will use to find relatively unique elements to LinkedBag that called the method
     * @return Returns in a new LinkedBag all the elements that were unique to the calling LinkedBag of the method*/
    public BagInterface<T> difference(BagInterface<T> anotherBag){ // need to keep the contents of the calling one, make sure
        checkIntegrity();
        BagInterface<T> differenceBag = new LinkedBag<>();
        BagInterface<T> duplicateBag = new LinkedBag<>();
        if (this.isEmpty() || this==null) // explicit handle of empty and null cases 
            return differenceBag;
        Object bagArray2[] = anotherBag.toArray();
        T element;
        for(int i=0; i<anotherBag.getCurrentSize(); i++) { // dump contents of bag passed as an argument into duplicate bag
            element = (T)bagArray2[i];
            duplicateBag.add(element);
        }
        Node<T> currentNodeB1=this.firstNode;
        for(int i=0; i<numberofEntries; i++) {
             //when common unique elements found(2 x's in Bag 1, 3 x's in Bag2, x is the unique element), duplicates are eliminated first
            if (duplicateBag.contains(currentNodeB1.data)) {
                duplicateBag.remove(currentNodeB1.data);
            } else differenceBag.add(currentNodeB1.data); // adds left over amount of duplicates of elements unique to calling bag, and any other elements that are not in the argument bag
            currentNodeB1 = currentNodeB1.next;
        }
        return differenceBag;
    }
    }