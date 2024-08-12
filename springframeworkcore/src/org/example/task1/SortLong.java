package org.example.task1;

public class SortLong implements Comparison<Long>{

    @Override
    public boolean comparison(Long x, Long y) {
        if(x > y)
            return true;
        return false;
    }
}
