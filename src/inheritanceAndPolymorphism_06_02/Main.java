package inheritanceAndPolymorphism_06_02;

public class Main {
    public static void main(String[] args) {
        DepositCount loDepositCount = new DepositCount();

        CardCount loCardCount = new CardCount();

        //������ ������ �� ���������� ����
        loDepositCount.makeMoney(4000);

        //�������� ������ �� ��������� ����
        if (loDepositCount.send(loCardCount, 1500)) {
            System.out.println("������ ������� ���������� �� ��������� ����");
        }

        //�������� ������ �� ���������� ����
        if (loCardCount.send(loDepositCount, 1000)) {
            System.out.println("������ ������� ���������� �� ���������� ����");
        }
    }
}