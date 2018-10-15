package com.exb.server.client.server.communication.fileservicecommunication.component;

import com.exb.client.fileserviceclient.service.impl.FileServiceImpl;
import com.exb.server.client.server.communication.fileservicecommunication.FileServiceCommunicationApplication;
import com.exb.server.client.server.communication.fileservicecommunication.service.FileComponentI;
import com.exb.server.client.server.communication.fileservicecommunication.service.impl.FileComponentImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = FileServiceCommunicationApplication.class)
public class FileComponentImplTest {

    private FileComponentImpl componentI;

    private FileServiceImpl fileService;

    @Before
    public void before(){
        this.componentI = new FileComponentImpl();
        this.fileService = new FileServiceImpl();
    }

    @Test
    public void exist() throws Exception {
        Boolean exist = componentI.exist();

    }

}