package com.vwits.skoda.skodademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.ArrayList;

@Service
public class ModelService  {
    @Autowired
    ModelRepository repo;

    public List<Model> getAllPublishdata() {
        List<Model> publish = new ArrayList<Model>();
        repo.findAll().forEach(model -> publish.add(model));
        System.out.println("reached");
        return publish;
    }

    public Model searchByurl(String backend_url) {
        return repo.findById(backend_url).get();
    }

    public Model saveOrUpdate(Model model) {
        return repo.save(model);
    }
    public void delete(String backend_url) {
        repo.deleteById(backend_url);
    }


}
