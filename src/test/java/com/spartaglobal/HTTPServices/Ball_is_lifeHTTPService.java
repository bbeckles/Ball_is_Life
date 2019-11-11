package com.spartaglobal.HTTPServices;




import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.spartaglobal.config.*;

import java.io.IOException;

public class Ball_is_lifeHTTPService {

    private CloseableHttpResponse ballResponse;
    private String DataJsonString;



    public void executeLatestRates() {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        String latestServiceURL = BallisLifeURL.BASEURL + BallisLifeURL.teams;

        HttpGet httpGet = new HttpGet(latestServiceURL);
        try {
            ballResponse = closeableHttpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            DataJsonString = EntityUtils.toString(ballResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFixerLatestRateJsonString() {
        return DataJsonString;
    }

    public CloseableHttpResponse getFixerResponse(){
        return ballResponse;
    }

}

