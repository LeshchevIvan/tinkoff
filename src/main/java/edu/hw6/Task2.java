package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FilenameUtils;

public class Task2 {

    public static void cloneFile(Path path) throws IOException {

        if (Files.exists(path)) {
            Path directory = path.getParent();
            List<Path> filesList = Files.walk(directory)
                .filter(Files::isRegularFile)
                .toList();
            String fileExtension = FilenameUtils.getExtension(path.toString());
            fileExtension = "." + fileExtension;
            String fileName = path.getFileName().toString();
            String fileNameWithoutExtension = fileName.substring(0, fileName.length() - fileExtension.length());
            Pattern pattern = Pattern.compile(fileNameWithoutExtension + " - копия [(](\\d+)[)]"
                + fileExtension);
            Matcher matcher;
            Pattern pattern1 = Pattern.compile(fileNameWithoutExtension + " - копия" + fileExtension);
            boolean isCopyAlreadyExist = false;
            int maxCopyIndex = 1;
            int copyIndex;
            for (Path file : filesList) {
                matcher = pattern.matcher(file.getFileName().toString());
                if (pattern1.matcher(file.getFileName().toString()).find()) {
                    isCopyAlreadyExist = true;
                }
                if (matcher.find()) {
                    copyIndex = Integer.parseInt(matcher.group(1));
                    if (copyIndex > maxCopyIndex) {
                        maxCopyIndex = copyIndex;
                    }
                }
            }
            Path newFileName;
            if (isCopyAlreadyExist) {
                newFileName = Path.of(
                    directory + "\\" + fileNameWithoutExtension + " - копия (" + String.format("%d", maxCopyIndex + 1)
                        + ")" + fileExtension);
            } else {
                newFileName = Path.of(directory + "\\" + fileNameWithoutExtension + " - копия" + fileExtension);
            }
            Files.copy(path, newFileName);

        } else {
            System.out.println("There is no such file in this directory: " + path);
        }
    }
}

