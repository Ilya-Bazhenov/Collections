import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Queue;
import java.util.LinkedList;

import java.util.*;

public class QueueTest {
    private Queue<Integer> queue;

    @BeforeEach
    void initialQueueBeforeEachTest() {
        queue = new LinkedList<>();
    }

    @Test
    void checkForItemDeletion() {
        Queue<Integer> expected = new LinkedList<>();
        expected.add(2);

        queue.offer(1);
        queue.offer(2);

        queue.poll();

        assertIterableEquals(expected, queue);
    }

    @Test
    void shouldReturnNullWhenQueueIsEmpty() {
        Object actual = queue.poll();

        assertNull(actual);
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenQueueIsEmpty() {
        Executable executable = () -> queue.remove();

        assertThrows(NoSuchElementException.class, executable);
    }

    @Test
    void checkForReturnFirstItem() {
        queue.offer(1);
        queue.offer(2);

        Integer actual = queue.peek();

        assertEquals(1, actual);
    }

    @Test
    void shouldReturnNullWhenFirstItemNotExists() {
        Object actual = queue.peek();

        assertNull(actual);
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenFirstItemNotExists() {
        Executable executable = () -> queue.element();

        assertThrows(NoSuchElementException.class, executable);
    }
}
