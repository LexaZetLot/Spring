package org.example;

public abstract class AbstractLookupDemoBean implements DemoBean{
    public abstract Singer getMySinger();

    @Override
    public void doSomething(){
        getMySinger().sing();
    }
}
