import java.io.File;
import java.util.concurrent.ForkJoinPool;

import static com.sun.org.apache.xpath.internal.compiler.Token.contains;

public class Main {



    public static void main(String[] args) {

//        MyThread thread = new MyThread(1);
//        MyThread thread2 = new MyThread(2);
//
//        thread.start();
//        thread2.start();
        String folderPath = "C:\\Users\\Diagnost\\Desktop";
        File file = new File(folderPath);
        Node root = new Node(file);
        long start = System.currentTimeMillis();

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);

        long duration = System.currentTimeMillis() - start;
        System.out.println(duration + " ms");


    }

    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for (File file : files) {
            sum += getFolderSize(file);
        }
        return sum;
    }


}