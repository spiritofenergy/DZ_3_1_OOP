package org.example;

import org.out.Java;
import org.out.Kotlin;
import org.out.Swift;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("1. Создайте классы с полями для описания структуры университета. \n" +
                "Комбинируйте! Пусть одни классы будут полями других");
        Decanat rector = new Decanat();
        System.out.println(rector.proRector);

        Chancellery buch = new Chancellery();
        System.out.println(buch.glavBuch);

        University univer = new University();
        System.out.println(univer.department);

        //////////////////
        System.out.println("2. Создайте классы для описания операционных систем");

        Windows win = new Windows();
        System.out.println(win.name + " " + win.prise);

        MacOS mac = new MacOS();
        System.out.println(mac.name + " " + mac.prise);

        Ubuntu ubuntu = new Ubuntu();
        System.out.println(ubuntu.name + " " + ubuntu.prise);

        /////////////////
        System.out.println("3. Создайте классы для описания языков программирования (типизации, версии, \n" +
                "массив ключевых слов..)");
//!!! Мне не удалось избежать дублирования кода(
        //Создаем экземпляр класса
        Swift swift = new Swift();
        Java java = new Java();
        Kotlin kotlin = new Kotlin();
        // Выводим значения полей kotlin
        System.out.println("\n Название языка : " + kotlin.name
                + ", Год создания: " + kotlin.year_of_creation
                + ", Создатель: " + kotlin.creator
                + ", Версия: " + kotlin.version
                + ", Типизированный: " + kotlin.types);
        System.out.println("Служебные слова: ");
        for (int y = 0; y < 6; y++) {
            System.out.print(kotlin.keywords[y] + ", ");
        }
        System.out.println("\n Применение: " + kotlin.main_Application);
        //Java
        System.out.println("\n Название языка : " + java.name
                + ", Год создания: " + java.year_of_creation
                + ", Создатель: " + java.creator
                + ", Версия: " + java.version
                + ", Типизированный: " + java.types);
        System.out.println("Служебные слова: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(java.keywords[i] + ", ");
        }
        System.out.println("\n Применение: " + java.main_Application);
        //Swift
        System.out.println("\n Название языка : " + swift.name
                + ", Год создания: " + swift.year_of_creation
                + ", Создатель: " + swift.creator
                + ", Версия: " + swift.version
                + ", Типизированный: " + swift.types);
        System.out.println("Служебные слова: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(swift.keywords[i] + ", ");
        }
        System.out.println("\n Применение: " + swift.main_Application);


        /////////////////
        System.out.println("4. Сохраните информацию о всех файлах в заданной директории в массив \n" +
                "FileInformation");
        File dir = new File("E:\\Sinergy\\DZ_3_1_OOP\\src\\main\\java\\org\\out\\");
        File[] files = dir.listFiles();
        int filesCount = files.length;
        FileInformation[] fileInfos = new FileInformation[filesCount];

        for (int i = 0; i < files.length; i++) {
            File currentFile = files[i];
            FileInformation info = new FileInformation();
            info.absolutePath = currentFile.getAbsolutePath();
            info.fileName = currentFile.getName();
            info.size = currentFile.length();
            fileInfos[i] = info;
        }
        for (int i = 0; i < files.length; i++) {
            System.out.println(" Название: "
                    + fileInfos[i].fileName + "\n Путь к файлу : "
                    + fileInfos[i].absolutePath + "\n Размер: "
                    + fileInfos[i].size);
        }

        System.out.println("5. Сохраните снимок дня NASA в свой созданный класс");
        String DEMO_KEY = "WgH82FSmI6M04geem07EWObXt2MbUuZGM2dmfYTg";
        Nasa nasa = new Nasa();
        int data = 11;
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=" + DEMO_KEY + "&start_date=2017-07-08&end_date=2017-07-" + data);
        //Url
        int urlBegin = page.lastIndexOf("url");
        int urlEnd = page.lastIndexOf("}");
        String urlPhotos = page.substring(urlBegin + 6, urlEnd - 1);
        nasa.url = urlPhotos;
        //Date
        int dataBegin = page.lastIndexOf("date");
        int dateEnd = page.lastIndexOf("date");
        String dateUrl = page.substring(dataBegin + 7, dateEnd + 17);
        nasa.date = dateUrl;
        //Explanation
        int explanationBegin = page.lastIndexOf("explanation");
        int explanationEnd = page.lastIndexOf("hdurl");
        String textExplanation = page.substring(explanationBegin + 14, explanationEnd - 3);
        nasa.explanation = textExplanation;
        //title
        int titleBegin = page.lastIndexOf("title");
        int titleEnd = page.lastIndexOf("url\"");
        String title = page.substring(titleBegin + 8, titleEnd - 3);
        nasa.title = title;
        System.out.println(" Название: "
                + nasa.title + "\n Url адрес: "
                + nasa.url + "\n Date: "
                + nasa.date + "\n Описание: "
                + nasa.explanation);


        //////////////////
        System.out.println("\n 6. Сделайте класс для цитаты из breaking bad: цитата и автор. Сохраните в массив \n" +
                "таких классов 10 цитат.");
            Quote quote = new Quote();
        for (int i = 0; i < 10; i++){
            String pageQ = downloadWebPage("https://api.breakingbadquotes.xyz/v1/quotes");
            int quote4 = pageQ.lastIndexOf("quote");
            int author4 = pageQ.indexOf("author");
            int author_4 = pageQ.indexOf("\"}]");
            String strQuote = pageQ.substring(quote4 + 7, author4 - 2);
            String strAuthor = pageQ.substring(author4 + 9, author_4);
            quote.text = strQuote;
            quote.author = strAuthor;
            System.out.println(quote.author + quote.text);
        }
    }

         private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
        while ((line = br.readLine()) != null) {
        result.append(line);
        }
        }
        return result.toString();
    }
}





