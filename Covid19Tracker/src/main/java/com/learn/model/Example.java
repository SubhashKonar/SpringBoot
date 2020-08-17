package com.learn.model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Message",
"Status",
"PostOffice"
})
public class Example {

@JsonProperty("Message")
private String message;
@JsonProperty("Status")
private String status;
@JsonProperty("PostOffice")
private List<PostOffice> postOffice = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("Message")
public String getMessage() {
return message;
}

@JsonProperty("Message")
public void setMessage(String message) {
this.message = message;
}

@JsonProperty("Status")
public String getStatus() {
return status;
}

@JsonProperty("Status")
public void setStatus(String status) {
this.status = status;
}

@JsonProperty("PostOffice")
public List<PostOffice> getPostOffice() {
return postOffice;
}

@JsonProperty("PostOffice")
public void setPostOffice(List<PostOffice> postOffice) {
this.postOffice = postOffice;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}