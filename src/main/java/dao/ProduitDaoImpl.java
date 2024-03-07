package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.SingletonConnection;
import metier.entities.Accessoire;
public class ProduitDaoImpl implements IProduitDao {
@Override
public Accessoire save(Accessoire p) {
Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("INSERT INTO accessoire (NOM_PRODUIT,PRIX,CATEGORIE) VALUES(?,?,?)");
ps.setString(1, p.getNomProduit());
ps.setDouble(2, p.getPrix());
ps.setString(3, p.getCategorie());

ps.executeUpdate();
PreparedStatement ps2= conn.prepareStatement
("SELECT MAX(ID_PRODUIT) as MAX_ID FROM accessoire");
ResultSet rs =ps2.executeQuery();
if (rs.next()) {
p.setIdProduit(rs.getLong("MAX_ID"));
}
ps.close();
ps2.close();
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
@Override
public List<Accessoire> produitsParMC(String mc) {
 List<Accessoire> prods= new ArrayList<Accessoire>();
 Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("select * from accessoire where NOM_PRODUIT LIKE ?");
ps.setString(1, "%"+mc+"%");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
Accessoire p = new Accessoire();
p.setIdProduit(rs.getLong("ID_PRODUIT"));
p.setNomProduit(rs.getString("NOM_PRODUIT"));
p.setPrix(rs.getDouble("PRIX"));
p.setCategorie(rs.getString("CATEGORIE"));
prods.add(p);
}
} catch (SQLException e) {
e.printStackTrace();
}
return prods;
}


@Override
public Accessoire getProduit(Long id) {

 Connection conn=SingletonConnection.getConnection();
 Accessoire p = new Accessoire();
 try {
PreparedStatement ps= conn.prepareStatement("select * from accessoire where ID = ?");
ps.setLong(1, id);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
p.setIdProduit(rs.getLong("ID_PRODUIT"));
p.setNomProduit(rs.getString("NOM_PRODUIT"));
p.setCategorie(rs.getString("CATEGORIE"));
p.setPrix(rs.getDouble("PRIX"));
}
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
@Override
public Accessoire updateProduit(Accessoire p) {
Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("UPDATE accessoire SET NOM_PRODUIT=?,PRIX=? CATEGORIE=? WHERE ID=?");
ps.setString(1, p.getNomProduit());
ps.setDouble(2, p.getPrix());
ps.setString(3, p.getCategorie());
ps.setLong(4, p.getIdProduit());
ps.executeUpdate();
ps.close();
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
@Override
public void deleteProduit(Long id) {
Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("DELETE FROM accessoire WHERE ID = ?");
ps.setLong(1, id);
ps.executeUpdate();
ps.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
}