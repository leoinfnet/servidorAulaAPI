package br.com.infnet.server;

import br.com.infnet.server.model.Jogador;
import br.com.infnet.server.model.StatusPartida;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {
    @GetMapping("/umJogador")
    public ResponseEntity getjogador(){
        List<StatusPartida> list = Arrays.asList(StatusPartida.DERROTA, StatusPartida.VITORIA, StatusPartida.HUMILHACAO);
        Jogador lGloria = Jogador.builder().nickname("LGloria").pontos(13300)
                .ultimasPartidas(list)
                .build();
        return ResponseEntity.ok(lGloria);
    }
    @GetMapping("/variosJogadores")
    public ResponseEntity getjogadores(){
        List<StatusPartida> list = Arrays.asList(StatusPartida.DERROTA, StatusPartida.VITORIA, StatusPartida.HUMILHACAO);
        Jogador lGloria = Jogador.builder().nickname("LGloria").pontos(13300)
              .ultimasPartidas(list)
                .build();
        Jogador joaoPedro = Jogador.builder().nickname("pedro").pontos(13300)
               .ultimasPartidas(list)
                .build();
        Jogador marcio = Jogador.builder().nickname("marcio").pontos(13300)
               .ultimasPartidas(list)
                .build();
        List<Jogador> lGloria1 = List.of(lGloria, joaoPedro, marcio);
        return ResponseEntity.ok(lGloria1);
       // .timeout(Duration.of(10, SECONDS))
    }
}
