package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
//		LLNode<E> n1 = new LLNode();
//		this.head=n1;
//		LLNode<E> n2 = new LLNode();
//		this.tail = n2;
//		n1.next = n2;
//		n2.prev=n1;

		head = new LLNode<E>();
		tail = new LLNode<E>();
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element )
	{
		// TODO: Implement this method

		if(element == null)
		{
			throw new NullPointerException();
		}

		LLNode<E> curr = new LLNode<E>(element);
		curr.next = this.tail;
		curr.prev = this.tail.prev;
		this.tail.prev.next=curr;
		this.tail.prev=curr;
		this.size++;
		return true;
	}

	/** Get the element at position index
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index)
	{
		// TODO: Implement this method.
		if(index >= size || index < 0)
		{
			throw new IndexOutOfBoundsException("Invalid index!");
		}

		LLNode<E> currNode = this.head.next;
		for(int i=0; i<index; i++)
		{
			currNode = currNode.next;
		}
		return currNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element )
	{
		// TODO: Implement this method

		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}

		if(element == null)
		{
			throw new NullPointerException();
		}

		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> currNode = head.next;
		for(int i=0; i<index; i++)
		{
			currNode = currNode.next;
		}

		newNode.next = currNode;
		newNode.prev = currNode.prev;
		currNode.prev.next = newNode;
		currNode.prev = newNode;
		this.size++;

	}


	/** Return the size of the list */
	public int size()
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 *
	 */
	public E remove(int index)
	{
		// TODO: Implement this method

		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("Invalid Index!");
		}

		LLNode<E> currNode = this.head.next;
		for(int i=0; i<index; i++)
		{
			currNode = currNode.next;
		}
		currNode.prev.next = currNode.next;
		currNode.next.prev = currNode.prev;
		this.size--;
		return currNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element)
	{
		// TODO: Implement this method

		if(index < 0 || index >= this.size()){
			throw new IndexOutOfBoundsException();
		}

		if(element == null)
		{
			throw new NullPointerException();
		}

		LLNode<E> currNode = this.head.next;
		for(int i=0; i<index; i++)
		{
			currNode = currNode.next;
		}
		E oldData = currNode.data;
		currNode.data = element;
		return oldData;
	}
}

class LLNode<E>
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e)
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public LLNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}

}
