package com.prodius.module3.lesson16hw;

import com.prodius.module3.lesson16hw.annotation.Annotation;
import com.prodius.module3.lesson16hw.repository.ArrayRepository;
import com.prodius.module3.lesson16hw.repository.ListRepository;
import com.prodius.module3.lesson16hw.repository.MapRepository;
import com.prodius.module3.lesson16hw.util.SaveFile;


public class Main {
    public static void main(String[] args) {
        new Annotation().annotationHandler();

        MapRepository mapRepository = new MapRepository();
        mapRepository.addIndex("1", 1);
        mapRepository.addIndex("2", 1);
        mapRepository.remove("2");
        mapRepository.show();

        ListRepository listRepository = new ListRepository();
        listRepository.add(2);
        listRepository.add(3);
        listRepository.set(1, 4);
        listRepository.remove(2);
        listRepository.show();

        ArrayRepository arrayRepository = new ArrayRepository();
        arrayRepository.add(4);
        arrayRepository.addIndex(0, "1a");
        arrayRepository.set(1, 2);
        arrayRepository.show();

        SaveFile.saveToFile(Annotation.CACHE);
    }
}