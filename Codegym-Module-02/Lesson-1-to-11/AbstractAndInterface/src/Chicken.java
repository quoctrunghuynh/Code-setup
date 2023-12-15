public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "Chicken: Cookadooooo";
    }
@Override
    public String howToEat(){
        return "Fried with flavour";
    }
}
