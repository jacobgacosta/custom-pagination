package io.snippets;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ActionsPaginationTest {

    @Test
    public void testPagination() {
        String[] row1 = {"24-02-1988", "9832.90", "894.90", "8934.67", "7844", "3653.33", "7634.33", "72367.38", "1283.10", "3847.11"};
        String[] row2 = {"05-11-1993", "324", "5656", null, null, null, null, null, null, null };
        String[] row3 = {"10-05-2000", "4558.88", "546.90", "233.11", "345.67", null, null, null, null, null};
        String[] row4 = {"12-12-2000", null, null, "5986", null, null, null, null, null, null};
        String[] row5 = {"25-02-1991", null, null, null, null, null, null, null, null, null};

        List<Object[]> result = Arrays.asList(row1, row2, row3, row4, row5);

        ActionsPagination pagination1 = new ActionsPagination(result, 0, 20);

        assertEquals(1, pagination1.numberOfPages());

        assertEquals(16, pagination1.getPage(0).size());

        assertEquals("24-02-1988", pagination1.getPage(0).get(0).getDate());
        assertEquals("Deposito", pagination1.getPage(0).get(0).getName());
        assertEquals("9832.90", pagination1.getPage(0).get(0).getAmount().toString());

        ActionsPagination pagination2 = new ActionsPagination(result, 5, 7);

        assertEquals(4, pagination2.numberOfPages());

        assertEquals(3, pagination2.getPage(2).size());

        assertEquals(2, pagination2.getPage(3).size());

        assertEquals("10-05-2000", pagination2.getPage(2).get(0).getDate());
        assertEquals("Deposito", pagination2.getPage(2).get(0).getName());
        assertEquals("4558.88", pagination2.getPage(2).get(0).getAmount().toString());
    }

}
