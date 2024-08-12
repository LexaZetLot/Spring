package org.example;

public class NewDocumentarist extends  Documentarist{
    @Override
    public void execute(){
        guitarist.sing();
        Guitar guitar = new Guitar();
        guitar.setBrand("Gibson");
        guitarist.sing(guitar);
        guitarist.talk();
    }
}
