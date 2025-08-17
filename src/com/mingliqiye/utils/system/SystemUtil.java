package com.mingliqiye.utils.system;

import com.mingliqiye.utils.collection.Lists;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 系统工具类，提供操作系统类型判断和JDK版本检测功能
 *
 * @author MingLiPro
 */
public class SystemUtil {

	private static final String osName = System.getProperties().getProperty(
		"os.name"
	);

	/**
	 * 判断当前操作系统是否为Windows系统
	 *
	 * @return 如果是Windows系统返回true，否则返回false
	 */
	public static boolean isWindows() {
		return osName != null && osName.startsWith("Windows");
	}

	/**
	 * 判断当前操作系统是否为Mac系统
	 *
	 * @return 如果是Mac系统返回true，否则返回false
	 */
	public static boolean isMac() {
		return osName != null && osName.startsWith("Mac");
	}

	/**
	 * 判断当前操作系统是否为Unix/Linux系统
	 *
	 * @return 如果是Unix/Linux系统返回true，否则返回false
	 */
	public static boolean isUnix() {
		if (osName == null) {
			return false;
		}
		return (
			osName.startsWith("Linux") ||
			osName.startsWith("AIX") ||
			osName.startsWith("SunOS")
		);
	}

	/**
	 * 获取JDK版本号
	 *
	 * @return JDK版本号字符串
	 */
	public static String getJdkVersion() {
		return System.getProperty("java.specification.version");
	}

	/**
	 * 获取Java版本号的整数形式
	 *
	 * @return Java版本号的整数形式（如：8、11、17等）
	 */
	public static Integer getJavaVersionAsInteger() {
		String version = getJdkVersion();
		if (version == null || version.isEmpty()) {
			throw new IllegalStateException(
				"Unable to determine Java version from property 'java.specification.version'"
			);
		}

		String uversion;
		if (version.startsWith("1.")) {
			if (version.length() < 3) {
				throw new IllegalStateException(
					"Invalid Java version format: " + version
				);
			}
			uversion = version.substring(2, 3);
		} else {
			if (version.length() < 2) {
				throw new IllegalStateException(
					"Invalid Java version format: " + version
				);
			}
			uversion = version.substring(0, 2);
		}
		return Integer.parseInt(uversion);
	}

	/**
	 * 判断当前JDK版本是否大于8
	 *
	 * @return 如果JDK版本大于8返回true，否则返回false
	 */
	public static boolean isJdk8Plus() {
		return getJavaVersionAsInteger() > 8;
	}

	/**
	 * 获取本地IP地址数组
	 *
	 * @return 本地IP地址字符串数组
	 * @throws RuntimeException 当获取网络接口信息失败时抛出
	 */
	public static String[] getLocalIps() {
		try {
			List<String> ipList = new ArrayList<>();
			Enumeration<NetworkInterface> interfaces =
				NetworkInterface.getNetworkInterfaces();

			while (interfaces.hasMoreElements()) {
				NetworkInterface networkInterface = interfaces.nextElement();
				// 跳过回环接口和虚拟接口
				if (
					networkInterface.isLoopback() ||
					networkInterface.isVirtual() ||
					!networkInterface.isUp()
				) {
					continue;
				}

				Enumeration<InetAddress> addresses =
					networkInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress address = addresses.nextElement();
					// 只获取IPv4地址
					if (address instanceof Inet4Address) {
						ipList.add(address.getHostAddress());
					}
				}
			}

			return ipList.toArray(new String[0]);
		} catch (SocketException e) {
			throw new RuntimeException("Failed to get local IP addresses", e);
		}
	}

	/**
	 * 获取本地IP地址列表
	 *
	 * @return 本地IP地址的字符串列表
	 */
	public static List<String> getLocalIpsByList() {
		return Lists.newArrayList(getLocalIps());
	}

	/**
	 * 获取本地回环地址
	 *
	 * @return 回环地址字符串，通常为"127.0.0.1"
	 */
	public static String[] getLoopbackIps() {
		List<String> strings = new ArrayList<>(3);
		try {
			Enumeration<NetworkInterface> interfaces =
				NetworkInterface.getNetworkInterfaces();

			while (interfaces.hasMoreElements()) {
				NetworkInterface networkInterface = interfaces.nextElement();

				// 只处理回环接口
				if (networkInterface.isLoopback() && networkInterface.isUp()) {
					Enumeration<InetAddress> addresses =
						networkInterface.getInetAddresses();

					while (addresses.hasMoreElements()) {
						InetAddress address = addresses.nextElement();
						strings.add(address.getHostAddress());
					}
				}
			}
			return strings.toArray(new String[0]);
		} catch (SocketException e) {
			// 可考虑添加日志记录
			return new String[] { "127.0.0.1" };
		}
	}

	/**
	 * 获取本地回环地址IP列表
	 *
	 * @return 本地回环地址IP字符串列表的副本
	 */
	public static List<String> getLoopbackIpsByList() {
		// 将本地回环地址IP数组转换为列表并返回
		return Lists.newArrayList(getLoopbackIps());
	}
}
