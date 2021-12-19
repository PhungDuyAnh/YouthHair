package poly.datn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="lienHeTK")
public class LienHeTK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "monthYear")
    private String monthYear;

    @Column(name= "Phone")
    private String phone;

}
