import org.junit.jupiter.api.Test;

import static fr.enimaloc.enutils.classes.ObjectUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class ObjectUtilsTest {

    @Test
    void supplierGet() {
        assertEquals("success", getOr(this::shouldNotFail, "failed"));
    }

    @Test
    void supplierOrWithException() {
        assertEquals("failed", getOr(this::shouldFail, "failed"));
    }

    @Test
    void supplierOrWithNull() {
        assertEquals("or", getOr(this::shouldBeNull, "or"));
    }

    private String shouldNotFail() {
        return "success";
    }

    private String shouldFail() {
        throw new RuntimeException("Should fail !");
    }

    private String shouldBeNull() {
        return null;
    }

    @Test
    void valueGet() {
        assertEquals("success", getOr("success", "or"));
    }

    @Test
    void valueOr() {
        assertEquals("or", getOr(null, "or"));
    }
}