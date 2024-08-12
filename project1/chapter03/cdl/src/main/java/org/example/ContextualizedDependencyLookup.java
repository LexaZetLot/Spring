package org.example;

public class ContextualizedDependencyLookup implements ManagerComponent {
    private Dependency dependency;

    @Override
    public void performLookup(Container container){
        this.dependency = (Dependency) container.getDependency("myDependency");
    }

    @Override
    public String toString(){
        return dependency.toString();
    }
}
