package com.exercise.processor;

import com.exercise.translator.RequestTranslator;
import com.exercise.util.TLVVo;
import com.exercise.response.extractor.ResponseExtractor;
import com.exercise.response.extractor.ResponseExtractorFactory;

import java.util.List;

/**
 * Created by Randeep on 23/06/2017.
 */
public class TLVProcessorImpl implements TLVProcessor {

    @Override
    public void process(String[] requests) {
        List<TLVVo> tlvVos = RequestTranslator.translate(requests);
        for (TLVVo tlv : tlvVos) {
            ResponseExtractor responseExtractor = ResponseExtractorFactory.getResponseExtractor(tlv.getType());
            String response = responseExtractor.extract(tlv);
            System.out.println(response);
        }
    }
}
