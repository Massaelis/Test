package com.prodius.lesson6hw.repository;

import com.prodius.lesson6hw.product.Television;

public class Repository{
    private static Object[] objects = new Object[20];
    public void save(final Object obj) {
        int index = putIndex(obj);
        if (index == objects.length){
            int oldLength = objects.length;
            increaseArray();
            objects[oldLength] = obj;
        }
    }
    private int putIndex(final Object obj){
        int index = 0;
        for(;index < objects.length;index++){
            if(objects[index] == null){
                objects[index] = obj;
                break;
            }
        }
        return index;
    }
    private void increaseArray(){
        Object[] newObj = new Object[objects.length * 2];
        System.arraycopy(objects, 0, newObj, 0, objects.length);
        objects = newObj;
    }
}