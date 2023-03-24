package com.prodius.lesson9;

public class MyOptional<T> {

    private static final MyOptional<?> EMPTY = new MyOptional<>(null);

    private final T value;

    private MyOptional(final T value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public static <T> MyOptional<T> ofNullable(final T value) {
        return value == null ? (MyOptional<T>) EMPTY : new MyOptional<>(value);
    }

    boolean isPresent() {
        return value != null;
    }

    T get() {
        if (value == null) {
            throw new IllegalStateException();
        }
        return value;
    }
}

interface KeyValue<K, V> {
    K getKey();

    V getValue();
}

class MyKeyValue1<K, V> implements KeyValue<K, V> {
    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }
}

class MyKeyValue2 implements KeyValue<String, Integer> {
    @Override
    public String getKey() {
        return null;
    }

    @Override
    public Integer getValue() {
        return null;
    }
}

class MyKeyValue3<V> implements KeyValue<String, V> {
    @Override
    public String getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }
}

class MyKeyValue4<K, V, Y> implements KeyValue<K, V> {
    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }

    public Y getDescription() {
        return null;
    }
}

class ParamMethod {
    public <T> String toString(final T value) {
        return value.toString();
    }

    public static <T> String toString2(final T value) {
        return value.toString();
    }

}
