package inheritanceAndPolymorphism_06_02;

public class Main {
    public static void main(String[] args) {
        DepositCount loDepositCount = new DepositCount();

        CardCount loCardCount = new CardCount();

        //Внести деньги на депозитный счет
        loDepositCount.makeMoney(4000);

        //Передать деньги на карточный счет
        if (loDepositCount.send(loCardCount, 1500)) {
            System.out.println("Деньги успешно переведены на карточный счет");
        }

        //Передать деньги на депозитный счет
        if (loCardCount.send(loDepositCount, 1000)) {
            System.out.println("Деньги успешно переведены на депозитный счет");
        }
    }
}