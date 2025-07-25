package com.mingliqiye.utils.file;

import com.mingliqiye.utils.string.StringUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类，提供常用的文件操作方法
 *
 * @author MingLiPro
 */
public class FileUtil {

    /**
     * 默认字符集
     */
    @Getter
    @Setter
    private static Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    /**
     * 读取文件内容为字符串
     *
     * @param filePath 文件路径
     * @return 文件内容字符串
     * @throws IOException 读取文件时发生错误
     */
    public static String readFileToString(String filePath) throws IOException {
        return readFileToString(filePath, DEFAULT_CHARSET);
    }

    /**
     * 读取文件内容为字符串
     *
     * @param filePath 文件路径
     * @param charset  字符集
     * @return 文件内容字符串
     * @throws IOException 读取文件时发生错误
     */
    public static String readFileToString(String filePath, Charset charset)
        throws IOException {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, charset);
    }

    /**
     * 将字符串写入文件
     *
     * @param filePath 文件路径
     * @param content  要写入的内容
     * @throws IOException 写入文件时发生错误
     */
    public static void writeStringToFile(String filePath, String content)
        throws IOException {
        writeStringToFile(filePath, content, DEFAULT_CHARSET);
    }

    /**
     * 将字符串写入文件
     *
     * @param filePath 文件路径
     * @param content  要写入的内容
     * @param charset  字符集
     * @throws IOException 写入文件时发生错误
     */
    public static void writeStringToFile(
        String filePath,
        String content,
        Charset charset
    ) throws IOException {
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent());
        Files.write(path, content.getBytes(charset));
    }

    /**
     * 读取文件内容为字符串列表（按行分割）
     *
     * @param filePath 文件路径
     * @return 文件内容按行分割的字符串列表
     * @throws IOException 读取文件时发生错误
     */
    public static List<String> readLines(String filePath) throws IOException {
        return readLines(filePath, DEFAULT_CHARSET);
    }

    /**
     * 读取文件内容为字符串列表（按行分割）
     *
     * @param filePath 文件路径
     * @param charset  字符集
     * @return 文件内容按行分割的字符串列表
     * @throws IOException 读取文件时发生错误
     */
    public static List<String> readLines(String filePath, Charset charset)
        throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path, charset);
    }

    /**
     * 将字符串列表写入文件（每行一个元素）
     *
     * @param filePath 文件路径
     * @param lines    要写入的行内容列表
     * @throws IOException 写入文件时发生错误
     */
    public static void writeLines(String filePath, List<String> lines)
        throws IOException {
        writeLines(filePath, lines, DEFAULT_CHARSET);
    }

    /**
     * 将字符串列表写入文件（每行一个元素）
     *
     * @param filePath 文件路径
     * @param lines    要写入的行内容列表
     * @param charset  字符集
     * @throws IOException 写入文件时发生错误
     */
    public static void writeLines(
        String filePath,
        List<String> lines,
        Charset charset
    ) throws IOException {
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent());
        Files.write(path, lines, charset);
    }

    /**
     * 复制文件
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     * @throws IOException 复制文件时发生错误
     */
    public static void copyFile(String sourcePath, String targetPath)
        throws IOException {
        Path source = Paths.get(sourcePath);
        Path target = Paths.get(targetPath);
        Files.createDirectories(target.getParent());
        Files.copy(source, target);
    }

    /**
     * 删除文件
     *
     * @param filePath 文件路径
     * @return 如果文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.deleteIfExists(path);
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 检查文件是否存在
     *
     * @param filePath 文件路径
     * @return 如果文件存在返回true，否则返回false
     */
    public static boolean exists(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }

    /**
     * 获取文件大小
     *
     * @param filePath 文件路径
     * @return 文件大小（字节），如果文件不存在返回-1
     */
    public static long getFileSize(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.size(path);
        } catch (IOException e) {
            return -1;
        }
    }

    /**
     * 创建目录
     *
     * @param dirPath 目录路径
     * @return 如果目录创建成功返回true，否则返回false
     */
    public static boolean createDirectory(String dirPath) {
        try {
            Path path = Paths.get(dirPath);
            Files.createDirectories(path);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 获取文件扩展名
     *
     * @param fileName 文件名
     * @return 文件扩展名（不包含点号），如果无扩展名返回空字符串
     */
    public static String getFileExtension(String fileName) {
        if (StringUtil.isEmpty(fileName)) {
            return "";
        }
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == fileName.length() - 1) {
            return "";
        }
        return fileName.substring(lastDotIndex + 1);
    }

    /**
     * 获取不带扩展名的文件名
     *
     * @param fileName 文件名
     * @return 不带扩展名的文件名
     */
    public static String getFileNameWithoutExtension(String fileName) {
        if (StringUtil.isEmpty(fileName)) {
            return "";
        }
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return fileName;
        }
        return fileName.substring(0, lastDotIndex);
    }

    /**
     * 读取文件内容为字节数组
     *
     * @param filePath 文件路径
     * @return 文件内容的字节数组
     * @throws IOException 读取文件时发生错误
     */
    public static byte[] readFileToByteArray(String filePath)
        throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllBytes(path);
    }

    /**
     * 将字节数组写入文件
     *
     * @param filePath 文件路径
     * @param data     要写入的字节数据
     * @throws IOException 写入文件时发生错误
     */
    public static void writeByteArrayToFile(String filePath, byte[] data)
        throws IOException {
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent());
        Files.write(path, data);
    }

    /**
     * 将字节数组追加到文件末尾
     *
     * @param filePath 文件路径
     * @param data     要追加的字节数据
     * @throws IOException 追加数据时发生错误
     */
    public static void appendByteArrayToFile(String filePath, byte[] data)
        throws IOException {
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent());
        Files.write(
            path,
            data,
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND
        );
    }

    /**
     * 分块读取大文件为字节数组列表
     *
     * @param filePath  文件路径
     * @param chunkSize 每块大小（字节）
     * @return 文件内容按指定大小分割的字节数组列表
     * @throws IOException 读取文件时发生错误
     */
    public static List<byte[]> readFileToByteArrayChunks(
        String filePath,
        int chunkSize
    ) throws IOException {
        List<byte[]> chunks = new ArrayList<>();
        Path path = Paths.get(filePath);

        try (InputStream inputStream = Files.newInputStream(path)) {
            byte[] buffer = new byte[chunkSize];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byte[] chunk = new byte[bytesRead];
                System.arraycopy(buffer, 0, chunk, 0, bytesRead);
                chunks.add(chunk);
            }
        }

        return chunks;
    }

    /**
     * 将字节数组列表写入文件
     *
     * @param filePath 文件路径
     * @param chunks   字节数组列表
     * @throws IOException 写入文件时发生错误
     */
    public static void writeByteArrayChunksToFile(
        String filePath,
        List<byte[]> chunks
    ) throws IOException {
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent());

        try (OutputStream outputStream = Files.newOutputStream(path)) {
            for (byte[] chunk : chunks) {
                outputStream.write(chunk);
            }
        }
    }
}
