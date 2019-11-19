package com.vwits.skoda;

import com.vwits.skoda.skodademo.Model;
import com.vwits.skoda.skodademo.ModelRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.when;

public class ModelRepositoryTest {

    Model model=new Model();

    private  String backend_url="asa";
    private String publish_option="Azure";
    private String  basicname="srishti";
    private String  bussiness_domain="bussiness_domain";
    private String  changesapp="gdrg";
    private String  definition_upload="fed";
    private String product_name= "srgdfg";
    private String product_desp= "dsf";
    private String  no_of_requests= "2";
    private String  no_of_minutes= "3";
    private String displayname= "ADewferwf";
    private String basicdescription= "DFsdf";
    private String  basicpath="dsdass";

    private String  application_name="sdsad";

    @InjectMocks
    ModelRepository modelRepository;

    @Before
    public void setUp() throws Exception {
        model.setApplication_name(application_name);
        model.setBackend_url(backend_url);
        model.setBasicdescription(basicdescription);
        model.setBasicname(basicname);
        model.setBasicpath(basicpath);
        model.setBussiness_domain(bussiness_domain);
        model.setChangesapp(changesapp);
        model.setDefinition_upload(definition_upload);
        model.setDisplayname(displayname);
        model.setNo_of_minutes(no_of_minutes);
        model.setNo_of_requests(no_of_requests);
        model.setProduct_desp(product_desp);
        model.setProduct_name(product_name);
        model.setPublish_option(publish_option);
    }

    @Test
    public void testControllerShouldAcceptRequiredParamsAndReturnValidResponse() {



    }

}
