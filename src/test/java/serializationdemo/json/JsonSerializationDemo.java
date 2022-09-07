package serializationdemo.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class JsonSerializationDemo {

    @Test
    public void serializeObjectToJsonString() {
        // Создаем экземпляр класса Gson
        Gson gson = new Gson();
        // Создаем экземпляр объекта сериализации
        RegistrationJsonModel registration = GetRegistrationObject.getModelForJson();
        // Получаем Json-строку представление объекта
        String json = gson.toJson(registration);
        System.out.println(json);
    }

    @Test
    public void serializeObjectToJsonPrettyString() {
        // Создаем экземпляр класса GsonBuilder
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Создаем экземпляр объекта сериализации
        RegistrationJsonModel registration = GetRegistrationObject.getModelForJson();
        // Получаем Json-строку представление объекта
        String json = gson.toJson(registration);
        System.out.println(json);
    }

    @Test
    public void serializeObjectToJsonFile() {
        // Создаем экземпляр класса GsonBuilder
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Создаем экземпляр объекта сериализации
        RegistrationJsonModel registration = GetRegistrationObject.getModelForJson();
        // Создание JSON файла
        try (FileWriter writer = new FileWriter("src/test/resources/registration.json")) {
            gson.toJson(registration, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void serializeObjectFromJsonString() {
        // Создаем экземпляр класса GsonBuilder
        Gson gson = new Gson();
        // JSON строка
        String registration = "{\"zipCode\":\"23462\"," +
                "\"firstName\":\"Eura\"," +
                "\"lastName\":\"Halvorson\"," +
                "\"email\":\"jacque.reilly@yahoo.com\"," +
                "\"password\":\"string@43\"," +
                "\"confirmPassword\":\"string@43\"}";
        // Получаем объект из JSON
        RegistrationJsonModel registrationModel = gson.fromJson(registration, RegistrationJsonModel.class);
        System.out.println(registrationModel.toString());
    }

    @Test
    public void serializeObjectFromJsonFile() {
        // Создаем экземпляр класса GsonBuilder
        Gson gson = new Gson();
        // Получаем объект из JSON файла
        try (Reader reader = new FileReader("src/test/resources/registration.json")) {
            RegistrationJsonModel json = gson.fromJson(reader, RegistrationJsonModel.class);
            System.out.println(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
