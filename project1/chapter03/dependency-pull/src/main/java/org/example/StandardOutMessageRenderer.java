package org.example;

public class StandardOutMessageRenderer implements MessageRenderer{
    private MessageProvider messageProvider;

    @Override
    public void render(){
        if(messageProvider == null)
            throw new RuntimeException("You must set the property messageProvider of class: " +
                    StandardOutMessageRenderer.class.getName());
        else
            System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider){
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider(){
        return this.messageProvider;
    }
}
