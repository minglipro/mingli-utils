package com.mingliqiye.utils.stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class OutputStreamWrapper extends OutputStream implements AutoCloseable {

	@Getter
	private final OutputStream outputStream;

	private final ByteArrayOutputStream byteArrayOutputStream =
		new ByteArrayOutputStream();

	public OutputStreamWrapper(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public static OutputStreamWrapper of(OutputStream outputStream) {
		return new OutputStreamWrapper(outputStream);
	}

	@Override
	public void write(int b) throws IOException {
		byteArrayOutputStream.write(b);
	}

	@Override
	public void write(byte@NotNull [] b) throws IOException {
		byteArrayOutputStream.write(b);
	}

	public void write(List<Byte> b) throws IOException {
		write(b, 0, b.size());
	}

	@Override
	public void write(byte@NotNull [] b, int off, int len) throws IOException {
		byteArrayOutputStream.write(b, off, len);
	}

	public void write(List<Byte> b, int off, int len) throws IOException {
		byte[] bytes = new byte[b.size()];
		for (int i = 0; i < b.size(); i++) {
			bytes[i] = b.get(i);
		}
		byteArrayOutputStream.write(bytes, off, len);
	}

	@Override
	public void flush() throws IOException {
		outputStream.write(byteArrayOutputStream.toByteArray());
		byteArrayOutputStream.reset();
	}

	public int getBufferCachedSize() {
		return byteArrayOutputStream.size();
	}

	public byte[] getBufferCachedBytes() {
		return byteArrayOutputStream.toByteArray();
	}

	@Override
	public void close() {
		try {
			outputStream.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public long transferFromOutputStream(InputStream inputStream)
		throws IOException {
		return InputStreamUtils.transferTo(inputStream, outputStream);
	}
}
