package com.example.secondMicroService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/second")
    public ArrayList<Employee> getAll() throws JsonProcessingException {
        String url="http://openshift-adaptation-db-git-ranjithmgj-dev.apps.sandbox.x8i5.p1.openshiftapps.com/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        String res = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
        System.out.println(res);
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Employee> listFromJackson = mapper.readValue(res, new TypeReference<ArrayList<Employee>>(){});
        return listFromJackson;
    }

    @GetMapping("/praveen")
    public String getString2() throws JsonProcessingException {
        String url="http://testcloudcaller-git-1-pk96375-dev.apps.sandbox.x8i5.p1.openshiftapps.com/call?name=praveen";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        String res = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
        System.out.println(res);
        return res;
    }

}
