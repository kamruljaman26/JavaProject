package stringSearcher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic tester for string searchers.
 *
 * @author Hugh Osborne
 * @version October 2019
 */
abstract class StringSearcherTest {

    abstract StringSearcher getSearcher(String string);

    private int test(String substring,String superstring) throws NotFound {
        return getSearcher(substring).occursIn(superstring);
    }

    @Test
    void testFred() throws NotFound {
        assertEquals(2,test("fred","Alfred the Great"));
    }

    @Test
    void testCap() throws NotFound {
        assertEquals(6,test("cap","The incapable captain capsized the boat"));
    }

    @Test
    void testCab() {
        assertThrows(NotFound.class,()->test("absent","The can sent a message to base"));
    }
}