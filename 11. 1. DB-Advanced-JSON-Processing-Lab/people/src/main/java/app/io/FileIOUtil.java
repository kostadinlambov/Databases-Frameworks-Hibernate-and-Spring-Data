package app.io;

import java.io.*;

public class FileIOUtil {
    public String read(String filename) throws IOException {
        InputStream str =getClass().getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(str));
        StringBuilder sb = new StringBuilder();

        String line = null;
        while((line = reader.readLine()) != null){
            sb.append(line);
        }

        return sb.toString();
    }

    public void write(String content, String fileName) throws IOException {

        try(FileOutputStream outputStream = new FileOutputStream(fileName);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))
        ){
            writer.write(content);
        }
    }
}
