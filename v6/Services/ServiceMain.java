package com.MAX.v6.Services;

import com.MAX.v6.Controller.Car;
import com.MAX.v6.Controller.RequestDTO;
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

    public void setEnum(ResponseDTO user, RequestDTO json){

        for (Car car: json.getCarlist()){
            switch (car.getValue()){
                case "B":
                    user.setCarEnum(CarEnum.BIG);
                    break;
                case "S":
                    user.setCarEnum(CarEnum.SMALL);
                    break;
                default:
                    user.setCarEnum(CarEnum.WALK);
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
        datalist.add(user);
        log("Created",user);
        return user;

    }
    public ResponseDTO read(Integer id){
        for (ResponseDTO user: datalist){
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
    public Integer deleteA(Integer id){
        for (ResponseDTO user: datalist){
            if (user.getId().equals(id)){
                datalist.remove(user);
                return datalist.indexOf(user);
            }
        }
        return null;
    }
}
