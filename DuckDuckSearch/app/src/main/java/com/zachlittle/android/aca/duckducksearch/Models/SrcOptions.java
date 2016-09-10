
package com.zachlittle.android.aca.duckducksearch.Models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SrcOptions {

    private String skipEnd;
    private Integer skipAbstract;
    private String skipQr;
    private String language;
    private Integer skipIcon;
    private Integer skipImageName;
    private String directory;
    private String minAbstractLength;
    private Integer skipAbstractParen;
    private Integer isWikipedia;
    private String sourceSkip;
    private Integer isFanon;
    private Integer isMediawiki;
    private String srcInfo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The skipEnd
     */
    public String getSkipEnd() {
        return skipEnd;
    }

    /**
     * 
     * @param skipEnd
     *     The skip_end
     */
    public void setSkipEnd(String skipEnd) {
        this.skipEnd = skipEnd;
    }

    /**
     * 
     * @return
     *     The skipAbstract
     */
    public Integer getSkipAbstract() {
        return skipAbstract;
    }

    /**
     * 
     * @param skipAbstract
     *     The skip_abstract
     */
    public void setSkipAbstract(Integer skipAbstract) {
        this.skipAbstract = skipAbstract;
    }

    /**
     * 
     * @return
     *     The skipQr
     */
    public String getSkipQr() {
        return skipQr;
    }

    /**
     * 
     * @param skipQr
     *     The skip_qr
     */
    public void setSkipQr(String skipQr) {
        this.skipQr = skipQr;
    }

    /**
     * 
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The skipIcon
     */
    public Integer getSkipIcon() {
        return skipIcon;
    }

    /**
     * 
     * @param skipIcon
     *     The skip_icon
     */
    public void setSkipIcon(Integer skipIcon) {
        this.skipIcon = skipIcon;
    }

    /**
     * 
     * @return
     *     The skipImageName
     */
    public Integer getSkipImageName() {
        return skipImageName;
    }

    /**
     * 
     * @param skipImageName
     *     The skip_image_name
     */
    public void setSkipImageName(Integer skipImageName) {
        this.skipImageName = skipImageName;
    }

    /**
     * 
     * @return
     *     The directory
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * 
     * @param directory
     *     The directory
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    /**
     * 
     * @return
     *     The minAbstractLength
     */
    public String getMinAbstractLength() {
        return minAbstractLength;
    }

    /**
     * 
     * @param minAbstractLength
     *     The min_abstract_length
     */
    public void setMinAbstractLength(String minAbstractLength) {
        this.minAbstractLength = minAbstractLength;
    }

    /**
     * 
     * @return
     *     The skipAbstractParen
     */
    public Integer getSkipAbstractParen() {
        return skipAbstractParen;
    }

    /**
     * 
     * @param skipAbstractParen
     *     The skip_abstract_paren
     */
    public void setSkipAbstractParen(Integer skipAbstractParen) {
        this.skipAbstractParen = skipAbstractParen;
    }

    /**
     * 
     * @return
     *     The isWikipedia
     */
    public Integer getIsWikipedia() {
        return isWikipedia;
    }

    /**
     * 
     * @param isWikipedia
     *     The is_wikipedia
     */
    public void setIsWikipedia(Integer isWikipedia) {
        this.isWikipedia = isWikipedia;
    }

    /**
     * 
     * @return
     *     The sourceSkip
     */
    public String getSourceSkip() {
        return sourceSkip;
    }

    /**
     * 
     * @param sourceSkip
     *     The source_skip
     */
    public void setSourceSkip(String sourceSkip) {
        this.sourceSkip = sourceSkip;
    }

    /**
     * 
     * @return
     *     The isFanon
     */
    public Integer getIsFanon() {
        return isFanon;
    }

    /**
     * 
     * @param isFanon
     *     The is_fanon
     */
    public void setIsFanon(Integer isFanon) {
        this.isFanon = isFanon;
    }

    /**
     * 
     * @return
     *     The isMediawiki
     */
    public Integer getIsMediawiki() {
        return isMediawiki;
    }

    /**
     * 
     * @param isMediawiki
     *     The is_mediawiki
     */
    public void setIsMediawiki(Integer isMediawiki) {
        this.isMediawiki = isMediawiki;
    }

    /**
     * 
     * @return
     *     The srcInfo
     */
    public String getSrcInfo() {
        return srcInfo;
    }

    /**
     * 
     * @param srcInfo
     *     The src_info
     */
    public void setSrcInfo(String srcInfo) {
        this.srcInfo = srcInfo;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
