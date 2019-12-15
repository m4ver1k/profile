package com.m4ver1k.profile.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
@Entity
@Table(schema = "userdata", name = "profile")
public class UserProfile {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "profile_id")
    private String profileId;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "name")
    private String name;

    @Column(name = "profile_picture_uri")
    private String profilePictureURI;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "gender")
    private String gender;

    @Column(name = "ethnicity")
    private String ethnicity;

    @Column(name = "religion")
    private String religion;

    @Column(name = "height")
    private Integer height;

    @Column(name = "figure")
    private String figure;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "about_me")
    private String aboutMe;

    @Type(type = "jsonb")
    @Column(name = "location", columnDefinition = "jsonb")
    private String location;
}
