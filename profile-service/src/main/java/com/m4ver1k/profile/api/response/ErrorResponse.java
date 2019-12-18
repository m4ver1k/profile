package com.m4ver1k.profile.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * API Response object for Exceptions.
 */
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String errorCode;

    private String displayMessage;

    private String internalMessage;

}
