package dao;
import java.util.List;

import metier.entities.Accessoire;
public class TestDao {
public static void main(String[] args) {
ProduitDaoImpl pdao= new ProduitDaoImpl();
Accessoire prod= pdao.save(new Accessoire("jbl m2","haut-parleur",2800));
System.out.println(prod);
List<Accessoire> prods =pdao.produitsParMC("HP");
for (Accessoire p : prods)
System.out.println(p);
}
}