package edu.br.infnet.tp3devops_jdbc.clima_reactiveClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ClimaController {
    @Autowired
    private ClimaService climaService;


    @GetMapping("api/clima/{id}")
    public Mono<String> obterClima(@PathVariable Long id) {
        return climaService.obterClima(id);
    }
}
