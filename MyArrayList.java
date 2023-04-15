/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

/**
 * Write a description of class KWArrayList here.
 *
 * @author (Nurazzah Abd Rahman)
 * @version 3 (28 March 2023 - CS2304ABC)
 * <p>
 * This file is taken from Koffman & Wolfgang’s
 * "Data Structures: Abstraction and Design Using Java", 2nd Edition
 * Pub. John Wiley & Sons, Inc., 2010.
 * with minor modifications by Richard Eisenberg
 */


 import java.util.AbstractList;
 import java.util.Arrays;
 
 /** This class implements some of the methods of the Java
  * ArrayList class.
  * @param <E>
  */
 public class MyArrayList<E> extends AbstractList<E>
 {
     /** The default initial capacity */
     private static final int INITIAL_CAPACITY = 10;
     private E[] theData; // The underlying data array
     private int size = 0; // The current size
     private int capacity = 10; // The current capacity
 
     // INVARIANT: theData.length == capacity
     // INVARIANT: size <= capacity
     
     @SuppressWarnings("unchecked")
     // Default constructor
     public MyArrayList() // Creates a list with an initial capacity of INITIAL_CAPACITY     
     {
         capacity = INITIAL_CAPACITY;
         theData = (E[]) new Object[capacity]; // Initial Capacity of The ArrayList = 10 data
     }
      
     // Construct an empty KWArrayList with a specified initial capacity
     // @param capacity The initial capacity
     public MyArrayList(int capacity) {
         this.capacity = capacity;
         theData = (E[]) new Object[capacity];
     }
 
     // Adds a new element to this list
     // @param anEntry The new element
     // @return true, always
     @Override
     public boolean add(E anEntry)
     {
         if(size == capacity) // If current size == current capacity
         {
             reallocate(); // Then double the size of the array
         }
     
         theData[size] = anEntry; // Inserting the new element into an array
         size++;
         return true;
     }
 
     /** Get the element at a specified index
     * @param index The index at which to retrieve the item
     * @return The item at that index
     * @throws IndexOutOfBoundsException if the index is < 0 or >= size
     */
 
     @Override
     public E get(int index)
     {
         if(index < 0 || index >= size)
         {
             throw new IndexOutOfBoundsException("" + index);
         }
     
         return theData[index];
     }
  
     /** Change the value at a specified index
     * @param index The index at which to change the value
     * @param newValue The new value to be stored at that index
     * @return The old value at that index
     * @throws IndexOutOfBoundsException if the index < 0 or >= size
     */
 
     @Override
     public E set(int index, E newValue)
     {
         if(index < 0 || index >= size)
         {
             throw new IndexOutOfBoundsException("" + index);
         }
     
         E oldValue = theData[index];
         theData[index] = newValue;
         return oldValue;
     }
  
     /** Removes the element at the specified index, moving any later
     * elements to the left
     * @param index The index at which to remove an element
     * @return The element removed
     * @throws IndexOutOfBoundsException if the index < 0 or >= size
     */
 
     /** Adds a new element at the specified index to this list.
     * Later elements, if any, are moved to the right.
     * @param index Where to add this element; must be >= 0 and <= size
     * @param anEntry The new value to add
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
     @Override
     public void add(int index, E anEntry)
     {
         if(index < 0 || index > size)
         {
             throw new IndexOutOfBoundsException("" + index);
         }
     
         if(size == capacity)
         {
             reallocate();
         }
  
         // Shift data in elements from index to size - 1
         for(int i = size; i > index; i--)
         {
             theData[i] = theData[i - 1];
         }
  
         // Insert the new item
         theData[index] = anEntry;
         size++;
     }
     
     @Override
     public E remove(int index)
     {
         if(index < 0 || index >= size)
         {
             throw new IndexOutOfBoundsException("" + index);
         }
     
         E returnValue = theData[index];
     
         for(int i = index + 1; i < size; i++)
         {
             theData[i - 1] = theData[i];
         }
     
         size--;
         return returnValue;
     }
     
     // Doubles the capacity of this list, preserving the elements
     // Precondition: size == capacity
     private void reallocate()
     {
         capacity = 2 * capacity; // Double the size of the array
         theData = Arrays.copyOf(theData, capacity); // Change the current size of an array to a new "capacity" size
     }
  
     // To get the current size of the array
     // @return the size of this list
     @Override
     public int size()
     {
         return size;
     }
     
     /**
      * Returns the index of the first occurence of the specified element
      * in this list, or -1 if this list does not contain the element
      * @param item The object to search for
      * @return The index of the first occurence of the specified item
      *          or -1 if this list does not contain the element
      */
     @Override
     public int indexOf(Object item) {
         for (int i = 0; i < size; i++) {
             if (theData[i] == null && item == null) {
                 return i;
             }
             if (theData[i].equals(item)) {
                 return i;
             }
         }
         return -1;
     }
 }