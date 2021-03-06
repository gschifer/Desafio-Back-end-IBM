package com.example.challenge.api.openapi.controller;

import com.example.challenge.api.dto.AssociadoDTO;
import com.example.challenge.api.dto.VotoDTO;
import com.example.challenge.api.exceptionHandler.Problem;
import com.example.challenge.api.request.AssociadoRequest;
import com.example.challenge.api.request.VotoRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "Associados")
public interface AssociadoControllerOpenApi {

    @ApiOperation("Lista todos os associados cadastrados.")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Não há associados cadastrados no momento.", response = Problem.class)
    })
    ResponseEntity<List<AssociadoDTO>> getAssociados();


    @ApiOperation("Busca o associado desejado pelo ID informado.")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Associado não encontrado.", response = Problem.class)
    })
    ResponseEntity<AssociadoDTO> getAssociado(@ApiParam(value = "ID do associado", example = "1", required = true)
                                                      Long associadoId);


    @ApiOperation("Cadastra um novo associado.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Associado criado com sucesso.")
    })
    ResponseEntity<AssociadoDTO> salvaAssociado(@ApiParam(name = "Corpo de requisição",
            value = "Representação de um novo associado", required = true) AssociadoRequest associadoRequest);


    @ApiOperation("Cadastra o voto do associado para a pauta especificada.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Voto criado com sucesso.")
    })
    ResponseEntity<VotoDTO> votaEmUmaPauta(@ApiParam(name = "Corpo de requisição", value = "Representação de um novo voto", required = true) VotoRequest votoRequest,
                                           @ApiParam(value = "ID do associado", required = true) Long associadoId,
                                           @ApiParam(value = "ID da pauta", required = true) Long pautaId);


    @ApiOperation("Deleta um associado pelo ID informado.")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Associado excluído"),
            @ApiResponse(code = 404, message = "Associado não encontrado", response = Problem.class)
    })
    ResponseEntity<?> deleteAssociado(@ApiParam(value = "ID do associado", required = true) Long associadoId);


    @ApiOperation("Atualiza os dados do associado pelo ID informado.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Associado atualizado"),
            @ApiResponse(code = 404, message = "Associado não encontrado", response = Problem.class)
    })
    ResponseEntity<AssociadoDTO> updateAssociado(@ApiParam(value = "ID do associado", required = true) Long associadoId,
                                                 @ApiParam(name = "Corpo de requisição", value = "Representação de um " +
                                                         "associado com dados atualizados", required = true) AssociadoRequest associadoRequest);

}
