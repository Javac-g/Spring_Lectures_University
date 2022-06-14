package com.MAX.v1.Services;

import com.MAX.v1.Controller.Car;
import com.MAX.v1.Controller.ResponseDTO;

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
            FileOutputStream fileOutputStream = new FileOutputStream("log.dat",true);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){


            byteArrayOutputStream.write(data);
            byteArrayOutputStream.writeTo(fileOutputStream);
            dataOutputStream.writeUTF("\nID: " + user.getId()+ "\nType: " + type);


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
        log("Created",user);

        database.add(user);

        return user;
    }
    public ResponseDTO read(Integer id){
        for (ResponseDTO user: database){
            if (user.getId().equals(id)){
                log("Searched",user);
                return user;
            }
        }
        return null;
    }
    public  ResponseDTO update(Integer id,RequestDTO json){
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
    public Integer delete_one(Integer id){
        int IntexToRemove = -1;

        for (int i = 0; i < database.size(); i++){
            if (database.get(i).getId().equals(id)){
                log("Deleted_One",database.get(i));
                IntexToRemove = i;
            }
        }
        if (IntexToRemove != -1){
            database.remove(IntexToRemove);
            return IntexToRemove;
        }
        return null;
    }
    public Integer delete_two(Integer id){

        for (ResponseDTO user: database){
            if (user.getId().equals(id)){

                database.remove(user);
                log("Deleted_Two",user);
                return id;
            }
        }
        return null;
    }
}
