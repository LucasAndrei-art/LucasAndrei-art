package commands;

import annotations.Rota;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private static final Map<String, Command> commands = new HashMap<>();

    public static void register(String path, Command command) {
        commands.put(path, command);
    }

    public static Command getCommand(String path) {
        return commands.get(path);
    }

    public static void initializeRoutes(Object controller) throws Exception {
        Class<?> clazz = controller.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Rota.class)) {
                String path = method.getAnnotation(Rota.class).value();
                System.out.println("Registered route: " + path);  // Log to check route registration
                commands.put(path, (req, resp) -> {
                    try {
                        method.invoke(controller, req, resp);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to execute command", e);
                    }
                });
            }
        }
    }
}
