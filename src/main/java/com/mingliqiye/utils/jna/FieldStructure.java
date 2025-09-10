/*
 * Copyright 2025 mingliqiye
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ProjectName mingli-utils
 * ModuleName mingli-utils.main
 * CurrentFile FieldStructure.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

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
		List<String> fieldOrderList = new ArrayList<>();
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
