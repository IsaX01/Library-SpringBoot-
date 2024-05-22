package packageName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private EntityId id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String address;
    private Integer user_type_id;
    private String profile_picture;
    private String status;
    
    public Users() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}