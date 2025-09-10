package com.mingliqiye.utils.stream;

import java.io.*;
import java.util.List;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class InputStreanWrapper extends InputStream implements AutoCloseable {

	@Getter
	private final InputStream inputStream;

	public InputStreanWrapper(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	private static InputStreanWrapper of(InputStream inputStream) {
		return new InputStreanWrapper(inputStream);
	}

	@Override
	public int available() throws IOException {
		return inputStream.available();
	}

	@Override
	public int read() throws IOException {
		return inputStream.read();
	}

	@Override
	public int read(byte@NotNull [] b) throws IOException {
		return inputStream.read(b);
	}

	@Override
	public int read(byte@NotNull [] b, int off, int len) throws IOException {
		return inputStream.read(b, off, len);
	}

	@Override
	public long skip(long n) throws IOException {
		return inputStream.skip(n);
	}

	@Override
	public void mark(int readlimit) {
		inputStream.mark(readlimit);
	}

	@Override
	public void reset() throws IOException {
		inputStream.reset();
	}

	@Override
	public boolean markSupported() {
		return inputStream.markSupported();
	}

	@Override
	public void close() {
		try {
			inputStream.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 输入流转换为输出流 <br>
	 * jdk8 兼容实现 jdk9+ <br>
	 * 请使用 InputStream.transferTo()
	 *
	 * @param outputStream
	 * @return 转换的字节数
	 * @throws IOException
	 */
	public long transferToOutputStream(OutputStream outputStream)
		throws IOException {
		return InputStreamUtils.transferTo(inputStream, outputStream);
	}

	public byte[] readToArray() throws IOException {
		return InputStreamUtils.readToArray(inputStream);
	}

	public List<Byte> readToList() throws IOException {
		return InputStreamUtils.readToList(inputStream);
	}

	public String readToString() throws IOException {
		return InputStreamUtils.readToString(inputStream);
	}
}
