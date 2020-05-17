package com.capstne.penthoughts;

import com.capstne.penthoughts.controllers.EntryController;
import com.capstne.penthoughts.daos.EntryDAO;
import com.capstne.penthoughts.model.Entry;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EntryControllerTests {
    @Before
    public void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    EntryController entryController;

    @Mock
    EntryDAO entryDAO;

    @Test
    public void testAddEntry(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(entryDAO.addEntry(any(Entry.class))).thenReturn(true);

        Entry entry = new Entry(0, null, null, "test title", "test message");
        ResponseEntity<Entry> responseEntity = entryController.addEntry(entry);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void testUpdateEntry(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(entryDAO.addEntry(any(Entry.class))).thenReturn(true);

        Entry entry = new Entry(0, null, null, "test title", "updated message");
        ResponseEntity<Entry> responseEntity = entryController.updateEntry(entry,1);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}
