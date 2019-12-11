package org.mow.it.io;

import java.io.IOException;
import java.net.URISyntaxException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mow.it.util.TestUtil;

public class IOHelperTest {

  private static final String MOWER_BUFFER_READER_TEST_TXT = "org/mow/it/io/mower-buffer-reader-test.txt";

  @Test
  public void should_return_mower_buffered_reader_instance() throws IOException, URISyntaxException {
    Assertions
        .assertThat(IOHelper
            .createMowerBufferedReader(TestUtil.getPathFromRessource(MOWER_BUFFER_READER_TEST_TXT)))
        .isInstanceOf(MowerBufferdReader.class);
  }
}