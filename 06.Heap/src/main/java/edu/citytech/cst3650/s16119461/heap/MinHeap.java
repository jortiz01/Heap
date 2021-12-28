package edu.citytech.cst3650.s16119461.heap;

import com.jbbwebsolutions.datastructure.EnumComparison;
import com.jbbwebsolutions.datastructure.IHeap;
import com.jbbwebsolutions.datastructure.IHeapQuery;
import com.jbbwebsolutions.datastructure.Twin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class MinHeap implements IHeap, IHeapQuery {

    private int [] items = new int[10];
    private int size = 0;
    private int cap = 10;
    private int height = 0;
    private BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer = (e1, e2) -> {} ;



    //inserts multiple values, calling insert
    public void inserts(int... values){
        for (var value: values ) {
            this.insert(value);
        }
    }

    @Override
    public int height() {
        height =  (int)Math.ceil(Math.log(size +
                1) / Math.log(2)) - 1;

        return height;
    }

    public int getHeight(){
        return height;
    }

    @Override
    public List<Integer> find(Predicate<EnumComparison> predicate, int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {

        boolean greaterThan = predicate.test(EnumComparison.GREATER_THAN);
        boolean equalTo = predicate.test(EnumComparison.EQUAL);
        boolean lessThan = predicate.test(EnumComparison.LESS_THAN);
        boolean max = predicate.test(EnumComparison.MAX );
        boolean min = predicate.test(EnumComparison.MIN );

        System.out.println(greaterThan);
        System.out.println(equalTo);
        System.out.println(lessThan);
        System.out.println(max);
        System.out.println(min);

        if (greaterThan && !lessThan) {
            return findGreater(value, biConsumer);
        } else if (lessThan) {
            return findLess(value, biConsumer);
        }else if (max){
            return findMax(value, biConsumer);
        }else if (min){
            return findMin(value, biConsumer);
        }
        else return findEqualTo(value, biConsumer);
    }



    private List findMin(int value, BiConsumer biConsumer) {


        int index = value - 1;
        int count = 0;

        List result = new ArrayList();

        for (int i:items)
        {
            result.add(i);
        }

        Collections.sort(result);
        List answer = new ArrayList();

        for (Object i : result){
            if (i.equals(0) || i.equals(-999) || i.equals(-9999)){
                count++;
            }
        }
        answer.add(result.get((Integer) count + index));

        System.out.println(answer);

        return answer;


    }



    private List findMax(int value, BiConsumer biConsumer) {

        int index = value - 1;
        //int count = 0;

        List result = new ArrayList();

        for (int i:items)
        {
            result.add(i);
        }

        Collections.sort(result);
        List answer = new ArrayList();

        answer.add(result.get(((result.size()- 1)-index)));

        System.out.println(answer);
        return answer;


    }



    private List<Integer> findEqualTo(int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {

        List result = new ArrayList();

        for ( int i: items ) {
            if (i == value ){
                result.add(i);
            }
        }


        return result;
    }


    private List<Integer> findLess(int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {

        List result = new ArrayList();

        for ( int i: items ) {
            if (i < value ){
                result.add(i);
            }
        }
        return result;
    }

    private List<Integer> findGreater(int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {

        List result = new ArrayList();

        for ( int i: items ) {
            if (i > value ){
                result.add(i);
            }
        }
        return result;

    }

    @Override
    public int[] toArray() {

        System.out.println(Arrays.toString(Arrays.stream(items).toArray()));
        return Arrays.stream(items).toArray();

    }

    ArrayList list = new ArrayList();


    public List<Integer> toList() {
        for (int item:items)
        {
            list.add(item);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public int remove(){

        if (size == 0) //if array is empty, do nothing
            return 0;

        items[0] = items[size - 1]; //swap last item with top item (removing top item)
        items[size - 1] = 9999; //fill last item with placeholder value
        size -- ; //minus size so ignore -9999 placeholder
        bubbleDown();
        return 1;
    }

    private void bubbleDown() {

        int index = 0;

        while(isInvalidParent(index)){
            int smallerIndex = this.getSmallerIndex(index);
            this.swap(index, smallerIndex);
            index = smallerIndex;

        }

    }

    private int getBiggerIndex(int index){
        var biggerIndex = getLeftChild(index) > getRightChild(index) ?//if
                IHeap.getLeftChildIndex(index) : IHeap.getRightChildIndex(index); //otherwise

        return biggerIndex;
    }

    private int getSmallerIndex(int index){
        var smallerIndex = getLeftChild(index) < getRightChild(index) ?//if
                IHeap.getLeftChildIndex(index) : IHeap.getRightChildIndex(index); //otherwise

        return smallerIndex;
    }

    private boolean isInvalidParent(int index){
        var status = this.items[index] > this.getLeftChild(index)
                && this.items[index] > this.getRightChild(index);

        return status;

    }

    //used in insert to add cap=10 spaces to array
    private int[] resize(){

        return Arrays.copyOf(items, items.length + cap);
    }

    //insert individual values into array, checking if array is at cap or full
    public void insert(int value){

        if(this.size >= items.length - 1){
            items=this.resize();
        }
        items[size++] = value;
        bubbleUp();
        height = height();
    }

    private void bubbleUp(){
        var index = size - 1;
        var currentValue = items[index];
        var parentValue = this.getParent(index);

        while(currentValue < parentValue){
            //System.out.println("swap");
            var parentIndex = IHeap.getParentIndex(index);
            swap(index, parentIndex);

            index = parentIndex;

            currentValue = items[index];
            parentValue = getParent(index);
        }

    }


    private boolean hasRightChild(int i)
    {
        return rightIndex(i) <= size;
    }

    private boolean hasLeftChild(int i)
    {
        return leftIndex(i) <= size;
    }
    private int rightIndex(int i)
    {
        return i * 2 + 1;
    }
    private int leftIndex(int i)
    {
        return i * 2;
    }

    private void swap(int index, int parentIndex) {

        var temp = items[index];
        items[index] = items[parentIndex];
        items[parentIndex] = temp;

        Twin<Integer,Integer> pair = new Twin<Integer, Integer> (index, items[index]);
        Twin<Integer,Integer> pair1 = new Twin<Integer, Integer>(parentIndex, items[parentIndex]);

        biConsumer.accept(pair, pair1);
    }



    public int getSize() {
        return size;
    }

    @Override
    public void insertBiConsumer(BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {
        this.biConsumer = biConsumer;

    }


    public int getParent(int index){
        return items[IHeap.getParentIndex(index)];
    }


    /* T4_HeapLeftChild */
    public int getLeftChild(int parentIndex){
        return items[IHeap.getLeftChildIndex(parentIndex)];
    }

    /* T5_HeapRightChild */
    public int getRightChild(int parentIndex){
        return items[IHeap.getRightChildIndex(parentIndex)];
    }



    @Override
    public String toString() {
        return "MaxHeap{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                '}';
    }




}
