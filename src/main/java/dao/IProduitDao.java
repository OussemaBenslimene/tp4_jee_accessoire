package dao;
import java.util.List;

import metier.entities.Accessoire;
public interface IProduitDao {
public Accessoire save(Accessoire p);
public List<Accessoire> produitsParMC(String mc);
public Accessoire getProduit(Long id);
public Accessoire updateProduit(Accessoire p);
public void deleteProduit(Long id);
}