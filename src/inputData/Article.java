package inputData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Article {

    default List<String> readArticle(String linkOnArticle){
        File articleText = new File(linkOnArticle);
        List<String> article = new ArrayList<>();               // добавление слов из статьи в массив
        try {
            Scanner art = new Scanner(articleText);
            while (art.hasNext()) {
                String word = art.next();
                article.add(word);
            }
            art.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return article;
    }

    default boolean checkWordsInArticle(List<String> article){     //проверка колличества совпадений в словах
        int countRepeat=0;
        for(String words: article){
            if(words.equals("снижение") || words.equals("кредит")){countRepeat++;}
        }
        return (countRepeat>5);
    }
}