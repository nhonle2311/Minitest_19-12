import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhâp số nhân viên FullTime ");
        int n = scanner.nextInt();
        NhanVienFullTime[] nhanVienFullTimes = new NhanVienFullTime[n];

        for (int i = 0; i < n; i++) {
            nhanVienFullTimes[i] = new NhanVienFullTime();
            scanner.nextLine();
            System.out.println("id");
            nhanVienFullTimes[i].setID(scanner.nextLine());
            System.out.println("LastName");
            nhanVienFullTimes[i].setLastName(scanner.nextLine());
            System.out.println("FirstName");
            nhanVienFullTimes[i].setFirstName(scanner.nextLine());
            System.out.println("Age");
            nhanVienFullTimes[i].setAge(scanner.nextInt());
            System.out.println("Phone");
            nhanVienFullTimes[i].setPhone(scanner.nextLine());
            System.out.println("Email");
            nhanVienFullTimes[i].setEmail(scanner.nextLine());
            System.out.println("Bonus");
            nhanVienFullTimes[i].setBonus(scanner.nextDouble());
            System.out.println("Mulct");
            nhanVienFullTimes[i].setMulct(scanner.nextDouble());
            System.out.println("HardSalary");
            nhanVienFullTimes[i].setHardSalary(scanner.nextDouble());

        }
        System.out.println(Arrays.toString(nhanVienFullTimes));

        System.out.println("nhập số nhân viên partTime");
        int m = scanner.nextInt();
        NhanVienPartTime[] nhanVienPartTimes = new NhanVienPartTime[m];
        for (int i = 0; i < m; i++) {
            nhanVienPartTimes[i] = new NhanVienPartTime();
            scanner.nextLine();
            System.out.println("id");
            nhanVienPartTimes[i].setID(scanner.nextLine());
            System.out.println("LastName");
            nhanVienPartTimes[i].setLastName(scanner.nextLine());
            System.out.println("FirstName");
            nhanVienPartTimes[i].setFirstName(scanner.nextLine());
            System.out.println("Age");
            nhanVienPartTimes[i].setAge(scanner.nextInt());
            System.out.println("Phone");
            nhanVienPartTimes[i].setPhone(scanner.nextLine());
            System.out.println("Email");
            nhanVienPartTimes[i].setEmail(scanner.nextLine());
            System.out.println("TimeWords");
            nhanVienPartTimes[i].setTimWords(scanner.nextDouble());

        }
        System.out.println(Arrays.toString(nhanVienPartTimes));
        System.out.println("Menu");
        System.out.println("1. Tính lương trung bình nhân viên công ty");
        System.out.println("2. Tính lương trung bình nhân viên fulltime ");
        System.out.println("3. Tính lương trung bình nhân viên parttime ");
        System.out.println("4. Tính tổng lương phải trả cho nhân viên parttime");
        System.out.println("5. Đếm số người có mức lương cao hơn mức lương trung bình toàn công ty");
        System.out.println("6. Đếm số nhân viên partime có tên được nhập vào từ bàn phím");
        System.out.println("0. Exit");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                double allAverage = getAllAverage(nhanVienFullTimes, n, nhanVienPartTimes, m);
                System.out.println("Trung bình lương nhân viên công ty " + allAverage);
                break;
            case 2:
                double averageFullTime = getAverageFullTime(nhanVienFullTimes, n);
                System.out.println("Trung bình lương nhân viên fullTime " + averageFullTime);
                break;
            case 3:
                double averagePartTime = getAveragePartTime(nhanVienPartTimes, m);
                System.out.println("Trung bình lương nhân viên partTime " + averagePartTime);
                break;
            case 4:
                double sumSalaryAll = getSumSalaryAll(nhanVienFullTimes, nhanVienPartTimes);
                System.out.println("tổng lương phải trả " + sumSalaryAll);
                break;
            case 5:
                int countAll = getCountAll(nhanVienFullTimes, n, nhanVienPartTimes, m);
                System.out.println("số nhân viên có lương cao hơn trung bình " + countAll);
                break;
            case 6:
                System.out.println("số nhân viên partTime được nhaap vào từ bàn phím " + m);
                break;
            case 0:
                break;
        }
    }

    private static int getCountAll(NhanVienFullTime[] nhanVienFullTimes, int n, NhanVienPartTime[] nhanVienPartTimes, int m) {
        double allAverages = getAllAverage(nhanVienFullTimes, n, nhanVienPartTimes, m);

        int countFullTime = getCountFullTime(nhanVienFullTimes, allAverages);
        int countPartTime = getCountPartTime(nhanVienPartTimes, allAverages);
        return countPartTime + countFullTime;
    }

    private static int getCountPartTime(NhanVienPartTime[] nhanVienPartTimes, double allAverages) {
        int countPartTime = 0;
        for (NhanVienPartTime salaryPersonPartTime : nhanVienPartTimes){
            if (salaryPersonPartTime.getHardSalaryPartTim() > allAverages){
                countPartTime++;
            }
        }
        return countPartTime;
    }

    private static int getCountFullTime(NhanVienFullTime[] nhanVienFullTimes, double allAverages) {
        int countFullTime = 0;
        for (NhanVienFullTime salaryPersonFullTime : nhanVienFullTimes){
             if (salaryPersonFullTime.getHardSalary() > allAverages){
                 countFullTime++;
             }
        }
        return countFullTime;
    }


    private static double getSumSalaryAll(NhanVienFullTime[] nhanVienFullTimes, NhanVienPartTime[] nhanVienPartTimes) {
        double sumFullTime = getSumFullTime(nhanVienFullTimes);
        double sumPartTime = getSumPartTime(nhanVienPartTimes);
        return sumFullTime + sumPartTime;
    }

    private static double getSumPartTime(NhanVienPartTime[] nhanVienPartTimes) {
        double sumPartTime = 0;
        for (NhanVienPartTime sumSalary: nhanVienPartTimes){
            sumPartTime +=sumSalary.getHardSalaryPartTim();
        }
        return sumPartTime;
    }

    private static double getSumFullTime(NhanVienFullTime[] nhanVienFullTimes) {
        double sumFullTime = 0;
        for (NhanVienFullTime sumSalary : nhanVienFullTimes){
            sumFullTime += sumSalary.getHardSalary();
        }
        return sumFullTime;
    }

    private static double getAllAverage(NhanVienFullTime[] nhanVienFullTimes, int n, NhanVienPartTime[] nhanVienPartTimes, int m) {
        double averageFullTime = getAverageFullTime(nhanVienFullTimes, n);
        double averagePartTime = getAveragePartTime(nhanVienPartTimes, m);
        return (averageFullTime + averagePartTime) / 2;
    }

    private static double getAveragePartTime(NhanVienPartTime[] nhanVienPartTimes, int m) {
        double averagePartTime = 0;
        for (NhanVienPartTime partTime : nhanVienPartTimes){
            averagePartTime += partTime.getHardSalaryPartTim() / m;
        }
        return averagePartTime;
    }

    private static double getAverageFullTime(NhanVienFullTime[] nhanVienFullTimes, int n) {
        double averageFullTime = 0;
        for (NhanVienFullTime fullTime : nhanVienFullTimes){
            averageFullTime += fullTime.getSalary() / n;
        }
        return averageFullTime;
    }
}