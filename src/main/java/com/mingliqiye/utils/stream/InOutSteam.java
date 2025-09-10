package com.mingliqiye.utils.stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;

/**
 * 自定义的输入输出流工具类，支持线程安全的数据读写操作。<br>
 * 谁闲着没事干用本地输入输出<br>
 * 实现了 AutoCloseable、Closeable 和 Flushable 接口，便于资源管理。
 *
 * @author MingLiPro
 */
public class InOutSteam implements AutoCloseable, Closeable, Flushable {

	private final Lock lock = new ReentrantLock();

	List<Byte> bytes;

	/**
	 * 从内部缓冲区中读取最多 len 个字节到指定的字节数组 b 中。
	 *
	 * @param b   目标字节数组，用于存储读取的数据
	 * @param off 起始偏移位置
	 * @param len 最大读取字节数
	 * @return 实际读取的字节数；如果已到达流末尾，则返回 -1
	 * @throws IndexOutOfBoundsException 如果 off 或 len 参数非法
	 */
	public int read(byte@NotNull [] b, int off, int len) {
		if (bytes == null) return -1;
		if (bytes.isEmpty()) {
			return 0;
		}

		if (off < 0 || len < 0 || off + len > b.length) {
			throw new IndexOutOfBoundsException();
		}

		try {
			lock.lock();
			int bytesRead = Math.min(len, bytes.size());

			for (int i = 0; i < bytesRead; i++) {
				b[off + i] = bytes.get(i);
			}
			if (bytesRead > 0) {
				bytes.subList(0, bytesRead).clear();
			}

			return bytesRead;
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 读取一个字节的数据。
	 *
	 * @return 下一个字节数据（0~255），如果已到达流末尾则返回 -1
	 */
	public int read() {
		if (bytes == null) return -1;
		try {
			lock.lock();
			if (bytes.isEmpty()) {
				return -1;
			}
			return bytes.remove(0);
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 从内部缓冲区中读取最多 b.length 个字节到指定的字节数组 b 中。
	 *
	 * @param b 目标字节数组，用于存储读取的数据
	 * @return 实际读取的字节数；如果已到达流末尾，则返回 -1
	 */
	public int read(byte@NotNull [] b) {
		if (bytes == null) return -1;
		return read(b, 0, b.length);
	}

	/**
	 * 跳过并丢弃此输入流中数据的 n 个字节。
	 *
	 * @param n 要跳过的字节数
	 * @return 实际跳过的字节数
	 */
	public long skip(long n) {
		if (bytes == null) return -1;
		if (bytes.isEmpty()) {
			return 0;
		}

		try {
			lock.lock();
			if (n <= 0) {
				return 0;
			}
			long bytesToSkip = Math.min(n, bytes.size());

			// 移除跳过的字节
			if (bytesToSkip > 0) {
				bytes.subList(0, (int) bytesToSkip).clear();
			}

			return bytesToSkip;
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 返回此输入流下一个方法调用可以不受阻塞地从此输入流读取（或跳过）的估计字节数。
	 *
	 * @return 可以无阻塞读取的字节数
	 */
	public int available() {
		if (bytes == null) return -1;
		try {
			lock.lock();
			return bytes.size();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 获取与当前对象关联的 InputStream 实例。
	 *
	 * @return InputStream 实例
	 */
	public InputStream getInputStream() {
		if (inputStream == null) {
			inputStream = inputStream();
		}
		return inputStream;
	}

	private InputStream inputStream;
	private OutputStream outputStream;

	/**
	 * 获取与当前对象关联的 OutputStream 实例。
	 *
	 * @return OutputStream 实例
	 */
	public OutputStream getOutputStream() {
		if (outputStream == null) {
			outputStream = outputStream();
		}
		return outputStream;
	}

	/**
	 * 创建并返回一个包装后的 InputStream 实例。
	 *
	 * @return 新创建的 InputStream 实例
	 */
	private InputStream inputStream() {
		return new InputStreanWrapper(
			new InputStream() {
				@Override
				public int read() {
					return InOutSteam.this.read();
				}

				@Override
				public int read(byte@NotNull [] b, int off, int len) {
					return InOutSteam.this.read(b, off, len);
				}

				@Override
				public long skip(long n) {
					return InOutSteam.this.skip(n);
				}

				@Override
				public int available() {
					return InOutSteam.this.available();
				}
			}
		);
	}

	/**
	 * 创建并返回一个 OutputStream 实例。
	 *
	 * @return 新创建的 OutputStream 实例
	 */
	private OutputStream outputStream() {
		return new OutputStream() {
			@Override
			public void write(int b) {
				InOutSteam.this.write(b);
			}

			@Override
			public void write(byte@NotNull [] b, int off, int len) {
				InOutSteam.this.write(b, off, len);
			}
		};
	}

	/**
	 * 构造函数，初始化内部字节列表。
	 */
	public InOutSteam() {
		bytes = new ArrayList<>();
	}

	/**
	 * 将指定的字节写入此输出流。
	 *
	 * @param b 要写入的字节
	 */
	public void write(int b) {
		try {
			lock.lock();
			bytes.add((byte) b);
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 将指定字节数组中的部分数据写入此输出流。
	 *
	 * @param b   数据源字节数组
	 * @param off 起始偏移位置
	 * @param len 写入的字节数
	 * @throws IndexOutOfBoundsException 如果 off 或 len 参数非法
	 */
	public void write(byte@NotNull [] b, int off, int len) {
		if (off < 0 || len < 0 || off + len > b.length) {
			throw new IndexOutOfBoundsException("Invalid offset or length");
		}

		try {
			lock.lock();
			for (int i = off; i < off + len; i++) {
				bytes.add(b[i]);
			}
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 将整个字节数组写入此输出流。
	 *
	 * @param b 要写入的字节数组
	 */
	public void write(byte@NotNull [] b) {
		write(b, 0, b.length);
	}

	/**
	 * 刷新此输出流并强制写出所有缓冲的输出字节。
	 * 当前实现为空方法。
	 */
	@Override
	public void flush() {}

	/**
	 * 关闭此流并释放与其相关的所有资源。
	 * 清空并置空内部字节列表。
	 */
	@Override
	public void close() {
		bytes.clear();
		bytes = null;
	}
}
