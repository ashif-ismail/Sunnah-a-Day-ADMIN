package me.ashif.sunnah.backend.service;

import me.ashif.sunnah.backend.network.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Ashif on 12/7/17.
 * github.com/SheikhZayed
 */
@Service
public class AndroidFCMService {
    @Value("${FIREBASE_SERVER_KEY}")
    private static String mFirebaseServerKey;

    @Value("${FIREBASE_API_URL}")
    private static String mFirebaseEndpoint;

    @Autowired
    private RestTemplate mRestTemplate;

    @Autowired
    private ArrayList<ClientHttpRequestInterceptor> mClientRequestInterceptors;

    @Autowired
    private RequestInterceptor mRequestInterceptor;

    @Async
    public CompletableFuture<String> sendNotification(HttpEntity<String> entity){
        mRequestInterceptor.setmHeaderName("Authorization");
        mRequestInterceptor.setmHeaderValue("key=" + mFirebaseServerKey);
        mClientRequestInterceptors.add(mRequestInterceptor);
        mRestTemplate.setInterceptors(mClientRequestInterceptors);
        String firebaseResponse = mRestTemplate.postForObject(mFirebaseEndpoint,entity,String.class);
        return CompletableFuture.completedFuture(firebaseResponse);
    }
}
