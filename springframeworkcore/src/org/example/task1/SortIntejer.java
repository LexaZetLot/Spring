package org.example.task1;

public class SortIntejer implements Comparison<Integer>{

    @Override
    public boolean comparison(Integer x, Integer y) {
        if(x <= y)
            return true;
        return false;
    }
}
