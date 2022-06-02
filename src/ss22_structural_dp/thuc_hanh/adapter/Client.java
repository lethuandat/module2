package ss22_structural_dp.thuc_hanh.adapter;

public class Client {
    private FileCalculator fileCalculator;

    public Client(FileCalculator fileCalculator) {
        this.fileCalculator = fileCalculator;
    }

    public void printFileSize(String path) {
        long size = fileCalculator.calculateSize(path);
        System.out.println("Size: " + size);
    }
}
