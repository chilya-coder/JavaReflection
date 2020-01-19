package newcom;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class aClass = Class.forName("com.company.Hobby"); // находит класс по полному имени (агрумент - пакет.идентификатор_класса)
        Constructor constructor = aClass.getConstructor();
        Object newObject = constructor.newInstance();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field);
            if (field.getName().equals("privateField"))
            {
                field.setAccessible(true);
                System.out.println(field.getGenericType());
                field.set(newObject, 1);
                System.out.println(field.get(newObject));
            }
        }
        Method[] methods = aClass.getDeclaredMethods();
        System.out.println("\n\n\n");
        for (Method method: methods) {
            System.out.println(method);
            if (method.getName().equals("test"))
            {
               method.invoke(newObject,0,"Default",3.0f); // создает объект с переданными аргументами (имя_объекта, аргумент1, 2, и т.д.)
                // если бы метод был статичным, в параметр object было бы "null" (для вызова метода не требуется объект)
            }
        }
        Constructor[] constructors = aClass.getConstructors();
        System.out.println("\n\n\n");
        for (Constructor constructor1: constructors) {
            System.out.println(constructor1);
        }
        System.out.println("\n\n\n");
    }
}//qwerty
