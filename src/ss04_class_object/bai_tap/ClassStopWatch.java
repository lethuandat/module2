package ss04_class_object.bai_tap;

import java.util.Date;

public class ClassStopWatch {
    public static void main(String[] args) {

    }

    public static class StopWatch {
        private String startTime;
        private String endTime;

        public StopWatch() {
        }

        public StopWatch(String startTime, String endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
//
//        public String start() {
//
//        }
//
//        public String stop() {
//
//        }
//
//        public String getElapsedTime() {
//
//        }
    }
}
