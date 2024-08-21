package work_of_file;

import java.io.*;
import java.util.ArrayList;

public class FileResouce {
    private File file;
    private String path_to_file;
    private ArrayList<String> file_words = new ArrayList<>();

    public FileResouce(String path_to_file) {
        this.path_to_file = path_to_file;
        file = new File(path_to_file);

        //Запишем в список все слова файла
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            //Считывание слов из файла
            String word;

            while ((word = br.readLine()) != null) {
                file_words.add(word);
            }

        } catch (IOException e) {
            System.err.println("Произошла ошибка считывания файла!");
        }
    }


    //Поток считывает и сохраняет слова(заданных позиций) из файла в список
    public void SaveReadWord(ThreadReader thread, Integer i_start_word, Integer delta) {
        // i_start_word – индекс первого слова, с которым начинает работать поток
        //delta – увеличение индекса предыдущей итерации на заданное значние delta

        for (Integer i = i_start_word; i < file_words.size(); i += delta) {
            if (i < file_words.size()) thread.saveWordInThread(file_words.get(i));
        }

    }

}
