package com.exb.server.client.server.communication.fileservicecommunication.service.impl;

import DTO.FileDTO;
import com.exb.client.fileserviceclient.service.FileService;
import com.exb.server.client.server.communication.fileservicecommunication.feign.FileFeignClient;
import com.exb.server.client.server.communication.fileservicecommunication.service.FileComponentI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class FileComponentImpl implements FileComponentI {

    @Autowired
    private FileService fileService;

    @Autowired
    private FileFeignClient fileFeignClient;

    @Override
    public boolean exist() throws IOException {
       return this.fileService.exist("123", "/tmp/download.png");
    }

    @Override
    public String upload(String aSessionId, MultipartFile file) throws IOException {
        return this.fileService.upload(aSessionId, file);
    }

    @Override
    public List<String> list() throws IOException {
        String token = this.buildTokenJwt(fileService.getToken());
        return fileFeignClient.list("123", token);
    }

    @Override
    public List<FileDTO> listFile() throws IOException {
        String token = this.buildTokenJwt(fileService.getToken());
        return fileFeignClient.listFile("123", token);
    }

    private String buildTokenJwt(String token) {
        if (null != token) {
            token = "Bearer " + token;
        }
        return token;
    }



  /*  public List<FileDTO> list(){
        return this.fileService.exist("123", "/tmp/download.png");
    }*/




}
