package ss04_class_object.bai_tap.class_stop_watch;

public class TestStopWatch {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch(200,300);
        System.out.println(stopWatch);

        System.out.println("Bắt đầu đếm thời gian.");
        stopWatch.start();

        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        System.out.print("Mảng ban đầu: ");
        for (int item : arr) {
            System.out.print(item + " ");
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    maxIdx = j;
                }
                int temp = arr[maxIdx];
                arr[maxIdx] = arr[i];
                arr[i] = temp;
            }
        }

        System.out.print("\nMảng sau khi sắp xếp: ");
        for (int item : arr) {
            System.out.print(item + " ");
        }

        System.out.print("\nKết thúc đếm thời gian.");
        stopWatch.stop();

        long timeRun = stopWatch.getElapsedTime();
        System.out.print("\nThời gian chạy: " + timeRun + " milliseconds.");
    }
}
