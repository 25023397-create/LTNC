package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePathUtils {

    private static final Logger logger = LoggerFactory.getLogger(FilePathUtils.class);

    /**
     * Xay dung duong dan file theo cach portable (hoat dong tren moi OS)
     * Su dung java.nio.file.Path thay vi ghep chuoi thu cong
     */
    public static String buildPath(String directory, String filename) {
        // DUNG: Dung Path API - tu dong dung dung separator cua tung OS
        Path path = Paths.get(directory, filename);
        String result = path.toString();
        logger.info("Built path: {}", result);
        return result;
    }

    /**
     * Lay ten file tu duong dan day du
     */
    public static String getFileName(String fullPath) {
        Path path = Paths.get(fullPath);
        String fileName = path.getFileName().toString();
        logger.info("Extracted filename '{}' from path '{}'", fileName, fullPath);
        return fileName;
    }

    /**
     * Lay thu muc cha tu duong dan
     */
    public static String getParentDir(String fullPath) {
        Path path = Paths.get(fullPath);
        Path parent = path.getParent();
        if (parent == null) {
            logger.warn("No parent directory for path: {}", fullPath);
            return "";
        }
        logger.info("Parent dir: {}", parent);
        return parent.toString();
    }

    public static void main(String[] args) {
        logger.info("=== FilePathUtils Demo ===");
        logger.info("OS: {}", System.getProperty("os.name"));
        logger.info("Separator: '{}'", File.separator);

        String path = buildPath("reports", "summary.txt");
        logger.info("Path: {}", path);
        logger.info("Filename: {}", getFileName(path));
        logger.info("=== Done ===");
    }
}
