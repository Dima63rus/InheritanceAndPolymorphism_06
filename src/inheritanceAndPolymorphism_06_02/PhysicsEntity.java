package inheritanceAndPolymorphism_06_02;

/*
1. Создайте классы, представляющие клиентов банка: абстрактный класс Client, классы для физических лиц,
 юридических лиц и индивидуальных предпринимателей.
        У каждого клиента есть сумма денег на счету (число). Деньги можно положить на счёт,
         снять и вернуть остаток на счёте. Каждый класс должен содержать метод,
         который выводит информацию в консоль о счёте: условие пополнения, условие снятия и баланс.

2. Реализуйте методы, при которых:
	У физических лиц пополнение и снятие происходит без комиссии.
	У юридических лиц — снятие с комиссией 1%.
	У ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей.
	И с комиссией 0,5%, если сумма больше либо равна 1000 рублей.
*/
public class PhysicsEntity extends BankAccount {
    private double mvSumOnCount;

    @Override
    public void showInfo() {
        System.out.println("Условия пополнения: " + "Пополнение происходит без комиссии.");
        System.out.println("Условия снятия: " + "Снятие происходит без комиссии.");
        System.out.println("Баланс: " + mvSumOnCount);
    }

    /* Снять со счёта сумму денег (без комиссии). */
    protected Boolean withdrawMoney(double ivSum) {
        if (mvSumOnCount < ivSum) {
            System.out.println("Недостаточно денег на депозитном счете");
            return false;
        } else {
            mvSumOnCount -= ivSum;
            return true;
        }
    }

    /* Вносить на счёт сумму денег (без комиссии). */
    protected void makeMoney(double ivSum) {
        mvSumOnCount += ivSum;
    }

    /* Получить остаток на счёте. */
    protected double getRestMoney() {
        return 0.0d;
    }
}
