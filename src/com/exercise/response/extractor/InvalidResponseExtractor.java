package com.exercise.response.extractor;

import com.exercise.util.TLVVo;

import static com.exercise.util.Constants.INVALID_REQUEST_MESSAGE;

/**
 * Created by Randeep on 24/06/2017.
 */
public class InvalidResponseExtractor extends ResponseExtractor {
    @Override
    public String extract(TLVVo tlv) {
        return INVALID_REQUEST_MESSAGE;
    }
}
