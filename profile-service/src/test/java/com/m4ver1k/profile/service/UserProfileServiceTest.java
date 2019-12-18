package com.m4ver1k.profile.service;

import com.m4ver1k.profile.exception.ProfileNotFoundException;
import com.m4ver1k.profile.model.UserProfile;
import com.m4ver1k.profile.repository.UserProfileRepository;
import org.junit.Before;
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

    @Before
    public void setUp() throws Exception {
        this.userProfileService = new UserProfileService(this.userProfileRepository);
    }

    @Test
    public void should_save_and_return_profile() {

        UserProfile userProfile = new UserProfile("", "dname2", "adarsh2", "/pathtopic/jpg", LocalDate.now(), "male", "asian", "na", 123, "fat", "married", "sodt dev", "adasdasdasdasd", "{}");

        Mockito.when(this.userProfileRepository.save(userProfile))
                .thenReturn(userProfile);

        UserProfile response = this.userProfileService.save(userProfile);

        assertEquals(userProfile, response);
    }

    @Test
    public void should_return_if_profile_exist() {

        UserProfile userProfile = new UserProfile("", "dname2", "adarsh2", "/pathtopic/jpg", LocalDate.now(), "male", "asian", "na", 123, "fat", "married", "sodt dev", "adasdasdasdasd", "{}");

        Mockito.when(this.userProfileRepository.findById("1234"))
                .thenReturn(Optional.of(userProfile));

        Optional<UserProfile> response = this.userProfileService.get("1234");

        assertEquals(userProfile, response.get());
    }

    @Test
    public void should_return_empty_optional_when_no_profile_exist() {

        Mockito.when(this.userProfileRepository.findById("1234"))
                .thenReturn(Optional.empty());

        Optional<UserProfile> response = this.userProfileService.get("1234");

        assertTrue(response.isPresent() == false);
    }

    @Test
    public void should_update_existing_profile() {

        UserProfile request = new UserProfile("", "dname2", "adarsh2", "/pathtopic/jpg", LocalDate.now(), "male", "asian", "na", 123, "fat", "married", "sodt dev", "adasdasdasdasd", "{}");
        UserProfile userProfile = new UserProfile("1234", "dname2", "adarsh2", "/pathtopic/jpg", LocalDate.now(), "male", "asian", "na", 123, "fat", "married", "sodt dev", "adasdasdasdasd", "{}");

        Mockito.when(this.userProfileRepository.existsById("1234"))
                .thenReturn(true);

        Mockito.when(this.userProfileRepository.save(userProfile))
                .thenReturn(userProfile);

        UserProfile response = this.userProfileService.update("1234", request);

        assertEquals("1234", response.getProfileId());

    }

    @Test(expected = ProfileNotFoundException.class)
    public void should_throw_exception_when_profile_dont_exist() {

        UserProfile request = new UserProfile("", "dname2", "adarsh2", "/pathtopic/jpg", LocalDate.now(), "male", "asian", "na", 123, "fat", "married", "sodt dev", "adasdasdasdasd", "{}");

        Mockito.when(this.userProfileRepository.existsById("1234"))
                .thenReturn(false);

        this.userProfileService.update("1234", request);
    }
}
