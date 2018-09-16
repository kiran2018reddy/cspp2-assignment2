import java.util.Arrays;
import java.io.BufferedInputStream;
import java.util.Scanner;
/*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, when we do not what we are going to have in the list
     * We need to create a Generic list to store the items
     * Here E is a type parameter, and it will be replaced with
        actual type when the object got created.
     */

class List<E> {
    /**
     * { var_description }.
     */
    private E[] list;
    /**
     * { var_description }.
     */
    private int size;
    //Constructor

    /**
     * Constructs the object.
     */
    List() {
        // Create a variable of the type Object[]
        final int ten = 10;
        list = ((E[]) new Object[ten]);
        //Object is the base class for all the classes
        size = 0;
    }
    //Overloaded Constructor

    /**
     * Constructs the object.
     *
     * @param      param  The parameter
     */
    List(final int param) {
        list = ((E[]) new Object[param]);
        size = 0;
    }
    /* The add method does what the name suggests.
     * Add a generic type item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     */

    /**
     * { function_description }.
     */
    public void resize() {
     list = Arrays.copyOf(list, 2 * size);
    }
public void add(final E item) {
        //Inserts the specified element at the end of the list.
        //You can modify the code in this method.
        try {
            list[size++] = item;
          } catch (Exception e) {
            resize();
        }
    }
    /*Inserts all the elements of specified int
    array to the end of list*/

    /**
     * Adds all.
     *
     * @param      items  The items
     */
    public void addAll(final E[] items) {
        //Write logic for addAll method
        for (int i = 0; i < items.length; i++) {
            try {

                list[size] = items[i];
                size++;
            } catch (Exception e) {
                resize();
                list[size++] = items[i];
            }
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * { function_description }.
     *
     * @param      idex  The idex
     */
    public void remove(final int idex) {
        //Write logic for remove method
        try {
            if (idex >= size || idex < 0) {
                throw new Exception();

            }
        } catch (Exception e) {
            System.out.println("Invalid Position Exception");
            return;
        }
        E[] arrayCopy = ((E[]) new Object[list.length]);
        for (int i = 0; i < list.length; i++) {
            arrayCopy[i] = list[i];
        }
        int index1 = 0;
        for (int i = 0; i < arrayCopy.length; i++) {
            if (i != idex) {
                list[index1] = arrayCopy[i];
                index1 = index1 + 1;
         }

        }

        size = size - 1;
    }
    /*
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     */

   public E get(final int index) {
        //Write logic for get method
        return list[index];
    }
    /*
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
     */

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {

        if (size == 0) {
            return "[]";
        }
        E[] printArray = ((E[]) new Object[size]);
        for (int i = 0; i < size; i++) {
            printArray[i] = list[i];
        }
        return Arrays.toString(printArray).replaceAll(" ", "");
    }
    /*
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false
     */

    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final E item) {
        //Write logic for contains method
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return true;
            }
        }
        return false;
    }
    /*
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */

    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final E item) {
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                return i;
            }
        }
        return -1;
    }

    /* Removes all of its elements that
     * are contained in the specified int array.
     */

    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int count(final E item) {
        // write the logic
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                c++;
            }
        }
        return c;
    }

 public void removeAll(final E[] items) {
        // // write the logic
       for (int i = 0; i < items.length; i++) {
            int c = count(items[i]);
            for (int j = 0; j < c; j++) {
                remove(indexOf(items[i]));

          }
        }
    }

    /*Returns a list containing elements, including
     startIndex and excluding endIndex. The first parameter
     indicates the startIndex and the second parameter
     indicates the endIndex.
     */

    public List subList(final int start, final int end) {
        try {
            if (start < 0 || end > size + 1 || !(start < end)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Index Out of Bounds Exception");
            return null;
        }
        List sublist = new List(end - start);
        for (int i = start; i < end; i++) {
            sublist.add(list[i]);
        }
        return sublist;
    }
   public boolean equals(final List<E> li) {

        if (Arrays.equals(list, li.list)) {
            return true;
        }
        return false;
    }
      public int equals() {
        return 0;

    }
    /**
     * { function_description }.
     */
    public void clear() {
        // write the logic for clear.
        final int ten = 10;
        list = ((E[]) new Object[ten]);
        size = 0;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
  public static void main(final String[] args) {
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        String objectType = stdin.nextLine();
        List<Integer> l = new List();
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "add":
                if (tokens.length == 2) {
                    String[] t = tokens[1].split(",");
                    if (t.length == 1) {
                        l.add(Integer.parseInt(tokens[1]));
                    }
                }
                break;
            case "size":
                System.out.println(l.size());
                break;
            case "print":
                System.out.println(l);
                break;
            case "remove":
                if (tokens.length == 2) {
                    l.remove(Integer.parseInt(tokens[1]));
                }
                break;
            case "indexOf":
                if (tokens.length == 2) {
                    System.out.println(l.indexOf(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "get":
                if (tokens.length == 2) {
                    System.out.println(l.get(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "contains":
                if (tokens.length == 2) {
                    System.out.println(l.contains(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "addAll":
                if (tokens.length == 2) {
                    String[] t1 = tokens[1].split(",");
                    Integer[] temp = new Integer[t1.length];
                    for (int i = 0; i < temp.length; i++) {
                        temp[i] = Integer.parseInt(t1[i]);
                    }
                    l.addAll(temp);
                }
                break;
            case "removeAll":
                if (tokens.length == 2) {
                    String[] t2 = tokens[1].split(",");
                    Integer[] a = new Integer[t2.length];
                    for (int i = 0; i < t2.length; i++) {
                        a[i] = Integer.parseInt(t2[i]);
                    }
                    l.removeAll(a);
                }
                break;
            case "subList":
                if (tokens.length != 2) {
                    break;
                }
                String[] arrstring3 = tokens[1].split(",");
                List object = l.subList(Integer.parseInt(arrstring3[0]),
                                        Integer.parseInt(arrstring3[1]));
                if (object != null) {
                    System.out.println(object);
                }
                break;
            case "count":
                System.out.println(l.count(Integer.parseInt(tokens[1])));
                break;
            case "equals":
                if (tokens.length == 2) {
                    String[] lt = tokens[1].split(",");
                    List l2 = new List();
                    for (int k = 0; k < lt.length; k++) {
                        l2.add(Integer.parseInt(lt[k]));
                    }
                    System.out.println(l.equals(l2));
                }
                break;
            case "clear":
                l.clear();
                break;
            default:
                break;
            }
        }
    }

}