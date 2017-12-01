package cn.com.edzleft.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ASUS on 2017/11/29.
 */
public class file {
    public static String readFile(String fileName) {
        String output = "";

        File file = new File(fileName);

        if(file.exists()){
            if(file.isFile()){
                try{
                    BufferedReader input = new BufferedReader (new FileReader(file));
                    StringBuffer buffer = new StringBuffer();
                    String text;

                    while((text = input.readLine()) != null)
                        buffer.append(text +"/n");

                    output = buffer.toString();
                }
                catch(IOException ioException){
                    System.err.println("File Error!");

                }
            }
            else if(file.isDirectory()){
                String[] dir = file.list();
                output += "Directory contents:/n";

                for(int i=0; i<dir.length; i++){
                    output += dir[i] +"/n";
                }
            }
        }
        else{
            System.err.println("Does not exist!");
        }
        return output;
    }

    public static void main (String args[]){
        String  str = readFile("47.104.103.141/usr/local/apache-tomcat-7.0.79/RUNNING.txt");

        System.out.print(str);
    }
}
