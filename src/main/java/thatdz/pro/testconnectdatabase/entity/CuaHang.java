package thatdz.pro.testconnectdatabase.entity;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name ="cua_hang")
public class CuaHang {
    @Column(name="ten_cua_hang")
    @NotNull
    @NotBlank(message = "this field must not blank")
    @Length(max = 200, min=5, message = "This field size 5 to 200 oke ")
    private String tenCH;

    @Column(name="dia_chi")
    @NotNull
    @NotBlank(message = "this field must not blank")
    @Length(max = 200, min=5, message = "This field size 5 to 200 oke ")
    private String diaChi;

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Override
    public String toString() {
        return id + "  "+ tenCH + " "+ diaChi;
    }
}
