package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.domain.FlorEntity;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.dto.FlorDTO;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.services.FlorService;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.services.impl.FlorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9001")
@RestController
@RequestMapping("/flor/v1")
public class FlorController {
    private FlorService florService;

    public FlorController(FlorService florService){
        this.florService = florService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> createFlor(@Valid @RequestBody FlorEntity flor){
        florService.addFlor(flor);
        return new ResponseEntity<>("Flower successfully created", HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFlor(@PathVariable("id") Integer id, @Valid @RequestBody FlorEntity flor){
        FlorEntity _flor = florService.getOneFlor(id);
        _flor.setNomFlor(flor.getNomFlor());
        _flor.setPaisFlor(flor.getPaisFlor());
        florService.updateFlor(_flor);
        return new ResponseEntity<>("FlorEntity successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlorEntity(@PathVariable("id") Integer id){
        florService.deleteFlor(id);
        return new ResponseEntity<>("FlorEntity successfully deleted", HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDTO> getOne(@PathVariable("id") Integer id){
        FlorEntity flor = florService.getOneFlor(id);
        FlorDTO florDTO = florService.florEntityToDTO(flor);
        return new ResponseEntity<>(florDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDTO>> getAll(){
        List<FlorDTO> flors = florService.getAllFlor();
        return new ResponseEntity<>(flors, HttpStatus.OK);
    }
}
