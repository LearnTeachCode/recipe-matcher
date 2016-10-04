package devApp.modules.fileIo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasicFileUtilImpl implements BasicFileUtil {

    private static final Log LOG = LogFactory.getLog(BasicFileUtilImpl.class);
    private static final String NL = "\n";

    @Override
    public String readFileContent(String fileName, String location) {

        final String resolvedFilePath =
                location + "/" + fileName;

        final StringBuilder content =
                new StringBuilder();

        try (final BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(resolvedFilePath))){

            String line = bufferedReader.readLine();

            while (line != null) {
                content.append(line)
                        .append(NL);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error(e.getMessage(), e);
            }
        }

        return content.toString();
    }

    @Override
    public List<String> readFileContentIntoLines(String fileName, String location) {

        final String resolvedFilePath =
                location + "/" + fileName;

        final List<String> content = new ArrayList<>();

        try (final BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(resolvedFilePath))){

            String line = bufferedReader.readLine();

            while (line != null) {
                content.add(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error(e.getMessage(), e);
            }
        }

        return content;
    }

    @Override
    public void writeToFile(String content, String fileName, String location) {

        final String resolvedFilePath =
                location + "/" + fileName;

        try (final BufferedWriter bufferWriter =
                     new BufferedWriter(new FileWriter(resolvedFilePath))){

            // write to file
            bufferWriter.write(content);

        } catch (IOException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public void deleteFile(String fileName, String location) {

        final String resolvedFilePath =
                location + "/" + fileName;

        final File file = new File(resolvedFilePath);

        if (file.exists()) {

            final Boolean isDeleted = file.delete();

            if (LOG.isInfoEnabled()) {
                LOG.info("Delete outcome for file: " +
                        fileName +
                        " was: " +
                        isDeleted);
            }
        }
    }
}
