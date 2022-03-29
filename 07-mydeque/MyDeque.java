import java.util.*;

public class MyDeque<E>{
    private E[] data;
    private int start, end, size;

    public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 0;
        start = 5;
        end = 4;
    }

    public MyDeque(int initialCapacity){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[initialCapacity];
        data = d;
        size = 0;
        start = initialCapacity/2;
        end = initialCapacity/2 - 1;
    }

    public int size(){
        return size;
    }

    public String toString(){
        String str = "[";
        for(int i = start; i < end; i++){
            str += data[i] + ", ";
        }
        str += data[end] + "]";
        return str;
    }

    public void addFirst(E element){
        if (element == null) throw new NullPointerException();
        if(start == 0){
            resize(10,true);
        }
        start--;
        data[start] = element;
        size++;
    }

    public void addLast(E element){
        if(element == null) throw new NullPointerException();
        if (end == data.length-1){
            resize(10,false);
        }
        end++;
        data[end] = element;
        size++;
    }

    public E removeFirst(){
        if(size == 0) throw new NoSuchElementException();
        E temp = data[start];
        data[start] = null;
        start++;
        size--;
        return temp;
    }

    public E removeLast(){
        if(size == 0) throw new NoSuchElementException();
        E temp = data[end];
        data[end] = null;
        end--;
        size--;
        return temp;
    }

    public E getFirst(){
        if (size == 0) throw new NoSuchElementException();
        return data[start];
    }

    public E getLast(){
        if (size == 0) throw new NoSuchElementException();
        return data[end];
    }
    
    private void resize(int newsize, boolean front){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[data.length+newsize];
        if(front){
            for(int i = start; i <= end; i++){
                d[i+newsize] = data[i];
            }
            start += newsize;
            end += newsize;
        }
        else{
            for(int i = start; i <= end; i++){
                d[i] = data[i];
            }
        }
        data = d;
    }
}