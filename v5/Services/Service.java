package com.MAX.v5.Services;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    List<ResponseDTO> datalist = new ArrayList<>();

    public String print(String msg){
        return msg;
    }

    public void log(String type,ResponseDTO user){
        byte[] data = ("\nType: " + type + "\nName: " + user.getName()).getBytes();
        String str = "ID: " + user.getId();

        try(FileOutputStream fileOutputStream = new FileOutputStream("log.dat",true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){

            byteArrayOutputStream.write(data);
            byteArrayOutputStream.writeTo(fileOutputStream);
            dataOutputStream.writeUTF(str);

        }catch (IOException e){

            e.printStackTrace();

        }


    }
}
