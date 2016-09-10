
package com.zachlittle.android.aca.duckducksearch.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Meta {

    private Maintainer maintainer;
    private String perlModule;
    private String status;
    private String productionState;
    private Object devDate;
    private String jsCallbackName;
    private String signalFrom;
    private Object liveDate;
    private Integer srcId;
    private SrcOptions srcOptions;
    private String repo;
    private List<Developer> developer = new ArrayList<Developer>();
    private String tab;
    private Object producer;
    private Integer unsafe;
    private String id;
    private String devMilestone;
    private List<String> topic = new ArrayList<String>();
    private String name;
    private Object attribution;
    private Object createdDate;
    private String exampleQuery;
    private String description;
    private Object isStackexchange;
    private Object designer;
    private String srcDomain;
    private String srcName;
    private Object blockgroup;
    private Object srcUrl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The maintainer
     */
    public Maintainer getMaintainer() {
        return maintainer;
    }

    /**
     * 
     * @param maintainer
     *     The maintainer
     */
    public void setMaintainer(Maintainer maintainer) {
        this.maintainer = maintainer;
    }

    /**
     * 
     * @return
     *     The perlModule
     */
    public String getPerlModule() {
        return perlModule;
    }

    /**
     * 
     * @param perlModule
     *     The perl_module
     */
    public void setPerlModule(String perlModule) {
        this.perlModule = perlModule;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The productionState
     */
    public String getProductionState() {
        return productionState;
    }

    /**
     * 
     * @param productionState
     *     The production_state
     */
    public void setProductionState(String productionState) {
        this.productionState = productionState;
    }

    /**
     * 
     * @return
     *     The devDate
     */
    public Object getDevDate() {
        return devDate;
    }

    /**
     * 
     * @param devDate
     *     The dev_date
     */
    public void setDevDate(Object devDate) {
        this.devDate = devDate;
    }

    /**
     * 
     * @return
     *     The jsCallbackName
     */
    public String getJsCallbackName() {
        return jsCallbackName;
    }

    /**
     * 
     * @param jsCallbackName
     *     The js_callback_name
     */
    public void setJsCallbackName(String jsCallbackName) {
        this.jsCallbackName = jsCallbackName;
    }

    /**
     * 
     * @return
     *     The signalFrom
     */
    public String getSignalFrom() {
        return signalFrom;
    }

    /**
     * 
     * @param signalFrom
     *     The signal_from
     */
    public void setSignalFrom(String signalFrom) {
        this.signalFrom = signalFrom;
    }

    /**
     * 
     * @return
     *     The liveDate
     */
    public Object getLiveDate() {
        return liveDate;
    }

    /**
     * 
     * @param liveDate
     *     The live_date
     */
    public void setLiveDate(Object liveDate) {
        this.liveDate = liveDate;
    }

    /**
     * 
     * @return
     *     The srcId
     */
    public Integer getSrcId() {
        return srcId;
    }

    /**
     * 
     * @param srcId
     *     The src_id
     */
    public void setSrcId(Integer srcId) {
        this.srcId = srcId;
    }

    /**
     * 
     * @return
     *     The srcOptions
     */
    public SrcOptions getSrcOptions() {
        return srcOptions;
    }

    /**
     * 
     * @param srcOptions
     *     The src_options
     */
    public void setSrcOptions(SrcOptions srcOptions) {
        this.srcOptions = srcOptions;
    }

    /**
     * 
     * @return
     *     The repo
     */
    public String getRepo() {
        return repo;
    }

    /**
     * 
     * @param repo
     *     The repo
     */
    public void setRepo(String repo) {
        this.repo = repo;
    }

    /**
     * 
     * @return
     *     The developer
     */
    public List<Developer> getDeveloper() {
        return developer;
    }

    /**
     * 
     * @param developer
     *     The developer
     */
    public void setDeveloper(List<Developer> developer) {
        this.developer = developer;
    }

    /**
     * 
     * @return
     *     The tab
     */
    public String getTab() {
        return tab;
    }

    /**
     * 
     * @param tab
     *     The tab
     */
    public void setTab(String tab) {
        this.tab = tab;
    }

    /**
     * 
     * @return
     *     The producer
     */
    public Object getProducer() {
        return producer;
    }

    /**
     * 
     * @param producer
     *     The producer
     */
    public void setProducer(Object producer) {
        this.producer = producer;
    }

    /**
     * 
     * @return
     *     The unsafe
     */
    public Integer getUnsafe() {
        return unsafe;
    }

    /**
     * 
     * @param unsafe
     *     The unsafe
     */
    public void setUnsafe(Integer unsafe) {
        this.unsafe = unsafe;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The devMilestone
     */
    public String getDevMilestone() {
        return devMilestone;
    }

    /**
     * 
     * @param devMilestone
     *     The dev_milestone
     */
    public void setDevMilestone(String devMilestone) {
        this.devMilestone = devMilestone;
    }

    /**
     * 
     * @return
     *     The topic
     */
    public List<String> getTopic() {
        return topic;
    }

    /**
     * 
     * @param topic
     *     The topic
     */
    public void setTopic(List<String> topic) {
        this.topic = topic;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The attribution
     */
    public Object getAttribution() {
        return attribution;
    }

    /**
     * 
     * @param attribution
     *     The attribution
     */
    public void setAttribution(Object attribution) {
        this.attribution = attribution;
    }

    /**
     * 
     * @return
     *     The createdDate
     */
    public Object getCreatedDate() {
        return createdDate;
    }

    /**
     * 
     * @param createdDate
     *     The created_date
     */
    public void setCreatedDate(Object createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 
     * @return
     *     The exampleQuery
     */
    public String getExampleQuery() {
        return exampleQuery;
    }

    /**
     * 
     * @param exampleQuery
     *     The example_query
     */
    public void setExampleQuery(String exampleQuery) {
        this.exampleQuery = exampleQuery;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The isStackexchange
     */
    public Object getIsStackexchange() {
        return isStackexchange;
    }

    /**
     * 
     * @param isStackexchange
     *     The is_stackexchange
     */
    public void setIsStackexchange(Object isStackexchange) {
        this.isStackexchange = isStackexchange;
    }

    /**
     * 
     * @return
     *     The designer
     */
    public Object getDesigner() {
        return designer;
    }

    /**
     * 
     * @param designer
     *     The designer
     */
    public void setDesigner(Object designer) {
        this.designer = designer;
    }

    /**
     * 
     * @return
     *     The srcDomain
     */
    public String getSrcDomain() {
        return srcDomain;
    }

    /**
     * 
     * @param srcDomain
     *     The src_domain
     */
    public void setSrcDomain(String srcDomain) {
        this.srcDomain = srcDomain;
    }

    /**
     * 
     * @return
     *     The srcName
     */
    public String getSrcName() {
        return srcName;
    }

    /**
     * 
     * @param srcName
     *     The src_name
     */
    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    /**
     * 
     * @return
     *     The blockgroup
     */
    public Object getBlockgroup() {
        return blockgroup;
    }

    /**
     * 
     * @param blockgroup
     *     The blockgroup
     */
    public void setBlockgroup(Object blockgroup) {
        this.blockgroup = blockgroup;
    }

    /**
     * 
     * @return
     *     The srcUrl
     */
    public Object getSrcUrl() {
        return srcUrl;
    }

    /**
     * 
     * @param srcUrl
     *     The src_url
     */
    public void setSrcUrl(Object srcUrl) {
        this.srcUrl = srcUrl;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
