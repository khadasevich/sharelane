package apitests.httpclient;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class HTTPClientTest {

    @Test
    public void checkGetUsersResponseCodeTest() throws IOException {
        // Создание клиента
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Создание объекта Get реквеста
        HttpGet get = new HttpGet("https://reqres.in/api/users?page=2");

        // Выполнение запроса
        HttpResponse httpresponse = httpClient.execute(get);

        // Проверка статус кода
        Assert.assertEquals(httpresponse.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void checkGetUserResponseBody() throws IOException {
        // Создание клиента
        HttpClient httpClient = HttpClientBuilder.create().build();
        // Создание объекта Get реквеста
        HttpGet get = new HttpGet("https://reqres.in/api/users/2");
        // Выполнение запроса
        HttpResponse httpresponse = httpClient.execute(get);
        Gson gson = new Gson();
        //Получение Actual result из респонса
        UserModel actualUser = gson.fromJson(EntityUtils.toString(httpresponse.getEntity()), UserModel.class);
        //Получение Expected result из файла
        UserModel expectedUser = null;
        try (Reader reader = new FileReader("src/test/resources/user.json")) {
            expectedUser = gson.fromJson(reader, UserModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Проверка тела респонса
        Assert.assertEquals(actualUser, expectedUser, "Users are not equal");
    }

    @Test
    public void createNewUserTest() throws IOException {
        // Создание клиента
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Создание объекта Post реквеста
        HttpPost post = new HttpPost("https://reqres.in/api/users");

        // Подготовка Post Body запроса
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name", "John"));
        params.add(new BasicNameValuePair("job", "pass"));
        post.setEntity(new UrlEncodedFormEntity(params));

        // Выполнение запроса
        HttpResponse httpresponse = httpClient.execute(post);

        // Проверка статус кода
        Assert.assertEquals(httpresponse.getStatusLine().getStatusCode(), 201);
    }
}
