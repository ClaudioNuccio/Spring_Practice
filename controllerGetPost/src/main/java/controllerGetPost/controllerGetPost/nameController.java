package controllerGetPost.controllerGetPost;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/")
    public class nameController {
    @GetMapping(path ="getname")
    public String getName (@RequestParam String name){
        return name;
    }
    @PostMapping(path ="createreversedname")
    public StringBuilder postName (@RequestParam String name){
        StringBuilder invertedName = new StringBuilder(name);
        return  invertedName.reverse();
    }
}
