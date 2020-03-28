package factory;

import factory.animal.Dog;

public class DogFactory implements AnimalFactory {
    @Override
    public Animal getAnimal() {
        return new Dog();
    }
}
