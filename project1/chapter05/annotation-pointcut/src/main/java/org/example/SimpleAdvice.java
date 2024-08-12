package org.example;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable{
        System.out.print(">> Invoking " + invocation.getMethod().getName() + "\n");
        Object retVal = invocation.proceed();
        System.out.print(">> Done\n");
        return retVal;
    }
}
