package com.exercise.response.extractor;

import static com.exercise.util.Constants.*;

/**
 * Created by Randeep on 24/06/2017.
 */
public class ResponseExtractorFactory {

    public static ResponseExtractor getResponseExtractor(String type) {
        if(type.equals(TYPE_UPPRCS)){
            return new UpperCaseResponseExtractor();
        } else if(type.equals(TYPE_REPLCE)){
            return new ReplaceResponseExtractor();
        } else if(type.equals(TYPE_INVLID)){
            return new InvalidResponseExtractor();
        }
        return new DefaultResponseExtractor();
    }
}
