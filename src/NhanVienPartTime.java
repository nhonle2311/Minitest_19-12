import java.util.Arrays;
import java.util.Scanner;

public class NhanVienPartTime extends NhanVien{
    private double timeWords;

    public NhanVienPartTime(String ID, String lastName, String firstName, int age, String phone, String email, double timWords) {
        super(ID, lastName, firstName, age, phone, email);
        this.timeWords = timeWords;
    }

    public NhanVienPartTime() {

    }

    public double getTimWords() {
        return timeWords;
    }

    public void setTimWords(double timWords) {
        this.timeWords = timWords;
    }
    public double getHardSalaryPartTim(){
        return this.timeWords * 100000;
    }

}
