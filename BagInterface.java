package project1_2400;


public interface BagInterface<T> { 
    /** Finds the number of elements in the instance of the implementation of the BagInterface that makes this call. 
     * @return Returns the size of the Bag
     */
    public int getCurrentSize(); 
    /** Checks to see if the instance of the implementation of the BagInterface that makes this call is empty.
     * @return True if Bag is empty, false if non-empty Bag.
     */
    public boolean isEmpty();
    /** Adds the new element to the Beg calling this method and will return a boolean value. Expect False values when implementing
     * fixed-sized arrays because you may hit your capacity.
     * @param newEntry The new element that we are adding to our Bag.
     * @return True if it was added, will return false when you are unable to add to the bag due to storage restrictions.
     */ 
    public boolean add(T newEntry);
    /** Will an unspecified element, since order does not matter then removal will be random.
     * @return Returns True if the element was removed, false if it was unable to remove an element.
     */ 
    public T remove(); 
    /** Will remove a given element, will have to search through bag to find element to remove
     * @param anEntry The element we are attempting to remove from the Bag.
     * @return Will return True if the element was found and removed, false otherwise
     */
    public boolean remove(T anEntry);
    /** Will remove all the elements in the Bag that called this method.
     */
    public void clear();
    /** Find out how many instances of an element were found inside of the Bag that called this method.
     * @param anEntry The element we are counting in the Bag. 
     * @return How many instances of the element were found
     */
    public int getFrequencyOf(T anEntry);
    /** Checks to see if the Bag contains an element
     * @param anEntry The element we are searching for
     * @return Returns True if the element was contained in the Bag and False of the element was not found in the Bag
     */
    public boolean contains(T anEntry);
    /** Places the Bag that called this method into a fixed-size Array
     * @return Returns the fixed-sized Array
     */
    public T[] toArray();
    /** Will return a new Bag filled it with all of the elements in the Bag calling the method in addition to all the elements in the Bag that was passed as an argument in the method call. Finds all elements in either multiset.
     * @param anotherBag The Bag that will be used to make a union with the Bag that called this method
     * @return Returns the union of the Bag that called the method and the Bag in the argument that was passed in the method call.  
     */
    public BagInterface<T> union(BagInterface<T> anotherBag);
    /** Will return a new Bag filled it with all of the elements that were found in both the calling Bag and the Bag passed as an argument. Finds all the elements that were found in both multisets.
     * @param anotherBag The Bag that will be used to make an intersecton with the Bag that called this method
     * @return Returns the intersection of the Bag that called the method and the Bag in the argument that was passed in the method call. 
     */
    public BagInterface<T> intersection(BagInterface<T> anotherBag);
    /** Will return a new Bag filled it with all of the elements that were exclusive to the Bag that is making the method call
     * @param anotherBag The Bag used to pull all elements from the Bag making the method call that were contained in the argument Bag.
     * @return The new Bag after the difference was taken
     */
    public BagInterface<T> difference(BagInterface<T> anotherBag);

}
