package serializationdemo.json;

public class GetRegistrationObject {

    public static RegistrationJsonModel getModelForJson() {
        return RegistrationJsonModel
                .builder()
                .zipCode("12345")
                .firstName("Alex")
                .lastName("Khad")
                .email("alex@gmail.com")
                .password("string@1")
                .confirmPassword("string@1")
                .build();
    }
}
