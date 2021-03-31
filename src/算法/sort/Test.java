package 算法.sort;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author ：Good_M
 * @date ：Created in 2020 2020/3/14 14:02
 */
public class Test {

    public static int[] retainAll(int[] arr1,int[] arr2){
        int i = 0;
        int j = 0;
        int k = 0;
        int minLenth = Math.min(arr1.length, arr2.length);
        int[] res = new int[minLenth];
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] == arr2[j]) {
                res[k] = arr1[i];
                i++;
                j++;
                k++;
                continue;
            }
            if (arr1[i] > arr2[j]) {
                j++;
                continue;
            }
            i++;
        }
        return res;
    }


    public static char find(char[] chars1,char[] chars2){
        int i = chars1.length/2;
        return binaryFind(chars1, chars2,i);


    }

    private static char binaryFind(char[] chars1,char[] chars2,int end){
        if (chars1[end] == chars2[end]) {
            if (chars1[end+1] != chars2[end+1]) {
                return chars1[end+1];
            }
            int i = (chars1.length - end) / 2;
            return binaryFind(chars1,chars2,i);
        }
        if (0 != end && chars1[end - 1] == chars2[end - 1]) {
            return chars1[end];
        }
        int i = (end - 0) / 2;
        return binaryFind(chars1,chars2,i);
    }

    public static void lock1(){
        try {
            synchronized (a){
                Thread.sleep(5000);
                synchronized (b){
                    //doSomething
                }
            }
        }catch (Exception e){
            //log
        }

    }
    public static void lock2(){
        try {
            synchronized (b){
                Thread.sleep(5000);
                synchronized (a){
                    //doSomething
                }
            }
        }catch (Exception e){
            //log
        }
    }

    static final Object a = 0;
    static final Object b = 0;

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime parse = LocalDateTime.parse("2020-04-15 11:25:36", formatter);
        long l = LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(l);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
//        String format = formatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(1586921136000L), ZoneId.systemDefault()));
//        System.out.println(format);

    }

}
