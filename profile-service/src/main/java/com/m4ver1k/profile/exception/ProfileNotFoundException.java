package com.m4ver1k.profile.exception;

/**
 * This Exception is thrown when no {@link com.m4ver1k.profile.model.UserProfile}
 */
public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(String ex) {
        super(ex);
    }
}
