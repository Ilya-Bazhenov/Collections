import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

class IteratorTest {
    private List<ComplexNumber> listComplexNumbers;

    @BeforeEach
    void initialListBeforeEachTest() {
        listComplexNumbers = new ArrayList<>();
    }

    @Test
    void shouldReturnTrueWhenNextElementExists() {
        listComplexNumbers.add(new ComplexNumber(1, 1));
        Iterator<ComplexNumber> it = listComplexNumbers.iterator();

        assertTrue(it.hasNext());
    }

    @Test
    void shouldReturnFalseWhenNextElementNotExists() {
        Iterator<ComplexNumber> it = listComplexNumbers.iterator();

        assertFalse(it.hasNext());
    }

    @Test
    void shouldReturnNextElementInIterable() {
        ComplexNumber expected = new ComplexNumber(1, 1);

        listComplexNumbers.add(new ComplexNumber(1, 1));
        Iterator<ComplexNumber> it = listComplexNumbers.iterator();

        assertEquals(expected, it.next());
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenNextElementNotExists() {
        Iterator<ComplexNumber> it = listComplexNumbers.iterator();

        Executable executable = () -> it.next();

        assertThrows(NoSuchElementException.class, executable);
    }

    @Test
    void shouldRemoveLastElementReturnedByThisIterator() {
        listComplexNumbers.add(new ComplexNumber(1, 1));
        Iterator<ComplexNumber> it = listComplexNumbers.iterator();

        it.next();
        it.remove();

        assertTrue(listComplexNumbers.isEmpty());
    }

    @Test
    void shouldThrowIllegalStateExceptionWhenNextHasNotBeenCalled() {
        Iterator<ComplexNumber> it = listComplexNumbers.iterator();

        Executable executable = () -> it.remove();

        assertThrows(IllegalStateException.class, executable);
    }
}