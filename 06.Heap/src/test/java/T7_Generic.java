import com.jbbwebsolutions.datastructure.EnumComparison;
import com.jbbwebsolutions.datastructure.EnumMaxMin;
import com.jbbwebsolutions.datastructure.IGenericHeap;
import com.jbbwebsolutions.datastructure.IHeap;
import edu.citytech.cst3650.s16119461.heap.MaxGenericHeap;
import edu.citytech.cst3650.s16119461.heap.MaxHeap;
import edu.citytech.cst3650.s16119461.heap.MinGenericHeap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T7_Generic {

    @Test
    @DisplayName("T01 Insert 3 Numbers")
    public void insertTest(){

        IGenericHeap m = new MaxGenericHeap();


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

        IGenericHeap m = new MaxGenericHeap();

        m.inserts(10,20,30);

        var expected = 3;
        var actual = m.getSize();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("T01 Batch Insert 3 Numbers")
    public void insertTest3toArray(){

        IGenericHeap m = new MaxGenericHeap();

        m.inserts(10,20,30,20,50,90,30,55,1);

        //System.out.println((m.getSize()));
        System.out.println(((MaxGenericHeap<?>) m).toArray());

    }

    @Test
    @DisplayName("tolist")
    public  void toList(){
        IGenericHeap m = new MaxGenericHeap();

        m.inserts('a','b','c','d','e','f');;
        System.out.println(((MaxGenericHeap<?>) m).toList());
    }

    @Test
    @DisplayName("tolist")
    public  void findMaxGenericc(){
        MaxGenericHeap m = new MaxGenericHeap();

        Predicate<EnumMaxMin> maxPredicate = e -> EnumMaxMin.MAX == e;
        //Predicate<EnumComparison> minPredicate = e -> EnumComparison.MIN == e;

        m.inserts(25,42,66,98,2,57,63);
        //m.remove();
        m.find(maxPredicate, 1, (e1, e2) -> {});
        //((MaxHeap) m).find(minPredicate, 2, (e1, e2) -> {});
    }

    @Test
    @DisplayName("tolist")
    public  void findMaxGenericMaxTree(){
        MaxGenericHeap m = new MaxGenericHeap();

        Predicate<EnumMaxMin> maxPredicate = e -> EnumMaxMin.MAX == e;
        //Predicate<EnumComparison> minPredicate = e -> EnumComparison.MIN == e;

        m.inserts(5,2,3,9,4,7,8,12,1);
        //m.remove();
        m.find(maxPredicate, 2, (e1, e2) -> {});
        //((MaxHeap) m).find(minPredicate, 2, (e1, e2) -> {});
    }

    @Test
    @DisplayName("tolist")
    public  void findMinGenericMaxTree(){

        IGenericHeap m = new MaxGenericHeap();

        //Predicate<EnumMaxMin> maxPredicate = e -> EnumMaxMin.MAX == e;
        Predicate<EnumMaxMin> minPredicate = e -> EnumMaxMin.MIN == e;

        m.inserts(5,2,3,9,4,7,8,12,1);
        //m.remove();
        //m.find(maxPredicate, 2, (e1, e2) -> {});
        ((MaxGenericHeap<?>) m).find(minPredicate, 1,(e1, e2) -> {} );
    }

    @Test
    @DisplayName("findMin in a GenericMinTree")
    public  void findMinGenericMinTree(){

        IGenericHeap m = new MinGenericHeap();

        //Predicate<EnumMaxMin> maxPredicate = e -> EnumMaxMin.MAX == e;
        Predicate<EnumMaxMin> minPredicate = e -> EnumMaxMin.MIN == e;

        m.inserts(5,2,3,9,4,7,8,12,1);
        //m.remove();
        //m.find(maxPredicate, 2, (e1, e2) -> {});
        ((MinGenericHeap<?>) m).find(minPredicate, 3,(e1, e2) -> {} );
    }

    @Test
    @DisplayName("findMax in a GenericMinTree")
    public  void findMaxGenericMinTree(){

        IGenericHeap m = new MinGenericHeap();

        Predicate<EnumMaxMin> maxPredicate = e -> EnumMaxMin.MAX == e;
        //Predicate<EnumMaxMin> minPredicate = e -> EnumMaxMin.MIN == e;

        m.inserts(5,2,3,9,4,7,8,12,1);
        //m.remove();
        ((MinGenericHeap<?>) m).find(maxPredicate, 1, (e1, e2) -> {});
        //((MinGenericHeap<?>) m).find(minPredicate, 3,(e1, e2) -> {} );
    }




    @Test
    @DisplayName("tolist")
    public  void findMaxGenericLettersMaxTree(){
        MaxGenericHeap m = new MaxGenericHeap();

        Predicate<EnumMaxMin> maxPredicate = e -> EnumMaxMin.MAX == e;
        //Predicate<EnumComparison> minPredicate = e -> EnumComparison.MIN == e;

        m.inserts('a','b','c','d','e','f');

        m.find(maxPredicate, 1, (e1, e2) -> {});
        //((MaxHeap) m).find(minPredicate, 2, (e1, e2) -> {});
    }



    @Test
    @DisplayName("T01 swap 44 and 100")
    public void swap01(){
        IGenericHeap m = new MaxGenericHeap();

        m.inserts(25,42,66,98,2,57,63,26,10);
        m.remove();
        m.remove();
        System.out.println(((MaxGenericHeap<?>) m).toList());
        //System.out.println("test");
    }


    @Test
    @DisplayName("T01 Batch Insert 3 Numbers")
    public void insertTestMin(){

        IGenericHeap m = new MinGenericHeap();

        m.inserts(25,42,66,98,2,57,63,26,10);
        m.remove();
        System.out.println((m.getSize()));
        System.out.println(((MinGenericHeap<?>) m).toList());

    }

    @Test
    @DisplayName("tolist")
    public  void mintoList(){
        IGenericHeap m = new MinGenericHeap();

        m.inserts(25,42,66,98,2,57,63,25,10);
        System.out.println(((MinGenericHeap<?>) m).toList());
    }

    @Test
    @DisplayName("tolist")
    public  void findMinMaxTree(){
        IGenericHeap m = new MaxGenericHeap();

        //Predicate<EnumMaxMin> maxPredicate = e -> EnumMaxMin.MAX == e;
        Predicate<EnumMaxMin> minPredicate = e -> EnumMaxMin.MIN == e;

        m.inserts(1,2,3,4,5,6,7,8,9);

        //((MaxGenericHeap<?>) m).find(maxPredicate, 1, (e1, e2) -> {});
        ((MaxGenericHeap) m).find(minPredicate, 1, (e1, e2) -> {});
    }

    @Test
    @DisplayName("tolist")
    public  void findGreaterThan(){
        IGenericHeap m = new MaxGenericHeap();

        //Predicate<EnumMaxMin> maxPredicate = e -> EnumMaxMin.MAX == e;
        //Predicate<EnumMaxMin> minPredicate = e -> EnumMaxMin.MIN == e;
        Predicate<EnumComparison> greaterThanPredicate = e -> EnumComparison.GREATER_THAN == e;

        m.inserts(1,2,3,4,5,6,7,8,9);

        //((MaxGenericHeap<?>) m).find(maxPredicate, 1, (e1, e2) -> {});
        ((MaxGenericHeap<?>) m).find(greaterThanPredicate, (Comparable) 2, (e1, e2) -> {});
    }

    @Test
    @DisplayName("findgreaterthan")
    public void findGreaterMaxHeap(){

        IGenericHeap m = new MaxGenericHeap();

        Predicate<EnumComparison> greaterThanPredicate = e -> EnumComparison.GREATER_THAN == e;

        m.inserts(1,2,3,4,5,6,7,8,9);

        ((MaxGenericHeap<?>) m).find(greaterThanPredicate, (Comparable) 5, (e1, e2) -> {});



    }













}





