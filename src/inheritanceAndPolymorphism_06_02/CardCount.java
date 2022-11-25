package inheritanceAndPolymorphism_06_02;

/*
2. Создайте два класса наследника, расширяющие работу с остатком на счёте:
	Карточный счёт, при снятии денег с которого будет взиматься комиссия 1%.
 */
public class CardCount extends BankAccount {
    private double mvSumOnCount;

    /* Снять со счёта сумму денег (без комиссии). */
    public Boolean withdrawMoney(double ivSum) {
        if (mvSumOnCount < ivSum) {
            System.out.println("Денег на счете меньше чем запрашиваемая сумма");
            return false;
        } else {
            //Комиссия 1% на снятие
            //Расчет 1% от вычитаемой суммы
            double lvProc = calcProc(ivSum);
            if (checkSumRestAfterTakeProc(mvSumOnCount, ivSum, lvProc)) {
                //Взять 1%
                mvSumOnCount = mvSumOnCount - ivSum - lvProc;
                return true;
            } else {
                System.out.println("Сумма после вычита процента < 0");
                System.out.println("Снятие денежных средств невозможно");
                return false;
            }
        }
    }

    /* Вносить на счёт сумму денег (без комиссии). */
    public void makeMoney(double ivSum) {
        mvSumOnCount += ivSum;
    }

    /* Получить остаток на счёте. */
    public double getRestMoney() {
        return mvSumOnCount;
    }

    /* Для отправки денег с одного счёта на другой.
       Метод должен вернуть true, если деньги успешно переведены. */
    public boolean send(BankAccount ioReceiver, double ivAmount) {
        //Снять деньги с карточного счета
        if (withdrawMoney(ivAmount)) {
            //Положить деньги на депозитный счет
            ioReceiver.makeMoney(ivAmount);

            return true;
        } else {
            System.out.println("Денег на карточном счете не достаточно для снятия");
            return true;
        }
    }

    //Расчет 1% от вычитаемой суммы
    private double calcProc(double ivSum) {
        return ivSum * 0.01;
    }

    /*  Проверка на остаток суммы после вычета 1% */
    private Boolean checkSumRestAfterTakeProc(double ivSumOnCount,
                                              double ivSum,
                                              double ivProc) {
        if ((ivSumOnCount - ivSum + ivProc) >= 0) {
            return true;
        } else {
            return false;
        }
    }
}