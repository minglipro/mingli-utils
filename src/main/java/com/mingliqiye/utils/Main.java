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
 * CurrentFile Main.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils;

import com.mingliqiye.utils.collection.Lists;
import com.mingliqiye.utils.collection.Maps;
import com.mingliqiye.utils.springboot.autoconfigure.AutoConfiguration;
import com.mingliqiye.utils.stream.SuperStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		AutoConfiguration.printBanner();

		Map<String, String> map = Maps.of("1", "2", "3", "4");

		SuperStream.of(map).entryToMap();
	}
}
