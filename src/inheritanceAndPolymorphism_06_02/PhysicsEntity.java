package inheritanceAndPolymorphism_06_02;

/*
1. �������� ������, �������������� �������� �����: ����������� ����� Client, ������ ��� ���������� ���,
 ����������� ��� � �������������� ����������������.
        � ������� ������� ���� ����� ����� �� ����� (�����). ������ ����� �������� �� ����,
         ����� � ������� ������� �� �����. ������ ����� ������ ��������� �����,
         ������� ������� ���������� � ������� � �����: ������� ����������, ������� ������ � ������.

2. ���������� ������, ��� �������:
	� ���������� ��� ���������� � ������ ���������� ��� ��������.
	� ����������� ��� � ������ � ��������� 1%.
	� �� � ���������� � ��������� 1%, ���� ����� ������ 1000 ������.
	� � ��������� 0,5%, ���� ����� ������ ���� ����� 1000 ������.
*/
public class PhysicsEntity extends BankAccount {
    private double mvSumOnCount;

    @Override
    public void showInfo() {
        System.out.println("������� ����������: " + "���������� ���������� ��� ��������.");
        System.out.println("������� ������: " + "������ ���������� ��� ��������.");
        System.out.println("������: " + mvSumOnCount);
    }

    /* ����� �� ����� ����� ����� (��� ��������). */
    protected Boolean withdrawMoney(double ivSum) {
        if (mvSumOnCount < ivSum) {
            System.out.println("������������ ����� �� ���������� �����");
            return false;
        } else {
            mvSumOnCount -= ivSum;
            return true;
        }
    }

    /* ������� �� ���� ����� ����� (��� ��������). */
    protected void makeMoney(double ivSum) {
        mvSumOnCount += ivSum;
    }

    /* �������� ������� �� �����. */
    protected double getRestMoney() {
        return 0.0d;
    }
}
