package inheritanceAndPolymorphism_06_02;

/*
1. �������� ������, �������������� �������� �����: ����������� ����� Client, ������ ��� ���������� ���,
 ����������� ��� � �������������� ����������������.
        � ������� ������� ���� ����� ����� �� ����� (�����).
        ������ ����� �������� �� ����, ����� � ������� ������� �� �����.
        ������ ����� ������ ��������� �����,
         ������� ������� ���������� � ������� � �����: ������� ����������, ������� ������ � ������.

2. ���������� ������, ��� �������:
	� ���������� ��� ���������� � ������ ���������� ��� ��������.
	� ����������� ��� � ������ � ��������� 1%.
	� �� � ���������� � ��������� 1%, ���� ����� ������ 1000 ������.� � ��������� 0,5%, ���� ����� ������ ����
	  ����� 1000 ������.
*/
public class IndividualEntity extends BankAccount {
    private double mvSumOnCount;

    @Override
    public void showInfo() {
        System.out.println("������� ����������: " + "\n\t���������� � ��������� 1% ���� ����� ������ 1000 ������");
        System.out.println("\n\t���������� � ��������� 0,5%, ���� ����� ������ ���� ����� 1000 ������");
        System.out.println("������� ������: " + "������ ���������� ��� ��������.");
        System.out.println("������: " + mvSumOnCount);
    }

//    /* ����� �� ����� ����� ����� (��� ��������). */
//    protected Boolean withdrawMoney(double ivSum) {
//        return false;
//    }
//
    /* ������� �� ���� ����� �����.
       ���������� � ��������� 1%, ���� ����� ������ 1000 ������
       � � ��������� 0,5%, ���� ����� ������ ���� ����� 1000 ������. */
    protected void makeMoney(double ivSum) {
        if (ivSum < 1000) {
            //���������� � ��������� 1%
            double lvProc = getProc(ivSum, 0.01);

            mvSumOnCount += ivSum + lvProc;
        } else if (ivSum >= 1000) {
            //� � ��������� 0,5%
            double lvProc = getProc(ivSum, 0.005);

            mvSumOnCount += ivSum + lvProc;
        }
    }

//    /* �������� ������� �� �����. */
//    protected double getRestMoney() {
//        return 0.0d;
//    }

    private double getProc(double ivSum, double ivProcCoef) {
        return ivSum * ivProcCoef;
    }
}
