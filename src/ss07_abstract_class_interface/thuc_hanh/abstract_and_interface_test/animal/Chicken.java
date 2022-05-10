package ss07_abstract_class_interface.thuc_hanh.abstract_and_interface_test.animal;

import ss07_abstract_class_interface.thuc_hanh.abstract_and_interface_test.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
