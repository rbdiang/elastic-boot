package com.rbdiang.com.rbdiang.controllers;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by brian on 2/14/16.
 */
@RestController
public class ElasticPostController {

    @Autowired
    private Client client;


    @RequestMapping(path = "/isalive")
    public boolean isAlive() {
        return Boolean.TRUE;

    }

    @RequestMapping(path = "/json-post", method = RequestMethod.POST)
    public IndexResponse postJson(@RequestParam(name = "rawJson") String json) {
        System.out.println("Received json: " + json);
        return client.prepareIndex("events", "event").setSource(json).get();
    }
}
