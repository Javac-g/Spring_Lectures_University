package com.MAX.v8.Service;

import com.MAX.v8.Controller.RequestDTO;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service_Main {

    private List<ResponseDTO> datalist = new ArrayList<>();

    public String print(String msg){
        return msg;
    }
    public void log(String type,ResponseDTO user){

        byte[] data = ("\nType: " + type + "\nName: " + user.getName()+ "\nId: " + user.getId()).getBytes();
        String A = "\nTool - A: "+ user.getTool().getFirst() + "\nTool - A: " + user.getTool().getSecond();
        String B = "\nCar: " + user.getCarEnum();

        try(FileOutputStream fileOutputStream = new FileOutputStream("Logger.dat",true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){


            byteArrayOutputStream.write(data);
            byteArrayOutputStream.writeTo(fileOutputStream);

            dataOutputStream.writeUTF(A);
            dataOutputStream.writeUTF(B);


        }catch (IOException e){
            e.printStackTrace();
        }



    }
    public ResponseDTO Create(RequestDTO data){
        ResponseDTO user = new ResponseDTO();

        user.setName(data.getName());
        user.setId(data.getId());
        user.setTool(data.getTool());
        user.setEnum(user,data);
        log("Created",user);
        datalist.add(user);
        return user;

    }
}
