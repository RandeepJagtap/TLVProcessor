package com.exercise.translator;

import com.exercise.util.TLVVo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.exercise.util.Constants.*;

/**
 * Created by Randeep on 24/06/2017.
 */
public class RequestTranslator {

    public static List<TLVVo> translate(String[] requests) {
        List<TLVVo> tlvVos = new ArrayList<>();
        for (String request : requests) {
            Pattern pattern = Pattern.compile(TYPES_REGEX);
            Matcher matcher = pattern.matcher(request);
            int startIndex = 0;
            while (matcher.find()) {
                int matchIndex = matcher.start();
                if (matchIndex > startIndex) {
                    String subRequest = request.substring(startIndex, matchIndex);
                    startIndex = matchIndex;
                    addToTLVVos(subRequest, tlvVos);
                }
            }
            addToTLVVos(getSubString(request, startIndex), tlvVos);
        }
        return tlvVos;
    }

    private static void addToTLVVos(String request, List<TLVVo> tlvVos) {

        String subRequest = null;
        subRequest = getSubRequest(request, tlvVos);
        if (subRequest != null) {
            addToTLVVos(subRequest, tlvVos);
        }
    }

    private static String getSubRequest(String request, List<TLVVo> tlvVos) {
        String[] split = request.split(TLV_SEPERATOR);
        TLVVo tlvVo = null;
        String subRequest = null;
        if (isInvalidSplit(split)) {
            tlvVo = new TLVVo(TYPE_INVLID, null, request);
        } else if (isSplitLengthThree(split)) {
            tlvVo = new TLVVo(split[0], split[1], split[2]);
        } else {
            tlvVo = new TLVVo(split[0], split[1], split[2].substring(0, Integer.parseInt(split[1])));
            subRequest = getSubString(request, getBeginIndexForSubRequest(split));
        }
        tlvVos.add(tlvVo);
        return subRequest;
    }

    private static String getSubString(String request, int beginIndex) {
        return request.substring(beginIndex);
    }

    private static boolean isSplitLengthThree(String[] splitTLV) {
        return splitTLV.length == 3;
    }

    private static boolean isInvalidSplit(String[] splitTLV) {
        return splitTLV == null || splitTLV.length < 3;
    }

    private static int getBeginIndexForSubRequest(String[] split) {
        return split[0].length() + split[1].length() + SEPERATOR_COUNT + Integer.parseInt(split[1]);
    }
}
