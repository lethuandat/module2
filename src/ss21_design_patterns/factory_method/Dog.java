package ss21_design_patterns.factory_method;

public class Dog extends Animal {
    @Override
    public String makeSound() {
        return "Woof";
    }
}
