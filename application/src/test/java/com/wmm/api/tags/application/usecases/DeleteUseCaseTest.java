package com.wmm.api.tags.application.usecases;

import com.wmm.api.tags.application.ports.input.DeleteTagInputPort;
import com.wmm.api.tags.application.ports.output.TagOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DeleteUseCaseTest {

    @InjectMocks
    private DeleteTagInputPort deleteTagInputPort;

    @Mock
    private TagOutputPort tagOutputPort;

    private String tagId;

    @Test
    public void test(){
       Mockito.doNothing().when(tagOutputPort).delete(tagId);
       deleteTagInputPort.execute(tagId);
       Mockito.verify(tagOutputPort, Mockito.times(1)).delete(tagId);
    }
}
