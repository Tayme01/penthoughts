package com.capstne.penthoughts;

import com.capstne.penthoughts.controllers.EntryController;
import com.capstne.penthoughts.daos.EntryDAO;
import com.capstne.penthoughts.model.Entry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class EntryControllerTests {
    @InjectMocks
    EntryController entryController;

    @Mock
    EntryDAO entryDAO;

    @Test
    public void testAddEntry(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(entryDAO.addEntry(any(Entry.class))).thenReturn(true);
    }
}
