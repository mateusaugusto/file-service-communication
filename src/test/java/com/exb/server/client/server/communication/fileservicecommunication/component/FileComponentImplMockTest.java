package com.exb.server.client.server.communication.fileservicecommunication.component;

import DTO.FileDTO;
import com.exb.client.fileserviceclient.service.FileService;
import com.exb.server.client.server.communication.fileservicecommunication.service.impl.FileComponentImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FileComponentImplMockTest {

    @Mock
    private FileComponentImpl service;

    @Test
    public void exist() throws Exception {
        given(service.exist()).willReturn(true);

        Boolean exist = service.exist();

        verify(service, times(1)).exist();
        assertThat(exist).isEqualTo(true);

    }

    @Test
    public void list() throws Exception {
        List<String> listPath = Arrays.asList("/tmp/download.png", "/tmp/download1.png", "/tmp/download2.png", "/tmp/download3.png", "/tmp/download4.png");

        given(service.list()).willReturn(listPath);
        List<String> listPathActual= service.list();

        verify(service, times(1)).list();
        Assert.assertEquals(listPath.size(), listPathActual.size());

    }

    @Test
    public void listFile() throws Exception {
        List<FileDTO> listPath = this.fileDTOList();

        given(service.listFile()).willReturn(listPath);
        List<FileDTO> listPathActual= service.listFile();

        verify(service, times(1)).listFile();
        Assert.assertEquals(listPath.size(), listPathActual.size());

    }

    private List<FileDTO> fileDTOList() throws IOException {
        List<FileDTO> list = new ArrayList<>();
        File file = File.createTempFile("hello", ".tmp");

        for(int i =0; i <= 10; i++){
            FileDTO fileDTO = new FileDTO();
            fileDTO.setName(new Random() + ".png");
            fileDTO.setPath(file.toPath());
            list.add(fileDTO);
        }

        return list;

    }

}