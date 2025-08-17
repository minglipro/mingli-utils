package com.mingliqiye.utils.network;

import com.mingliqiye.utils.string.StringUtil;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * 网络地址类，用于表示一个网络地址（IP或域名），并提供相关操作。
 * 支持IPv4和IPv6地址的解析与验证。
 *
 * @author MingLiPro
 */
public class NetworkAddress implements Serializable {

	/**
	 * IPv6标识
	 */
	public static int IPV6 = 6;

	/**
	 * IPv4标识
	 */
	public static int IPV4 = 4;

	/**
	 * IPv4地址正则表达式
	 */
	static String IPV4REG =
		"^((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2" +
		"(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}$";

	/**
	 * 编译后的IPv4地址匹配模式
	 */
	private static final Pattern IPV4_PATTERN = Pattern.compile(IPV4REG);

	/**
	 * IPv6地址正则表达式
	 */
	static String IPV6REG =
		"^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$|" +
		"^(::([0-9a-fA-F]{1,4}:){0,6}[0-9a-fA-F]{1,4})$" +
		"|" +
		"^(::)$|" +
		"^([0-9a-fA-F]{1,4}::([0-9a-fA-F]{1,4}:){0,5}[0-9a-fA-F]{1,4})$|" +
		"^(([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4})$|" +
		"^(([0-9a-fA-F]{1,4}:){6}(([0-9]{1,3}\\.){3}[0-9]{1,3}))$|" +
		"^::([fF]{4}:)?(([0-9]{1,3}\\.){3}[0-9]{1,3})$";

	/**
	 * 编译后的IPv6地址匹配模式
	 */
	private static final Pattern IPV6_PATTERN = Pattern.compile(IPV6REG);

	/**
	 * IP地址类型：4 表示 IPv4，6 表示 IPv6
	 */
	@Getter
	private int IPv;

	/**
	 * IP地址字符串
	 */
	@Getter
	private String ip;

	/**
	 * 域名（如果输入的是域名）
	 */
	private String domain;

	/**
	 * 标识是否是域名解析来的IP
	 */
	private boolean isdom;

	/**
	 * 构造方法，根据传入的字符串判断是IP地址还是域名，并进行相应处理。
	 *
	 * @param domip 可能是IP地址或域名的字符串
	 */
	NetworkAddress(String domip) {
		try {
			// 尝试将输入识别为IP地址
			IPv = testIp(domip);
			ip = domip;
		} catch (NetworkException e) {
			try {
				// 如果不是有效IP，则尝试作为域名解析
				String ips = getHostIp(domip);
				IPv = testIp(ips);
				ip = ips;
				isdom = true;
				domain = domip;
			} catch (UnknownHostException ex) {
				throw new NetworkException(ex);
			}
		}
	}

	/**
	 * 静态工厂方法，创建 NetworkAddress 实例。
	 *
	 * @param domip 可能是IP地址或域名的字符串
	 * @return 新建的 NetworkAddress 实例
	 */
	public static NetworkAddress of(String domip) {
		return new NetworkAddress(domip);
	}

	/**
	 * 静态工厂方法，通过 InetAddress 创建 NetworkAddress 实例。
	 *
	 * @param inetAddress InetAddress 对象
	 * @return 新建的 NetworkAddress 实例
	 */
	public static NetworkAddress of(InetAddress inetAddress) {
		return new NetworkAddress(inetAddress.getHostAddress());
	}

	/**
	 * 从DNS服务器解析域名获取对应的IP地址。
	 *
	 * @param domain 域名
	 * @return 解析出的第一个IP地址
	 * @throws UnknownHostException 如果域名无法解析
	 */
	public static String getHostIp(@NotNull String domain)
		throws UnknownHostException {
		InetAddress[] addresses = InetAddress.getAllByName(domain.trim());
		return addresses[0].getHostAddress();
	}

	/**
	 * 检测给定字符串是否为有效的IPv4或IPv6地址。
	 *
	 * @param ip 要检测的IP地址字符串
	 * @return 4 表示IPv4，6 表示IPv6
	 * @throws NetworkException 如果IP格式无效
	 */
	public static int testIp(String ip) {
		if (ip == null) {
			throw new NetworkException("IP地址不能为null");
		}
		String trimmedIp = ip.trim();

		// 判断是否匹配IPv4格式
		if (IPV4_PATTERN.matcher(trimmedIp).matches()) {
			return IPV4;
		}

		// 判断是否匹配IPv6格式
		if (IPV6_PATTERN.matcher(trimmedIp).matches()) {
			return IPV6;
		}

		// 不符合任一格式时抛出异常
		throw new NetworkException(
			StringUtil.format("[{}] 不是有效的IPv4或IPv6地址", ip)
		);
	}

	/**
	 * 将当前 NetworkAddress 转换为 InetAddress 对象。
	 *
	 * @return InetAddress 对象
	 */
	public InetAddress toInetAddress() {
		try {
			return InetAddress.getByName(ip != null ? ip : domain);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 返回 NetworkAddress 的字符串表示形式。
	 *
	 * @return 字符串表示
	 */
	public String toString() {
		return isdom
			? StringUtil.format(
				"NetworkAddress(IP='{}',type='{}'," + "domain='{}')",
				ip,
				IPv,
				domain
			)
			: StringUtil.format("NetworkAddress(IP='{}',type='{}')", ip, IPv);
	}
}
