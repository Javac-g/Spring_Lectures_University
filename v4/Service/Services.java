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

}
