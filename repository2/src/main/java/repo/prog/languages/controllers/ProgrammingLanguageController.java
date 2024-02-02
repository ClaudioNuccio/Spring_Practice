package repo.prog.languages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repo.prog.languages.entities.ProgrammingLanguage;
import repo.prog.languages.repositories.ProgrammingLanguageRepository;

@RestController
@RequestMapping("/v1")
public class ProgrammingLanguageController {
@Autowired
ProgrammingLanguageRepository programmingLanguageRepository;
    @PostMapping(path = "/create")
    public ProgrammingLanguage create (@RequestBody ProgrammingLanguage programmingLanguage){
       return programmingLanguageRepository.saveAndFlush(programmingLanguage);
    }
    @PatchMapping (path = "/patch/{id}")
    public ProgrammingLanguage patch (@PathVariable Long id ,@RequestBody ProgrammingLanguage programmingLanguage){
        return programmingLanguageRepository.saveAndFlush(programmingLanguage);
    }
}
