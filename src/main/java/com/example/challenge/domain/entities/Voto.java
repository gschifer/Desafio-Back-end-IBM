package com.example.challenge.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "votos")
public class Voto implements Serializable {

    private static final long serialVersionUID = 1;

    @ApiModelProperty(example = "1", position = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ApiModelProperty(example = "Sim", position = 5, required = true)
    @NotBlank
    @Column(name = "descricao_voto", nullable = false)
    private String descricaoVoto;

    @ManyToOne
    private Associado associado;

    @JsonIgnore
    @ManyToOne
    private Pauta pauta;
}
