package org.example;

public class CDLDemo {
    public static void main(String[] args){
        Container container = new DefaultContainer();
        ManagerComponent managerComponent = new ContextualizedDependencyLookup();
        managerComponent.performLookup(container);

        System.out.println(managerComponent);
    }
}
