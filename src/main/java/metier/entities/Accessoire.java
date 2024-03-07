package metier.entities;
import java.io.Serializable;
public class Accessoire implements Serializable{
private Long idProduit;
private String nomProduit;
private String Categorie;
private double prix;
public Accessoire() {
super();
}

public Accessoire(String nomProduit, String categorie, double prix) {
	super();
	this.nomProduit = nomProduit;
	Categorie = categorie;
	this.prix = prix;
}

public Long getIdProduit() {
	return idProduit;
}
public void setIdProduit(Long idProduit) {
	this.idProduit = idProduit;
}
public String getNomProduit() {
	return nomProduit;
}
public void setNomProduit(String nomProduit) {
	this.nomProduit = nomProduit;
}
public String getCategorie() {
	return Categorie;
}
public void setCategorie(String categorie) {
	Categorie = categorie;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}

}