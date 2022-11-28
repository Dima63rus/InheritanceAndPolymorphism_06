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
public class LegalEntity extends BankAccount {
    private double mvSumOnCount;

    @Override
    public void showInfo() {
        System.out.println("������� ����������: " + "���������� ���������� ��� ��������.");
        System.out.println("������� ������: " + "������ � ��������� 1%.");
        System.out.println("������: " + mvSumOnCount);
    }

    //    /* ������ - 1%. */
    protected Boolean withdrawMoney(double ivSum) {
        if (mvSumOnCount < ivSum) {
            System.out.println("����� �� ����� ������ ��� ������������� �����");
            return false;
        } else {
            //�������� 1% �� ������
            //������ 1% �� ���������� �����
            double lvProc = calcProc(ivSum);
            if (checkSumRestAfterTakeProc(mvSumOnCount, ivSum, lvProc)) {
                //����� 1%
                mvSumOnCount = mvSumOnCount - ivSum - lvProc;
                return true;
            } else {
                System.out.println("����� ����� ������ �������� < 0");
                System.out.println("������ �������� ������� ����������");
                return false;
            }
        }
    }

    /* ������� �� ���� ����� ����� (��� ��������). */
    protected void makeMoney(double ivSum) {
        mvSumOnCount += ivSum;
    }

//    /* �������� ������� �� �����. */
//    protected double getRestMoney() {
//        return 0.0d;
//    }

    //������ 1% �� ���������� �����
    private double calcProc(double ivSum) {
        return ivSum * 0.01;
    }

    /*  �������� �� ������� ����� ����� ������ 1% */
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
