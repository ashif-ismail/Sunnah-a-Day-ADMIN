package me.ashif.sunnah.backend.service;

import me.ashif.sunnah.backend.network.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Ashif on 12/7/17.
 * github.com/SheikhZayed
 */
@Service
public class AndroidFCMService {
    private final static String mFirebaseServerKey = "AAAA1180ktg:APA91bFDsCPWOUsBYVlWDhGfTbSVRCx3I30G5-QVUg8gXg1ADzp-DJJEobOeVO5icmJa-0VxW9Nn0UCJ8T2_zKJjjAv0sAfS_m6CbZD7uXKeo3VER6O8MtJlAXFfJT_irtcZVjwzH5eF";
    private final static String mFirebaseEndpoint = "https://fcm.googleapis.com/fcm/send";

    @Autowired
    private RestTemplate mRestTemplate;
    private ArrayList<ClientHttpRequestInterceptor> mClientRequestInterceptors;

    @Async
    public CompletableFuture<String> sendNotification(HttpEntity<String> entity){
        mClientRequestInterceptors = new ArrayList<>();
        mClientRequestInterceptors.add(new RequestInterceptor("Authorization", "key=" + mFirebaseServerKey));
        mClientRequestInterceptors.add(new RequestInterceptor("Content-Type", "application/json"));
        mRestTemplate.setInterceptors(mClientRequestInterceptors);
        String firebaseResponse = mRestTemplate.postForObject(mFirebaseEndpoint,entity,String.class);
        return CompletableFuture.completedFuture(firebaseResponse);
    }
}
