package ss21_design_patterns.factory_method;

public class Cat extends Animal {
    @Override
    public String makeSound() {
        return "Meow";
    }
}