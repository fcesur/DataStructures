package DataStructures;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.*;

public class StackTest {

    Stack stackTest = new Stack<Integer>(3);

    @Test
    public void Push_PushingAnItem_SuccessfulAdding() {
        assertTrue(stackTest.push(5));
    }

    @Test
    public void Push_PushingOverflowItem_UnsuccessfulAdding() {
        stackTest.push(5);
        stackTest.push(5);
        stackTest.push(5);
        assertFalse(stackTest.push(5));
    }

    @Test
    public void Pop_PoppingEmptyStack_ThrowsStackIsEmptyException() {
        assertThatThrownBy(() -> stackTest.pop())
                .isInstanceOf(Exception.class)
                .hasMessage("Stack is empty.");
    }

    @Test
    public void Pop_PoppingAnItem_ReturnsItem() {
        stackTest.push(5);
        try {
            assertEquals(5, stackTest.pop());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}