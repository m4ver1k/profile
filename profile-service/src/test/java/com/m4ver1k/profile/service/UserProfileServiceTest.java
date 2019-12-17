package com.m4ver1k.profile.service;

import com.m4ver1k.profile.model.UserProfile;
import com.m4ver1k.profile.repository.UserProfileRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserProfileServiceTest {

    private UserProfileService userProfileService;

    @MockBean
    private UserProfileRepository userProfileRepository;

    @Test
    public void should_save_and_return_profile() {

        this.userProfileService = new UserProfileService(this.userProfileRepository);

        UserProfile userProfile = new UserProfile("", "dname2", "adarsh2", "/pathtopic/jpg", LocalDate.now(), "male", "asian", "na", 123, "fat", "married", "sodt dev", "adasdasdasdasd", "{}");

        Mockito.when(this.userProfileRepository.save(userProfile))
                .thenReturn(userProfile);

        UserProfile response = this.userProfileService.save(userProfile);

        assertEquals(userProfile, response);
    }

    @Test
    public void should_return_if_profile_exist() {
        this.userProfileService = new UserProfileService(this.userProfileRepository);

        UserProfile userProfile = new UserProfile("", "dname2", "adarsh2", "/pathtopic/jpg", LocalDate.now(), "male", "asian", "na", 123, "fat", "married", "sodt dev", "adasdasdasdasd", "{}");

        Mockito.when(this.userProfileRepository.findById("1234"))
                .thenReturn(Optional.of(userProfile));

        Optional<UserProfile> response = this.userProfileService.get("1234");

        assertEquals(userProfile, response.get());
    }

    @Test
    public void should_return_empty_optional_when_no_profile_exist() {
        this.userProfileService = new UserProfileService(this.userProfileRepository);


        Mockito.when(this.userProfileRepository.findById("1234"))
                .thenReturn(Optional.empty());

        Optional<UserProfile> response = this.userProfileService.get("1234");

        assertTrue(response.isPresent() == false);
    }

}
