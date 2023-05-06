package com.prodius.module3.lesson16hw;

import com.prodius.module3.lesson16hw.annotation.Annotation;
import com.prodius.module3.lesson16hw.util.SaveFile;


public class Main {
    public static void main(String[] args) {
        final Annotation annotation = new Annotation();
        annotation.annotationHandler();
        SaveFile.saveToFile(annotation.getCache());

        /*MapRepository<String, Integer> mapRepository = new MapRepository<>();
        mapRepository.addIndex("1", 1);
        mapRepository.addIndex("2", 2);
        mapRepository.remove(2);
        mapRepository.show();

        ListRepository<Integer> listRepository = new ListRepository<>();
        listRepository.add(2);
        listRepository.add(3);
        listRepository.set(1, 4);
        listRepository.remove(2);
        listRepository.show();

        ArrayRepository<Integer> arrayRepository = new ArrayRepository<>();
        arrayRepository.add(4);
        arrayRepository.addIndex(0, 0);
        arrayRepository.set(1, 2);
        arrayRepository.show();*/


    }
}