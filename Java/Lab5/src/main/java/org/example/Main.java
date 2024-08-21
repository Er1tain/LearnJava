package org.example;

import work_of_file.FileResouce;
import work_of_file.ThreadReader;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        //Список всех слов файла в обратном порядке
        ArrayList<String> reverse_list_all_words = new ArrayList<String>();

        FileResouce resource = new FileResouce("Files/words.txt");

        ThreadReader t1 = new ThreadReader(resource, "1");
        t1.setStartWordDelta(0, 4);
        t1.start();

        ThreadReader t2 = new ThreadReader(resource, "2");
        t2.setStartWordDelta(1, 4);
        t2.start();

        ThreadReader t3 = new ThreadReader(resource, "3");
        t3.setStartWordDelta(2, 4);
        t3.start();

        ThreadReader t4 = new ThreadReader(resource, "4");
        t4.setStartWordDelta(3, 4);
        t4.start();

        //Переворачиваем список слов файла
//        ThreadReader[] threads = {t2, t3, t4};
//
//        int m = 1, n = 2;
//        for(ThreadReader t: threads) {
//            t.join();
//            ArrayList<String> list = t.getWordsThread();
//            int j = 0;
//            for (int i = m; i < reverse_list_all_words.size(); i += n) {
//                if (j < list.size()) reverse_list_all_words.add(i, list.get(j));
//                j++;
//            }
//            m++;
//            n++;
//        }

        t1.join();
        reverse_list_all_words.addAll(t1.getWordsThread());

        t2.join();
        ArrayList<String> list = t2.getWordsThread();
        int j = 0;
        for (int i = 1; i < reverse_list_all_words.size(); i += 2) {
            if (j < list.size()) reverse_list_all_words.add(i, list.get(j));
            j++;
        }

        t3.join();
        list = t3.getWordsThread();
        j = 0;
        for (int i = 2; i < reverse_list_all_words.size(); i += 3) {
            if (j < list.size()) reverse_list_all_words.add(i, list.get(j));
            j++;
        }

        t4.join();
        list = t4.getWordsThread();
        j = 0;
        for (int i = 3; i < reverse_list_all_words.size(); i += 4) {
            if (j < list.size()) reverse_list_all_words.add(i, list.get(j));
            j++;
        }

        System.out.println(reverse_list_all_words.reversed());

    }
}