 Nackage pozoriste;

import liquibase.change.DatabaseChange;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "Actors")
public class Actors {

    private int actorID;
    private String fname;
    private String lname;
    private Date dob;
    private String bio;

    public Actors(String fname, String lname, Date dob, String bio) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.bio = bio;
    }
}
