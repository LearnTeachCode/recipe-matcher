package devApp.modules.fileIo;

import java.util.List;

public interface BasicFileUtil {

    /**
     * Return file content in a single string, following same format.
     * @param fileName name of the file.
     * @param location directory the file live in.
     * @return String content of the file.
     */
    String readFileContent(String fileName, String location);

    /**
     * Return file content each element representing a line in the file.
     * @param fileName name of the file.
     * @param location directory the file live in.
     * @return String content of the file.
     */
    List<String> readFileContentIntoLines(String fileName, String location);

    /**
     * Write the string content into a new file.
     * @param content string content to write to a file.
     * @param fileName file name to save under.
     * @param location file location to save.
     */
    void writeToFile(String content, String fileName, String location);

    /**
     * Delete a file.
     * @param fileName name of the file to delete.
     * @param location location of the file to delete.
     */
    void deleteFile(String fileName, String location);
}
