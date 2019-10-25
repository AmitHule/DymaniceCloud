package com.testDemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Poc {

    @Id
    int id;

    @NotNull
    String apiUrl;

    public String getApiUrl() {
        return apiUrl;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    String  apiName;
}
