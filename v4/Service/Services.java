package com.MAX.v4.Service;

import com.MAX.v4.Controller.Car;
import com.MAX.v4.Controller.RequestDTO;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Services {
    List<ResponseDTO> datalist = new ArrayList<>();
    private String firstProperty,secondProperty;

    public String getFirstProperty() {
        return firstProperty;
    }

    public void setFirstProperty(String firstProperty) {
        this.firstProperty = firstProperty;
    }

    public String getSecondProperty() {
        return secondProperty;
    }

    public void setSecondProperty(String secondProperty) {
        this.secondProperty = secondProperty;
    }

    public void log(String type, ResponseDTO user){
        byte[] data = ("Type: " + type + "\nName: " + user.getName()).getBytes();

        try(ByteArrayOutputStream b = new ByteArrayOutputStream();
            FileOutputStream f = new FileOutputStream("log.dat",true);
            DataOutputStream d = new DataOutputStream(f)){


            b.write(data);
            b.writeTo(f);
            d.writeUTF("\nID: " + user.getId());

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void setEnum(ResponseDTO user, RequestDTO json){
        for (Car car : json.getCarlist()){
            switch (car.getValue()){
                case "S":
                    user.setCarEnum(CarEnum.Supra);
                    break;
                case "L":
                    user.setCarEnum(CarEnum.Lanos);
                    break;
                default:
                    user.setCarEnum(CarEnum.Ferrary);
                    break;
            }
        }
    }
    public String print(String msg){
        return msg;
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
    public Integer deleteA(Integer id){
        for(ResponseDTO user:datalist){
            if (user.getId().equals(id)){
                datalist.remove(user);
                return id;
            }
        }
        return null;
    }
    public Integer deleteB(Integer id){
        int  index = -1;
        for (int i = 0 ; i < datalist.size(); i++){
            if (datalist.get(i).getId().equals(id)){
                index = i;
                log("Deleted",datalist.get(index));
            }
        }
        if (index != -1){
            datalist.remove(index);
            return index;
        }
        return null;
    }

}
