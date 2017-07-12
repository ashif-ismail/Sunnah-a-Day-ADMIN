package me.ashif.sunnah.backend.controller;

import me.ashif.sunnah.backend.service.AndroidFCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ashif on 12/7/17.
 * github.com/SheikhZayed
 */
@RestController
public class FCMController {
    @Autowired
    private AndroidFCMService mAndroidFCMService;

}
