package DataStructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList testInstance = new LinkedList<Integer>();


    @Test
    public void Insert_InsertOneItem_SuccessfulInsertion() {
        assertTrue(testInstance.insert(5));
    }

    @Test
    public void DeleteByIndex_DeleteAnItem_SuccessfulDeletion() {
        testInstance.insert(1);
        testInstance.insert(2);
        assertTrue(testInstance.deleteByIndex(1));
    }

    @Test
    public void DeleteByIndex_IndexOutOfRange_UnsuccessfulDeletion() {
        testInstance.insert(1);
        testInstance.insert(2);
        assertFalse(testInstance.deleteByIndex(2));
    }

    @Test
    public void DeleteByIndex_DeletingEmptyList_UnsuccessfulDeletion() {
        assertFalse(testInstance.deleteByIndex(0));
    }

    @Test
    public void DeleteByIndex_DeletingRootIndex_SuccessfulDeletion() {
        testInstance.insert(5);
        assertTrue(testInstance.deleteByIndex(0));
    }

    @Test
    public void DeleteByData_DeletingExistData_SuccessfulDeletion() {
        testInstance.insert(5);
        assertTrue(testInstance.deleteByData(5));
    }


}
