package org.example;

import org.springframework.aop.AfterReturningAdvice;
import static org.example.KeyGenerator.WEAK_KEY;
import java.lang.reflect.Method;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable{
        if((target instanceof  KeyGenerator) && ("getKey".equals(method.getName()))){
            long key = ((Long) returnValue).longValue();

            if(key == WEAK_KEY)
                throw new SecurityException("Key Generator generated a weak key. Try again");
        }
    }
}
