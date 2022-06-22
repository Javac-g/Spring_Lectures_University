package com.MAX.v4.Service;

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
}
