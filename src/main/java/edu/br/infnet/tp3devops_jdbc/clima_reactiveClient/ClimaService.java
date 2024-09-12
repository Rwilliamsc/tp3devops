package edu.br.infnet.tp3devops_jdbc.clima_reactiveClient;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClimaService {

    private final WebClient webClient;


    public ClimaService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://apiadvisor.climatempo.com.br").build();
    }

    public Mono<String> obterClima(Long idCidade) {
        String apiKey = "8f244859db8203c0925f36748d4ca848";
        return webClient.get()
                .uri("/api/v1/weather/locale/{idCidade}/current?token={apiKey}", idCidade, apiKey)
                .retrieve()
                .bodyToMono(String.class);
    }
}

