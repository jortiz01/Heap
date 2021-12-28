import com.jbbwebsolutions.datastructure.IHeap;
import com.jbbwebsolutions.datastructure.IHeapQuery;
import edu.citytech.cst3650.s16119461.heap.MaxHeap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T2_HeapParentsAndChildren {

    static IHeap m = new MaxHeap();

    @BeforeAll
    static void loadData(){
        m.inserts(100,50,75,30,20,10,15);
    }

    @Test
    @DisplayName("T01 getLeftChild on Zero Index")
    public void getChild1(){

        var expected = 1;
        var actual = IHeap.getLeftChildIndex(0);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("T02 getLeftChild on 1 Index")
    public void getChild2(){

        var expected = 3;
        var actual = IHeap.getLeftChildIndex(1);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("T03 getLeftChild on 2 Index")
    public void getChild3(){

        var expected = 5;
        var actual = IHeap.getLeftChildIndex(2);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("T03 getLeftChild on 2 Index")
    public void toArray(){

        //m.toArray();
    }










}
