package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HashMap<K,V> {
    Object[] keys;
    Object[] Values;
    int size;
    HashMap(){
        this.keys=new Object[100];
        this.Values =new Object[100];
        this.size=0;
    }
    public void put(K key,V value) {
        int keyIndex=indexOfKey(key);
        if(keyIndex!=-1){
            this.Values[keyIndex]=value;
            return;
        }
        keys[size]=key;
        Values[size]=value;
        size++;
    }

    private int indexOfKey(K key) {
        for(int i=0;i<size;i++){
            if(key.equals(keys[i])){
                return i;
            }
        }
        return -1;
    }

    public V get(K key) {
        int keyIndex=indexOfKey(key);
        if(keyIndex==-1){
            return null;
        }
        return (V) Values[keyIndex];
    }

    public int size() {
        return size;
    }

    public void remove(K key) {
        int keyIndex = indexOfKey(key);

        if (keyIndex == -1) {
            return;
        }
        moveLeft(keys, keyIndex + 1, size - 1);
        moveLeft(Values, keyIndex + 1, size - 1);
        size--;
    }

    private void moveLeft(Object[] arrs, int start, int end) {
        for(int i=start;start<end;i++){
            arrs[i-1]=arrs[i];
        }
    }

    public List<K> keySet() {
        List<K> arr=new ArrayList<>();
        for(Object key : keys){
            arr.add((K)key);
        }
        return arr;
    }
}
