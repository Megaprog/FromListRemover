package sometree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FromListRemoverTest {

    private List<Integer> numbers1 = new ArrayList<>(Arrays.asList(2, 1, 1, 1, 1, 3, 3, 3, 1, 3, 2, 2));

    @Test(expected = IllegalArgumentException.class)
    public void test_removeNRepeatedInARow_WrongN() throws Exception {
        FromListRemover.removeNRepeatedInARow(Collections.emptyList(), 1);
    }

    @Test
    public void test_removeNRepeatedInARow_3() throws Exception {
        Assert.assertEquals(Arrays.asList(2, 1, 3, 2, 2), FromListRemover.removeNRepeatedInARow(numbers1, 3));
    }

    @Test
    public void test_removeNRepeatedInARow_2() throws Exception {
        Assert.assertEquals(Arrays.asList(2, 1, 3), FromListRemover.removeNRepeatedInARow(numbers1, 2));
    }

    @Test
    public void test_removeNRepeatedInARow_4() throws Exception {
        Assert.assertEquals(Arrays.asList(2, 3, 3, 3, 1, 3, 2, 2), FromListRemover.removeNRepeatedInARow(numbers1, 4));
    }

    @Test
    public void test_removeNRepeatedInARow_5() throws Exception {
        Assert.assertEquals(Arrays.asList(2, 1, 1, 1, 1, 3, 3, 3, 1, 3, 2, 2), FromListRemover.removeNRepeatedInARow(numbers1, 5));
    }


    private List<Integer> numbers2 = new ArrayList<>(Arrays.asList(2, 1, 2, 3, 4, 3, 3, 2, 4, 3));

    @Test(expected = IllegalArgumentException.class)
    public void test_removeNRepeated_WrongN() throws Exception {
        FromListRemover.removeNRepeated(Collections.emptyList(), 1);
    }

    @Test
    public void test_removeNRepeated_3() throws Exception {
        Assert.assertEquals(Arrays.asList(1, 4, 4), FromListRemover.removeNRepeated(numbers2, 3));
    }

    @Test
    public void test_removeNRepeated_2() throws Exception {
        Assert.assertEquals(Arrays.asList(1), FromListRemover.removeNRepeated(numbers2, 2));
    }

    @Test
    public void test_removeNRepeated_4() throws Exception {
        Assert.assertEquals(Arrays.asList(2, 1, 2, 4, 2, 4), FromListRemover.removeNRepeated(numbers2, 4));
    }

    @Test
    public void test_removeNRepeated_5() throws Exception {
        Assert.assertEquals(Arrays.asList(2, 1, 2, 3, 4, 3, 3, 2, 4, 3), FromListRemover.removeNRepeated(numbers2, 5));
    }
}
