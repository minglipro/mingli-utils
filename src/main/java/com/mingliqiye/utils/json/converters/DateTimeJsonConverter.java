package com.mingliqiye.utils.json.converters;

import com.mingliqiye.utils.time.DateTime;
import com.mingliqiye.utils.time.Formatter;

public class DateTimeJsonConverter extends JsonStringConverter<DateTime> {

	@Override
	public Class<DateTime> getTClass() {
		return DateTime.class;
	}

	@Override
	public String convert(DateTime obj) {
		if (obj == null) {
			return null;
		}
		return obj.format(Formatter.STANDARD_DATETIME);
	}

	@Override
	public DateTime deConvert(String string) {
		if (string == null) {
			return null;
		}
		return DateTime.parse(
			string,
			Formatter.STANDARD_DATETIME_MILLISECOUND7,
			true
		);
	}
}
