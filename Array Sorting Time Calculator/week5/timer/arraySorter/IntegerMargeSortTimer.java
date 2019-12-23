package arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.IntegerArrayGenerator;
import scope.IntegerScope;
import timer.Timer;

public class IntegerMargeSortTimer extends MargeSortTimer<Integer>{

    @Override
    public Timer getTimer(int size) {
        ArrayGenerator<Integer> generator = new IntegerArrayGenerator(new IntegerScope());
        setArray(generator.getArray(size));
        return this;
    }

    public static void main(String[] args) {
        MargeSortTimer timer = new IntegerMargeSortTimer();
        timer.timingSequence();
    }

}

