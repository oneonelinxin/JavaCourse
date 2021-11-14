package okhttp;

import okhttp3.*;

import java.io.IOException;

public class OKHttp {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        //RequestBody body = RequestBody.create(mediaType, "123");
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8808/test")
                .method("GET",null)
                .addHeader("X-HW-APPKEY", "0djsA128djKll5jd8AprjL6==")
                .addHeader("Authorization", "Barer rykdskDFJ212554JDFHNHHKFJNNJdsdsu==")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String string = response.body().string();
        System.out.println(string);
    }

}
