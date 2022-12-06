package animal_interfaceedible;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "Chicken: ò ó o...";
    }

    @Override
    public String howToEat() {
        return "Mổ cục cục";
    }
}
