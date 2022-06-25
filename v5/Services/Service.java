package com.MAX.v5.Services;

import com.MAX.v5.Controller.Car;
import com.MAX.v5.Controller.RequestDTO;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Service {
    List<ResponseDTO> datalist = new ArrayList<>();
    public String now;
    public String print(String msg){
        return msg;
    }

    public void log(String type,ResponseDTO user){
        byte[] data = ("\nType: " + type + "\nDate: " + java.time.Clock.systemUTC().millis() + "\nName: " + user.getName()).getBytes();
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

    public void setEnum(ResponseDTO user, RequestDTO json){
        for (Car car: json.getCarlist()){
            switch (car.getValue()){
                case "R":
                    user.setCarEnum(CarEnum.Rich);
                    break;
                case "P":
                    user.setCarEnum(CarEnum.Poor);
                    break;
                default:
                    user.setCarEnum(CarEnum.bycicle);
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
        log("Created:",user);
        datalist.add(user);
        return user;
    }
    public ResponseDTO read(Integer id){
        for (ResponseDTO user: datalist){
            if (user.getId().equals(id)){
                log("Searched",user);
                return user;
            }
        }
        return null;
    }

    public ResponseDTO update(Integer id, RequestDTO json){
        ResponseDTO user = read(id);
        if (user != null){
            user.setName(json.getName());
            user.setTool(json.getTool());
            user.setId(json.getId());
            setEnum(user,json);
            log("Updated",user);
            return user;
        }
        return null;
    }
}//
