import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

class HashSetTest {

    @Test
    public void testCheckAll() {
        final HashSet<Integer> aHashStructure = new HashSet<Integer>();
        // Insert elements from 1 to 10_000_000 to the MM-Hash
        for(int i = 0; i < 10_000_000; i++)
        {
            aHashStructure.add(i);
        }
        long aStartTime = System.currentTimeMillis();

        for(int i = 0; i< 10_000_000; i++)
        {
            int aElement = i;
            assertTrue(aHashStructure.contains(aElement));
        }

        System.out.println("Время (мс)=" + (System.currentTimeMillis()-aStartTime));

    }

    @Test
    public void testCheckSingle() {
        final HashSet<Integer> aHashStructure = new HashSet<Integer>();
        // Insert elements from 1 to 10_000_000 to the MM-Hash
        for(int i = 0; i < 10_000_000; i++)
        {
            aHashStructure.add(i);
        }
        long aStartTime = System.currentTimeMillis();

        int aElement = 0;
        for(int i = 0; i< 10_000_000; i++)
        {
            assertTrue(aHashStructure.contains(aElement));
        }

        System.out.println("Время (мс)=" + (System.currentTimeMillis()-aStartTime));

    }

}