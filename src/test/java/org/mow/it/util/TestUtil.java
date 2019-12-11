package org.mow.it.util;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUtil {

  public static Path getPathFromRessource(String name) throws URISyntaxException {
    return Paths.get(TestUtil.class.getClassLoader().getResource(name).toURI());
  }

}
