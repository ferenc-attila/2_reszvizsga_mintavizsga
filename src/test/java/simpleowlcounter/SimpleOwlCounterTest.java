package simpleowlcounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import owlcounter.OwlCounter;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleOwlCounterTest {

    SimpleOwlCounter simpleOwlCounter;

    @BeforeEach
    void init() {
        simpleOwlCounter = new SimpleOwlCounter();
        Path path = Paths.get("src/test/resources/owls.txt");
        simpleOwlCounter.readFromFile(path);
    }

    @Test
    void testGetNumberOfOwls() {
        assertEquals(1000, simpleOwlCounter.getNumberOfOwls("Bács-Kiskun"));
        assertEquals(893, simpleOwlCounter.getNumberOfOwls("Somogy"));
        assertEquals(135, simpleOwlCounter.getNumberOfOwls("Zala"));
    }

    @Test
    void testReadFromFileWithWrongPath() {
        IllegalStateException ex = assertThrows(IllegalStateException.class,
                () -> new OwlCounter().readFromFile(Paths.get("src/test/resources/xyz.txt")));
        assertEquals("Can not read file.", ex.getMessage());
    }

    @Test
    void testGetNumberOfOwlsWithWrongCounty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> simpleOwlCounter.getNumberOfOwls("xyz"));
        assertEquals("No such county in Hungary!", ex.getMessage());
    }

    @Test
    void testGetNumberOfAllOwls() {
        assertEquals(11410, simpleOwlCounter.getNumberOfAllOwls());
    }
}