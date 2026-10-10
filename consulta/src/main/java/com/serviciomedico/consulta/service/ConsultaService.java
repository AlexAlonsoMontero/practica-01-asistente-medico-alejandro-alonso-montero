package com.serviciomedico.consulta.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService implements ConsultaServiceIterface {

    private ChatClient chatClient;

    public ConsultaService(ChatClient chatClient) {
        super();
        this.chatClient = chatClient;
    }

    @Override
    public String consultaLlm(String consulta) {
        String prompt = "Explica de forma sencilla con que enfermedad puede corresponder el síntoma.";
        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
