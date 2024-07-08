package com.br.gabproject.simpleproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "Home", description = "Tutorial management APIs")
@RestController
@RequestMapping()
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/about")
    public String about() {
        return "{\n" + //
                "    \"nome\": \"TechConsult\",\n" + //
                "    \"descrição\": \"TechConsult é uma empresa de consultoria de informática especializada em fornecer soluções personalizadas para empresas de todos os tamanhos. Nossa equipe altamente qualificada e experiente está comprometida em oferecer serviços de consultoria de alta qualidade para atender às necessidades específicas de nossos clientes.\",\n"
                + //
                "    \"objetivo_equipe\": \"Nosso objetivo é fornecer consultoria especializada em tecnologia da informação para ajudar as empresas a otimizar suas operações, implementar soluções inovadoras e alcançar seus objetivos de negócios com eficiência e eficácia.\"\n"
                + //
                "}";
    }
}
