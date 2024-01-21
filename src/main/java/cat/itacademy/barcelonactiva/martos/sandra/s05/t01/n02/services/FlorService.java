package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.services;

import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.domain.FlorEntity;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.dto.FlorDTO;

import java.util.List;

public interface FlorService {
    public void addFlor(FlorEntity florEntity);
    public void updateFlor(FlorEntity florEntity);
    public void deleteFlor(Integer id);
    public FlorEntity getOneFlor(Integer id);
    public FlorDTO florEntityToDTO(FlorEntity florEntity);
    public List<FlorDTO> getAllFlor();
}
