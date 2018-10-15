package com.exb.server.client.server.communication.fileservicecommunication.feign;

import DTO.FileDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

@FeignClient(name = "file", url = "http://localhost:8080")
public interface FileFeignClient {


    @RequestMapping(value = "/file/list/{aSessionId}", method = {RequestMethod.GET})
    List<String> list(@PathVariable("aSessionId") String aSessionId,
                      @RequestHeader("Authorization") String token) throws IOException;

    @RequestMapping(value = "/file/all/{aSessionId}", method = {RequestMethod.GET})
    List<FileDTO> listFile(@PathVariable("aSessionId") String aSessionId,
                       @RequestHeader("Authorization") String token) throws IOException;


}
