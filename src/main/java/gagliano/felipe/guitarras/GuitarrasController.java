package gagliano.felipe.guitarras;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class GuitarrasController {

    @Autowired
    GuitarrasRepository repositorio;


    //********** cria novo documento *************
    @RequestMapping (value = "/guitarras", method = RequestMethod.PUT)
    public void createNovaGuitarra(@RequestBody Guitarra guitarra){
        repositorio.save(guitarra);
    }



    //********** Recupera documento(s) *************
    // listar todos os documentos
    @GetMapping(value = "/guitarras")
    public List<Guitarra> getGuitarras(){
        List<Guitarra> guitarras = repositorio.findAll();
        return guitarras;
    }

    // selecionar ordernado pelo ranking
    @GetMapping(value = "/guitarras/ranking")
    public List<Guitarra> selectGuitarraOrderByRanking(){
    List<Guitarra> guitarras = repositorio.findAll(Sort.by(Sort.Direction.DESC,"ranking"));
        return guitarras;
    }

    // selecionar 1 documento pelo id
    @GetMapping(value = "/guitarras/id/{id}")
    public Optional<Guitarra> selectGuitarraById(@PathVariable String id){
        System.out.println(id);
        var guitarra = repositorio.findById(id);
        return guitarra;
    }

    // selecionar 1 documento pelo nome
    @GetMapping(value = "/guitarras/name/{name}")
    public Optional<Guitarra> selectGuitarraByName(@PathVariable String name){
        System.out.println(name);
        var guitarra = repositorio.findByTitle(name);
        return guitarra;
    }

    //***** update 1 documento pelo ID *********
    @PostMapping(value = "/guitarras/{id}/update")
    public void createGuitarra(@PathVariable String id, @RequestBody Guitarra guitarra){
        Guitarra guitarraAtual = new Guitarra(guitarra.getId(), guitarra.getTitle(), guitarra.getImage(), guitarra.getRanking() );
        repositorio.save(guitarraAtual);
    }

    //***** delete 1 documento pelo ID *********
    @GetMapping("/guitarras/{id}/delete")
    public void deleteGuitarra(@PathVariable String id){
        repositorio.deleteById(id);
    }
}
