package com.MAX.v2.Service;

import com.MAX.v2.Controller.Car;
import com.MAX.v2.Controller.ResponseDTO;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    List<ResponseDTO> datalist = new ArrayList<>();

    public String print(Integer id){

        return"Person № - [" + id + "] was deleted ";

    }
    public void log(String type,ResponseDTO user){
        byte[] data = ("\nType: " + type+"\nName: " + user.getName()).getBytes();
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("log.dat");
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){

            byteArrayOutputStream.write(data);
            byteArrayOutputStream.writeTo(fileOutputStream);
            dataOutputStream.writeUTF("\nID: " + user.getId());


        }catch(IOException e){

            e.printStackTrace();

        }
    }
    public void setEnum(ResponseDTO user,RequestDTO json){

        for (Car x : json.getCarList()){
            switch (x.getValue()){
                case "A" :
                    user.setCarEnum(CarEnum.Audi);
                    break;
                case "B" :
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
        log("Created",user);
        datalist.add(user);
        return user;
    }
    public ResponseDTO read(Integer id){
        for (ResponseDTO user : datalist){
            if (user.getId().equals(id)){
                log("Finded",user);
                return user;
            }
        }
        return null;
    }

    public ResponseDTO update(Integer id, RequestDTO json){
        ResponseDTO user = read(id);

        if (user != null){
            user.setName(json.getName());
            user.setId(json.getId());
            user.setTool(json.getTool());
            setEnum(user,json);
            log("Updated",user);
            return user;
        }
        return null;
    }



}//EOF
