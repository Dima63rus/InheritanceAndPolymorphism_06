package inheritanceAndPolymorphism_06_02;

/*
2. �������� ��� ������ ����������, ����������� ������ � �������� �� �����:
	��������� ����, ��� ������ ����� � �������� ����� ��������� �������� 1%.
 */
public class CardCount extends BankAccount {
    private double mvSumOnCount;

    /* ����� �� ����� ����� ����� (��� ��������). */
    public Boolean withdrawMoney(double ivSum) {
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
    public void makeMoney(double ivSum) {
        mvSumOnCount += ivSum;
    }

    /* �������� ������� �� �����. */
    public double getRestMoney() {
        return mvSumOnCount;
    }

    /* ��� �������� ����� � ������ ����� �� ������.
       ����� ������ ������� true, ���� ������ ������� ����������. */
    public boolean send(BankAccount ioReceiver, double ivAmount) {
        //����� ������ � ���������� �����
        if (withdrawMoney(ivAmount)) {
            //�������� ������ �� ���������� ����
            ioReceiver.makeMoney(ivAmount);

            return true;
        } else {
            System.out.println("����� �� ��������� ����� �� ���������� ��� ������");
            return true;
        }
    }

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