package com.exb.server.client.server.communication.fileservicecommunication.controller;

import DTO.FileDTO;
import com.exb.server.client.server.communication.fileservicecommunication.service.FileComponentI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/file")
@Slf4j
public class FileController {

    @Autowired
    private FileComponentI component;

    @GetMapping
    public boolean exist() throws IOException {
        return component.exist();
    }

    @GetMapping(value = "/list")
    public List<String> list() throws IOException {
        return component.list();
    }

    @GetMapping(value = "/all")
    public List<FileDTO> listFile() throws IOException {
        return component.listFile();
    }

}
