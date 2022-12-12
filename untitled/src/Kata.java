import java.util.*;

public class Kata {

    public static void main(String[] args) {


        int[] a = {1,2,2,2,3,3,4};
        int[] b = {1,2,3};

        System.out.println(arrayDiff(a,b));
    }


    public static int[] arrayDiff(int[] a, int[] b) {

        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            numbers.add(a[i]);
        }

        List<Integer> list = new ArrayList<Integer>(numbers);

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j <list.size(); j++) {

                if (list.get(j).equals(b[i])){
                    list.remove(j);
                }
            }
        }

        int[] finalArray = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {

            finalArray[i] = list.get(i);
        }
        return finalArray;
    }


}

