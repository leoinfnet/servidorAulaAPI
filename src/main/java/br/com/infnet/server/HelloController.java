package br.com.infnet.server;

import br.com.infnet.server.model.Jogador;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private static final  Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/paraleloSucesso")
    public ResponseEntity executaAlgoEmParalelo(){
        return ResponseEntity.ok().build();
    }
    @GetMapping("/paraleloErro")
    public ResponseEntity executaAlgoEmParaleloComErro(){

        return ResponseEntity.internalServerError().body(Map.of("message", "Erro Esquisito"));
    }
    @GetMapping("/paraleloSucessoMsg")
    public ResponseEntity executaAlgoEmParaleloSucessoMessage(){
        return ResponseEntity.ok(Map.of("message", "sucesso"));
    }
    @PostMapping("/recebendo")
    public ResponseEntity recebendoPost(@RequestBody Jogador jogador){
        LOGGER.info("Jogador: " + jogador);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/query")
    public ResponseEntity recebendoQueryString(@RequestParam(required = true) int size){
        LOGGER.info("param: " + size);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/lista")
    public ResponseEntity getLista(@RequestParam(required = false, defaultValue = "5") int size){
        LOGGER.info("param: " + size);
        List<String> nomes = List.of("Leonardo", "Joao", "Pedro", "Jose", "Carlos");
        List<String> sublist = nomes.subList(0, size);
        LOGGER.info("Size da Lista: " + size);
        return ResponseEntity.ok(sublist);
    }
    @GetMapping("/lento")
    public ResponseEntity lento(){
        LOGGER.info("Iniciado");
        LOGGER.info("Durmindo");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException ignore) {}
        return ResponseEntity.ok().build();
    }




}
