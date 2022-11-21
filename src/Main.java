import java.io.File;

public class Main {
    public static void main(String[] args)
    {

        MyThread thread = new MyThread(1);
        MyThread thread2 = new MyThread(2);

        thread.start();
        thread2.start();

        String folderPath = "C:\\Users\\Diagnost\\Desktop";
        File file = new File(folderPath);
        System.out.println(file.length());
        long start = System.currentTimeMillis();

        System.out.println(getFolderSize(file));

        long duration = System.currentTimeMillis() - start;
        System.out.println(duration + " ms");
    }

    public static long getFolderSize(File folder){
        if (folder.isFile()){
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for (File file : files){
            sum += getFolderSize(file);
        }
        return sum;
    }
}