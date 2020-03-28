package factory.animal;

import factory.Animal;

public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗狗");
    }
}
