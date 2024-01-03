package org.example;

import org.out.Java;
import org.out.Kotlin;
import org.out.Swift;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {

    /*    System.out.println("1. Создайте классы с полями для описания структуры университета. \n" +
                "Комбинируйте! Пусть одни классы будут полями других");
        Decanat rector = new Decanat();
        System.out.println(rector.proRector);

        Chancellery buch = new Chancellery();
        System.out.println( buch.glavBuch);

        University univer = new University();
        System.out.println(univer.department);

        //////////////////
        System.out.println("2. Создайте классы для описания операционных систем");

        Windows win = new Windows();
        System.out.println(win.name +" "+ win.prise);

        MacOS mac = new MacOS();
        System.out.println(mac.name + " " + mac.prise);

        Ubuntu ubuntu = new Ubuntu();
        System.out.println(ubuntu.name + " " + ubuntu.prise);

        /////////////////
        System.out.println("3. Создайте классы для описания языков программирования (типизации, версии, \n" +
                "массив ключевых слов..)");
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
                System.out.print(kotlin.keywords[y] + ", ");}
            System.out.println("\n Применение: " + kotlin.main_Application);
            //Java
            System.out.println("\n Название языка : " + java.name
                    + ", Год создания: "+ java.year_of_creation
                    + ", Создатель: " + java.creator
                    + ", Версия: "+ java.version
                    + ", Типизированный: "+ java.types);
            System.out.println("Служебные слова: ");
            for (int i = 0; i < 6;i++){
                System.out.print(java.keywords[i] + ", ");}
            System.out.println("\n Применение: " + java.main_Application);
            //Swift
            System.out.println("\n Название языка : " + swift.name
                    + ", Год создания: "+ swift.year_of_creation
                    + ", Создатель: " + swift.creator
                    + ", Версия: "+ swift.version
                    + ", Типизированный: "+ swift.types);
                System.out.println("Служебные слова: ");
                for (int i = 0; i < 6;i++){
                    System.out.print(swift.keywords[i] + ", ");}
                System.out.println("\n Применение: " + swift.main_Application);


        /////////////////
        System.out.println("4. Сохраните информацию о всех файлах в заданной директории в массив \n" +
                "FileInformation");
        File dir = new File("E:\\Sinergy\\DZ_3_1_OOP\\src\\main\\java\\org\\out\\");
        File[] files = dir.listFiles();
        int filesCount = files.length;
        FileInformation[] fileInfos = new FileInformation[filesCount];

        for (int i = 0; i < files.length; i++){
            File currentFile = files[i];
            FileInformation info = new FileInformation();
            info.absolutePath = currentFile.getAbsolutePath();
            info.fileName = currentFile.getName();
            info.size = currentFile.length();
            fileInfos[i] = info;
        }
        for (int i = 0; i < files.length; i++){
            System.out.println(" Название: "
                    + fileInfos[i].fileName +"\n Путь к файлу : "
                    + fileInfos[i].absolutePath +"\n Размер: "
                    + fileInfos[i].size);
        }
*/

        String DEMO_KEY = "WgH82FSmI6M04geem07EWObXt2MbUuZGM2dmfYTg";
        for (int data = 10; data <= 15; data++ ) {

            String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key="+DEMO_KEY+"&start_date=2017-07-08&end_date=2017-07-"+data);
            System.out.println(page);
            int urlBegin = page.lastIndexOf("url");
            int urlEnd = page.lastIndexOf("}");
            String url = page.substring(urlBegin + 6, urlEnd - 1);
            System.out.println(url);
            try (InputStream in = new URL(url).openStream()) {
                Files.copy(in, Paths.get(data + "photo.jpg"));
            }
        }
        System.out.println("Ended");
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

   /*     String DEMO_KEY = "WgH82FSmI6M04geem07EWObXt2MbUuZGM2dmfYTg";
        String page = downloadWebPage("https://api.nasa.gov/planetary/earth/imagery?lon=-95.33&lat=29.78&date=2018-01-01&dim=0.15&api_key="+DEMO_KEY);
       // String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key="+DEMO_KEY);
        //  System.out.println(page);
        int urlBegin = page.lastIndexOf("url");
        int urlEnd = page.lastIndexOf("}");
        String url = page.substring(urlBegin + 6, urlEnd - 1);
        try (InputStream in = new URL(url).openStream()) {
            Files.copy(in, Paths.get("new_image.jpg"));
        }
        System.out.println("Picture saved");

        int explanationBegin = page.lastIndexOf("explanation");
        int explanationEnd = page.lastIndexOf("hdurl");
        String explanation = page.substring(explanationBegin + 13, explanationEnd - 2);
       // System.out.println(explanation);
    }

    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (
                InputStream is = urlConnection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();

    }
*/
      //  System.out.println("5. Сохраните снимок дня NASA в свой созданный класс");

  /*
        System.out.println("6. Сделайте класс для цитаты из breaking bad: цитата и автор. Сохраните в массив \n" +
                "таких классов 10 цитат.");
*/



