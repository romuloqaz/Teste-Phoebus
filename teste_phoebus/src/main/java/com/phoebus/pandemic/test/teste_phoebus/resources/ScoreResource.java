package com.phoebus.pandemic.test.teste_phoebus.resources;

import com.phoebus.pandemic.test.teste_phoebus.domain.Score;
import com.phoebus.pandemic.test.teste_phoebus.services.ScoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/pontos")
public class ScoreResource {

    @Autowired
    private ScoreService service;

    @ApiOperation(value="lista pontuação maxima de recursos")
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Score>> findAll() {
        List<Score> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value="atualiza pontuação maxima de recursos")
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody Score obj, @PathVariable Integer id){
        obj.setId(id);
        obj = service.update(obj.getId(), obj.getPoints());
        return ResponseEntity.noContent().build();
    }


}