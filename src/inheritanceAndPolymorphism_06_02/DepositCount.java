package inheritanceAndPolymorphism_06_02;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
2. �������� ��� ������ ����������, ����������� ������ � �������� �� �����:
	���������� ��������� ����, � �������� ������ ������� ������ � ������� ������
	����� ���������� ��������.
 */
public class DepositCount extends BankAccount {
    private double mvSumOnCount;

    private Date mvDateMakeMoney;

    /* ����� �� ����� ����� ����� (��� ��������).
    ���������� ��������� ����, � �������� ������ ������� ������ � ������� ������
    ����� ���������� ��������.
     */
    public Boolean withdrawMoney(double ivSum) {
        if (mvSumOnCount < ivSum) {
            System.out.println("������������ ����� �� ���������� �����");
            return false;
        } else {
            //�������� �� ���� ��������(������ ������ �����)
            if (checkDate(mvDateMakeMoney)) {
                mvSumOnCount -= ivSum;
                return true;
            } else {
                System.out.println("����� �������� ����� �� ������ �����");
                System.out.println("����� ����� ����������");
                return false;
            }
        }
    }

    /* ������� �� ���� ����� ����� (��� ��������). */
    public void makeMoney(double ivSum) {
        mvSumOnCount += ivSum;

        //�������� ���� �������� ����� �� ���������� ����
        mvDateMakeMoney = getDateMake();
    }

    /* �������� ������� �� �����. */
    public double getRestMoney() {
        return mvSumOnCount;
    }

    /* ��� �������� ����� � ������ ����� �� ������.
   ����� ������ ������� true, ���� ������ ������� ����������. */
    public boolean send(BankAccount ioReceiver, double ivAmount) {
        //����� ����� � ����������� �����
        if (withdrawMoney(ivAmount)) {
            //�������� ������ �� ��������� ����
            ioReceiver.makeMoney(ivAmount);
            System.out.println("������� �� ���������� �����: " + getRestMoney());
            return true;
        } else {
            System.out.println("�������� ����� � ����������� ����� �� ��������� ����������");
            System.out.println("������� �� ���������� �����: " + getRestMoney());
            return false;
        }
    }

    /* �������� ���� �������� ����� �� ���������� ���� */
    private Date getDateMake() {
        return new Date();
    }

    /* ������� ������� ����� ����� ��������/������  */
    private Boolean checkDate(Date ivDateLoad) {
        Date lvCurrent = new Date();

        //������������
        long lvMilliSec = lvCurrent.getTime() - ivDateLoad.getTime();

        // 24 ���� = 1 440 ����� = 1 ����
        int lvDays = (int) (lvMilliSec / (24 * 60 * 60 * 1000));

        if (lvDays < 30) {
            return false;
        } else {
            return true;
        }
    }
}