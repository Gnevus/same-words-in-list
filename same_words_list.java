package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
@airoo
Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов.
Нужно подсчитать сколько раз каждое слово встречается в списке.
Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр - уникальная строка, а второй - число, сколько раз данная строка встречалась в списке.

Вывести содержимое словаря на экран.
В тестах регистр (большая/маленькая буква) влияет на результат.

Требования:
1. Метод countWords должен объявлять и инициализировать HashMap с типом элементов .
2. Метод countWords должен возвращать созданный словарь.
3. Метод countWords должен добавлять в словарь ключи, соответствующие уникальным строкам, и значения по этим ключам, отображающие сколько раз встречалась строка.
4. Программа должна выводить на экран полученный словарь.
5. Метод main должен вызывать метод countWords.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //вводим с клавиатуры 20 строк
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }
        //получаем Map с подсчетами из метода countWords
        Map<String, Integer> map = countWords(words);
        //выводим на экран полученный Map
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        //not economical
        /*
        int count = 0;
        for (String str : list) {
            for (String str2 : list) {
                if (str == str2) {
                    count++;
                }
            }
            result.put(str, count);
            count = 0;
        }
        */
        
        //заносим в HashMap данные слово - значение, если такой ключ уже встречается в HashMap,
        //то увеличиваем value по данному ключу на единицу, если нет, заносим данный ключ и значение 1
        for (String word: list) {
            result.put(word, result.containsKey(word) ? result.get(word) + 1: 1);
        }
        
        return result;
    }
}
