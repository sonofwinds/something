package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FruitInfoUtil {
	public static void main(String[] args) {
//		getFruitInfo(Apple.class);
		Method[] methods = Apple.class.getMethods();
//		for(Method method : methods) {
//			System.out.println(method.getName());
//		}
		Apple apple = new Apple();
		Field[] fields = apple.getClass().getDeclaredFields();
		for(Field field : fields) {
			try {
				field.setAccessible(true);
				field.set(apple, new String("ddd"));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	public static void getFruitInfo(Class<?> clazz) {
		String strFruitName = " 水果名称：";
		String strFruitColor = " 水果颜色：";
		String strFruitProvicer = "供应商信息：";
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = field.getAnnotation(FruitName.class);
				strFruitName += fruitName.value();
				System.out.println(strFruitName);
			} else if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = field.getAnnotation(FruitColor.class);
				strFruitColor = strFruitColor + fruitColor.fruitColor().toString();
				System.out.println(strFruitColor);
			} else if (field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
				strFruitProvicer = " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name() + " 供应商地址："
						+ fruitProvider.address();
				System.out.println(strFruitProvicer);
			}
		}
	}

}
