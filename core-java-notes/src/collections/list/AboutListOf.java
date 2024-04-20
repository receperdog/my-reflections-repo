package collections.list;

import java.util.List;

public class AboutListOf {
    public static void main(String[] args) {
        /**
         *  List.of method creates an immutable list, it means do not insert new elements to it.
         * */

        List<String> immutableList = List.of("test", "test2", "test3");
        immutableList.forEach(System.out::println);
        // try to add new element to immutable list
        try {
            immutableList.add("will throw an exception");
        }catch (Exception e){
            System.out.println(e.toString()); // OUTPUT: java.lang.UnsupportedOperationException
        }

    }

}
