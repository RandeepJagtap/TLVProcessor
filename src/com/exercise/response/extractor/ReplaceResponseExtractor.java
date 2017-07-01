package com.exercise.response.extractor;

import com.exercise.util.TLVVo;

import static com.exercise.util.Constants.*;

/**
 * Created by Randeep on 24/06/2017.
 */
public class ReplaceResponseExtractor extends ResponseExtractor {
    @Override
    public String extract(TLVVo tlv) {
        return getPrefix(tlv.getType()) + REPLCE_STRING;
    }
}
