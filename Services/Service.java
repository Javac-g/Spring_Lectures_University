package com.MAX.Services;

import com.MAX.Controller.Car;
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
    public void setEnum(ResponseDTO user, RequestDTO json){
        for (Car x : json.getCarList()){
            switch (x.getValue()){
                case "A":
                    user.setCarEnum(CarEnum.AUDI);
                    break;
                case "B":
                    user.setCarEnum(CarEnum.BMW);
                    break;
            }
        }
    }


    public ResponseDTO create(RequestDTO json){

        ResponseDTO user = new ResponseDTO();

        user.setName(json.getName());
        user.setId(json.getId());
        user.setTool(json.getTool());

        setEnum(user,json);
        log("Created.dat",user);

        database.add(user);

        return user;
    }
    public ResponseDTO read(Integer id){
        for (ResponseDTO user: database){
            if (user.getId().equals(id)){
                log("Searched.dat",user);
                return user;
            }
        }
        return null;
    }
}
