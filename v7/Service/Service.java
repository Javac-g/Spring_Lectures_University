package com.MAX.v7.Service;

import com.MAX.v7.Controller.Car;
import com.MAX.v7.Controller.RequestDTO;
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
    public void setEnum(ResponseDTO user, RequestDTO json){
        for (Car car: json.getCarlist()){
            switch (car.getValue()){
                case "A" :
                    user.setCarEnum(CarEnum.Audi);
                    break;
                case "F":
                    user.setCarEnum(CarEnum.Ferrary);
                    break;
                default:
                    user.setCarEnum(CarEnum.poor);
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
        for (ResponseDTO user:datalist){
            if (user.getId().equals(id)){
                log("Searched",user);
                return user;
            }
        }
        return null;
    }
    public ResponseDTO update(Integer id,RequestDTO json){
        ResponseDTO user = read(id);
        if (user != null){
            user.setName(json.getName());
            user.setId(json.getId());
            user.setTool(json.getTool());
            setEnum(user,json);
            log("Updated",user);
        }
        return null;
    }

}
