package cl.easy.app.controller;

import cl.easy.app.model.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RequestController {
    private String link1 = "https://reqres.in/api/users?page=1";
    private String link2 = "https://reqres.in/api/users?page=2";
    private ArrayList<String> links = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public RequestController() throws JsonProcessingException {
        System.out.println("Constructor...");
        links.add(link1);
        links.add(link2);

        for (String link : links) {
            System.out.println("Visiting "+ link);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response
                    = restTemplate.getForEntity(link, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode name = root.path("data");

            for (JsonNode j : name) {
                System.out.println(j);
                Usuario usuario = mapper.readValue(j.toString(), Usuario.class);
                usuarios.add(usuario);
            }
        }
    }

    //Método GET que liste todos los usuarios que existen en el API externa.
    @GetMapping("/listarUsuarios")
    public ArrayList<Usuario> listarUsuarios() throws JsonProcessingException {
        System.out.println("GET MAPPING");
        return usuarios;
    }

    // Método POST que permita buscar datos de un usuario por ID y por nombre.
    @PostMapping("/buscarUsuario")
    public List<Usuario> buscarUsuario(@RequestBody Usuario usuario){
        System.out.println("POST MAPPING "+usuario.toString());
        return  usuarios.stream().filter( f ->  f.getFirst_name().contains(usuario.getFirst_name()) && f.getId() == usuario.getId() ).collect(Collectors.toList());
    }
}
