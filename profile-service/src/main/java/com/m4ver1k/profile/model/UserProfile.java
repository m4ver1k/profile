package com.m4ver1k.profile.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "marital_status")
    private String maritalStatus;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "occupation")
    private String occupation;

    @Column(name = "about_me")
    private String aboutMe;

    @Type(type = "jsonb")
    @Column(name = "location", columnDefinition = "jsonb")
    private String location;
}
