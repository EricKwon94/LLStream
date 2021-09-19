package com.github.llstream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class LLStream {
    private LLStream() {
    }

    //region FILTER
    static public <T> T[] filter(T[] arr, Predicate1<T> predicate) {
        ArrayList<T> temp = new ArrayList<>();
        for (T elem : arr) {
            if (predicate.call(elem)) {
                temp.add(elem);
            }
        }
        T[] array = (T[]) Array.newInstance(arr[0].getClass(), temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <T> T[] filter(T[] arr, Class<?> c, Predicate1<T> predicate) {
        ArrayList<T> temp = new ArrayList<>();
        for (T elem : arr) {
            if (predicate.call(elem)) {
                temp.add(elem);
            }
        }
        T[] array = (T[]) Array.newInstance(c, temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public byte[] filter(byte[] arr, Predicate1<Byte> predicate) {
        ArrayList<Byte> temp = new ArrayList<>();
        for (byte elem : arr) {
            if (predicate.call(elem)) {
                temp.add(elem);
            }
        }
        byte[] array = new byte[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public boolean[] filter(boolean[] arr, Predicate1<Boolean> predicate) {
        ArrayList<Boolean> temp = new ArrayList<>();
        for (boolean elem : arr) {
            if (predicate.call(elem)) {
                temp.add(elem);
            }
        }
        boolean[] array = new boolean[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public char[] filter(char[] arr, Predicate1<Character> predicate) {
        ArrayList<Character> temp = new ArrayList<>();
        for (char elem : arr) {
            if (predicate.call(elem)) {
                temp.add(elem);
            }
        }
        char[] array = new char[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public int[] filter(int[] arr, Predicate1<Integer> predicate) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int elem : arr) {
            if (predicate.call(elem)) {
                temp.add(elem);
            }
        }
        int[] array = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public float[] filter(float[] arr, Predicate1<Float> predicate) {
        ArrayList<Float> temp = new ArrayList<>();
        for (float elem : arr) {
            if (predicate.call(elem)) {
                temp.add(elem);
            }
        }
        float[] array = new float[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public double[] filter(double[] arr, Predicate1<Double> predicate) {
        ArrayList<Double> temp = new ArrayList<>();
        for (double elem : arr) {
            if (predicate.call(elem)) {
                temp.add(elem);
            }
        }
        double[] array = new double[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <V, T extends Collection<V>> T filter(T collection, Predicate1<V> predicate) {
        T temp = createCollection(collection);
        for (V elem : collection) {
            if (predicate.call(elem)) {
                temp.add(elem);
            }
        }
        return temp;
    }

    static public <K, V, T extends Map<K, V>> T filter(T map, Predicate1<Map.Entry<K, V>> predicate) {
        T temp = createMap(map);
        for (var elem : map.entrySet()) {
            if (predicate.call(elem)) {
                temp.put(elem.getKey(), elem.getValue());
            }
        }
        return temp;
    }
    //endregion

    //region REDUCE
    static public <IV, T> IV reduce(T[] arr, IV initValue, Func2<IV, T, IV> func) {
        IV temp = initValue;
        for (T elem : arr) {
            temp = func.call(temp, elem);
        }
        return temp;
    }

    static public <IV> IV reduce(byte[] arr, IV initValue, Func2<IV, Byte, IV> func) {
        IV temp = initValue;
        for (byte elem : arr) {
            temp = func.call(temp, elem);
        }
        return temp;
    }

    static public <IV> IV reduce(boolean[] arr, IV initValue, Func2<IV, Boolean, IV> func) {
        IV temp = initValue;
        for (boolean elem : arr) {
            temp = func.call(temp, elem);
        }
        return temp;
    }

    static public <IV> IV reduce(char[] arr, IV initValue, Func2<IV, Character, IV> func) {
        IV temp = initValue;
        for (char elem : arr) {
            temp = func.call(temp, elem);
        }
        return temp;
    }

    static public <IV> IV reduce(int[] arr, IV initValue, Func2<IV, Integer, IV> func) {
        IV temp = initValue;
        for (int elem : arr) {
            temp = func.call(temp, elem);
        }
        return temp;
    }

    static public <IV> IV reduce(float[] arr, IV initValue, Func2<IV, Float, IV> func) {
        IV temp = initValue;
        for (float elem : arr) {
            temp = func.call(temp, elem);
        }
        return temp;
    }

    static public <IV> IV reduce(double[] arr, IV initValue, Func2<IV, Double, IV> func) {
        IV temp = initValue;
        for (double elem : arr) {
            temp = func.call(temp, elem);
        }
        return temp;
    }

    static public <IV, V, T extends List<V>> IV reduce(T list, IV initValue, Func2<IV, V, IV> func) {
        IV temp = initValue;
        for (V elem : list) {
            temp = func.call(temp, elem);
        }
        return temp;
    }

    static public <IV, K, V, T extends Map<K, V>> IV reduce(T map, IV initValue, Func2<IV, Map.Entry<K, V>, IV> func) {
        IV temp = initValue;
        for (var elem : map.entrySet()) {
            temp = func.call(temp, elem);
        }
        return temp;
    }

    static public <IV, V, T extends Set<V>> IV reduce(T set, IV initValue, Func2<IV, V, IV> func) {
        IV temp = initValue;
        for (V elem : set) {
            temp = func.call(temp, elem);
        }
        return temp;
    }
    //endregion

    //region ANY
    static public <T> boolean any(T[] arr, Predicate1<T> predicate) {
        for (T elem : arr) {
            if (predicate.call(elem))
                return true;
        }
        return false;
    }

    static public boolean any(byte[] arr, Predicate1<Byte> predicate) {
        for (byte elem : arr) {
            if (predicate.call(elem))
                return true;
        }
        return false;
    }

    static public boolean any(boolean[] arr, Predicate1<Boolean> predicate) {
        for (boolean elem : arr) {
            if (predicate.call(elem))
                return true;
        }
        return false;
    }

    static public boolean any(char[] arr, Predicate1<Character> predicate) {
        for (char elem : arr) {
            if (predicate.call(elem))
                return true;
        }
        return false;
    }

    static public boolean any(int[] arr, Predicate1<Integer> predicate) {
        for (int elem : arr) {
            if (predicate.call(elem))
                return true;
        }
        return false;
    }

    static public boolean any(float[] arr, Predicate1<Float> predicate) {
        for (float elem : arr) {
            if (predicate.call(elem))
                return true;
        }
        return false;
    }

    static public boolean any(double[] arr, Predicate1<Double> predicate) {
        for (double elem : arr) {
            if (predicate.call(elem))
                return true;
        }
        return false;
    }

    static public <T> boolean any(List<T> list, Predicate1<T> predicate) {
        for (T elem : list) {
            if (predicate.call(elem))
                return true;
        }
        return false;
    }

    static public <K, V> boolean any(Map<K, V> map, Predicate1<Map.Entry<K, V>> predicate) {
        for (var elem : map.entrySet()) {
            if (predicate.call(elem))
                return true;
        }
        return false;
    }

    static public <T> boolean any(Set<T> set, Predicate1<T> predicate) {
        for (T elem : set) {
            if (predicate.call(elem))
                return true;
        }
        return false;
    }
    //endregion

    //region ALL
    static public <T> boolean all(T[] arr, Predicate1<T> predicate) {
        for (T elem : arr) {
            if (!predicate.call(elem))
                return false;
        }
        return true;
    }

    static public boolean all(byte[] arr, Predicate1<Byte> predicate) {
        for (byte elem : arr) {
            if (!predicate.call(elem))
                return false;
        }
        return true;
    }

    static public boolean all(boolean[] arr, Predicate1<Boolean> predicate) {
        for (boolean elem : arr) {
            if (!predicate.call(elem))
                return false;
        }
        return true;
    }

    static public boolean all(char[] arr, Predicate1<Character> predicate) {
        for (char elem : arr) {
            if (!predicate.call(elem))
                return false;
        }
        return true;
    }

    static public boolean all(int[] arr, Predicate1<Integer> predicate) {
        for (int elem : arr) {
            if (!predicate.call(elem))
                return false;
        }
        return true;
    }

    static public boolean all(float[] arr, Predicate1<Float> predicate) {
        for (float elem : arr) {
            if (!predicate.call(elem))
                return false;
        }
        return true;
    }

    static public boolean all(double[] arr, Predicate1<Double> predicate) {
        for (double elem : arr) {
            if (!predicate.call(elem))
                return false;
        }
        return true;
    }

    static public <T> boolean all(List<T> list, Predicate1<T> predicate) {
        for (T elem : list) {
            if (!predicate.call(elem))
                return false;
        }
        return true;
    }

    static public <K, V> boolean all(Map<K, V> map, Predicate1<Map.Entry<K, V>> predicate) {
        for (var elem : map.entrySet()) {
            if (!predicate.call(elem))
                return false;
        }
        return true;
    }

    static public <T> boolean all(Set<T> set, Predicate1<T> predicate) {
        for (T elem : set) {
            if (!predicate.call(elem))
                return false;
        }
        return true;
    }
    //endregion

    //region COUNT
    static public <T> int count(T[] arr, Predicate1<T> predicate) {
        int count = 0;
        for (var elem : arr) {
            if (predicate.call(elem))
                ++count;
        }
        return count;
    }

    static public int count(byte[] arr, Predicate1<Byte> predicate) {
        int count = 0;
        for (var elem : arr) {
            if (predicate.call(elem))
                ++count;
        }
        return count;
    }

    static public int count(boolean[] arr, Predicate1<Boolean> predicate) {
        int count = 0;
        for (var elem : arr) {
            if (predicate.call(elem))
                ++count;
        }
        return count;
    }

    static public int count(char[] arr, Predicate1<Character> predicate) {
        int count = 0;
        for (var elem : arr) {
            if (predicate.call(elem))
                ++count;
        }
        return count;
    }

    static public int count(int[] arr, Predicate1<Integer> predicate) {
        int count = 0;
        for (var elem : arr) {
            if (predicate.call(elem))
                ++count;
        }
        return count;
    }

    static public int count(float[] arr, Predicate1<Float> predicate) {
        int count = 0;
        for (var elem : arr) {
            if (predicate.call(elem))
                ++count;
        }
        return count;
    }

    static public int count(double[] arr, Predicate1<Double> predicate) {
        int count = 0;
        for (var elem : arr) {
            if (predicate.call(elem))
                ++count;
        }
        return count;
    }

    static public <V, T extends Collection<V>> int count(T collection, Predicate1<V> predicate) {
        int count = 0;
        for (var elem : collection) {
            if (predicate.call(elem))
                ++count;
        }
        return count;
    }

    static public <K, V, T extends Map<K, V>> int count(T map, Predicate1<Map.Entry<K, V>> predicate) {
        int count = 0;
        for (var elem : map.entrySet()) {
            if (predicate.call(elem))
                ++count;
        }
        return count;
    }
    //endregion

    //region SKIP
    static public <T> T[] skip(T[] arr, int skip) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = skip; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        T[] array = (T[]) Array.newInstance(arr[0].getClass(), temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <T> T[] skip(T[] arr, Class<?> c, int skip) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = skip; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        T[] array = (T[]) Array.newInstance(c, temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public byte[] skip(byte[] arr, int skip) {
        ArrayList<Byte> temp = new ArrayList<>();
        for (int i = skip; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        byte[] array = new byte[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public boolean[] skip(boolean[] arr, int skip) {
        ArrayList<Boolean> temp = new ArrayList<>();
        for (int i = skip; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        boolean[] array = new boolean[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public char[] skip(char[] arr, int skip) {
        ArrayList<Character> temp = new ArrayList<>();
        for (int i = skip; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        char[] array = new char[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public int[] skip(int[] arr, int skip) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = skip; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        int[] array = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public float[] skip(float[] arr, int skip) {
        ArrayList<Float> temp = new ArrayList<>();
        for (int i = skip; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        float[] array = new float[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public double[] skip(double[] arr, int skip) {
        ArrayList<Double> temp = new ArrayList<>();
        for (int i = skip; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        double[] array = new double[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <V, T extends List<V>> T skip(T list, int skip) {
        T temp = createCollection(list);
        for (int i = skip; i < list.size(); i++) {
            temp.add(list.get(i));
        }
        return temp;
    }

    static public <K, V, T extends SortedMap<K, V>> T skip(T map, int skip) {
        T temp = createMap(map);
        Object[] keys = map.keySet().toArray();

        for (int i = skip; i < map.size(); i++) {
            K key = (K) keys[i];
            V value = map.get(key);
            temp.put(key, value);
        }
        return temp;
    }

    static public <K, V, T extends LinkedHashMap<K, V>> T skip(T map, int skip) {
        T temp = createMap(map);
        Object[] keys = map.keySet().toArray();

        for (int i = skip; i < map.size(); i++) {
            K key = (K) keys[i];
            V value = map.get(key);
            temp.put(key, value);
        }
        return temp;
    }

    static public <V, T extends SortedSet<V>> T skip(T set, int skip) {
        T temp = createCollection(set);
        Object[] v = set.toArray();

        for (int i = skip; i < set.size(); i++) {
            temp.add((V) v[i]);
        }
        return temp;
    }

    static public <V, T extends LinkedHashSet<V>> T skip(T set, int skip) {
        T temp = createCollection(set);
        Object[] v = set.toArray();

        for (int i = skip; i < set.size(); i++) {
            temp.add((V) v[i]);
        }
        return temp;
    }
    //endregion

    //region SKIPLAST
    static public <T> T[] skipLast(T[] arr, int skip) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = 0; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        T[] array = (T[]) Array.newInstance(arr[0].getClass(), temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <T> T[] skipLast(T[] arr, Class<?> c, int skip) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = (arr.length - 1) - skip; i > -1; i--) {
            temp.add(arr[i]);
        }
        T[] array = (T[]) Array.newInstance(c, temp.size());
        for (int i = 0; i < arr.length - skip; i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public byte[] skipLast(byte[] arr, int skip) {
        ArrayList<Byte> temp = new ArrayList<>();
        for (int i = 0; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        byte[] array = new byte[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public boolean[] skipLast(boolean[] arr, int skip) {
        ArrayList<Boolean> temp = new ArrayList<>();
        for (int i = 0; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        boolean[] array = new boolean[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public char[] skipLast(char[] arr, int skip) {
        ArrayList<Character> temp = new ArrayList<>();
        for (int i = 0; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        char[] array = new char[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public int[] skipLast(int[] arr, int skip) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        int[] array = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public float[] skipLast(float[] arr, int skip) {
        ArrayList<Float> temp = new ArrayList<>();
        for (int i = 0; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        float[] array = new float[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public double[] skipLast(double[] arr, int skip) {
        ArrayList<Double> temp = new ArrayList<>();
        for (int i = 0; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        double[] array = new double[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <V, T extends List<V>> T skipLast(T list, int skip) {
        T temp = createCollection(list);
        for (int i = 0; i < list.size() - skip; i++) {
            temp.add(list.get(i));
        }
        return temp;
    }

    static public <K, V, T extends SortedMap<K, V>> T skipLast(T map, int skip) {
        T temp = createMap(map);
        Object[] keys = map.keySet().toArray();

        for (int i = 0; i < map.size() - skip; i++) {
            K key = (K) keys[i];
            V value = map.get(key);
            temp.put(key, value);
        }
        return temp;
    }

    static public <K, V, T extends LinkedHashMap<K, V>> T skipLast(T map, int skip) {
        T temp = createMap(map);
        Object[] keys = map.keySet().toArray();

        for (int i = 0; i < map.size() - skip; i++) {
            K key = (K) keys[i];
            V value = map.get(key);
            temp.put(key, value);
        }
        return temp;
    }

    static public <V, T extends SortedSet<V>> T skipLast(T set, int skip) {
        T temp = createCollection(set);
        Object[] v = set.toArray();

        for (int i = 0; i < set.size() - skip; i++) {
            temp.add((V) v[i]);
        }
        return temp;
    }

    static public <V, T extends LinkedHashSet<V>> T skipLast(T set, int skip) {
        T temp = createCollection(set);
        Object[] v = set.toArray();

        for (int i = 0; i < set.size() - skip; i++) {
            temp.add((V) v[i]);
        }
        return temp;
    }
    //endregion

    //region TAKE
    static public <T> T[] take(T[] arr, int take) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = 0; i < take; i++) {
            temp.add(arr[i]);
        }
        T[] array = (T[]) Array.newInstance(arr[0].getClass(), temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <T> T[] take(T[] arr, Class<?> c, int take) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = 0; i < take; i++) {
            temp.add(arr[i]);
        }
        T[] array = (T[]) Array.newInstance(c, temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public byte[] take(byte[] arr, int take) {
        ArrayList<Byte> temp = new ArrayList<>();
        for (int i = 0; i < take; i++) {
            temp.add(arr[i]);
        }
        byte[] array = new byte[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public boolean[] take(boolean[] arr, int take) {
        ArrayList<Boolean> temp = new ArrayList<>();
        for (int i = 0; i < take; i++) {
            temp.add(arr[i]);
        }
        boolean[] array = new boolean[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public char[] take(char[] arr, int take) {
        ArrayList<Character> temp = new ArrayList<>();
        for (int i = 0; i < take; i++) {
            temp.add(arr[i]);
        }
        char[] array = new char[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public int[] take(int[] arr, int take) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < take; i++) {
            temp.add(arr[i]);
        }
        int[] array = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public float[] take(float[] arr, int take) {
        ArrayList<Float> temp = new ArrayList<>();
        for (int i = 0; i < take; i++) {
            temp.add(arr[i]);
        }
        float[] array = new float[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public double[] take(double[] arr, int take) {
        ArrayList<Double> temp = new ArrayList<>();
        for (int i = 0; i < take; i++) {
            temp.add(arr[i]);
        }
        double[] array = new double[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <V, T extends List<V>> T take(T list, int take) {
        T temp = createCollection(list);
        for (int i = 0; i < take; i++) {
            temp.add(list.get(i));
        }
        return temp;
    }

    static public <K, V, T extends SortedMap<K, V>> T take(T map, int take) {
        T temp = createMap(map);
        Object[] keys = map.keySet().toArray();

        for (int i = 0; i < take; i++) {
            K key = (K) keys[i];
            V value = map.get(key);
            temp.put(key, value);
        }
        return temp;
    }

    static public <K, V, T extends LinkedHashMap<K, V>> T take(T map, int take) {
        T temp = createMap(map);
        Object[] keys = map.keySet().toArray();

        for (int i = 0; i < take; i++) {
            K key = (K) keys[i];
            V value = map.get(key);
            temp.put(key, value);
        }
        return temp;
    }

    static public <V, T extends SortedSet<V>> T take(T set, int take) {
        T temp = createCollection(set);
        Object[] v = set.toArray();

        for (int i = 0; i < take; i++) {
            temp.add((V) v[i]);
        }
        return temp;
    }

    static public <V, T extends LinkedHashSet<V>> T take(T set, int take) {
        T temp = createCollection(set);
        Object[] v = set.toArray();

        for (int i = 0; i < take; i++) {
            temp.add((V) v[i]);
        }
        return temp;
    }
    //endregion

    //region TAKELAST
    static public <T> T[] takeLast(T[] arr, int take) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = arr.length - take; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        T[] array = (T[]) Array.newInstance(arr[0].getClass(), temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <T> T[] takeLast(T[] arr, Class<?> c, int take) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = arr.length - take; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        T[] array = (T[]) Array.newInstance(c, temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public byte[] takeLast(byte[] arr, int take) {
        ArrayList<Byte> temp = new ArrayList<>();
        for (int i = arr.length - take; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        byte[] array = new byte[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public boolean[] takeLast(boolean[] arr, int take) {
        ArrayList<Boolean> temp = new ArrayList<>();
        for (int i = arr.length - take; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        boolean[] array = new boolean[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public char[] takeLast(char[] arr, int take) {
        ArrayList<Character> temp = new ArrayList<>();
        for (int i = arr.length - take; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        char[] array = new char[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public int[] takeLast(int[] arr, int take) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = arr.length - take; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        int[] array = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public float[] takeLast(float[] arr, int take) {
        ArrayList<Float> temp = new ArrayList<>();
        for (int i = arr.length - take; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        float[] array = new float[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public double[] takeLast(double[] arr, int take) {
        ArrayList<Double> temp = new ArrayList<>();
        for (int i = arr.length - take; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        double[] array = new double[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <V, T extends List<V>> T takeLast(T list, int take) {
        T temp = createCollection(list);
        for (int i = list.size() - take; i < list.size(); i++) {
            temp.add(list.get(i));
        }
        return temp;
    }

    static public <K, V, T extends SortedMap<K, V>> T takeLast(T map, int take) {
        T temp = createMap(map);
        Object[] keys = map.keySet().toArray();

        for (int i = map.size() - take; i < map.size(); i++) {
            K key = (K) keys[i];
            V value = map.get(key);
            temp.put(key, value);
        }
        return temp;
    }

    static public <K, V, T extends LinkedHashMap<K, V>> T takeLast(T map, int take) {
        T temp = createMap(map);
        Object[] keys = map.keySet().toArray();

        for (int i = map.size() - take; i < map.size(); i++) {
            K key = (K) keys[i];
            V value = map.get(key);
            temp.put(key, value);
        }
        return temp;
    }

    static public <V, T extends SortedSet<V>> T takeLast(T set, int take) {
        T temp = createCollection(set);
        Object[] v = set.toArray();

        for (int i = set.size() - take; i < set.size(); i++) {
            temp.add((V) v[i]);
        }
        return temp;
    }

    static public <V, T extends LinkedHashSet<V>> T takeLast(T set, int take) {
        T temp = createCollection(set);
        Object[] v = set.toArray();

        for (int i = set.size() - take; i < set.size(); i++) {
            temp.add((V) v[i]);
        }
        return temp;
    }
    //endregion

    //region SKIPTAKE
    static public <T> T[] skipTake(T[] arr, int skip, int take) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = skip; i < skip + take; i++) {
            temp.add(arr[i]);
        }
        T[] array = (T[]) Array.newInstance(arr[0].getClass(), temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <T> T[] skipTake(T[] arr, Class<?> c, int skip, int take) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = skip; i < skip + take; i++) {
            temp.add(arr[i]);
        }
        T[] array = (T[]) Array.newInstance(c, temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public byte[] skipTake(byte[] arr, int skip, int take) {
        ArrayList<Byte> temp = new ArrayList<>();
        for (int i = skip; i < skip + take; i++) {
            temp.add(arr[i]);
        }
        byte[] array = new byte[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public boolean[] skipTake(boolean[] arr, int skip, int take) {
        ArrayList<Boolean> temp = new ArrayList<>();
        for (int i = skip; i < skip + take; i++) {
            temp.add(arr[i]);
        }
        boolean[] array = new boolean[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public char[] skipTake(char[] arr, int skip, int take) {
        ArrayList<Character> temp = new ArrayList<>();
        for (int i = skip; i < skip + take; i++) {
            temp.add(arr[i]);
        }
        char[] array = new char[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public int[] skipTake(int[] arr, int skip, int take) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = skip; i < skip + take; i++) {
            temp.add(arr[i]);
        }
        int[] array = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public float[] skipTake(float[] arr, int skip, int take) {
        ArrayList<Float> temp = new ArrayList<>();
        for (int i = skip; i < skip + take; i++) {
            temp.add(arr[i]);
        }
        float[] array = new float[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public double[] skipTake(double[] arr, int skip, int take) {
        ArrayList<Double> temp = new ArrayList<>();
        for (int i = skip; i < skip + take; i++) {
            temp.add(arr[i]);
        }
        double[] array = new double[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <V, T extends List<V>> T skipTake(T list, int skip, int take) {
        T temp = createCollection(list);
        for (int i = skip; i < skip + take; i++) {
            temp.add(list.get(i));
        }
        return temp;
    }

    static public <K, V, T extends SortedMap<K, V>> T skipTake(T map, int skip, int take) {
        T temp = createMap(map);
        Object[] keys = map.keySet().toArray();

        for (int i = skip; i < skip + take; i++) {
            K key = (K) keys[i];
            V value = map.get(key);
            temp.put(key, value);
        }
        return temp;
    }

    static public <K, V, T extends LinkedHashMap<K, V>> T skipTake(T map, int skip, int take) {
        T temp = createMap(map);
        Object[] keys = map.keySet().toArray();

        for (int i = skip; i < skip + take; i++) {
            K key = (K) keys[i];
            V value = map.get(key);
            temp.put(key, value);
        }
        return temp;
    }

    static public <V, T extends SortedSet<V>> T skipTake(T set, int skip, int take) {
        T temp = createCollection(set);
        Object[] v = set.toArray();

        for (int i = skip; i < skip + take; i++) {
            temp.add((V) v[i]);
        }
        return temp;
    }

    static public <V, T extends LinkedHashSet<V>> T skipTake(T set, int skip, int take) {
        T temp = createCollection(set);
        Object[] v = set.toArray();

        for (int i = skip; i < skip + take; i++) {
            temp.add((V) v[i]);
        }
        return temp;
    }
    //endregion

    //region SKIPTAKELAST
    static public <T> T[] skipTakeLast(T[] arr, int skip, int take) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = arr.length - skip - take; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        T[] array = (T[]) Array.newInstance(arr[0].getClass(), temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <T> T[] skipTakeLast(T[] arr, Class<?> c, int skip, int take) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = arr.length - skip - take; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        T[] array = (T[]) Array.newInstance(c, temp.size());
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public byte[] skipTakeLast(byte[] arr, int skip, int take) {
        ArrayList<Byte> temp = new ArrayList<>();
        for (int i = arr.length - skip - take; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        byte[] array = new byte[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public boolean[] skipTakeLast(boolean[] arr, int skip, int take) {
        ArrayList<Boolean> temp = new ArrayList<>();
        for (int i = arr.length - skip - take; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        boolean[] array = new boolean[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public char[] skipTakeLast(char[] arr, int skip, int take) {
        ArrayList<Character> temp = new ArrayList<>();
        for (int i = arr.length - skip - take; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        char[] array = new char[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public int[] skipTakeLast(int[] arr, int skip, int take) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = arr.length - skip - take; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        int[] array = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public float[] skipTakeLast(float[] arr, int skip, int take) {
        ArrayList<Float> temp = new ArrayList<>();
        for (int i = arr.length - skip - take; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        float[] array = new float[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public double[] skipTakeLast(double[] arr, int skip, int take) {
        ArrayList<Double> temp = new ArrayList<>();
        for (int i = arr.length - skip - take; i < arr.length - skip; i++) {
            temp.add(arr[i]);
        }
        double[] array = new double[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    static public <V, T extends List<V>> T skipTakeLast(T list, int skip, int take) {
        T temp = createCollection(list);
        for (int i = list.size() - skip - take; i < list.size() - skip; i++) {
            temp.add(list.get(i));
        }
        return temp;
    }

    static public <K, V, T extends SortedMap<K, V>> T skipTakeLast(T map, int skip, int take) {
        T temp = createMap(map);
        Object[] keys = map.keySet().toArray();

        for (int i = map.size() - skip - take; i < map.size() - skip; i++) {
            K key = (K) keys[i];
            V value = map.get(key);
            temp.put(key, value);
        }
        return temp;
    }

    static public <K, V, T extends LinkedHashMap<K, V>> T skipTakeLast(T map, int skip, int take) {
        T temp = createMap(map);
        Object[] keys = map.keySet().toArray();

        for (int i = map.size() - skip - take; i < map.size() - skip; i++) {
            K key = (K) keys[i];
            V value = map.get(key);
            temp.put(key, value);
        }
        return temp;
    }

    static public <V, T extends SortedSet<V>> T skipTakeLast(T set, int skip, int take) {
        T temp = createCollection(set);
        Object[] v = set.toArray();

        for (int i = set.size() - skip - take; i < set.size() - skip; i++) {
            temp.add((V) v[i]);
        }
        return temp;
    }

    static public <V, T extends LinkedHashSet<V>> T skipTakeLast(T set, int skip, int take) {
        T temp = createCollection(set);
        Object[] v = set.toArray();

        for (int i = set.size() - skip - take; i < set.size() - skip; i++) {
            temp.add((V) v[i]);
        }
        return temp;
    }
    //endregion

    //region INDEXOF PREDICATE
    static public <T> int indexOf(T[] arr, Predicate1<T> predicate) {
        for (int i = 0; i < arr.length; i++) {
            if (predicate.call(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    static public int indexOf(byte[] arr, Predicate1<Byte> predicate) {
        for (int i = 0; i < arr.length; i++) {
            if (predicate.call(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    static public int indexOf(boolean[] arr, Predicate1<Boolean> predicate) {
        for (int i = 0; i < arr.length; i++) {
            if (predicate.call(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    static public int indexOf(char[] arr, Predicate1<Character> predicate) {
        for (int i = 0; i < arr.length; i++) {
            if (predicate.call(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    static public int indexOf(int[] arr, Predicate1<Integer> predicate) {
        for (int i = 0; i < arr.length; i++) {
            if (predicate.call(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    static public int indexOf(float[] arr, Predicate1<Float> predicate) {
        for (int i = 0; i < arr.length; i++) {
            if (predicate.call(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    static public int indexOf(double[] arr, Predicate1<Double> predicate) {
        for (int i = 0; i < arr.length; i++) {
            if (predicate.call(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    static public <V, T extends List<V>> int indexOf(T list, Predicate1<V> predicate) {
        for (int i = 0; i < list.size(); i++) {
            if (predicate.call(list.get(i))) {
                return i;
            }
        }
        return -1;
    }

    static public <K, V, T extends Map<K, V>> int indexOf(T map, Predicate1<Map.Entry<K, V>> predicate) {
        Object[] entries = map.entrySet().toArray();
        for (int i = 0; i < map.size(); i++) {
            Map.Entry<K, V> entry = (Map.Entry<K, V>) entries[i];
            if (predicate.call(entry)) {
                return i;
            }
        }
        return -1;
    }

    static public <V, T extends Set<V>> int indexOf(T set, Predicate1<V> predicate) {
        Object[] values = set.toArray();
        for (int i = 0; i < set.size(); i++) {
            V value = (V) values[i];
            if (predicate.call(value)) {
                return i;
            }
        }
        return -1;
    }
    //endregion

    //region GET
    static public <T> T get(T[] arr, Predicate1<T> predicate) {
        for (var elem : arr) {
            if (predicate.call(elem))
                return elem;
        }
        return null;
    }

    static public <V, T extends List<V>> V get(T list, Predicate1<V> predicate) {
        if (list.size() == 0)
            throw new LLStreamException("Don't put empty List");

        for (var elem : list) {
            if (predicate.call(elem))
                return elem;
        }

        V value = list.get(0);
        if (value instanceof Number)
            return (V) (Object) 0;
        else if (value instanceof Boolean)
            return (V) (Object) false;
        else if (value instanceof Character)
            return (V) (Object) ' ';
        return null;
    }

    static public <K, V, T extends Map<K, V>> Map.Entry<K, V> get(T map, int index) {
        Object[] entries = map.entrySet().toArray();
        for (int i = 0; i < map.size(); i++) {
            if (i == index) {
                return (Map.Entry<K, V>) entries[i];
            }
        }
        return null;
    }

    static public <K, V, T extends Map<K, V>> Map.Entry<K, V> get(T map, Predicate1<Map.Entry<K, V>> predicate) {
        for (var elem : map.entrySet()) {
            if (predicate.call(elem))
                return elem;
        }
        return null;
    }

    static public <V, T extends Set<V>> V get(T set, int index) {
        if (set.size() == 0)
            throw new LLStreamException("Don't put empty Set");

        Object[] values = set.toArray();
        for (int i = 0; i < set.size(); i++) {
            if (i == index) {
                return (V) values[i];
            }
        }
        if (values[0] instanceof Number)
            return (V) (Object) 0;
        else if (values[0] instanceof Boolean)
            return (V) (Object) false;
        else if (values[0] instanceof Character)
            return (V) (Object) ' ';
        return null;
    }

    static public <V, T extends Set<V>> V get(T set, Predicate1<V> predicate) {
        if (set.size() == 0)
            throw new LLStreamException("Don't put empty Set");

        for (var elem : set) {
            if (predicate.call(elem))
                return elem;
        }

        Object[] values = set.toArray();
        if (values[0] instanceof Number)
            return (V) (Object) 0;
        else if (values[0] instanceof Boolean)
            return (V) (Object) false;
        else if (values[0] instanceof Character)
            return (V) (Object) ' ';
        return null;
    }
    //endregion

    //region PRIVATE
    static private <V, T extends Collection<V>> T createCollection(T collection) {
        try {
            return (T) collection.getClass().getConstructor().newInstance();
        } catch (Exception e) {
            throw new LLStreamException("This is not Collection");
        }
    }

    static private <K, V, T extends Map<K, V>> T createMap(T map) {
        try {
            return (T) map.getClass().getConstructor().newInstance();
        } catch (Exception e) {
            throw new LLStreamException("This is not Map");
        }
    }
    //endregion

    //region INTERFACE
    public interface Action {
        void call();
    }

    public interface Action1<T1> {
        void call(T1 t1);
    }

    public interface Action2<T1, T2> {
        void call(T1 t1, T2 t2);
    }

    public interface Action3<T1, T2, T3> {
        void call(T1 t1, T2 t2, T3 t3);
    }

    public interface Action4<T1, T2, T3, T4> {
        void call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    public interface Action5<T1, T2, T3, T4, T5> {
        void call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5);
    }

    public interface Action6<T1, T2, T3, T4, T5, T6> {
        void call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6);
    }

    public interface Action7<T1, T2, T3, T4, T5, T6, T7> {
        void call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7);
    }

    public interface Action8<T1, T2, T3, T4, T5, T6, T7, T8> {
        void call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8);
    }

    public interface Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        void call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9);
    }

    public interface Func<R> {
        R call();
    }

    public interface Func1<T1, R> {
        R call(T1 t1);
    }

    public interface Func2<T1, T2, R> {
        R call(T1 t1, T2 t2);
    }

    public interface Func3<T1, T2, T3, R> {
        R call(T1 t1, T2 t2, T3 t3);
    }

    public interface Func4<T1, T2, T3, T4, R> {
        R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    public interface Func5<T1, T2, T3, T4, T5, R> {
        R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5);
    }

    public interface Func6<T1, T2, T3, T4, T5, T6, R> {
        R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6);
    }

    public interface Func7<T1, T2, T3, T4, T5, T6, T7, R> {
        R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7);
    }

    public interface Func8<T1, T2, T3, T4, T5, T6, T7, T8, R> {
        R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8);
    }

    public interface Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> {
        R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9);
    }

    public interface Predicate {
        boolean call();
    }

    public interface Predicate1<T1> {
        boolean call(T1 t1);
    }

    public interface Predicate2<T1, T2> {
        boolean call(T1 t1, T2 t2);
    }

    public interface Predicate3<T1, T2, T3> {
        boolean call(T1 t1, T2 t2, T3 t3);
    }

    public interface Predicate4<T1, T2, T3, T4> {
        boolean call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    public interface Predicate5<T1, T2, T3, T4, T5> {
        boolean call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5);
    }

    public interface Predicate6<T1, T2, T3, T4, T5, T6> {
        boolean call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6);
    }

    public interface Predicate7<T1, T2, T3, T4, T5, T6, T7> {
        boolean call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7);
    }

    public interface Predicate8<T1, T2, T3, T4, T5, T6, T7, T8> {
        boolean call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8);
    }

    public interface Predicate9<T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        boolean call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9);
    }
    //endregion
}

class LLStreamException extends RuntimeException {
    public LLStreamException() {
        super();
    }

    public LLStreamException(String message) {
        super(message);
    }

    public LLStreamException(String message, Throwable cause) {
        super(message, cause);
    }

    public LLStreamException(Throwable cause) {
        super(cause);
    }
}