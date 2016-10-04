package devApp.modules.fileIo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class BasicFileUtilImplTest {

    private static final Log LOG = LogFactory.getLog(BasicFileUtilImplTest.class);

    private BasicFileUtil basicFileUtil;

    @Before
    public void setUp() throws Exception {
        this.basicFileUtil = new BasicFileUtilImpl();
    }

    @After
    public void tearDown() throws Exception {
        this.basicFileUtil = null;
    }

    @Test
    public void readFileContent() throws Exception {

        final String content = "Suren Abrahamyan, 39";

        this.basicFileUtil
                .writeToFile(content, "suren.txt", System.getProperty("user.home"));

        final String contentRead =
                this.basicFileUtil
                        .readFileContent("suren.txt", System.getProperty("user.home"));

        Assert.assertEquals("File contents did not match.", contentRead.trim(), content);

        this.basicFileUtil
                .deleteFile("suren.txt", System.getProperty("user.home"));
    }

    @Test
    public void readFileContentIntoLines() throws Exception {

    }

    @Test
    public void writeToFile() throws Exception {

    }

}