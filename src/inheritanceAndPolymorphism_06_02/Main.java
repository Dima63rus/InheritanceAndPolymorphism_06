package inheritanceAndPolymorphism_06_02;

public class Main {
    public static void main(String[] args) {

//У физических лиц пополнение и снятие происходит без комиссии.
        PhysicsEntity loPhysicsEntity = new PhysicsEntity();
        //Пополнить
        loPhysicsEntity.makeMoney(1000);
        //Баланс
        loPhysicsEntity.showInfo();

        //Снять
        if (loPhysicsEntity.withdrawMoney(300)) {
            System.out.println("Снятие успешно!");
        }
        //Баланс
        loPhysicsEntity.showInfo();


//У юридических лиц — снятие с комиссией 1%.
        LegalEntity loLegalEntity = new LegalEntity();
        //Пополнить
        loLegalEntity.makeMoney(1000);
        //Баланс
        loLegalEntity.showInfo();

        //Снять
        if (loLegalEntity.withdrawMoney(300)) {
            System.out.println("Снятие успешно!");
        }
        //Баланс
        loLegalEntity.showInfo();


//У ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей
//      И с комиссией 0,5%, если сумма больше либо равна 1000 рублей
        IndividualEntity loIndividualEntity = new IndividualEntity();

        //Пополнить
        loIndividualEntity.makeMoney(1000);

        //Баланс
        loIndividualEntity.showInfo();
    }
}