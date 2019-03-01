package co.com.jjoc.aspects.utils;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class OrderUtils {

    public static final String DESC = "DESC";

    public static <T> void applyOrderRule(Class<T> classType, List objects, Map<String, String> orderFilters) {

        String orderFieldFilter = orderFilters.get("orderField");
        String order = orderFilters.get("order");

        Field[] fields = classType.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(OrderField.class)) {

                OrderField orderField = field.getAnnotation(OrderField.class);
                String name = !StringUtils.EMPTY.equals(orderField.name()) ? orderField.name() : field.getName();

                Class<?> classOrder = orderField.type();

                if (name.equals(orderFieldFilter)) {

                    //crear comparador con el campo que encontro
                    Comparator<T> comparator = null;

                    Function<T, String> function = null;

                    function = (t) -> {
                        try {
                            return (String) t.getClass().getMethod("get" + StringUtils.capitalize(name)).invoke(t);
                        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException("error");
                        }
                    };

                    if (classOrder == String.class) {
                        comparator = Comparator.comparing(function);
                    } else if (classOrder == LocalDateTime.class) {
                        comparator = Comparator.comparing(function, Comparator.comparing(LocalDateTime::parse));
                    } else if (classOrder == Integer.class) {
                        comparator = Comparator.comparing(function, Comparator.comparing(Integer::valueOf));
                    }

                    Collections.sort(objects, comparator);

                    if (DESC.equals(order)) {
                        Collections.reverse(objects);
                    }

                    return;
                }

            }
        }

    }

}