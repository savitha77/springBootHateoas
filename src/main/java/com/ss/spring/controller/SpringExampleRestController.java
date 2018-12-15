package com.ss.spring.controller;


import com.ss.spring.pojo.TestResponse;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.print.attribute.standard.Media;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.jaxrs.JaxRsLinkBuilder.linkTo;

@RestController

public class SpringExampleRestController {


    @RequestMapping(method = RequestMethod.GET, path = "/withoutheader", produces =
            {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TestResponse> getMyName() {
        TestResponse response = new TestResponse();
        response.setMessage("Without Header");
        response.setName("From Controller");
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/testing", produces = "application/vnd.company.app-v1+json")
    public ResponseEntity<TestResponse> getMyNameHeader() {
        TestResponse response = new TestResponse();
        response.setMessage("WithHeader");
        response.setName("Controller");

        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/withlink" )
    public ResponseEntity<TestResponse> getResponseWithLink() {
        List<TestResponse> arrayList =new ArrayList();

        TestResponse response = new TestResponse();
        response.setMessage("WithLink");
        response.setName("From Controller");
        arrayList.add(response);
        Link selfLink = ControllerLinkBuilder
                .linkTo(ControllerLinkBuilder
                        .methodOn(SpringExampleRestController.class).getMyName())
                .withSelfRel();
        response.add(selfLink);
        return new ResponseEntity<TestResponse>(response,HttpStatus.FOUND);
    }

}
