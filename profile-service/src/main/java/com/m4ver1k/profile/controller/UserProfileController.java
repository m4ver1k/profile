package com.m4ver1k.profile.controller;

import com.m4ver1k.profile.model.UserProfile;
import com.m4ver1k.profile.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/profiles")
public class UserProfileController {
    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<UserProfile> create(@RequestBody UserProfile userProfile) {
        UserProfile savedProfile = this.userProfileService.save(userProfile);
        return ResponseEntity.created(URI.create("/api/v1/profiles/"+savedProfile.getProfileId())).body(savedProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> update(@PathVariable String id,@RequestBody UserProfile userProfile) {

        UserProfile savedProfile = this.userProfileService.update(id,userProfile);
        return ResponseEntity.ok(savedProfile);
    }

}
