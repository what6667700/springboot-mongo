package com.dc.mc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.*;


@SpringBootTest
public class ResultReview {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void reviewResults() throws IOException {
        File file = new File("E:\\Workspace\\workspace_intellij2020\\springboot-mongo\\src\\test\\resources\\longtou.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string = null;
        StringBuffer sb = new StringBuffer();
        while ((string = br.readLine())!= null){
            System.out.println(string);
        }
        br.close();
    }
}
