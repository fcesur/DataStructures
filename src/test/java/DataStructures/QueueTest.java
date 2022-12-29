package DataStructures;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class QueueTest {

    Queue<Integer> queueTest = new Queue<Integer>(5);

    @Test
    public void Enqueue_AddOneItem_SuccessfulAddition() {
        assertTrue(queueTest.enqeue(1));
    }

    @Test
    public void Enqueue_OverflowItem_UnsuccessfulAddition() {
        queueTest.enqeue(1);
        queueTest.enqeue(2);
        queueTest.enqeue(3);
        queueTest.enqeue(4);
        queueTest.enqeue(5);
        assertFalse(queueTest.enqeue(6));
    }

    @Test
    public void Dequeue_DequeueEmptyList_ThrowQueueEmptyException() {

        assertThatThrownBy(() -> queueTest.dequeue())
                .isInstanceOf(Exception.class)
                .hasMessage("Queue is empty");
    }

    @Test
    public void Dequeue_AfterAdditionDequeueUntilEmpty_ThrowQueueEmptyException() throws Exception {

        queueTest.enqeue(2);
        queueTest.dequeue();

        assertThatThrownBy(() -> queueTest.dequeue())
                .isInstanceOf(Exception.class)
                .hasMessage("Queue is empty");
    }

}