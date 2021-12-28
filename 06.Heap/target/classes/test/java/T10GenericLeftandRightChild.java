import com.jbbwebsolutions.datastructure.IGenericHeap;
import edu.citytech.cst3650.s16119461.heap.MaxGenericHeap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T10GenericLeftandRightChild {


    static IGenericHeap m = new MaxGenericHeap();

    @BeforeAll
    static void loadData(){ m.inserts(100,50,75,30,20,10,15);}

    @Test
    @DisplayName("T01 Get leftChild for index 0")
    public void getChild1(){
        var expected = 50;
        var actual = m.getLeftChild(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T02 Get leftChild for index 1")
    public void getChild2(){
        var expected = 30;
        var actual = m.getLeftChild(1);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T03 Get leftChild for index 2")
    public void getChild4(){
        var expected = 10;
        var actual = m.getLeftChild(2);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T01 Get rightChild for index 0")
    public void getChild5(){
        var expected = 75;
        var actual = m.getRightChild(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T02 Get rightChild for index 1")
    public void getChild6(){
        var expected = 20;
        var actual = m.getRightChild(1);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T03 Get rightChild for index 2")
    public void getChild7(){
        var expected = 15;
        var actual = m.getRightChild(2);
        assertEquals(expected, actual);
    }

    @Test
        @DisplayName("T01 swap 44 and 100")
        public void swap01(){
            MaxGenericHeap m = new MaxGenericHeap();
            m.insertBiConsumer( (e1, e2) -> {
                System.out.println(e1 + " | " + e2);
            });
            m.inserts(44,100,35,200,150);
            //System.out.println(m);
            System.out.println("test");
    }






    }


