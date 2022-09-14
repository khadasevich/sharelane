package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentModel {

    private String id;
    private String name;
    private String groupId;
}
