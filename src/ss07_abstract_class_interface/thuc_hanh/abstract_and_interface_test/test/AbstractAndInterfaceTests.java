package ss07_abstract_class_interface.thuc_hanh.abstract_and_interface_test.test;

import ss07_abstract_class_interface.thuc_hanh.abstract_and_interface_test.animal.Animal;
import ss07_abstract_class_interface.thuc_hanh.abstract_and_interface_test.animal.Chicken;
import ss07_abstract_class_interface.thuc_hanh.abstract_and_interface_test.animal.Tiger;
import ss07_abstract_class_interface.thuc_hanh.abstract_and_interface_test.edible.Edible;
import ss07_abstract_class_interface.thuc_hanh.abstract_and_interface_test.fruit.Apple;
import ss07_abstract_class_interface.thuc_hanh.abstract_and_interface_test.fruit.Fruit;
import ss07_abstract_class_interface.thuc_hanh.abstract_and_interface_test.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
