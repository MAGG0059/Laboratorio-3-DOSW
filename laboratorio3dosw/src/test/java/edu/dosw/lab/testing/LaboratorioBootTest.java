package edu.dosw.lab.testing;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import edu.dosw.lab.Laboratorio3doswApplication;

@SpringBootTest
class Laboratorio3doswApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void mainMethodRuns() {
    
        assertDoesNotThrow(() -> 
            Laboratorio3doswApplication.main(new String[] {})
        );
    }
}
