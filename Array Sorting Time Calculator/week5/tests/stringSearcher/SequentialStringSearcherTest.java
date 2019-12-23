package stringSearcher;

/**
 * Tests sequential string searchers.
 *
 * @author Hugh Osborne
 * @version October 2019
 */
class SequentialStringSearcherTest extends StringSearcherTest {

    @Override
    StringSearcher getSearcher(String string) {
        return new SequentialStringSearcher(string);
    }
}