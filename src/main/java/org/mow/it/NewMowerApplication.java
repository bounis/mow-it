package org.mow.it;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mow.it.business.BusinessService;
import org.mow.it.configuration.ApplicationProperties;

public class NewMowerApplication {

  private static final Logger LOGGER = Logger.getLogger(NewMowerApplication.class.getName());

  private static final String MOWER_CONFIG_FILE = "MOWER_CONFIG_FILE";

  public static void main(String[] args) {

    String inputFilePath = null;

    if (args.length > 0 && args[0] != null) {
      inputFilePath = args[0];

    } else if (System.getProperty(MOWER_CONFIG_FILE) != null) {
      inputFilePath = System.getProperty(MOWER_CONFIG_FILE);

    } else if (System.getenv().get(MOWER_CONFIG_FILE) != null) {
      inputFilePath = System.getenv().get(MOWER_CONFIG_FILE);

    } else if (ApplicationProperties.instance.getMowerConfigPath() != null) {
      inputFilePath = ApplicationProperties.instance.getMowerConfigPath();

    } else {
      LOGGER.log
          (Level.SEVERE,

              "\n\n oups !! no mower config file path provided \n"

              + "consider defining the absolute path (sorry!! you can provide relative path in a next release) by using one the following solutions \n"
              + "NB: with this order you can override the path value \n"

              + "1) the first argument of the program main class\n"
              + "2) VM argument named MOWER_CONFIG_FILE\n"
              + "3) ENV variable named MOWER_CONFIG_FILE\n"
              + "4) the property mower.config.file in the application.properties file");

      System.exit(1);
    }

    Path path = Paths.get(inputFilePath);
    if (!Files.exists(path)) {

      LOGGER.log(Level.SEVERE, "please provide valid config file path");
      System.exit(1);
    }

    BusinessService.getInstance().startMowers(path);

  }
}
