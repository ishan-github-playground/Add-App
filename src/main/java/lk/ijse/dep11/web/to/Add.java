package lk.ijse.dep11.web.to;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Add implements Serializable {
    private String name;
    private String description;
    private String price;
    private String pictureUrl;

}
