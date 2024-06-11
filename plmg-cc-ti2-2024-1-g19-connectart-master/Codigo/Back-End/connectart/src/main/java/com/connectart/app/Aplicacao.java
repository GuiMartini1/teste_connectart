package com.connectart.app;



import static spark.Spark.*;
import com.connectart.service.ArtistaService;
import com.connectart.service.ClienteService;

public class Aplicacao {
    public static ClienteService clienteService = new ClienteService();
    public static ArtistaService artistaService = new ArtistaService();
    public static void main(String[] args) {
        port(4567);
        // Configurar CORS
        enableCORS("*", "*", "*");

        System.out.println("Servidor rodando em http://localhost:4567");
        //caminho para enviar informaçoes do cliente e artista do js no formato json para criacao de clientes e artistas
        post("/cliente", (req, res) -> clienteService.cadastrarCliente(req, res));
        post("/artista", (req, res) -> artistaService.cadastrarArtista(req, res));

        //caminho para enviar informaçoes do login do cliente e artista do js no formato json
        put("/login/cliente", (req, res) -> clienteService.loginCliente(req, res));
        put("/login/artista", (req, res) -> artistaService.loginArtista(req, res));

        //caminho para deletar cliente e artista
        delete("/deletar/cliente", (request, response) -> clienteService.excluirCliente(request, response));
        delete("/deletar/artista", (req, res) -> artistaService.excluirArtista(req,res));
}


// Método para configurar CORS
private static void enableCORS(final String origin, final String methods, final String headers) {
    options("/*", (request, response) -> {
        String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
        if (accessControlRequestHeaders != null) {
            response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
        }

        String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
        if (accessControlRequestMethod != null) {
            response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
        }

        return "OK";
    });

    before((request, response) -> {
        response.header("Access-Control-Allow-Origin", origin);
        response.header("Access-Control-Request-Method", methods);
        response.header("Access-Control-Allow-Headers", headers);
        // Note: this may or may not be necessary in your particular application
        response.type("application/json");
    });
}
}

