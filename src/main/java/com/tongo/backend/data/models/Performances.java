import liquibase.change.DatabaseChange;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.joda.DateTimeParser;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.DateTimeException;
import java.util.Date;


@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "Performances")

public class Performances{

    private int PerformanceID;
    private int PlayID;
    private Date datetime;
    private int numOfTickets;
    private int ticketPrice;

    public Performances(Date datetime, int numOfTickets, int ticketPrice) {
        this.datetime = datetime;
        this.numOfTickets=numOfTickets;
        this.ticketPrice=ticketPrice;
    }
}