
/**
 * Name:
 * Student Number:
 */
public class Main {

    public static void main(String[] args) {
        OrganisingList list = new OrganisingList();

        list.insert(5);
        System.out.println(list.toStringKeysOnly());
        //5

        list = new OrganisingList();
        list.insert(7);
        list.insert(3);
        System.out.println(list.toStringKeysOnly());
        //7,3

        list.insert(90);
        list.insert(4);
        list.insert(50);
        System.out.println(list.toStringKeysOnly());
        //7,3,90,4,50

        list.delete(7);
        list.delete(90);
        list.delete(50);

        list.insert(2);
        list.insert(1);
        list.getData(4);
        System.out.println(list.toStringKeysOnly());
        //4,3,2,1

        System.out.println(list.contains(10000));
        System.out.println(list.contains(4) + "," + list.contains(1) + "," + list.contains(3));
        System.out.println(list.contains(24) + "," + list.contains(-1) + "," + list.contains(122343));
        /*false
        true, true, true
        false, false, false*/

        list.delete(4);
        list.delete(3);
        list.delete(2);
        list.delete(1);
        System.out.println(list.toString());
        System.out.println(list.toStringKeysOnly());
        //List is empty
        //List is empty

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        System.out.println(list.toStringKeysOnly());
        //1,2,3,4

        list.delete(3);
        System.out.println(list.toStringKeysOnly());
        //1,2,4

        list.delete(1);
        list.delete(132846);
        list.delete(-132846);
        System.out.println(list.toStringKeysOnly());
        //2,4

        list.delete(4);
        list.delete(3);
        list.delete(2);
        list.insert(3);
        System.out.println(list.toStringKeysOnly());
        //3

        list.delete(3);
        list.insert(20);
        System.out.println(list.toStringKeysOnly());
        //20

        list.delete(20);
        list.insert(7);
        System.out.println(list.toString());
        //[K: 7, D: 7]

        list.insert(3);
        list.insert(6);
        list.insert(2);
        System.out.println(list.toString());
        //[K: 7, D: 139] [K: 3, D: -13] [K: 6, D: 46] [K: 2, D: 2]

        System.out.println(list.getData(99));
        //null

        list = new OrganisingList();

        list.insert(13);
        System.out.println(list.toStringKeysOnly());
        //13

        list = new OrganisingList();
        list.insert(5);
        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.getData(3);
        System.out.println(list.toString());
        //[K: 3, D: 8] [K: 5, D: 37] [K: 4, D: 23] [K: 2, D: 5] [K: 1, D: 1]

        list.delete(12);
        list.delete(12234);
        list.delete(-12);
        list.delete(0);
        System.out.println(list.toString());
        //[K: 3, D: 8] [K: 5, D: 37] [K: 4, D: 23] [K: 2, D: 5] [K: 1, D: 1]

        list.delete(5);
        list.insert(9);
        list.delete(3);
        list.insert(41);
        list.delete(4);
        list.getData(41);
        list.getData(9);
        System.out.println(list.toString());
        //[K: 9, D: -1322] [K: 41, D: 1799] [K: 2, D: 5] [K: 1, D: 1]

        list.delete(41);
        System.out.println(list.toString());
        //[K: 9, D: 103] [K: 2, D: 5] [K: 1, D: 1]

        list.insert(41);
        list.getData(41);
        System.out.println(list.toString());
        //[K: 41, D: 2070] [K: 9, D: 103] [K: 2, D: 5] [K: 1, D: 1]
    }
}
