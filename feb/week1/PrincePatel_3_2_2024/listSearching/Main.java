package listSearching;
import java.util.Date;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static ArrayList<Integer> createArrayList(){
        ArrayList<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 15000; i++) {
            arr.add(random.nextInt(15000));
        }

        return arr;
    }

    public static int linearSearch(ArrayList<Integer> list, int target) {
        int n = list.size();

        for (int i = 0; i < n; i++) {
            if (list.get(i) == target) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = createArrayList();

        long startTime;
        long endTime;



        System.out.println("---------------Comparing Searching algorithms--------------------");


        startTime = new Date().getTime();
        arr = createArrayList();
        linearSearch(arr,10901);
        endTime = new Date().getTime();
        System.out.println("linear search took "+ (endTime-startTime) + " miliseconds to find");
        System.out.println();


        startTime = new Date().getTime();
        arr = createArrayList();
        binarySearch(arr,11001);
        endTime = new Date().getTime();
        System.out.println("binary search took "+ (endTime-startTime) + " miliseconds to find");
        System.out.println();

    }
}

