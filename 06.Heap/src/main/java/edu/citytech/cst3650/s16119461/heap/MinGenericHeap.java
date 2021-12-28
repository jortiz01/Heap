package edu.citytech.cst3650.s16119461.heap;

import com.jbbwebsolutions.datastructure.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class MinGenericHeap<T extends Comparable<T>> extends ComparisonHelper implements IGenericHeap, IGenericHeapQuery {

    private T[] items;
    private int size;
    private int cap;
    private int height;
    private BiConsumer<Twin<Integer, T>, Twin<Integer, T>> biConsumer ;

    public MinGenericHeap()
    {
        items = (T[]) new Comparable[cap];
        size = 0;
        cap = 10;
        biConsumer = (e1, e2) -> {};
        height = 0;

    }



    @Override
    public void inserts(Comparable... values) {
        for (var value: values ) {
            this.insert(value);
        }

    }

    @Override
    public void insert(Comparable value) {
        if(this.size >= items.length - 1){
            items= this.resize();
        }
        items[size++] = (T) value;
        bubbleUp();
        height = height();
    }

    @Override
    public List find(Predicate predicate, Comparable value, BiConsumer biConsumer) {

        boolean greaterThan = predicate.test(EnumComparison.GREATER_THAN);
        boolean equalTo = predicate.test(EnumComparison.EQUAL);
        boolean lessThan = predicate.test(EnumComparison.LESS_THAN);


        System.out.println(greaterThan);
        System.out.println(equalTo);
        System.out.println(lessThan);



        if (greaterThan && !lessThan) {
            return findGreaterT(value, biConsumer);
        } else if (lessThan) {
            return findLessT(value, biConsumer);
        } else return findEqualToT(value, biConsumer);

    }


    private List findEqualToT(Comparable value, BiConsumer biConsumer) {
        List result = new ArrayList();

        for ( Comparable t: items ) {
            if (t.equals(value) ){
                result.add(t);
            }
        }

        return result;
    }



    private List findLessT(Comparable value, BiConsumer biConsumer) {
        List result = new ArrayList();

        for ( Comparable t: items ) {
            if (isLessThan(t, value)){
                result.add(t);
            }
        }
        return result;

    }

    private List findGreaterT(Comparable value, BiConsumer biConsumer) {
        List result = new ArrayList();

        for ( Comparable t: items ) {
            if (isGreaterThan(t, value)){
                result.add(t);
            }
        }
        return result;
    }


    @Override
    public List find(Predicate predicate, int value, BiConsumer biConsumer) {

        boolean max = predicate.test(EnumMaxMin.MAX );
        boolean min = predicate.test(EnumMaxMin.MIN );

        System.out.println(max);
        System.out.println(min);

        if (max) {
            return findMax(value, biConsumer);
        } else return findMin(value, biConsumer);

    }

    private List findMin(int value, BiConsumer biConsumer) {


        int index = (-1 + value);
        List result = new ArrayList();
        List answer = new ArrayList();
        for (T i : items) {
            result.add(i);
        }
        answer.add(result.get(index));
        System.out.println(answer);
        return answer;


    }

    private List findMax(int value, BiConsumer biConsumer) {


        List result = new ArrayList();
        List answer = new ArrayList();
        for (T i : items) {
            result.add(i);
        }
        System.out.println(result);
        answer.add(result.get(size - value));
        System.out.println(answer);
        return answer;

    }

    @Override
    public int remove(){

        if (size == 0) //if array is empty, do nothing
            return 0;

        items[0] = items[size - 1]; //swap last item with top item (removing top item)
        items[size - 1] = null; //fill last item with placeholder value
        size -- ; //minus size so ignore null placeholder
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
        int biggerIndex = 0;
        if (isLessThan(getLeftChild(index), getRightChild(index)))
            biggerIndex = IHeap.getLeftChildIndex(index);
        else biggerIndex = IHeap.getRightChildIndex(index); //otherwise

        return biggerIndex;
    }

    private int getSmallerIndex(int index){
        int smallerIndex;
        if (isGreaterThan(getLeftChild(index), getRightChild(index)))
            smallerIndex = IHeap.getRightChildIndex(index);
        else smallerIndex = IHeap.getLeftChildIndex(index); //otherwise

        return smallerIndex;
    }

    private boolean isInvalidParent(int index){


        var status = isGreaterThan(this.items[index], this.getLeftChild(index))
                && isGreaterThan(this.items[index], this.getRightChild(index));
        return status;

    }

    @Override
    public Object[] toArray() {
        System.out.println(Arrays.toString(Arrays.stream(items).toArray()));
        return Arrays.stream(items).toArray();
    }

    @Override
    public void insertBiConsumer(BiConsumer biConsumer) {
        this.biConsumer = biConsumer;
    }

    private T[] resize()
    {
        // add 10 to array capacity
        return Arrays.copyOf(items, items.length + cap);
    }

    private void swap(int index, int parentIndex) {

        var temp = items[index];
        items[index] = items[parentIndex];
        items[parentIndex] = temp;

        Twin<Integer,T> pair = new Twin<Integer, T> (index, items[index]);
        Twin<Integer,T> pair1 = new Twin<Integer, T>(parentIndex, items[parentIndex]);

        biConsumer.accept(pair, pair1);
    }


    private void bubbleUp(){
        var index = size - 1;
        T currentValue = items[index];
        T parentValue = (T) this.getParent(index);

        while(isLessThan(currentValue, parentValue)){
            //System.out.println("swap");
            var parentIndex = IHeap.getParentIndex(index);
            swap(index, parentIndex);

            index = parentIndex;

            currentValue = items[index];
            parentValue = (T) getParent(index);
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



    public Comparable getParentIndex(int index){
        return (index - 1) / 2;
    }

    public static Comparable getLeftChildIndex(int parentIndex){
        return parentIndex * 2 + 1;
    }

    public static Comparable getRightChildIndex(int parentIndex){
        return parentIndex * 2 + 2;
    }

    public int getSize(){return size;}


    @Override
    public String toString() {
        return "MaxGenericHeap{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                ", biConsumer=" + biConsumer +
                '}';
    }


    public T getParent(int index){
        return items[IHeap.getParentIndex(index)];
    }



    public T getLeftChild(int parentIndex){
        return items[IHeap.getLeftChildIndex(parentIndex)];
    }


    public T getRightChild(int parentIndex){
        return items[IHeap.getRightChildIndex(parentIndex)];
    }

    List<T> list = new ArrayList<>();

    @Override
    public List<T> toList() {
        for (T item:items)
        {
            list.add((T) item);
        }
        return list;
    }

}
