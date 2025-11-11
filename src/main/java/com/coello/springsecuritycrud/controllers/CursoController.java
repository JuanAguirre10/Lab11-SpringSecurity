package com.coello.springsecuritycrud.controllers;

import com.coello.springsecuritycrud.entities.Curso;
import com.coello.springsecuritycrud.services.ICursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("curso")
public class CursoController {

    @Autowired
    private ICursoService cursoService;

    @GetMapping({"/", "/listar"})
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Cursos");
        model.addAttribute("cursos", cursoService.findAll());
        return "listar";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/form")
    public String crear(Model model) {
        Curso curso = new Curso();
        model.addAttribute("curso", curso);
        model.addAttribute("titulo", "Crear Curso");
        return "form";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/form/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes flash) {
        Curso curso = null;

        if (id > 0) {
            curso = cursoService.findById(id);
            if (curso == null) {
                flash.addFlashAttribute("error", "El ID del curso no existe en la base de datos");
                return "redirect:/listar";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del curso no puede ser cero");
            return "redirect:/listar";
        }

        model.addAttribute("curso", curso);
        model.addAttribute("titulo", "Editar Curso");
        return "form";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/form")
    public String guardar(@Valid Curso curso, BindingResult result, Model model,
                          RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Curso");
            return "form";
        }

        String mensaje = (curso.getId() != null) ? "Curso editado con éxito" : "Curso creado con éxito";

        cursoService.save(curso);
        status.setComplete();
        flash.addFlashAttribute("success", mensaje);
        return "redirect:/listar";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes flash) {

        if (id > 0) {
            cursoService.delete(id);
            flash.addFlashAttribute("success", "Curso eliminado con éxito");
        }

        return "redirect:/listar";
    }

}