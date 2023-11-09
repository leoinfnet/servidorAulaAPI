package br.com.infnet.server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Jogador {
    private String nickname;
    private double pontos;

    List<StatusPartida> ultimasPartidas;
}
