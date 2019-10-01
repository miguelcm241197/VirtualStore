package pe.isil.isilweb.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    private String codCli;
    private String name;
    private String lastNameFather;
    private String lastNameMother;
    private String email;
    private String place;
    private String phone;
}
