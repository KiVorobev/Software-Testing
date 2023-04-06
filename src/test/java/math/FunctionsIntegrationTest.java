package math;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionsIntegrationTest {
    Functions f;

    @BeforeEach
    void init() {
        f = Mockito.spy(new Functions());
    }
}
