package Entities;

import org.codehaus.jackson.annotate.JsonProperty;

public class produit {
	@Override
	public String toString() {
		return "produit [code=" + code + ", libelle=" + libelle + ", prix=" + prix + ", quantiteStock=" + quantiteStock
				+ ", Id categorie=" +  id_categorie+ "]";
	}
	private int code;
	private String libelle;
	private double prix;
	private int quantiteStock;
	 //@JsonProperty("id_categorie")
	private int  id_categorie;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public produit() {
		super();
	}

	
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	public int getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantiteStock(int quantiteStock) {
		this.quantiteStock = quantiteStock;
	}

	
}
