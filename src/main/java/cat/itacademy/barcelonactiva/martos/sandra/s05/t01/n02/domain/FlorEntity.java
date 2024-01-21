package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="flors", uniqueConstraints = @UniqueConstraint(columnNames = "nomFlor"))
public class FlorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pk_FlorID;
    @Column(nullable = false)
    @Size(min = 4, max = 40, message = "{Size.Flor.nomFlor}")
    @NotBlank(message = "{NotBlank.Flor.nomFlor}")
    private String nomFlor;
    @Column(nullable = false)
    @NotBlank(message = "{NotBlank.Flor.paisFlor}")
    private String paisFlor;

    public FlorEntity() {
    }

    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNomFlor() {
        return nomFlor;
    }

    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }
}
