package util;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.util.Map;

public class YamlConfigReader {
    public static Map<String, Object> readConfig(String filePath) throws Exception {
        Yaml yaml = new Yaml();
        FileInputStream inputStream = new FileInputStream(filePath);
        Map<String, Object> config = yaml.load(inputStream);
        inputStream.close();
        return config;
    }
    public static Map<String, Map<String, Object>> readSpecAnimal(String filePath) throws Exception {
        Yaml yaml = new Yaml();
        FileInputStream inputStream = new FileInputStream(filePath);
        Map<String, Map<String, Object>> specAnimal  = yaml.load(inputStream);
        inputStream.close();
        return specAnimal;
    }
}
