package com.exb.server.client.server.communication.fileservicecommunication.component;

import com.exb.server.client.server.communication.fileservicecommunication.service.impl.FileComponentImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileComponentImplTest {

    @Autowired
    private FileComponentImpl fileComponent;

    private static String pathLocalFile = "simple_file.txt";


    @Test
    public void should_not_exit() throws Exception {
        Boolean exist = fileComponent.exist();
        assertThat(exist).isEqualTo(false);
    }

    @Ignore
    public void should_create() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
                "text/plain", "Spring Framework".getBytes());

        String created = fileComponent.upload("123", multipartFile);
        assertThat(created).isEqualTo("File created");
    }

}