public class InsertionSort {

    public static void main(String[] args) {

        int[] array1 = {5,644,64,61,98};
        int[] array2 = {98,4124,56436,34,77};
        int[] array3 = {90,76,83,65,33};
        insertionSort(array1);
        insertionSort(array2);
        insertionSort(array3);
        print(array1);
        print(array2);
        print(array3);

    }


    public static void insertionSort(int[] array) {


        for (int i = 0; i < array.length; i++) {

            boolean isTrue = false;


            for (int j = 0; j < array.length-1; j++) {

                if (array[j] > array[j + 1]) {
                    int value = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = value;
                    isTrue=true;
                }
            }
            if (!isTrue){
                break;
            }
        }
    }

    public static void print(int[] array){

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
