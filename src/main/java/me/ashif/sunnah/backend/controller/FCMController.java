package me.ashif.sunnah.backend.controller;

import me.ashif.sunnah.backend.service.AndroidFCMService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by Ashif on 12/7/17.
 * github.com/SheikhZayed
 */
@RestController
public class FCMController {
    @Autowired
    private AndroidFCMService mAndroidFCMService;
    private final static String mFirebaseTopic = "generic";

    @RequestMapping(value = "/send", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> send(@RequestParam("title") String title,
                                       @RequestParam("body") String desc) throws JSONException{
        JSONObject body = new JSONObject();
        body.put("to", "/topics/" + mFirebaseTopic);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", title);
        notification.put("body", desc);

        JSONObject data = new JSONObject();
//        data.put("Key-1", "JSA Data 1");
//        data.put("Key-2", "JSA Data 2");

        body.put("notification", notification);
        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = mAndroidFCMService.sendNotification(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();
            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }
}
