
package com.zachlittle.android.aca.duckducksearch.Models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Maintainer {

    private String github;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The github
     */
    public String getGithub() {
        return github;
    }

    /**
     * 
     * @param github
     *     The github
     */
    public void setGithub(String github) {
        this.github = github;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
