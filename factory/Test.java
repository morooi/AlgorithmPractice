package factory;

public class Test {

    public static void main(String[] args) {
        Animal cat = new CatFactory().getAnimal();
        cat.eat();

        Animal dog = new DogFactory().getAnimal();
        dog.eat();
    }

}
