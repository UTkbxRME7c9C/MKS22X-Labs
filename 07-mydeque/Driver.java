
public class Driver {
    public static void main(String[] args){
        MyDeque<Integer> ass = new MyDeque<Integer>(2);
        ass.addFirst(1);
        System.out.println(ass);
 
        ass.addFirst(2);
        System.out.println(ass);
        ass.addLast(3);
        ass.addLast(999);
        ass.addFirst(99);
        System.out.println(ass);
        ass.removeLast();
        System.out.println(ass);
        System.out.println(ass.size());

    }
}
