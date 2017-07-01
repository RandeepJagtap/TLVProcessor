package com.exercise;

import com.exercise.processor.TLVProcessor;
import com.exercise.processor.TLVProcessorImpl;

public class Main {

    public static void main(String[] args) {
        TLVProcessor tlvProcessor = new TLVProcessorImpl();
        tlvProcessor.process(args);
    }
}
