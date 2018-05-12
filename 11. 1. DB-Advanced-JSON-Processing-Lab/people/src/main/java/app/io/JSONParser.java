package app.io;

import app.domain.dto.PersonDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class JSONParser {
    private Gson gson;
    private FileIOUtil fileIOUtil;

    public JSONParser() {
        this.fileIOUtil = new FileIOUtil();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public <T> T importJson(Class<T> tClass, String filename) throws IOException {
        String content = this.fileIOUtil.read(filename);
        T mapped = this.gson.fromJson(content, tClass);
        return mapped;
    }

    public void outputJson(PersonDto dto, String filename) throws IOException {
        String content = gson.toJson(dto);
        this.fileIOUtil.write(content, filename);
    }
}
