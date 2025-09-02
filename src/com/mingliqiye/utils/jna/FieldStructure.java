package com.mingliqiye.utils.jna;

import com.sun.jna.Structure;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MingLiPro
 */
public class FieldStructure extends Structure {

	@Override
	protected List<String> getFieldOrder() {
		List<String> fieldOrderList = new ArrayList<String>();
		for (
			Class<?> cls = getClass();
			!cls.equals(FieldStructure.class);
			cls = cls.getSuperclass()
		) {
			Field[] fields = cls.getDeclaredFields();
			int modifiers;
			for (Field field : fields) {
				modifiers = field.getModifiers();
				if (
					Modifier.isStatic(modifiers) ||
					!Modifier.isPublic(modifiers)
				) {
					continue;
				}
				fieldOrderList.add(field.getName());
			}
		}
		return fieldOrderList;
	}
}
