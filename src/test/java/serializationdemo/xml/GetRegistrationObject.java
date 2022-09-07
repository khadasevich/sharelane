package serializationdemo.xml;

public class GetRegistrationObject {

    public static RegistrationXmlModel getModelForXml() {
        return RegistrationXmlModel
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
