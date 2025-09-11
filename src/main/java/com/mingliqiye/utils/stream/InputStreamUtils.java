package com.mingliqiye.utils.stream;

import com.mingliqiye.utils.collection.Lists;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import lombok.val;

/**
 * 输入流工具类，提供对InputStream的常用操作封装
 */
public class InputStreamUtils {

	/**
	 * 默认缓冲区大小：1MB
	 */
	public static final int DEFAULT_BUFFER_SIZE = 1024 * 1024;

	/**
	 * 将输入流读取到字节数组中<br>
	 * 请在外部自行关闭输入流对象 避免资源泄露
	 *
	 * @param inputStream 输入流对象，用于读取数据
	 * @return 包含输入流所有数据的字节数组
	 * @throws IOException 当读取输入流或写入输出流时发生IO异常
	 */
	public static byte[] readToArray(InputStream inputStream)
		throws IOException {
		// 使用ByteArrayOutputStream来收集输入流中的所有数据
		try (val byteArrayOutputStream = new ByteArrayOutputStream()) {
			val bytes = new byte[DEFAULT_BUFFER_SIZE];
			int length;
			// 循环读取输入流数据，直到读取完毕
			while ((length = inputStream.read(bytes)) != -1) {
				byteArrayOutputStream.write(bytes, 0, length);
			}
			return byteArrayOutputStream.toByteArray();
		}
	}

	/**
	 * 将输入流读取到Byte列表中<br>
	 * 请在外部自行关闭输入流对象 避免资源泄露
	 *
	 * @param inputStream 输入流对象，用于读取数据
	 * @return 包含输入流所有数据的Byte列表
	 * @throws IOException 当读取输入流时发生IO异常
	 */
	public static List<Byte> readToList(InputStream inputStream)
		throws IOException {
		return Lists.toList(readToArray(inputStream));
	}

	/**
	 * 将输入流读取为字符串<br>
	 * 请在外部自行关闭输入流对象 避免资源泄露
	 *
	 * @param inputStream 输入流对象，用于读取数据
	 * @return 输入流对应的字符串内容
	 * @throws IOException 当读取输入流时发生IO异常
	 */
	public static String readToString(InputStream inputStream)
		throws IOException {
		return new String(readToArray(inputStream));
	}

	/**
	 * 将输入流的数据传输到输出流中<br>
	 * 请在外部自行关闭输入流输出流对象 避免资源泄露
	 *
	 * @param inputStream  源输入流，用于读取数据
	 * @param outputStream 目标输出流，用于写入数据
	 * @return 传输的总字节数
	 * @throws IOException 当读取或写入流时发生IO异常
	 */
	public static long transferTo(
		InputStream inputStream,
		OutputStream outputStream
	) throws IOException {
		if (inputStream == null) {
			throw new IllegalArgumentException("inputStream can not be null");
		}
		if (outputStream == null) {
			throw new IllegalArgumentException("outputStream can not be null");
		}
		val bytes = new byte[DEFAULT_BUFFER_SIZE];
		int length;
		long readAll = 0L;
		// 循环读取并写入数据，直到输入流读取完毕
		while ((length = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, length);
			readAll += length;
		}
		outputStream.flush();
		return readAll;
	}
}
