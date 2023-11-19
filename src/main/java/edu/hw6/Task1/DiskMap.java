package edu.hw6.Task1;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DiskMap implements Map<String, String> {
    private List<String> keys = new ArrayList<>();
    private List<String> values = new ArrayList<>();
    private int size = 0;

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public String get(Object key) {
        return values.get(keys.indexOf(key));
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        this.keys.addLast(key);
        this.values.addLast(value);
        this.size++;
        return null;
    }

    @Override
    public String remove(Object key) {
        this.values.remove(keys.indexOf(key));
        this.keys.remove(key);
        this.size--;
        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        this.keys.addAll(m.keySet());
        this.values.addAll(m.values());
        this.size+=m.size();
    }

    @Override
    public void clear() {
        this.size=0;
        this.keys.clear();
        this.values.clear();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return new HashSet<>(keys);
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return values;
    }


    @Override
    public Set<Entry<String, String>> entrySet() {
        Map<String,String> map=new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(keys.get(i),values.get(i));
        }

        return map.entrySet();
    }

    public void write(String path) throws IOException {
        Path p = Path.of(path);
        try {
            Files.createFile(p);
        }
        catch (IOException e){
            System.out.println("Error "+e);
        }
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < size-1; i++) {
            data.append(keys.get(i)).append(":").append(values.get(i)).append('\n');
        }
        data.append(keys.get(size-1)).append(":").append(values.get(size-1));
        Files.write(p,data.toString().getBytes());
    }
    public void read(String path){
        Path p = Path.of(path);
        try{
            List<String> data=Files.readAllLines(p);
            String[] kv;
            for (String keyValue:data) {
                kv=keyValue.split(":");
                this.keys.addLast(kv[0]);
                this.values.addLast(kv[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
