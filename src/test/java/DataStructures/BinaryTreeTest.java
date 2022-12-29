package DataStructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    BinaryTree binaryTreeTest = new BinaryTree();

    @Test
    public void Add_InsertOneItem_ItemContainsInTree() {
        binaryTreeTest.add(5);
        assertTrue(binaryTreeTest.contains(5));
    }

    @Test
    public void Delete_DeletingExistItem_SuccessfulDeletion() {
        binaryTreeTest.add(5);
        binaryTreeTest.delete(5);
        assertFalse(binaryTreeTest.contains(5));
    }

    @Test
    public void traverseLDR_TraversingLDR_CorrectTraversing() {
        binaryTreeTest.add(10);
        binaryTreeTest.add(20);
        binaryTreeTest.add(30);

        binaryTreeTest.traverseLDR(binaryTreeTest.root);
    }

    @Test
    public void traverseDLR_TraversingDLR_CorrectTraversing() {
        binaryTreeTest.add(10);
        binaryTreeTest.add(20);
        binaryTreeTest.add(30);


        binaryTreeTest.traverseDLR(binaryTreeTest.root);

    }

    @Test
    public void traverseLRD_TraversingLRD_CorrectTraversing() {
        binaryTreeTest.add(10);
        binaryTreeTest.add(20);
        binaryTreeTest.add(30);

        binaryTreeTest.traverseLRD(binaryTreeTest.root);

    }

}