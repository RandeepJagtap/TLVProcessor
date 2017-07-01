package com.exercise.response.extractor;

import com.exercise.util.TLVVo;

import static com.exercise.util.Constants.TYPE_NOT_FOUND_MESSAGE;

/**
 * Created by Randeep on 24/06/2017.
 */
public class DefaultResponseExtractor extends ResponseExtractor {
    @Override
    public String extract(TLVVo tlv) {
        return TYPE_NOT_FOUND_MESSAGE;
    }
}
