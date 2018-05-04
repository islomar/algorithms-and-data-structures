package com.islomar.cracking.chapter1.stringbuffer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyStringBuffer {

    private List<String> chunks = new ArrayList<>();

    public String toString(){
        return chunks.stream().collect(Collectors.joining());
    }

    public void append(String chunk) {
        this.chunks.add(chunk);
    }
}
