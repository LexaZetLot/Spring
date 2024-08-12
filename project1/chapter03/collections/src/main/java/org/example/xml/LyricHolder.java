package org.example.xml;

import org.example.ContentHolder;

public class LyricHolder implements ContentHolder {
    private String value = "'You be the DJ, I'll be the driver'";

    @Override
    public String toString(){
        return "LyricHolder: {" + value + "}";
    }
}
