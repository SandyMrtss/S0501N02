package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.repository;

import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.domain.FlorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<FlorEntity, Integer> {
}
