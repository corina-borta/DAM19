package org.scrum.restaurant.repo;

import org.scrum.restaurant.meniu.Bauturi;
import org.scrum.restaurant.meniu.Preparat;
import org.scrum.restaurant.meniu.TipPreparat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreparateRepository extends JpaRepository<Preparat, Integer> {

     List<Preparat> findByPretGreaterThanEqual(double pret);
     List<Preparat> findByTipPreparat(TipPreparat tipPreparat);
     List<Preparat> findByIngredienteContaining(String ingrediente);
     List<Preparat> findByMeniuIdMeniu(Integer idMeniu);// gasirea preparatului care apartine unui anumit meniu
     List<Preparat> findByNume(String nume);

     List<Bauturi> findByVolum(double volum);

     List<Bauturi> findByAlcoolic(boolean alcoolic);
}
