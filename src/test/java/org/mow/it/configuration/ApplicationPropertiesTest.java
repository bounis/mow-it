package org.mow.it.configuration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApplicationPropertiesTest {

    private static final String THE_ABSOLUTE_PATH_TO_CONFIG_FILE = "the-absolute-path-to-config-file";

    @Test
    public void should_read_config_property_from_properties_file() {
        String mowerConfigPath = ApplicationProperties.instance.getMowerConfigPath();
        Assertions.assertThat(mowerConfigPath).isEqualTo(THE_ABSOLUTE_PATH_TO_CONFIG_FILE);
    }
}