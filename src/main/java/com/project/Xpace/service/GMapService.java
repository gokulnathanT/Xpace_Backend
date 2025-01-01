package com.project.Xpace.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class GMapService {
    private static final String API_KEY="AIzaSyC5SgK0WoWZnFEJ3VgL0PUU0_V5wAkdSM0";
    private static final String Distance_Matrix_URL="https://maps.googleapis.com/maps/api/distancematrix/json";


    public  int calculateDistance(String origin,String destination){
        try {
            String url=Distance_Matrix_URL+"?origins=" +origin+"&destinations="+destination+"&key="+API_KEY;
            RestTemplate restTemplate=new RestTemplate();
            String response =restTemplate.getForObject(url,String.class);
            JSONObject jsonResponse=new JSONObject(response);
            int distance =jsonResponse
                    .getJSONArray("rows")
                    .getJSONObject(0)
                    .getJSONArray("elements")
                    .getJSONObject(0)
                    .getJSONObject("distance")
                    .getInt("value");

            return distance/1000;
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;

        }
    }

}
