package com.exercise.response.extractor;

import com.exercise.util.TLVVo;

/**
 * Created by Randeep on 24/06/2017.
 */
public class UpperCaseResponseExtractor extends ResponseExtractor {
    @Override
    public String extract(TLVVo tlv) {
        return getPrefix(tlv.getType()) + tlv.getValue().toUpperCase();
    }
}
