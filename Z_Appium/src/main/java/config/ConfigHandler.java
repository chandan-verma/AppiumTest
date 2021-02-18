package config;

import org.cfg4j.provider.ConfigurationProvider;
import org.cfg4j.provider.ConfigurationProviderBuilder;
import org.cfg4j.source.ConfigurationSource;
import org.cfg4j.source.files.FilesConfigurationSource;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class ConfigHandler {


    public static String getConfig(String fileName) {
        return System.getProperty("user.dir") + "/resource/" + fileName;
    }

    private static Path getPathToConfig(String fileName) {
        return Paths.get(new File(getConfig(fileName)).toURI());
    }

    public static CommonConfig buildConfig(String fileName) {
        ConfigurationSource source = new FilesConfigurationSource(() -> Collections.singletonList(getPathToConfig(fileName)));
        ConfigurationProvider configProvider = new ConfigurationProviderBuilder().withConfigurationSource(source).build();
        App1Config app1 = configProvider.bind("app1", App1Config.class);
        return new CommonConfig(app1);
    }
}
