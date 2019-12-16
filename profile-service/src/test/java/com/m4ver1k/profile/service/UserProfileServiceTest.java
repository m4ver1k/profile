package com.m4ver1k.profile.service;

import com.m4ver1k.profile.model.UserProfile;
import com.m4ver1k.profile.repository.UserProfileRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

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

        assertEquals(userProfile,response);
    }


}
