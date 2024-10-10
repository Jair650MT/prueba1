package com.example.validacion.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.validacion.model.Persona;

import jakarta.validation.Valid;

@Controller
public class PersonaController {
	@GetMapping("/registrar")
    public String mostrarFormulario(Model model){
        Persona persona = new Persona();
        model.addAttribute("persona",persona);
        List<String> listaProfesiones = Arrays.asList("Programador","Tester","Arquitecto");
        model.addAttribute("profesiones",listaProfesiones);
        return "registrar_form";
    }
    @PostMapping("/registrar")
    public String submitFormulario(@Valid @ModelAttribute Persona persona, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            List<String> listaProfesiones = Arrays.asList("Programador", "Tester", "Arquitecto");
            model.addAttribute("profesiones",listaProfesiones);
            return "registrar_form";
        }else{
            return "registro_success";
        }
    }	
}
