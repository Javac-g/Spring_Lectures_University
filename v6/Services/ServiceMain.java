package com.MAX.v6.Services;

import com.MAX.v6.Controller.Car;
import com.MAX.v6.Controller.RequestDTO;


import java.io.ByteArrayOutputStream;
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
    public Integer deleteB(Integer id){
        int R = -1;
        for (int i = 0 ; i < datalist.size(); i++){
            if (datalist.get(i).getId().equals(id)){
                R = i;
            }
        }
        if (R != -1){
            datalist.remove(R);
            return R;
        }
        return null;
    }
}
