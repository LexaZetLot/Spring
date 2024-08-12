package org.example.propertyeditor;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String str = text.toUpperCase();

        setValue(str);
    }
}
