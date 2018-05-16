package com.vistar.vetclinic.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

@RestController
@RequestMapping("/api")
public class RestControllerAPIs {

    @Autowired
    GridFsOperations gridOperations;

    private String imageFileId = "";

    @GetMapping("/save")
    public String saveFiles() throws FileNotFoundException {

        DBObject metaData = new BasicDBObject();
        metaData.put("organization", "JavaSampleApproach");

        InputStream iamgeStream = new FileInputStream("//home//anatoliy//more.jpg");
        metaData.put("type", "image");
        imageFileId = gridOperations.store(iamgeStream, "more.jpg", "image/jpg", metaData).toString();

        return "Done";
    }

    @GetMapping("/delete")
    public String deleteFile() {
        gridOperations.delete(new Query(Criteria.where("_id").is(imageFileId)));
        return "Done";
    }
}