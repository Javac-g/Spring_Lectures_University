package com.MAX.v3.Service;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Service {
    List<ResponseDTO> datalist = new ArrayList<>();

    public String print(String msg){
        return msg;
    }

    public void log(String type, ResponseDTO user){

        byte[] data = ("\nType: " + type + "\nName: " + user.getName()).getBytes();

        try(FileOutputStream f = new FileOutputStream("log.dat",true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(f)){

            byteArrayOutputStream.write(data);
            byteArrayOutputStream.writeTo(f);
            dataOutputStream.writeUTF("\nID: " + user.getId());


        }catch (IOException e){

            e.printStackTrace();

        }



    }
}
