import java.util.Arrays;
    /*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, when we do not what we are going to have in the list
     * We need to create a Generic list to store the items
     * Here E is a type parameter, and it will be replaced with
        actual type when the object got created.
     */

/**
 * List of .
 *
 * @param      <E>   generic.
 */
public class List<E> {

    /**
     * list to store elements.
     */
    private E[] array;

    /**
     * size of array.
     */
    private int size;

    //Constructor
    /**
     * Constructs the object.
     */
    public List() {
        // Create a variable of the type Object[]
        final int defaultsize = 10;
        array = ((E[]) new Object[defaultsize]);
        //Object is the base class for all the classes
        size = 0;
    }

    //Overloaded Constructor
    /**
     * Constructs the object.
     *
     * @param      param  The parameter
     */
    public List(final int param) {
        array = ((E[]) new Object[param]);
        size = 0;
    }
    /**
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     *
     * The method returns void (nothing).
     * @param item item to be added.
     */
    public void add(final E item) {
        //Inserts the specified element at the end of the list.
        array[size++] = item;
    }

    /**
     * Adds all.
     *
     * @param      items  The items
     */
    public void addAll(final E[] items) {
        if (size == array.length || array.length - size < items.length) {
            E[] tmp = (E[]) new Object[array.length + array.length];
            for (int i = 0; i < size; i++) {
                tmp[i] = array[i];
            }
            for (int i = 0; i < items.length; i++) {
                tmp[i + size] = items[i];
            }

            array = tmp;

        } else {
            for (int i = 0; i < items.length; i++) {
                array[i + size] = items[i];
            }
        }

        size += items.length;


    }

    /*
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     */

    /**
     * getter func for size.
     *
     * @return     size of array.
     */
    public int size() {
        return size;
    }


    /**
         * The remove method does what the name suggests.
         * Removes an int item, specified by the index argument, from the list
         * It also does an additional step.
         * Think about what happens when
         * an item is removed from the middle of the list
         * It creates a hole in the list, right?
         * This would mean, all the items that are
         * to the right side of the removed item should be
         * moved to the left by one position.
         * Here is an example:
         * array = [1,2,3,0,0,0,0,0,0,0]
         * remove(2) would remove the item 2
         * But how do you remove the item from an array?
         * Well, the way to remove it is to move all
         * the items, that are to the right of the removed item, to the left
         * So, the new array looks like
         * array = [1,3,0,0,0,0,0,0,0,0]
         * The method returns void (nothing).
         *
         *@param index index starting from 0 given to be removed.
         */
    public void remove(final int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.

        if (index >= size || index <= -1) {
            System.out.println("Invalid Position Exception");
        } else if (index == array.length - 1) {
            array[index] = null;
            size--;
        } else {
            array[index] = array[index + 1];

            for (int i = index + 1; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }

            array[array.length - 1] = null;
            size--;
            //System.out.println(Arrays.toString(array));
        }


    }

    /**
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     *
     *@param index index strating from 0.
     *
     *@return element if valid position else -1.
     */
    public E get(final int index) {
        // Replace the code below to write the code for get

        if (index < size && index >= 0) {
            return array[index];
        }
        return null;
    }


    /**
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the array.
     *
     *
     *@return array in string format.
     *
     */
    public String toString() {
        // Replace the code below
        E[] tmparray = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            tmparray[i] = array[i];
        }

        return Arrays.toString(tmparray).replace(" ", "");
    }


    /**
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false.
     *
     *@param item element to be checked.
     *
     *@return true if present else false.
     *
     */
    public boolean contains(final E item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     *@param item element for which index is required.
     *
     *@return index of the element if present
     */
    public int indexOf(final E item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }


    /*
     Removes all of its elements that are contained in the specified int
     array.
    */

    /**
     * Removes all.
     *
     * @param      newArray  The new array
     */
    public void removeAll(final E[] newArray) {
        for (E i : newArray) {
            for (int j = 0; j < size; j++) {
                if (array[j].equals(i)) {
                    remove(j);
                    j--;
                }
            }
        }
    }



    /*
    Returns a list object containing elements, including startIndex and
    excluding endIndex. The first parameter indicates the startIndex and the
    second parameter indicates the endIndex. Returns null and print
    "Index Out of Bounds Exception" if any of values start and end are negative
    and also if start is greater than end.
    */

    /**
     * sublist getter.
     *
     * @param      start  The start
     * @param      end    The end
     *
     * @return     { description_of_the_return_value }
     */
    public List subList(final int start, final int end) {
        // write the logic for subList
        if (start >= end || (start < 0 || end < 0) || size == 0) {
            System.out.println("Index Out of Bounds Exception");
            return null;
        }

        List slist = new List();

        for (int i = start; i < end; i++) {
            slist.add(array[i]);
        }

        return slist;
    }


    /*
    Returns a boolean indicating whether the parameter i.e a List object is
    exactly matching with the given list or not.
    */

    /**
     * equal or not checker.
     *
     * @param      list  The list
     *
     * @return     true if equal else false.
     */
    public boolean equals(final List list) {
        if (this.size != list.size()) {
            return false;
        }

        for (int i = 0; i < this.size; i++) {
            if (!this.array[i].equals(list.array[i])) {
                return false;
            }
        }

        return true;
    }

    /*
    * Removes all the elements from list
    * Think about this case and make the method
    * the simpler.
    */

    /**
     * clear the array.
     */
    public void clear() {
        // write the logic for clear.
        final int defaultsize = 10;
        array = ((E[]) new Object[defaultsize]);
        this.size = 0;
    }

}