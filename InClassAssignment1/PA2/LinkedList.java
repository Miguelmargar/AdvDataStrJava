/* LinkedList
*  Anderson, Franceschi
*/

/**
 *
 * properties of this implementation are such that:
 *   - the list is singly linked
 *   - data contained in the nodes are limited to integers
 *   - nodes are sorted in ascending order of data
 *   - duplicate data is allowed
 */
import java.util.ArrayList;

public class LinkedList
{
  private Node head;

  /** default constructor
  *    sets head to null
  */
  public LinkedList( )
  {
    head = null;
  }

  /** insert method
  *  @param value number to insert
  */
  public void insert( int value )
  {
	  Node newest = new Node(value);
	  
	  int size = count();	  

	  if (size == 0) {
		  newest.setNext(null);
		  head = newest;
	  } else if (size > 0) {
		  Node current = head;
		  
		  for (int i = 0; i < size; i++) {
			  if (current.getData() == newest.getData()) {
				  newest.setNext(current.getNext());
				  current.setNext(newest);
				  break;
			  } else if ((newest.getData() > current.getData()) && current.getNext() == null) {
				  newest.setNext(current.getNext());
				  current.setNext(newest);
				  break;
			  } else if (newest.getData() > current.getData() && newest.getData() < current.getNext().getData()) {
				  newest.setNext(current.getNext());
				  current.setNext(newest);
				  break;
			  } else if (newest.getData() < current.getData()) {
				  newest.setNext(current);
				  head = newest;
				  break;
			  } else {
				  current =current.getNext();
			  }
		  }
	  }
  }

  /** delete method
  *  @param  value  data value to delete
  *  @return true if delete was successful; otherwise, false
  */
  public boolean delete(int value)
  {
	  int size = count();
	  
	  if (size == 0) return false;
	  else {
		  Node current = head;
		  int count = -1;
		  for (int i = 0; i < size; i++) {
			  if (current.getData() == value) {
				  count = i;
				  break;
			  } else {
				  current = current.getNext();
			  }
		  }
		  current = head;
		  if (count < 0) return false;
		  else if (count == 0) {
			  head = current.getNext();
			  current.setNext(null);
			  return true;
		  } else if (count > 0) {
			  for (int i = 0; i <= size; i++) {
				  if (i == count -1) {
					 Node next = current.getNext();
					 current.setNext(next.getNext());
					 next.setNext(null);
					 return true;
				  }
			  }
		  }
	  }
	  return false;
  }

  /** count method
  *  @return the number of nodes in the list
  */
  public int count( )
  {
    int n = 0;
    Node current = head;
    while ( current != null )
    {
      n++;
      current = current.getNext( );
    }
    return n;
  }
  
  /** toString
  * @return a list of the data items in the list
  */
  @Override
  public String toString( )
  {
    String result = "List: ";
    Node current = head;
    while ( current != null )
    {
      result += ( current.getData( ) + "  " );
      current = current.getNext( );
    }
    return result;
  }

  /** clear method
  *  deletes all data by setting head to null
  */
  public void clear( )
  {
    head = null;
  }
   
  /** toArrayList method
  *  @return an ArrayList containing the data in the list
  */ 
  public ArrayList<Integer> toArrayList( )
  {
    ArrayList<Integer> result = new ArrayList<Integer>( );
    Node current = head;
    while ( current != null )
    {
      result.add( current.getData( ) );
      current = current.getNext( );
    }
    return result;
  }

}