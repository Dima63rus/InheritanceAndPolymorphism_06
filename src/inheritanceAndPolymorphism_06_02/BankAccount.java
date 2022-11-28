package inheritanceAndPolymorphism_06_02;
/*
���� �������
������� �� �������� ������������ �������.
��� ����� �������
1. �������� ����� BankAccount, ������� ������������ ����� ��������� ���� � �����. � ������ ���������� �������� ������:
     a. ����� �� ����� ����� ����� (��� ��������).
     b. ������� �� ���� ����� ����� (��� ��������).
     c. �������� ������� �� �����.
2. �������� ��� ������ ����������, ����������� ������ � �������� �� �����:
�	���������� ��������� ����, � �������� ������ ������� ������ � ������� ������ ����� ���������� ��������.
�	��������� ����, ��� ������ ����� � �������� ����� ��������� �������� 1%.
 */

public class BankAccount extends Client {
    /* ����� �� ����� ����� ����� (��� ��������). */
    protected Boolean withdrawMoney(double ivSum) {
        return false;
    }

    /* ������� �� ���� ����� ����� (��� ��������). */
    protected void makeMoney(double ivSum) {
    }

    /* �������� ������� �� �����. */
    protected double getRestMoney() {
        return 0.0d;
    }

    /* ��� �������� ����� � ������ ����� �� ������.
       ����� ������ ������� true, ���� ������ ������� ����������. */
    protected boolean send(BankAccount ioReceiver, double ivAmount) {
        return false;
    }

    @Override
    public void showInfo() {
    }
}