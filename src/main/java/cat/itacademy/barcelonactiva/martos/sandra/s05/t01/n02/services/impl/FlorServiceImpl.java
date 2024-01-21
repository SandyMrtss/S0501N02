package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.services.impl;

import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.domain.FlorEntity;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.dto.FlorDTO;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.repository.FlorRepository;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.services.FlorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlorServiceImpl implements FlorService {

    private FlorRepository florRepository;

    public FlorServiceImpl(FlorRepository florRepository){
        this.florRepository = florRepository;
    }
    @Override
    public void addFlor(FlorEntity florEntity) {
        florRepository.save(florEntity);
    }

    @Override
    public void updateFlor(FlorEntity florEntity) {
        florRepository.save(florEntity);
    }

    @Override
    public void deleteFlor(Integer id) {
        Optional<FlorEntity> flor = florRepository.findById(id);
        if(flor.isPresent()){
            florRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public FlorDTO getOneFlor(Integer id) {
        Optional<FlorEntity> flor = florRepository.findById(id);
        if(flor.isPresent()){
            return florEntityToDTO(flor.get());
        }
        else {
            throw new EntityNotFoundException();
        }    }

    @Override
    public FlorDTO florEntityToDTO(FlorEntity florEntity) {
        return new FlorDTO(florEntity);
    }

    @Override
    public List<FlorDTO> getAllFlor() {
        List<FlorDTO> allFlorDTO = new ArrayList<>();
        florRepository.findAll().forEach(f-> allFlorDTO.add(florEntityToDTO(f)));
        return allFlorDTO;
    }
}
