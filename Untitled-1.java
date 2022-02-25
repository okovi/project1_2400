public class LinkedBag<T> implements BagInterface<T> { 
    private Node<T> firstNode, tail; // addition of tail node
    private int numberofEntries=0;
    LinkedBag() { 
        Node();
    }
    
    class Node<T> { 
        private T  data; 
        private Node next;
        /** Creates a node with element and next Node to point to. Increments numofEntries, next pointer for firstNode will reference itself,then we move firstNode pointer to the Node we just created.
         * @param data The element that is being stored in the node
         * @param next The next Node that it will point to in the chain */
        Node(T data , Node next) {
            this.data=data;
            this.next=next; 
            numberofEntries++;
            firstNode.next=firstNode; // make head's next point to itself
            firstNode=this; // the swap
        }
        /** To be used only to start the chain forming in LinkedBags. Sets next pointer to null, brings the firstNode pointer to the instance just created.
         * @param data The element that is being stored in the node. */
        Node(T data) { 
            this.data=data;
            this.next=null;
            firstNode=this;
           
        }
        Node() { 
            this.data=null; 
            this.next=null; 
            firstNode=this; 
        }
    }
    
    /** Number of nodes are in the LinkedBag. */
    public int getCurrentSize(){ 
        return numberofEntries;
    }
    
    /** Will check if the LinkedBag recieving the method call is empty. Returns true if empty, false otherwise.*/
    public boolean isEmpty(){  
        if(numberofEntries==0)
            return true; 
        return false;
    }
    
    /** Checks that the head node had a data field equivalent to the argument that was passed. 
     * Returns false when the firstNode's data does not equal what was passed as an argument, returns true otherwise. */
    public boolean add(T newEntry){ 
        Node(newEntry,firstNode); // next pointer will be current first node
        if (newEntry==firstNode.data)
            return true; 
        else 
            return false;
    }
    
    /** Removes the first element in the LinkedBag and returns it.
     * Store the first element, then move the firstNode pointer foward so that the old head node gets garbage collected.*/
    public T remove(){ 
    // need to handle the case where there is only one element or when the bag called is empty 
        
        T removed=firstNode.data; 
        firstNode=firstNode.next; // taking pointer and moving it to the second element 
        numberofEntries--;
        return removed;
        // there might be a better way to write this to save space but I want to do this on my own before I have to look at the slides any more
    }
    
    /** Iterates through the LinkedBag until we have looped through each element once or until we have found the first instance of the element in the LinkedBag. 
     * @return True if element is found and removed, otherwise false. */
    // i have to account for my tail node here, if i remove at the end then the tail node has to be moved to previous
    public boolean remove(T anEntry) {
        Node<T> current=firstNode, previous=null;
        if(isEmpty()|| anEntry==null) 
            return false;
        while(current.next!=null){ 
            if(current.data==anEntry){
                if(current.next=null) 
                    tail =previous; // if the last node is remvoed, then the previous pointer till share a reference to new last node as tail
                previous.next=current.next;
                numberofEntries--; 
                return true;
            } //  takes the next pointer fo the previous node then moves it to the one after the node we are trying to remove
            previous=current;
            current=current.next;     
        }
        return false;
    }
    
    /** Moves head pointer to reference null, so the Bag will get garbage collected . */
    public void clear() { 
        firstNode=tail=null; // pointers move to null so all bag gets collected
    }
    /** Iterates through the LinkedBag and records the anount of times an element was found inside of it. 
     * @param anEntry This is the target element we are looking for occurances of.
     * @return Returns the number of occurances of an element within a LinkedBag. */
    public int getFrequencyOf(T anEntry){
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
        Node<T> current=firstNode;
        // finding the entry or hitting null stopping it, but if you do a or statement then when you finish you cant be sure if it was bc null or not 
        while(current.next!=null) { // i think this misses the last element and being able to check it 
            // if we would have done firstNode.next then it would have stopped executting a node before the last one because the last one's next will be to null 
            if(current.data==anEntry)
                return true;
            current=current.next;
        }
        return false;
    }
    /** Loops through the LinkedBag and copies over the values into a fixed-size array. */
    public T[] toArray() {
        T[] LinkBagArray= new T[numberofEntries];
        for(int i=0;i<numberofEntries; i++) { 
            LinkBagArray[i]= firstNode.data;
            firstNode=firstNode.next;
        }
    }
    /** Will get an Array of each LinkedBag, then loop through each array to add every element into the new LinkedBag.
     * @param anotherBag The parameter for the LinkedBag that will get passed as an argument when other LinkedBag makes the method call. 
     * @return Returns a new LinkedBag with all elements in either the LinkedBag making the method call or the LinkedBag that gets passed as an argument. 
     */
    // think I can get around the for
    public LinkedBag<T> union(LinkedBag<T> anotherBag) { 
        LinkedBag<T> unionBag = new LinkedBag();
        T[] bag1= this.toArray();
        T[] bag2= anotherBag.toArray();
        for(T element: bag1) 
            unionBag.add(element); 
        for(T element: bag2) 
            unionBag.add(element);
        return unionBag;
    }
    /** 
     * 
     * @param anotherBag
     * @return
     */
    public LinkedBag<T> intersection(LinkedBag<T> anotherBag) { 
        // I think i need to add usage of the clone function, not sure if that would impact how i add in elements, I think it would so i need to make clones out of each object
        LinkedBag<T> duplicateBag = new LinkedBag(); // add duplicate to bag and test against so we can use getFrequency of freely
        LinkedBag<T> intersectionBag = new LinkedBag();
        if (this.isEmpty() || this==null) // explicit handle of empty and null cases 
            return intersectionBag;
        Node<T> current1=this.firstNode;
        // use larger bag as stopping condition for loop  
        int numOfElem=(this.numberofEntries<anotherBag.numberofEntries) ? (this.numberofEntries):(anotherBag.numberofEntries); 
        for (int i=0;i<numOfElem;i++) {
            if (!duplicateBag.contains(current1.data)) { 
                int freqA=anotherBag.getFrequencyOf(current1.data);// check if element is in other bag 
                int freqB=this.getFrequencyOf(current1.data); 
                int intersect = (freqA>freqB)? (freqB) : (freqA); // pick lower frequency 
                for (int j=0; j<intersect;j++) // add in a loop
                    intersectionBag.add(current1.data);
                duplicateBag.add(current1.data);
            }
            current1=current1.next;
        }
        return intersectionBag;
    }
    public LinkedBag<T> difference(LinkedBag<T> anotherBag){
        LinkedBag<T> differenceBag = new LinkedBag();
        LinkedBag<T> duplicateBag = new LinkedBag();
        if (this.isEmpty() || this==null) // explicit handle of empty and null cases 
            return differenceBag;
        Node<T> current1=this.firstNode;
        for (int i=0; i<this.numberofEntries;i++) { // unique elem for calling bag, stopping condition is anchored by calling bag
            int freqA=anotherBag.getFrequencyOf(current1.data);
            int freqB=this.getFrequencyOf(current1.data);
            if (!duplicateBag.contains(current1.data)&& freqB>=freqA) {
                int instances= freqB-freqA; 
                for(int j=0; j<instances;j++) 
                    differenceBag.add(current1.data);
                duplicateBag.add(current1.data); 
            }
            current1=current1.next; 
        }
        return differenceBag;
    
    
    
    }
    
    
    
    
    
    
    
    
    
    }
    
    
    
    