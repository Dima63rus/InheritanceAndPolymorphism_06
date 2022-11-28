package inheritanceAndPolymorphism_06_02;

/*
1. Создайте классы, представляющие клиентов банка: абстрактный класс Client, классы для физических лиц,
 юридических лиц и индивидуальных предпринимателей.
        У каждого клиента есть сумма денег на счету (число).
        Деньги можно положить на счёт, снять и вернуть остаток на счёте.
        Каждый класс должен содержать метод,
         который выводит информацию в консоль о счёте: условие пополнения, условие снятия и баланс.

2. Реализуйте методы, при которых:
	У физических лиц пополнение и снятие происходит без комиссии.
	У юридических лиц — снятие с комиссией 1%.
	У ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей.И с комиссией 0,5%, если сумма больше либо
	  равна 1000 рублей.
*/
public class IndividualEntity extends BankAccount {
    private double mvSumOnCount;

    @Override
    public void showInfo() {
        System.out.println("Условия пополнения: " + "\n\tПополнение с комиссией 1% если сумма меньше 1000 рублей");
        System.out.println("\n\tПополнение с комиссией 0,5%, если сумма больше либо равна 1000 рублей");
        System.out.println("Условия снятия: " + "Снятие происходит без комиссии.");
        System.out.println("Баланс: " + mvSumOnCount);
    }

//    /* Снять со счёта сумму денег (без комиссии). */
//    protected Boolean withdrawMoney(double ivSum) {
//        return false;
//    }
//
    /* Вносить на счёт сумму денег.
       Пополнение с комиссией 1%, если сумма меньше 1000 рублей
       И с комиссией 0,5%, если сумма больше либо равна 1000 рублей. */
    protected void makeMoney(double ivSum) {
        if (ivSum < 1000) {
            //Пополнение с комиссией 1%
            double lvProc = getProc(ivSum, 0.01);

            mvSumOnCount += ivSum + lvProc;
        } else if (ivSum >= 1000) {
            //И с комиссией 0,5%
            double lvProc = getProc(ivSum, 0.005);

            mvSumOnCount += ivSum + lvProc;
        }
    }

//    /* Получить остаток на счёте. */
//    protected double getRestMoney() {
//        return 0.0d;
//    }

    private double getProc(double ivSum, double ivProcCoef) {
        return ivSum * ivProcCoef;
    }
}
