import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.HashSet;

public class SetTest {
    private static Set<ComplexNumber> otherSet;
    private Set<ComplexNumber> setComplexNumbers;

    @BeforeAll
    static void initialSetBeforeAllTests() {
        otherSet = new HashSet<>();
        otherSet.add(new ComplexNumber(1, 2));
        otherSet.add(new ComplexNumber(2, 2));
    }

    @BeforeEach
    void initialSetBeforeEachTest() {
        setComplexNumbers = new HashSet<>();
    }

    @Test
    void addingIdenticalComplexNumbers() {
        setComplexNumbers.add(new ComplexNumber(1, 1));
        setComplexNumbers.add(new ComplexNumber(1, 1));

        assertEquals(1, setComplexNumbers.size());
    }

    @Test
    void unionOfSets() {
        setComplexNumbers.add(new ComplexNumber(1, 1));
        setComplexNumbers.add(new ComplexNumber(1, 2));

        Set<ComplexNumber> unionSet = new HashSet<>(setComplexNumbers);
        unionSet.addAll(otherSet);

        assertEquals(3, unionSet.size());
    }

    @Test
    void intersectOfSets() {
        Set<ComplexNumber> expectedSet = Set.of(new ComplexNumber(1, 2));

        setComplexNumbers.add(new ComplexNumber(1, 1));
        setComplexNumbers.add(new ComplexNumber(1, 2));

        Set<ComplexNumber> intersectSet = new HashSet<>(setComplexNumbers);
        intersectSet.retainAll(otherSet);

        assertIterableEquals(expectedSet, intersectSet);
    }

    @Test
    void subtractOfSets() {
        Set<ComplexNumber> expectedSet = Set.of(new ComplexNumber(1, 1));

        setComplexNumbers.add(new ComplexNumber(1, 1));
        setComplexNumbers.add(new ComplexNumber(1, 2));

        Set<ComplexNumber> subtractSet = new HashSet<>(setComplexNumbers);
        subtractSet.removeAll(otherSet);

        assertIterableEquals(expectedSet, subtractSet);
    }
}
