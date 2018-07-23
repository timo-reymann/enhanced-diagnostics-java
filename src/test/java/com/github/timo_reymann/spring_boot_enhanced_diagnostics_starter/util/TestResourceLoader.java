package com.github.timo_reymann.spring_boot_enhanced_diagnostics_starter.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestResourceLoader {
    public static File loadFile(String fileName) {
        ClassLoader classLoader = TestResourceLoader.class.getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

    public static byte[] readFile(String fileName) throws IOException {
        return Files.readAllBytes(loadFile(fileName).toPath());
    }
}
