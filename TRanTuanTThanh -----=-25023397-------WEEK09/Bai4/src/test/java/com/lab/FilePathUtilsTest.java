package com.lab;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class FilePathUtilsTest {

    /**
     * Test nay phai pass tren moi OS (Ubuntu, Windows, macOS)
     * Dung File.separator thay vi hard-code / hoac \
     */
    @Test
    void testBuildPath() {
        String result = FilePathUtils.buildPath("reports", "summary.txt");

        // Kiem tra path dung dung File.separator cua OS hien tai
        String expected = "reports" + File.separator + "summary.txt";
        assertEquals(expected, result,
                "Path separator phai tuong thich voi OS: " + System.getProperty("os.name"));
    }

    @Test
    void testGetFileName() {
        // Tao path theo cach portable
        String fullPath = "data" + File.separator + "input.csv";
        assertEquals("input.csv", FilePathUtils.getFileName(fullPath));
    }

    @Test
    void testGetParentDir() {
        String fullPath = "data" + File.separator + "output.json";
        assertEquals("data", FilePathUtils.getParentDir(fullPath));
    }

    @Test
    void testNoParentDir() {
        assertEquals("", FilePathUtils.getParentDir("standalone.txt"));
    }
}
