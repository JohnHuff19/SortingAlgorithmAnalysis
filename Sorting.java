import java.util.*;
import java.util.Random;

public class Sorting {
    public static void main(String[] args) {
        Random rand = new Random();
        int size = displayIntro();
        int total_time = 0;
        for (int i = 0; i < 10; i++) {
            int[] array = fillArray(size);
            long startTime = System.currentTimeMillis();
            selectionSort(array);
            long stopTime = System.currentTimeMillis();
            long thisrun = stopTime - startTime;
            total_time += thisrun;
        }
        System.out.println("It took an average of " + total_time / 10 + " milliseconds for Selection Sort to sort each array.");
        total_time = 0;
        for (int i = 0; i < 10; i++) {
            int[] array = fillArray(size);
            long startTime = System.currentTimeMillis();
            bubbleSort(array);
            long stopTime = System.currentTimeMillis();
            long thisrun = stopTime - startTime;
            total_time += thisrun;
        }
        System.out.println("It took an average of " + total_time / 10 + " milliseconds for Bubble Sort to sort each array.");
        total_time = 0;
        for (int i = 0; i < 100; i++) {
            int[] array = fillArray(size);
            long startTime = System.currentTimeMillis();
            insertionSort(array);
            long stopTime = System.currentTimeMillis();
            long thisrun = stopTime - startTime;
            total_time += thisrun;
        }
        System.out.println("It took an average of " + total_time / 100 + " milliseconds for Insertion Sort to sort each array.");
        total_time = 0;
        for (int i = 0; i < 100; i++) {
            int[] array = fillArray(size);
            long startTime = System.currentTimeMillis();
            mergeSort(array, array.length);
            long stopTime = System.currentTimeMillis();
            long thisrun = stopTime - startTime;
            total_time += thisrun;
        }
        System.out.println("It took an average of " + total_time / 100 + " milliseconds for Merge Sort to sort each array.");
        total_time = 0;
        for (int i = 0; i < 100; i++) {
            int[] array = fillArray(size);
            long startTime = System.currentTimeMillis();
            quickSort(array, 0, array.length - 1);
            long stopTime = System.currentTimeMillis();
            long thisrun = stopTime - startTime;
            total_time += thisrun;
        }
        System.out.println("It took an average of " + total_time / 100 + " milliseconds for Quick Sort to sort each array.");
        total_time = 0;
        for (int i = 0; i < 100; i++) {
            int[] array = fillArray(size);
            long startTime = System.currentTimeMillis();
            heapSort(array);
            long stopTime = System.currentTimeMillis();
            long thisrun = stopTime - startTime;
            total_time += thisrun;
        }
        System.out.println("It took an average of " + total_time / 100 + " milliseconds for Heap Sort to sort each array.");
        total_time = 0;
        for (int i = 0; i < 100; i++) {
            int[] array = fillArray(size);
            long startTime = System.currentTimeMillis();
            radixSort(array, array.length);
            long stopTime = System.currentTimeMillis();
            long thisrun = stopTime - startTime;
            total_time += thisrun;
        }
        System.out.println("It took an average of " + total_time / 100 + " milliseconds for Radix Sort to sort each array.");
    }

    static int[] fillArray(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int j = 0; j < array.length; j++) {
            array[j] = rand.nextInt(n) + 1;
        }
        return array;
    }

    static int displayIntro() {
        System.out.println("This program will demonstrate the differences in speed 7 of the most common sorting algorithms.");
        System.out.println("1. Selection Sort\n2. Bubble Sort\n3. Insertion Sort\n4. Merge Sort\n5. Quick Sort\n6. Heap Sort\n7. Radix Sort");
        Scanner sc = new Scanner(System.in);
        System.out.println("Due to Selection Sort and Bubble Sort being less efficient, they will only sort 10 arrays.");
        System.out.println("Every other algorithm will sort 100 arrays of n size and display the average time in ms of each successful sort.");
        System.out.print("Enter how many integers you want each array to hold: ");
        return sc.nextInt();
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    static void heapify(int arr[], int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < N && arr[l] > arr[largest])
            largest = l;
        if (r < N && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, N, largest);
        }
    }

    static void heapSort(int arr[]) {
        int N = arr.length;
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
        for (int i = N - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void radixSort(int arr[], int n) {
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
