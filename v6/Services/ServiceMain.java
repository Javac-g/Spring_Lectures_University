package com.MAX.v6.Services;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServiceMain {
    List<ResponseDTO> datalist = new ArrayList<>();

    public String print(String msg){
        return msg;
    }
    public void log(String type,ResponseDTO user){
        byte[] data = ("\nType: " + type + "\nDate: " + java.time.Clock.systemUTC().millis() +  "\nName: " + user.getName()).getBytes();
        String str = "\nID: " + user.getId();

        try(FileOutputStream fileOutputStream = new FileOutputStream("log.txt",true);
            ByteOutputStream byteOutputStream = new ByteOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){

            byteOutputStream.write(data);
            byteOutputStream.writeTo(fileOutputStream);
            dataOutputStream.writeUTF(str);



        }catch (IOException e){

            e.printStackTrace();

        }
    }
}
