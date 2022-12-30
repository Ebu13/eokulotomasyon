/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.Managers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import main.entities.Person;

/**
 *
 * @author Ebubekir
 */
public class MTeacher implements PManager{
    public void notgir(String okulNo, String[] not,String branch) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        File notfile=new File(okulNo+"-notlar.txt");
        FileWriter fw = new FileWriter(notfile,true);
        BufferedWriter write = new BufferedWriter(fw);
        write.write(branch+";");
        write.write(not[0]+",");
        write.write(not[1]+",");
        write.write(not[2]+",");
        write.write(not[3]+",");
        write.write(not[4]+"!");
        write.close();
    }

    @Override
    public void changepassword(Person p) {
        
    }

}
