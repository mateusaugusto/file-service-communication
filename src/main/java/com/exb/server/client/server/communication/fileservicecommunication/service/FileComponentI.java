package com.exb.server.client.server.communication.fileservicecommunication.service;


import DTO.FileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileComponentI {
    boolean exist() throws IOException;

    String upload(String aSessionId, MultipartFile file) throws IOException;

    List<String> list() throws IOException;

    List<FileDTO> listFile() throws IOException;
}
