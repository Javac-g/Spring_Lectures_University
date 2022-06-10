package com.MAX.Services;

import com.MAX.Controller.ResponseDTO;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    List<ResponseDTO> database = new ArrayList<>();

    public String print(String msg){

        return msg;

    }
    public  void log(String type, ResponseDTO user){
        byte[] data = ("\nName: " + user.getName()).getBytes();
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(type,true);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){


            byteArrayOutputStream.write(data);
            byteArrayOutputStream.writeTo(fileOutputStream);
            dataOutputStream.writeUTF("\nID: " + user.getId());


        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
