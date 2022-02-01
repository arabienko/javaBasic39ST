package by.arabienko.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Class validation
 */
public class Validation {
    public boolean isNotEmpty(List list) {
        return !list.isEmpty() & list.size() >= 1;
    }
    public boolean isExist(String file) {
        Path path = Paths.get(file);
        return Files.exists(path);
    }
}
