package Test;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import Entities.categorie;
import Entities.produit;

import com.sun.jersey.api.client.ClientResponse;

public class ClientMain {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        // TODO Auto-generated method stub
        Client c = Client.create(new DefaultClientConfig());
        URI uri = UriBuilder.fromUri("http://localhost:8080/BackEndStock/").build();
        ObjectMapper mapper = new ObjectMapper();

        // Add a category
        categorie Categorie1 = new categorie();
        Categorie1.setId_categorie(1);
        Categorie1.setNom("Informatique");
        Categorie1.setDescription("des outils d'informatiques:Ordinateurs,...");
        // Convertir l'objet Categorie en JSON
        String categorieJson1 = mapper.writeValueAsString(Categorie1);
        ClientResponse respenseAddCategorie1 = c.resource(uri).path("api").path("/add").type("application/json")
                .post(ClientResponse.class, categorieJson1);
        categorie Categorie2 = new categorie();
        Categorie2.setId_categorie(2);
        Categorie2.setNom("Sport");
        Categorie2.setDescription("tous les types de sport:natation,...");
        String categorieJson2 = mapper.writeValueAsString(Categorie2);
        ClientResponse respenseAddCategorie2 = c.resource(uri).path("api").path("/add").type("application/json")
                .post(ClientResponse.class, categorieJson2);

        
        
        
        // update a category
        categorie UpdateCategorie2 = new categorie();
        UpdateCategorie2.setNom("Sport");
        UpdateCategorie2.setDescription("tous les types de sport:gymnastique,...");
        String UpdatecategorieJson = mapper.writeValueAsString(UpdateCategorie2);
        ClientResponse respenseUpdateCategorie2 = c.resource(uri).path("api").path("/updateCategory/2")
                .type("application/json").put(ClientResponse.class, UpdatecategorieJson);

       
        
        
        
        // Get All Categories
        System.out.println("Liste des catégories:");
        ClientResponse respenseCategorie = c.resource(uri).path("api").path("/categories").get(ClientResponse.class);
        String GetAllCategories = respenseCategorie.getEntity(String.class);

        categorie[] tabCat = mapper.readValue(GetAllCategories, categorie[].class);
        for (categorie cat : tabCat) {
            System.out.println(cat.toString());
        }

        
        
        
        
        // add a product
        produit produit1 = new produit();
        produit1.setCode(120);
        produit1.setLibelle("Pc Dell");
        produit1.setPrix(3000.0);
        produit1.setQuantiteStock(55);
        produit1.setId_categorie(1);
        String produitJson1 = mapper.writeValueAsString(produit1);
        ClientResponse respenseAddProduit1 = c.resource(uri).path("api").path("/addProduct").type("application/json")
                .post(ClientResponse.class, produitJson1);
        produit produit2 = new produit();
        produit2.setCode(150);
        produit2.setLibelle("équipements gymnastiques");
        produit2.setPrix(130.0);
        produit2.setQuantiteStock(60);
        produit2.setId_categorie(2);
        String produitJson2 = mapper.writeValueAsString(produit2);
        ClientResponse respenseAddProduit2 = c.resource(uri).path("api").path("/addProduct").type("application/json")
                .post(ClientResponse.class, produitJson2);
        produit produit3 = new produit();
        produit3.setCode(160);
        produit3.setLibelle("équipements natation");
        produit3.setPrix(145.0);
        produit3.setQuantiteStock(100);
        produit3.setId_categorie(2);
        String produitJson3 = mapper.writeValueAsString(produit3);
        ClientResponse respenseAddProduit3 = c.resource(uri).path("api").path("/addProduct").type("application/json")
                .post(ClientResponse.class, produitJson3);
//update product
        produit UpdateProduct = new produit();
        UpdateProduct.setLibelle("équipements gymnastiques");
        UpdateProduct.setQuantiteStock(170);
        UpdateProduct.setPrix(120.0);
        String UpdateProductJson = mapper.writeValueAsString(UpdateProduct);
        ClientResponse responseUpdateProduct = c.resource(uri).path("api").path("/updateProduct/150")
                .type("application/json").put(ClientResponse.class, UpdateProductJson);

        
        
        
        // Get All Products
        System.out.println("Liste des produits");
        ClientResponse respenseProduit = c.resource(uri).path("api").path("/produits").get(ClientResponse.class);
        String GetAllProducts = respenseProduit.getEntity(String.class);
        produit[] tabProd = mapper.readValue(GetAllProducts, produit[].class);
        for (produit p : tabProd) {
            System.out.println(p.toString());
        }
        
        
        
        // delete a product
        ClientResponse respenseDeleteProduct = c.resource(uri).path("api").path("/deleteProduct/160")
                .delete(ClientResponse.class);

        
        
        //get products by category
        System.out.println("Liste des produits par categorie");
        ClientResponse respenseProduitByCategorie = c.resource(uri).path("api").path("/produitsCategory/2")
                .get(ClientResponse.class);
        String GetProductsByCategorie = respenseProduitByCategorie.getEntity(String.class);

        produit[] TabProduits = mapper.readValue(GetProductsByCategorie, produit[].class);
        for (produit p : TabProduits) {
            System.out.println(p.toString());
        }
    }
}
