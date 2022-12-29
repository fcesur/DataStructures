package DataStructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    DoublyLinkedList doublyLinkedListTest = new DoublyLinkedList<Integer>();

    @Test
    public void InsertFront_InsertOneItem_SuccessfulAddition() {
        assertTrue(doublyLinkedListTest.insertFront(0));
    }

    @Test
    public void InsertEnd_InsertEndOneItem_SuccessfulAddition() {
        assertTrue(doublyLinkedListTest.insertEnd(0));
    }

    @Test
    public void InsertAfter_InsertAfterAnItem_SuccessfulAddition() {
        doublyLinkedListTest.insertEnd(3);
        assertTrue(doublyLinkedListTest.insertAfter(doublyLinkedListTest.head, 5));
    }

    @Test
    public void InsertAfter_InsertAfterNull_UnsuccessfulAddition() {
        assertFalse(doublyLinkedListTest.insertAfter(doublyLinkedListTest.head, 5));
    }

    @Test
    public void DeleteByData_DeleteItemNotContained_UnsuccessfulDeletion() {
        assertFalse(doublyLinkedListTest.deleteByData(0));
    }

    @Test
    public void DeleteByData_DeleteExistItem_SuccessfulDeletion() {
        doublyLinkedListTest.insertEnd(5);
        doublyLinkedListTest.insertEnd(4);
        assertTrue(doublyLinkedListTest.deleteByData(5));
    }


    @Test
    public void DeleteByIndex_DeleteRootIndexEmptyList_UnsuccessfulDeletion() {
        assertFalse(doublyLinkedListTest.deleteByIndex(0));
    }
}