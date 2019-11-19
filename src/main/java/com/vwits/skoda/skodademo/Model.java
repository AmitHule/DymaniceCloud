package com.vwits.skoda.skodademo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Component
// to create object

@Entity

@Table(name="PublishAPI")
public class Model {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String backend_url;


    @Column(name="publish_option")
    private String publish_option;

    @Column(name="basicname")
    private String basicname;

    @Column(name="Displayname")
    private String Displayname;

    @Column(name="Basicdescription")
    private String Basicdescription;

    @Column(name="bussiness_domain")
    private String bussiness_domain;

    @Column(name="Basicpath")
    private String Basicpath;

    @Column(name="Application_name")
    private String Application_name;

    @Column(name="changesapp")
    private String changesapp;

    @Column(name="definition_upload")
    private String definition_upload;

    @Column(name="product_name")
    private String product_name;

    @Column(name="product_desp")
    private String product_desp;

    @Column(name="no_of_requests")
    private String no_of_requests;

    @Column(name="no_of_minutes")
    private String no_of_minutes;

    public String getBasicname() {
        return basicname;
    }

    public void setBasicname(String basicname) {
        this.basicname = basicname;
    }

    public String getDisplayname() {
        return Displayname;
    }

    public void setDisplayname(String displayname) {
        Displayname = displayname;
    }

    public String getBasicdescription() {
        return Basicdescription;
    }

    public void setBasicdescription(String basicdescription) {
        Basicdescription = basicdescription;
    }

    public String getBussiness_domain() {
        return bussiness_domain;
    }

    public void setBussiness_domain(String bussiness_domain) {
        this.bussiness_domain = bussiness_domain;
    }

    public String getBasicpath() {
        return Basicpath;
    }

    public void setBasicpath(String basicpath) {
        Basicpath = basicpath;
    }

    public String getApplication_name() {
        return Application_name;
    }

    public void setApplication_name(String application_name) {
        Application_name = application_name;
    }

    public String getChangesapp() {
        return changesapp;
    }

    public void setChangesapp(String changesapp) {
        this.changesapp = changesapp;
    }

    public String getDefinition_upload() {
        return definition_upload;
    }

    public void setDefinition_upload(String definition_upload) {
        this.definition_upload = definition_upload;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_desp() {
        return product_desp;
    }

    public void setProduct_desp(String product_desp) {
        this.product_desp = product_desp;
    }

    public String getNo_of_requests() {
        return no_of_requests;
    }

    public void setNo_of_requests(String no_of_requests) {
        this.no_of_requests = no_of_requests;
    }

    public String getNo_of_minutes() {
        return no_of_minutes;
    }

    public void setNo_of_minutes(String no_of_minutes) {
        this.no_of_minutes = no_of_minutes;
    }

    public String getBackend_url() {
        return backend_url;
    }

    public void setBackend_url(String backend_url) {
        this.backend_url = backend_url;
    }

    public String getPublish_option() {
        return publish_option;
    }

    public void setPublish_option(String publish_option) {
        this.publish_option = publish_option;
    }





  public Model()
  {
  }




    @Override
    public String toString() {
        return backend_url;
    }
}
