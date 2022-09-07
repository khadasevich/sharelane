package apitests.httpclient;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class DataModel {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
