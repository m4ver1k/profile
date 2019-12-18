package com.m4ver1k.profile.controller;

import com.m4ver1k.profile.exception.ProfileNotFoundException;
import com.m4ver1k.profile.model.UserProfile;
import com.m4ver1k.profile.service.UserProfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserProfileService userProfileService;

    @Test
    public void should_save_and_return_profile() throws Exception {
        UserProfile userProfile = new UserProfile(null,
                "displayName",
                "name",
                "/pathtopic/jpg",
                LocalDate.parse("2019-12-15"),
                "male",
                "asian",
                "na",
                123,
                "fat",
                "married",
                "soft dev",
                "about me",
                "{}");

        when(userProfileService.save(userProfile)).thenReturn(userProfile);

        String json = "{\n" +
                "\"displayName\":\"displayName\",\n" +
                "\"name\":\"name\",\n" +
                "\"profilePictureURI\":\"/pathtopic/jpg\",\n" +
                "\"birthday\":\"2019-12-15\",\n" +
                "\"gender\":\"male\",\n" +
                "\"ethnicity\":\"asian\",\n" +
                "\"religion\":\"na\",\n" +
                "\"height\":\"123\",\n" +
                "\"figure\":\"fat\",\n" +
                "\"maritalStatus\":\"married\",\n" +
                "\"occupation\":\"soft dev\",\n" +
                "\"aboutMe\":\"about me\",\n" +
                "\"location\":\"{}\"\n" +
                "}";

        this.mockMvc.perform(
                post("/api/v1/profiles")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.displayName", is("displayName")))
                .andExpect(jsonPath("$.gender", is("male")))
                .andExpect(jsonPath("$.birthday", is("2019-12-15")))
                .andExpect(jsonPath("$.ethnicity", is("asian")))
                .andReturn();
    }

    @Test
    public void should_update_and_return_profile_when_exists() throws Exception {
        UserProfile request = new UserProfile(null,
                "displayName",
                "name",
                "/pathtopic/jpg",
                LocalDate.parse("2019-12-15"),
                "male",
                "asian",
                "na",
                123,
                "fat",
                "married",
                "soft dev",
                "about me",
                "{}");

        UserProfile response = new UserProfile("1234",
                "displayName",
                "name",
                "/pathtopic/jpg",
                LocalDate.parse("2019-12-15"),
                "male",
                "asian",
                "na",
                123,
                "fat",
                "married",
                "soft dev",
                "about me",
                "{}");

        when(userProfileService.update("1234", request)).thenReturn(response);

        String json = "{\n" +
                "\"displayName\":\"displayName\",\n" +
                "\"name\":\"name\",\n" +
                "\"profilePictureURI\":\"/pathtopic/jpg\",\n" +
                "\"birthday\":\"2019-12-15\",\n" +
                "\"gender\":\"male\",\n" +
                "\"ethnicity\":\"asian\",\n" +
                "\"religion\":\"na\",\n" +
                "\"height\":\"123\",\n" +
                "\"figure\":\"fat\",\n" +
                "\"maritalStatus\":\"married\",\n" +
                "\"occupation\":\"soft dev\",\n" +
                "\"aboutMe\":\"about me\",\n" +
                "\"location\":\"{}\"\n" +
                "}";

        this.mockMvc.perform(
                put("/api/v1/profiles/1234")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.profileId", is("1234")))
                .andExpect(jsonPath("$.displayName", is("displayName")))
                .andExpect(jsonPath("$.gender", is("male")))
                .andExpect(jsonPath("$.birthday", is("2019-12-15")))
                .andExpect(jsonPath("$.ethnicity", is("asian")))
                .andReturn();
    }

    @Test
    public void should_return_error_when_not_exists() throws Exception {
        UserProfile userProfile = new UserProfile(null,
                "displayName",
                "name",
                "/pathtopic/jpg",
                LocalDate.parse("2019-12-15"),
                "male",
                "asian",
                "na",
                123,
                "fat",
                "married",
                "soft dev",
                "about me",
                "{}");

        when(userProfileService.update("1234", userProfile)).thenThrow(new ProfileNotFoundException("Profile Not Found"));

        String json = "{\n" +
                "\"displayName\":\"displayName\",\n" +
                "\"name\":\"name\",\n" +
                "\"profilePictureURI\":\"/pathtopic/jpg\",\n" +
                "\"birthday\":\"2019-12-15\",\n" +
                "\"gender\":\"male\",\n" +
                "\"ethnicity\":\"asian\",\n" +
                "\"religion\":\"na\",\n" +
                "\"height\":\"123\",\n" +
                "\"figure\":\"fat\",\n" +
                "\"maritalStatus\":\"married\",\n" +
                "\"occupation\":\"soft dev\",\n" +
                "\"aboutMe\":\"about me\",\n" +
                "\"location\":\"{}\"\n" +
                "}";

        this.mockMvc.perform(
                put("/api/v1/profiles/1234")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorCode", is("p1001")))
                .andExpect(jsonPath("$.displayMessage", is("Profile Not Found")))
                .andExpect(jsonPath("$.internalMessage", is("Profile Not Found")))
                .andReturn();
    }

}