package list;

import com.liuzhao.list.MyArrayList;
import com.liuzhao.list.MyLinkedList;

import java.util.Date;
import java.util.Random;

public class TestList {

    public static void main(String[] args) {
        //Random random = new Random();
        //random.setSeed(new Date().getTime());

        //MyArrayList<Integer> list = new MyArrayList<Integer>();
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();

        list.add(5);
        list.add(9);
        list.add(13);
        list.add(-6);
        list.add(1);
        list.add(7);
        list.add(-3);
        list.add(2);
        list.add(7);

        System.out.println("list.size() = " + list.size());
        list.printList();

        list.remove(4);

        System.out.println("list.size() = " + list.size());
        list.printList();

        list.set(1, 8);

        System.out.println("list.size() = " + list.size());
        list.printList();

        int value = list.get(2);

        System.out.println("list.size() = " + list.size() + " index(2) = " + value);
        list.printList();

        list.removeByValue(7);
        System.out.println("list.size() = " + list.size());
        list.printList();

        list.remove(0);
        System.out.println("list.size() = " + list.size());
        list.printList();

        list.remove(0);
        System.out.println("list.size() = " + list.size());
        list.printList();

        list.remove(0);
        System.out.println("list.size() = " + list.size());
        list.printList();

        list.remove(0);
        System.out.println("list.size() = " + list.size());
        list.printList();

        list.remove(0);
        System.out.println("list.size() = " + list.size());
        list.printList();

        list.remove(0);
        System.out.println("list.size() = " + list.size());
        list.printList();

        list.remove(0);
        System.out.println("list.size() = " + list.size());
        list.printList();

        list.remove(0);
        System.out.println("list.size() = " + list.size());
        list.printList();

        list.remove(1);
        System.out.println("list.size() = " + list.size());
        list.printList();

        list.add(5);
        System.out.println("list.size() = " + list.size());
        list.printList();
    }

}
