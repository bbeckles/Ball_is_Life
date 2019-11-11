package com.spartaglobal.JSONParsing;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;

public class Deserialiser {
    public  BallDTO dataMapped;

    public Deserialiser(String filename){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dataMapped = objectMapper.readValue(new FileReader(filename), BallDTO.class);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
