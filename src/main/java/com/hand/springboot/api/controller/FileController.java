package com.hand.springboot.api.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description
 *
 * @author liangwusun 2021/03/29 15:14
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private Logger logger = LoggerFactory.getLogger(FileController.class);
    private String folder = "E:\\IDEA\\hzero\\spring-boot-logging\\src\\main\\resources\\static";

    @PostMapping
    public String upload(MultipartFile file) throws IOException {
        logger.info("fileName:" + file.getName());
        File localfile = new File(folder,System.currentTimeMillis()+".txt");
        file.transferTo(localfile);
        return localfile.getAbsolutePath();
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
        try (InputStream inputStream = new FileInputStream(new File(folder,id+".txt"));
            OutputStream outputStream = response.getOutputStream()){
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
