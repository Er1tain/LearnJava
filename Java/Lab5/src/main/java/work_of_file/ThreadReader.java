package work_of_file;

import java.util.ArrayList;

public class ThreadReader extends Thread{
    private FileResouce resource;
    private long time_sleep_thread;

    //Индекс слова с которого начинается обработка и шаг обработки
    private Integer start;
    private Integer delta;

    //Слова, обработанные потоком
    private ArrayList<String> words = new ArrayList<>();

    public ArrayList<String> getWordsThread() {
        return words;
    }

    public void saveWordInThread(String word) {
        words.add(word);
    }


    public ThreadReader(FileResouce resource, String thread_name) {
        setName(thread_name);
        this.resource = resource;
    }

    public ThreadReader(FileResouce resource, String thread_name, long time_sleep) {
        this.time_sleep_thread = time_sleep;
        setName(thread_name);
        this.resource = resource;
    }

    private void sleep_thread(long millsec) {
        try {
            sleep(millsec);
        } catch (InterruptedException e) {

        }
    }

    //Вывести обработанные слова
    public void PrintWords() {
        String result = "Поток " + getName() + ": ";
        for (String word: words) {
            result += word + ' ';
        }
        System.out.println(result);
    }

    public ThreadReader setStartWordDelta(Integer start_index, Integer i) {
        this.start = start_index;
        this.delta = i;

        return this;
    }

    @Override
    public void run() {
        sleep_thread(time_sleep_thread);
        resource.SaveReadWord(this, this.start, this.delta);

        //Выводим обработанные слова потока
        PrintWords();
    }

}
