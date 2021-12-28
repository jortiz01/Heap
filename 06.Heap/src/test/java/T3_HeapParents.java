import com.jbbwebsolutions.datastructure.IHeap;
import edu.citytech.cst3650.s16119461.heap.MaxHeap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T3_HeapParents {


    static IHeap m = new MaxHeap();

    @BeforeAll
    static void loadData(){ m.inserts(100,50,75,30,20,15,15);}

    @Test
    @DisplayName("T01 Get Parent for index 3")
    public void getParent1(){
        var expected = 50;
        var actual = m.getParent(3);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("T02 Get Parent for index 6")
    public void getParent2(){
        var expected = 75;
        var actual = m.getParent(6);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("T02 Get Parent for index 2")
    public void getParent3(){
        var expected = 100;
        var actual = m.getParent(2);
        assertEquals(expected,actual);
    }

}
