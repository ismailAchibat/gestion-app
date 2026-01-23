package org.example.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.Train;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TrainServiceTest {

    @Autowired
    private TrainService service;

    @Test
    void creer_matricule_ok() {
        Train train = service.creer("8921");
        assertNotNull(train);
        assertEquals("8921", train.getMatricule());
        assertNotNull(train.getWagons());
        assertTrue(train.getWagons().isEmpty());
    }
}
