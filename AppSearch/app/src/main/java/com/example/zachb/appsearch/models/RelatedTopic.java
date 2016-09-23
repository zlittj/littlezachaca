
package com.example.zachb.appsearch.models;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class RelatedTopic {

    public String result;
    public Icon icon;
    public String firstURL;
    public String text;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFirstURL() {
        return firstURL;
    }

    public void setFirstURL(String firstURL) {
        this.firstURL = firstURL;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}
