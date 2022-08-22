package models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class NewAccountModel {

    private String accountName;
    private String phone;
    private String type;
}
