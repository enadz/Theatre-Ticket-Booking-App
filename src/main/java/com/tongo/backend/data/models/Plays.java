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
@Table(name = "Plays")

public class Plays{

    private int PlayID;
    private String play_name;
    private String description;
    private Date premier_date;


    public Plays(String name, String description, Date date) {
        this.play_name = name;
        this.description = description;
        this.premier_date = date;

    }

}