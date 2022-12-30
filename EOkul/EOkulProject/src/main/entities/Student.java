package main.entities;

import java.util.List;
import java.util.Map;

public class Student extends Person {

    public Map<String, int[]> notlistesi;
    public String okulNo;
    public String grade;
    public List<String> devamsizlik;

    public Student(String okulNo, String adsoyad, String password, String tckimlik,String grade) {
        super.ad_soyad = adsoyad;
        super.password = password;
        super.tcKimlik = tckimlik;
        this.okulNo = okulNo;
        this.grade=grade;
    }

}
