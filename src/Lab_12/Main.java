package Lab_12;

import Lab_2.Factory;
import java.net.URL;
import java.io.File;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String path = "D:/0.Uni/Java_Labs/out/production/Java_Labs/Lab_2/Factory.class";
        File f = new File(path);
        URL[] cp = {f.toURI().toURL()};
        URLClassLoader urlClass = new URLClassLoader(cp);
        Class clazz = urlClass.loadClass("Lab_2.Factory");

        System.out.println(clazz.getPackage());

        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("Test methods");
//
        for(Method m : methods) {
            if  (m.isAnnotationPresent(Cris.class)) {

                Object obj = m.invoke( null);
                System.out.println(obj);
            }
        }
//


        //just for fun
        Method method = clazz.getDeclaredMethod("Add", int.class, int.class);

        Object result = method.invoke(null, 1, 2);
        System.out.println(result);



    }


}
