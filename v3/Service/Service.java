package com.MAX.v3.Service;

import com.MAX.v3.Controller.Car;
import com.MAX.v3.Controller.RequestDTO;

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
    public void setEnum(ResponseDTO user, RequestDTO json){
        for (Car car:json.getCarlist()){
            switch (car.getValue()){
                case "F":
                    user.setCarEnum(CarEnum.Ford);
                    break;
                case "P":
                    user.setCarEnum(CarEnum.Porshe);
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
            user.setId(json.getId());
            user.setTool(json.getTool());
            setEnum(user,json);
            log("Updated",user);
            return user;
        }
        return null;
    }

    public String delete(String str,Integer id){
        int index = -1;
        for (int i = 0; i < datalist.size(); i++){
            if (datalist.get(i).getId().equals(id)){
                index = i;
                log("Deleted",datalist.get(i));
            }
        }
        if (index != -1){
            datalist.remove(index);
            return str + index;
        }
        return "nobody deleted";
    }
}
