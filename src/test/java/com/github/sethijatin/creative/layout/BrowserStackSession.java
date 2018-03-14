package com.github.sethijatin.creative.layout;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class BrowserStackSession {

    private String urlPrefix;
    private OkHttpClient client;

    public BrowserStackSession(String username, String key){
        this.urlPrefix = "https://" + username + ":" + key + "@";
        this.client = new OkHttpClient();
    }

    public String getSessionsInBuild(String buildId) throws Exception{

        String url = "api.browserstack.com/automate/builds/" + buildId + "/sessions.json";

        Request request = new Request.Builder()
                              .url(urlPrefix + url)
                              .build();

        return client.newCall(request).execute().body().string();
    }

    public String getSession(String sessionId) throws Exception{

        String url = "api.browserstack.com/automate/sessions/" + sessionId + "/.json";

        Request request = new Request.Builder()
                .url(urlPrefix + url)
                .build();

        return client.newCall(request).execute().body().string();
    }

    public String getSessionLogs(String buildId, String sessionId) throws Exception{

        String url = "api.browserstack.com/automate/builds/" + buildId + "/sessions/" + sessionId + "/logs";

        Request request = new Request.Builder()
                .url(urlPrefix + url)
                .build();

        return client.newCall(request).execute().body().string();
    }

    public String getNetworkLogs(String buildId, String sessionId) throws Exception{

        String url = "api.browserstack.com/automate/builds/" + buildId + "/sessions/" + sessionId + "/networklogs";

        Request request = new Request.Builder()
                .url(urlPrefix + url)
                .build();

        return client.newCall(request).execute().body().string();
    }

    public String getConsoleLogs(String buildId, String sessionId) throws Exception{

        String url = "api.browserstack.com/automate/builds/" + buildId + "/sessions/" + sessionId + "/consolelogs";

        Request request = new Request.Builder()
                .url(urlPrefix + url)
                .build();

        return client.newCall(request).execute().body().string();
    }

    public String markSessionPassed(String sessionId) throws Exception{

        String url = "api.browserstack.com/automate/sessions/" + sessionId + ".json";

        String jsonBody = "{\"status\":\"passed\", \"reason\":\"Acceptance Criteria Met.\"}";

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, jsonBody);

        Request request = new Request.Builder()
                .url(url)
                .put(requestBody)
                .build();

        return client.newCall(request).execute().body().string();
    }

    public String markSessionFailed(String sessionId, String reason) throws Exception{

        String url = "api.browserstack.com/automate/sessions/" + sessionId + ".json";

        String jsonBody = "{\"status\":\"failed\", \"reason\":\"" + reason + "\"}";

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, jsonBody);

        Request request = new Request.Builder()
                .url(url)
                .put(requestBody)
                .build();

        return client.newCall(request).execute().body().string();
    }

    public String removeSession(String sessionId) throws Exception{

        String url = "api.browserstack.com/automate/sessions/" + sessionId + ".json";

        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();

        return client.newCall(request).execute().body().string();
    }

    public String removeNetworkLogs(String buildId, String sessionId) throws Exception{

        String url = "api.browserstack.com/automate/builds/" + buildId + "/sessions/" + sessionId + "/networklogs";

        Request request = new Request.Builder()
                .url(urlPrefix + url)
                .delete()
                .build();

        return client.newCall(request).execute().body().string();
    }

}
