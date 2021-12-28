import com.jbbwebsolutions.datastructure.EnumComparison;
import com.jbbwebsolutions.datastructure.EnumMaxMin;
import com.jbbwebsolutions.datastructure.IHeap;
import com.jbbwebsolutions.datastructure.IHeapQuery;
import edu.citytech.cst3650.s16119461.heap.MaxHeap;
import edu.citytech.cst3650.s16119461.heap.MinHeap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static com.jbbwebsolutions.datastructure.EnumComparison.EQUAL;

@DisplayName("Get Parent Value")
public class T6_Swap {
    @Test
    @DisplayName("T01 swap 44 and 100")
    public void swap01(){
        IHeap m = new MaxHeap();


        m.inserts(100,50,40,10,20,30,35);
        m.remove();
        m.remove();
        //var list =  MaxHeap.find(EQUAL, 30);
        System.out.println(m);
        //System.out.println("test");
    }

    @Test
    @DisplayName("T01 swap 44 and 100")
    public void swap02(){
        IHeap m = new MaxHeap();
        IHeap mh = m;
        //IHeapQuery mhq =  m;

        Predicate<EnumComparison> maxPredicate = e -> EnumComparison.MAX == e;
        //Predicate<EnumComparison> minPredicate = e -> EnumComparison.MIN == e;


        m.inserts(100,50,110,10,20,135,30,105,140,35);


        System.out.println("next test");
        m.remove();
        System.out.println(m);
        ((MaxHeap) m).find(maxPredicate, 1, (e1, e2) -> {});
        //((MaxHeap) m).find(minPredicate, 2, (e1, e2) -> {});



        //m.remove();
        //m.remove();
        //var list =  MaxHeap.find(EQUAL, 30);
        //System.out.println(m);
        //System.out.println("test");
    }
    @Test
    @DisplayName("T01 swap 44 and 100")
    public void findMaxMinHeap(){
        IHeap m = new MinHeap();

        Predicate<EnumComparison> maxPredicate = e -> EnumComparison.MAX == e;
        //Predicate<EnumComparison> minPredicate = e -> EnumComparison.MIN == e;


        m.inserts(100,50,110,10,20,135,30,105,140,35);


        System.out.println("next test");
        //m.remove();
        System.out.println(m);
        ((MinHeap) m).find(maxPredicate, 2, (e1, e2) -> {});
        //((MaxHeap) m).find(minPredicate, 2, (e1, e2) -> {});



        //m.remove();
        //m.remove();
        //var list =  MaxHeap.find(EQUAL, 30);
        //System.out.println(m);
        //System.out.println("test");
    }


    @Test
    @DisplayName("T01 swap 44 and 100")
    public void findMinMinHeap(){
        IHeap m = new MinHeap();

        //Predicate<EnumComparison> maxPredicate = e -> EnumComparison.MAX == e;
        Predicate<EnumComparison> minPredicate = e -> EnumComparison.MIN == e;


        m.inserts(100,50,110,10,20,135,30,105,140,35);


        System.out.println("next test");
        //m.remove();
        System.out.println(m);
        //((MinHeap) m).find(maxPredicate, 2, (e1, e2) -> {});
        ((MinHeap) m).find(minPredicate, 3, (e1, e2) -> {});



        //m.remove();
        //m.remove();
        //var list =  MaxHeap.find(EQUAL, 30);
        //System.out.println(m);
        //System.out.println("test");
    }




}
