package com.m4ver1k.profile.service;

import com.m4ver1k.profile.model.UserProfile;
import com.m4ver1k.profile.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Transactional
    public UserProfile save(UserProfile userProfile) {
        return this.userProfileRepository.save(userProfile);
    }

    public Optional<UserProfile> get(String id) {
        return this.userProfileRepository.findById(id);
    }
}
