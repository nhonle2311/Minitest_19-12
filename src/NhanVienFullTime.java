import java.util.Arrays;
import java.util.Scanner;

public class NhanVienFullTime extends NhanVien {
    private double bonus;
    private double mulct;
    private double hardSalary;
    public NhanVienFullTime(String ID, String lastName, String firstName, int age, String phone, String email, double bonus, double mulct, double hardSalary) {
        super(ID, lastName, firstName, age, phone, email);
        this.bonus = bonus;
        this.mulct = mulct;
        this.hardSalary = hardSalary;
    }
    public NhanVienFullTime(){

    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getMulct() {
        return mulct;
    }

    public void setMulct(double mulct) {
        this.mulct = mulct;
    }

    public double getHardSalary() {
        return this.hardSalary;
    }


    public void setHardSalary(double hardSalary) {
        this.hardSalary = hardSalary;
    }


    @Override
    public String toString() {
        return "NhanVienFullTime{" + super.toString() +
                "bonus=" + bonus +
                ", mulct=" + mulct +
                ", hardSalary=" + hardSalary +
                '}';
    }

    public double getSalary() {
        return getHardSalary() + (getBonus() - getMulct());
    }


}
