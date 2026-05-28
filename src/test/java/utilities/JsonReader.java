package utilities;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

    private JsonNode jsonNode;

    // File Path
    private static final String FILE_PATH =
            "src/test/resources/testdata/credentials.json";

    public JsonReader() {

        ObjectMapper mapper = new ObjectMapper();

        try {

            jsonNode = mapper.readTree(
                    new File(FILE_PATH));

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to read JSON file: " + FILE_PATH);
        }
    }

    public String getValue(String parentNode,
                           String childNode) {

        JsonNode parent = jsonNode.get(parentNode);

        if (parent == null) {

            throw new RuntimeException(
                    "Parent node not found: " + parentNode);
        }

        JsonNode child = parent.get(childNode);

        if (child == null) {

            throw new RuntimeException(
                    "Child node not found: " + childNode);
        }

        return child.asText();
    }
}