package com.umc.mission7.apiPayload.code.exception.handler;

import com.umc.mission7.apiPayload.code.BaseErrorCode;
import com.umc.mission7.apiPayload.code.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
