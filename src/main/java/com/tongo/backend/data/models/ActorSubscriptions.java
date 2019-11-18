package pozoriste;

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
@Table(name = "ActorSubscriptions")


public class ActorSubscriptions {

    int useActorID;
    int userID;
    int actorID;

}
