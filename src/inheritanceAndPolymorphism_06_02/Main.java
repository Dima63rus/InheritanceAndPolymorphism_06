package inheritanceAndPolymorphism_06_02;

public class Main {
    public static void main(String[] args) {

//� ���������� ��� ���������� � ������ ���������� ��� ��������.
        PhysicsEntity loPhysicsEntity = new PhysicsEntity();
        //���������
        loPhysicsEntity.makeMoney(1000);
        //������
        loPhysicsEntity.showInfo();

        //�����
        if (loPhysicsEntity.withdrawMoney(300)) {
            System.out.println("������ �������!");
        }
        //������
        loPhysicsEntity.showInfo();


//� ����������� ��� � ������ � ��������� 1%.
        LegalEntity loLegalEntity = new LegalEntity();
        //���������
        loLegalEntity.makeMoney(1000);
        //������
        loLegalEntity.showInfo();

        //�����
        if (loLegalEntity.withdrawMoney(300)) {
            System.out.println("������ �������!");
        }
        //������
        loLegalEntity.showInfo();


//� �� � ���������� � ��������� 1%, ���� ����� ������ 1000 ������
//      � � ��������� 0,5%, ���� ����� ������ ���� ����� 1000 ������
        IndividualEntity loIndividualEntity = new IndividualEntity();

        //���������
        loIndividualEntity.makeMoney(1000);

        //������
        loIndividualEntity.showInfo();
    }
}