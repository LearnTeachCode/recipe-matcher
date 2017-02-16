package devApp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
public class UserWithIdentity {
    public int id;
    public List<ItemWithIdentity> userItems;
}