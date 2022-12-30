
package main.Managers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import main.entities.Person;
import main.entities.Student;


public class MManager implements PManager{
    public void kayitekle(Student s) throws IOException {

        FileOutputStream ogrencikayit = new FileOutputStream(s.okulNo + ".txt");
        FileOutputStream ogrencidevamsizlik = new FileOutputStream(s.okulNo + "-devamsizlik.txt");
        FileOutputStream ogrencinot = new FileOutputStream(s.okulNo + "-notlar.txt");
        OutputStreamWriter write = new OutputStreamWriter(ogrencikayit, "UTF-8");
        write.write(s.ad_soyad + ",");
        write.write(s.password+",");
        write.write(s.tcKimlik+",");
        write.write(s.grade);
        write.close();
    }

    public void kayitsil(String okulNo) throws IOException {
        Files.delete(Paths.get(okulNo + ".txt"));
        Files.delete(Paths.get(okulNo+"-devamsizlik.txt"));
        Files.delete(Paths.get(okulNo+"-notlar.txt"));
    }

    public void devamsizlikgir(String okulNo, String tarih) throws FileNotFoundException, IOException {
        File devam=new File(okulNo+"-devamsizlik.txt");
        FileWriter fw = new FileWriter(devam,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(tarih+";");
        bw.newLine();
        bw.close();
    }

    @Override
    public void changepassword(Person name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
