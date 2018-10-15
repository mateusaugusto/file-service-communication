package com.exb.server.client.server.communication.fileservicecommunication.service;


import DTO.FileDTO;

import java.io.IOException;
import java.util.List;

public interface FileComponentI {
    boolean exist() throws IOException;

    List<String> list() throws IOException;

    List<FileDTO> listFile() throws IOException;
}
