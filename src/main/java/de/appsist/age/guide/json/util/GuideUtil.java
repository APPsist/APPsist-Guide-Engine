package de.appsist.age.guide.json.util;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import de.appsist.age.guide.json.JsonContent;
import de.appsist.age.guide.json.JsonGuide;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Utility class for handling guides.
 * @author simon.schwantzer(at)im-c.de
 */
public final class GuideUtil {
    private static final JsonFactory factory = new JsonFactory();
    
    /**
     * Reads a guide from a JSON string.
     * @param jsonString JSON string representing a guide.
     * @return Guide represented by the JSON object.
     * @throws IllegalArgumentException The given string is either no valid JSON object or does not encode a guide.
     */
    public static JsonGuide readGuide(String jsonString) throws IllegalArgumentException {
        ObjectNode objectNode = JsonUtil.readJson(jsonString);
        return new JsonGuide(objectNode);
    }
    
    /**
     * Reads a guide from a JSON file.
     * @param file JSON file.
     * @return Guide represented by the JSON file.
     * @throws IllegalArgumentException Failed to read file or no valid JSON object.
     */
    public static JsonGuide readGuide(File file) throws IllegalArgumentException {
        ObjectNode objectNode = JsonUtil.readJson(file);
        return new JsonGuide(objectNode);
    }
    
    /**
     * Exports a guide as JSON string.
     * @param guide Guide to serialize as JSON.
     * @param usePrettyPrint If set to <code>true</code>, whitepaces and identation is used.
     * @return JSON string encoding the guide.
     * @throws IOException Failed to serialize guide.
     */
    public static String exportGuide(JsonGuide guide, boolean usePrettyPrint) throws IOException {
        return JsonUtil.exportJson(guide.asJson(), usePrettyPrint);
    }
    
    /**
     * Writes a guide as JSON string directly in a file.
     * @param guide Guide to write.
     * @param usePrettyPrint If set to <code>true</code>, whitepaces and identation is used.
     * @param file File to write the JSON string in.
     * @throws IOException Failed to write the given file.
     */
    public static void writeGruide(JsonGuide guide, File file, boolean usePrettyPrint) throws IOException {
        JsonUtil.writeJson(guide.asJson(), file, usePrettyPrint);
    }
    
    public static JsonContent readContent(String contentString) throws IllegalArgumentException {
        ObjectNode object = JsonUtil.readJson(contentString);
        return new JsonContent(object);
    }
    
    public static JsonContent readContent(File file) throws IllegalArgumentException {
        ObjectNode object = JsonUtil.readJson(file);
        return new JsonContent(object);
    }
    
    public static String exportContent(JsonContent content, boolean usePrettyPrint) throws IOException {
       return JsonUtil.exportJson(content.asJson(), usePrettyPrint);
    }
    
    public static void writeContent(JsonContent content, File file, boolean usePrettyPrint) throws IOException {
        JsonUtil.writeJson(content.asJson(), file, usePrettyPrint);
    }
}
