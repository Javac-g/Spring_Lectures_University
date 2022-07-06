package com.MAX.v7.Service;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

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
    public void log(String type, ResponseDTO user){
        byte[] data = ("\nType: " + type + "\nName: " + user.getName() + "\nId: " + user.getId()).getBytes();
        String additional = "\nTool: first - " + user.getTool().getFirst()+"\nTool: - second"+ user.getTool().getSecond() +"\nCar: "+ user.getCarEnum();

        try(FileOutputStream fileOutputStream = new FileOutputStream("logger.dat",true);
            ByteOutputStream byteOutputStream = new ByteOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){

            byteOutputStream.write(data);
            byteOutputStream.writeTo(fileOutputStream);
            dataOutputStream.writeUTF(additional);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
