import com.jbbwebsolutions.datastructure.IHeap;
import edu.citytech.cst3650.s16119461.heap.MaxHeap;
import edu.citytech.cst3650.s16119461.heap.MinHeap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class T1_Heap {

    @Test
    @DisplayName("T01 Insert 3 Numbers")
    public void insertTest(){

        IHeap m = new MaxHeap();

        m.insert(10);
        m.insert(20);
        m.insert(30);

        var expected = 3;
        var actual = m.getSize();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("T01 Batch Insert 3 Numbers")
    public void insertTest2(){

        IHeap m = new MaxHeap();

        m.inserts(10,20,30);

        var expected = 3;
        var actual = m.getSize();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("T01 Batch Insert 11 Numbers")
    public void toList(){

        IHeap m = new MaxHeap();

        m.inserts(10,20,30,40,50,60,70,80,90);
        System.out.println(((MaxHeap) m).toList());

    }

    @Test
    @DisplayName("T01 Batch Insert 11 Numbers")
    public void toArray(){

        IHeap m = new MaxHeap();

        m.inserts(10,20,30,40,50,60,70,80,90);
        System.out.println(((MaxHeap) m).toArray());

    }

    @Test
    @DisplayName("T01 Batch Insert 11 Numbers")
    public void maxtoArray(){

        MaxHeap m = new MaxHeap();

        m.inserts(10,20,30,40,50,60,70,80,90);
        System.out.println(m.toArray());

    }
    @Test
    @DisplayName("T01 Insert 3 Numbers")
    public void insertTestMin1(){

        IHeap m = new MinHeap();

        m.insert(30);
        m.insert(20);
        m.insert(10);

        var expected = 3;
        var actual = m.getSize();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("T01 Batch Insert 3 Numbers")
    public void insertTestMin2(){

        IHeap m = new MinHeap();

        m.inserts(25,42,66,98,2,57,63,26,10);

        //m.remove();
        System.out.println(( ((MinHeap) m).toList()));

    }

    @Test
    @DisplayName("T01 Batch Insert 3 Numbers")
    public void insertTestMin3(){

        IHeap m = new MinHeap();

        m.inserts(14,19,26,31,10,42,27,33,35,44);

        System.out.println(((MinHeap) m).toArray());


    }


}
