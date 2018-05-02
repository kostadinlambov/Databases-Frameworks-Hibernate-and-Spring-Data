package Part_3_Strings_Maps_and_Stream_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15_URL_Parser {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String url = reader.readLine();
        String protocol = "";
        String server = "";
        String resource = "";
        String serverResource = "";

        int indexEndProtocol = url.indexOf("://");
        if(indexEndProtocol == -1){
            protocol = "";
            serverResource = url;
        }else{
            String[] tokens = url.split("://");
            protocol = tokens[0];
            serverResource = tokens[1];
        }

        int indexStartResource = serverResource.indexOf("/");
        if(indexStartResource == -1){
            server = serverResource;

        }else{
            server = serverResource.substring(0,indexStartResource);
            resource = serverResource.substring(indexStartResource+1);
        }

        System.out.printf(
                "[protocol] = \"%s\"\n" +
                        "[server] = \"%s\"\n" +
                        "[resource] = \"%s\"\n", protocol, server, resource);
    }
}
