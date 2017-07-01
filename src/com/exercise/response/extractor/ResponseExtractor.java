package com.exercise.response.extractor;

import com.exercise.util.TLVVo;

import static com.exercise.util.Constants.*;

/**
 * Created by Randeep on 23/06/2017.
 */
public abstract class ResponseExtractor {

    protected String getPrefix(String type) {
        return type + TLV_SEPERATOR;
    }

    public abstract String extract(TLVVo tlv);
}
