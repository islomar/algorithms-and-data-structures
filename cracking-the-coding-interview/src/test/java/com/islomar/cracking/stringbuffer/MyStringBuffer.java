package com.islomar.cracking.stringbuffer;

public class MyStringBuffer {

    private String chunk;

    public MyStringBuffer() {
        this.chunk = "";
    }

    public String toString(){
        return new String(chunk);
    }

    public void append(String chunk) {
        this.chunk = chunk;
    }
}
