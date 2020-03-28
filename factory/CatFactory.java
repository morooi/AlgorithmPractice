package factory;

import factory.animal.Cat;

public class CatFactory implements AnimalFactory {
    @Override
    public Animal getAnimal() {
        return new Cat();
    }
}
