package com.company;

import java.io.*;
import java.lang.reflect.*;

public class Saver implements Serializable {
    public static void save(Class<?>... ls) {
        try {
            for (Class<?> cls : ls) {
                    ClassWithFields cwf = new ClassWithFields();
                    Field[] fields = cls.getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        Save save = field.getAnnotation(Save.class);
                        String directory = save.directory();//маршрут к файлу, где все будет со
                        File file = new File(directory);
                        file.createNewFile();
                        if (!save.i()) {//если i-false, то выполняем следуюищй блок кода-сериализация
                            try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(directory))) {
                                OOS.writeObject(field.get(cwf).toString());
                            } catch (IOException | IllegalAccessException e) {e.printStackTrace();}
                        } else {//если i-true, то выполняем следуюищй блок кода-десериализация
                            try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(directory))) {
                                String text = (String) OIS.readObject();
                                field.set(cwf, text);
                            } catch (IOException | ClassNotFoundException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            }
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
