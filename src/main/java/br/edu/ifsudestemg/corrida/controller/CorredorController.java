package br.edu.ifsudestemg.corrida.controller;

import br.edu.ifsudestemg.corrida.model.Corredor;
import br.edu.ifsudestemg.corrida.repository.CorredorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/corredor")
public class CorredorController {
    @Autowired
    private CorredorRepository corredorRepository;

    @GetMapping
    public String corredores(Model model) {
        model.addAttribute("corredores", corredorRepository.findAll());
        return "corredor/corredores";
    }

    @GetMapping(value = "/add") // site.com/corredor/add
    public String displayCorredorForm() {
        return "corredor/add";
    }

    @PostMapping(value = "/add")
    public String processCorredorForm(@RequestBody Corredor corredor) {
        corredorRepository.save(corredor);
        return "redirect:";
    }

    @GetMapping(value = "/edit/{id}/{cpf}") // site.com/corredor/edit/1/
    public String corredorEdit(Model model, @PathVariable Long id, @PathVariable String cpf) {
        Corredor corredor = corredorRepository.findByIdAndCpf(id, cpf);
        model.addAttribute("title", "Editar corredor");
        model.addAttribute("corredor", corredor);
        return "corredor/edit";
    }

    @PutMapping(value = "/edit/{id}/{cpf}") // site.com/corredor/edit/1/
    public String edit(@RequestBody Corredor corredor, Model model,
                       @PathVariable String cpf, @PathVariable Long id) throws Exception {
        if (corredor.getCpf().equals(cpf) && id.equals(corredor.getId())) {
            corredorRepository.save(corredor);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:";
    }

    @GetMapping(value = "/delete/{id}") // site.com/corredor/delete/1
    public String corredorDelete(Model model, @PathVariable Long id) {
        Optional<Corredor> corredor = corredorRepository.findById(id);
        if (corredor.isPresent()) {
            model.addAttribute("corredor", corredor.get());
        }
        model.addAttribute("tittle", "Excluir corredor");
        return "corredor/delete";
    }

    @DeleteMapping(value = "/delete/{id}") // site.com/corredor/delete/1
    public String delete(@PathVariable Long id, @RequestBody Corredor corredor) {
        corredorRepository.delete(corredor);
        return "redirect:";
    }
}
