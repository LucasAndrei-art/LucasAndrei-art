package repositories;

import annotations.Singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonRegistry {
    private static final Map<Class<?>, Object> instances = new HashMap<>();

    public static Object getInstance(Class<?> clazz) throws Exception {
        if (!instances.containsKey(clazz)) {
            if (clazz.isAnnotationPresent(Singleton.class)) {
                instances.put(clazz, clazz.getDeclaredConstructor().newInstance());
            } else {
                throw new IllegalStateException("Class " + clazz.getName() + " is not annotated with @Singleton");
            }
        }
        return instances.get(clazz);
    }
}
