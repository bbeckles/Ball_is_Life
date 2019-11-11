package com.spartaglobal;

import com.spartaglobal.HTTPServices.Ball_is_lifeHTTPService;
import com.spartaglobal.JSONParsing.BallDTO;
import com.spartaglobal.JSONParsing.Data;
import com.spartaglobal.JSONParsing.Deserialiser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class BallislIfeTest {

   static Ball_is_lifeHTTPService ball_is_lifeHTTPService = new Ball_is_lifeHTTPService();
    private static Deserialiser ball;
    @BeforeClass
    public static void getHTTPRequest(){
        ball = new Deserialiser("Resource/Ball.Json");
        ball_is_lifeHTTPService.executeLatestRates();
    }

    @Test
    public void test(){
        System.out.println(ball_is_lifeHTTPService.getFixerLatestRateJsonString());
    }

    @Test
    public void testData(){
        for(Data obj : ball.dataMapped.getData())
        System.out.println(obj.getName() + " "+ obj.getConference());
    }
}
