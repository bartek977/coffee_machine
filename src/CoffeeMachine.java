package coffeemachine;
import java.util.Scanner;

abstract class Coffee{
    int water;
    int milk;
    int coffee;
    int cost;
}

class Espresso extends Coffee{

    Espresso(){
        super();
        super.water=250;
        super.milk=0;
        super.coffee=16;
        super.cost=4;

    }
}

class Latte extends Coffee{

    Latte(){
        super();
        super.water=350;
        super.milk=75;
        super.coffee=20;
        super.cost=7;
    }
}

class Cappuccino extends Coffee{

    Cappuccino(){
        super();
        super.water=200;
        super.milk=100;
        super.coffee=12;
        super.cost=6;
    }
}

class Machine{
    private int waterInMachine;
    private int milkInMachine;
    private int coffeeInMachine;
    private int cupsInMachine;
    private int moneyInMachine;

    Machine(int waterInMachine, int milkInMachine, int coffeeInMachine, int cupsInMachine, int moneyInMachine){
        this.waterInMachine=waterInMachine;
        this.milkInMachine=milkInMachine;
        this.coffeeInMachine=coffeeInMachine;
        this.cupsInMachine=cupsInMachine;
        this.moneyInMachine=moneyInMachine;
    }

    public void stan(){
        System.out.printf("\nThe coffee machine has:\n%d of water\n%d of milk\n%d of coffee beans\n%d of disposable cups\n$%d of money\n\n",
                waterInMachine, milkInMachine, coffeeInMachine, cupsInMachine, moneyInMachine);
    }

    public void fill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWrite how many ml of water do you want to add:");
        waterInMachine+= scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milkInMachine+= scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeInMachine+= scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cupsInMachine+= scanner.nextInt();
        System.out.println("");
    }

    public void buy(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String action = scanner.next();

        switch(action){
            case "1":
                Coffee espresso = new Espresso();
                make(espresso);
                break;
            case "2":
                Coffee latte = new Latte();
                make(latte);
                break;
            case "3":
                Coffee cappuccino = new Cappuccino();
                make(cappuccino);
                break;
            case "back":
                break;
        }
    }

    public void make(Coffee coffee){

        if(check(coffee))
        {
            waterInMachine-=coffee.water;
            milkInMachine-=coffee.milk;
            coffeeInMachine-=coffee.coffee;
            cupsInMachine--;
            moneyInMachine+=coffee.cost;
            System.out.println("I have enough resources, making you a coffee!\n");
        }
        else
        {
            String str = waterInMachine<coffee.water? "water" : (milkInMachine<coffee.milk? "milk" : (coffeeInMachine<coffee.coffee? "coffee beans" : (cupsInMachine<1 ? "disposable cups" : "nothing")));
            System.out.println("Sorry, not enough "+str+"\n\n");
        }
    }

    public void take(){
        System.out.println("I gave you $"+moneyInMachine+"\n");
        moneyInMachine=0;
    }
    public boolean check(Coffee coffee){
        return waterInMachine>=coffee.water && milkInMachine>=coffee.milk && coffeeInMachine>=coffee.coffee && cupsInMachine>=1;
    }


}

public class CoffeeMachine {
    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine(400, 540, 120, 9, 550);


        boolean exit = false;

        while(!exit){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            switch(scanner.next()){
                case "buy":
                    machine.buy();
                    break;
                case "fill":
                    machine.fill();
                    break;
                case "take":
                    machine.take();
                    break;
                case "remaining":
                    machine.stan();
                    break;
                case "exit":
                    exit=true;
                    break;
            }
        }

    }

}