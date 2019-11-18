import liquibase.change.DatabaseChange;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "Characters")
public class Characters {

    private int CharacterID;
    private int PlayID;
    private int ActorID;
    private String name;

    public Characters(String name) {
        this.name = name;
    }

}