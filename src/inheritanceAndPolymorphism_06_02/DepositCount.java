package inheritanceAndPolymorphism_06_02;

import java.util.Date;

/*
2. Создайте два класса наследника, расширяющие работу с остатком на счёте:
	Депозитный расчётный счёт, с которого нельзя снимать деньги в течение месяца
	после последнего внесения.
 */
public class DepositCount extends BankAccount {
    private double mvSumOnCount;

    private Date mvDateMakeMoney;

    /* Снять со счёта сумму денег (без комиссии).
    Депозитный расчётный счёт, с которого нельзя снимать деньги в течение месяца
    после последнего внесения.
     */
    protected Boolean withdrawMoney(double ivSum) {
        if (mvSumOnCount < ivSum) {
            System.out.println("Недостаточно денег на депозитном счете");
            return false;
        } else {
            //Проверка на дату внесения(должен пройти месяц)
            if (checkDate(mvDateMakeMoney)) {
                mvSumOnCount -= ivSum;
                return true;
            } else {
                System.out.println("После внесения денег не прошел месяц");
                System.out.println("Снять сумму невозможно");
                return false;
            }
        }
    }

    /* Вносить на счёт сумму денег (без комиссии). */
    protected void makeMoney(double ivSum) {
        mvSumOnCount += ivSum;

        //Получить дату внесения денег на депозитный счет
        mvDateMakeMoney = getDateMake();
    }

    /* Получить остаток на счёте. */
    protected double getRestMoney() {
        return mvSumOnCount;
    }

    /* Для отправки денег с одного счёта на другой.
   Метод должен вернуть true, если деньги успешно переведены. */
    protected boolean send(BankAccount ioReceiver, double ivAmount) {
        //Снять сумму с депозитного счета
        if (withdrawMoney(ivAmount)) {
            //Положить деньги на карточный счет
            ioReceiver.makeMoney(ivAmount);
            System.out.println("Остаток на депозитном счету: " + getRestMoney());
            return true;
        } else {
            System.out.println("Отправка денег с депозитного счета на карточный невозможна");
            System.out.println("Остаток на депозитном счете: " + getRestMoney());
            return false;
        }
    }

    /* Получить дату внесения денег на депозитный счет */
    private Date getDateMake() {
        return new Date();
    }

    /* Подсчет времени между датой внесения/снятия  */
    private Boolean checkDate(Date ivDateLoad) {
        Date lvCurrent = new Date();

        //Миллисекунды
        long lvMilliSec = lvCurrent.getTime() - ivDateLoad.getTime();

        // 24 часа = 1 440 минут = 1 день
        int lvDays = (int) (lvMilliSec / (24 * 60 * 60 * 1000));

        if (lvDays < 30) {
            return false;
        } else {
            return true;
        }
    }
}