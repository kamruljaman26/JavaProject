package arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CharacterArrayGenerator;

public class CharacterInsertionSortTest extends InsertionSortTest<Character> {
    @Override
    ArrayGenerator<Character> getGenerator() {
        return new CharacterArrayGenerator();
    }
}