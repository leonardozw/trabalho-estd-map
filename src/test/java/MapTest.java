import org.example.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MapTest {
    Map sut = new Map();
    @Test
    public void putByArguments_ReturnsNotNull(){
        sut.put("one", 1);
        Assertions.assertNotNull(sut);
        Assertions.assertEquals(1, sut.get("one"));
    }

    @Test
    public void getNodeByGivenKey_ReturnsValue(){
        sut.put("one", 1);
        var value = sut.get("one");
        Assertions.assertEquals(1, value);
    }

    @Test
    public void getSize_ReturnsSize(){
        sut.put("one", 1);
        Assertions.assertEquals(1, sut.size());
    }

    @Test
    public void isEmpty_ReturnsTrue(){
        Assertions.assertTrue(sut.isEmpty());
    }

    @Test
    public void isEmpty_ReturnsFalse(){
        sut.put("one", 1);
        Assertions.assertFalse(sut.isEmpty());
    }

    @Test
    public void removeNodeByGivenKey_ReturnsNull(){
        sut.put("one", 1);
        sut.remove("one");
        Assertions.assertNull(sut.get("one"));
    }

}
