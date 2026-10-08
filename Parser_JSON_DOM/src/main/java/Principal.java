import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Principal {

	public static void main(String[] args) {
		final String FITXER_ENTRADA =  "JsonData/MenuJSON.json";
		final String FITXER_SORTIDA = "JsonData/MenuJSON_mod.json";
		
		final String CLAU_MENUS = "Menu";
		final String CLAU_DESCRIPCIO = "Descripcio";
		final String CLAU_DCODI = "codi";
		final String CLAU_DPREU= "preu";
		final String CLAU_DTEXT = "text";
		final String CLAU_TIPUS = "Tipus";
		final String CLAU_GRUP = "Grup";
		final String CLAU_GID = "id";
		final String CLAU_GDESCRIPCIO = "Descripcio";
		final String CLAU_GTIPUS = "Tipus";
		
			
		// 1) Crear parser configurat amb Pretty Print i serialització de nuls
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
			.create();
		
		try (Reader reader = new InputStreamReader(
				new FileInputStream(FITXER_ENTRADA), StandardCharsets.UTF_8)) {
			
			// 2) Llegir el fitxer i convertir-lo en un arbre JSON
            JsonObject arrel = JsonParser.parseReader(reader).getAsJsonObject();

            // 3A) Accedir a l’array 
            JsonArray menus = arrel.getAsJsonArray(CLAU_MENUS);
            
            if (menus == null) {
                System.err.println("No s'ha trobat la clau "+CLAU_MENUS);
                return;
            }

            System.out.println("Llistat inicial de menus:");
            for (JsonElement e : menus) {
            	
            	JsonObject menu = e.getAsJsonObject();
            	JsonObject descripcio = menu.getAsJsonObject(CLAU_DESCRIPCIO);
            	String dcodi = descripcio.get(CLAU_DCODI).getAsString();
            	double dpreu = descripcio.get(CLAU_DPREU).getAsDouble();
            	String dtext = descripcio.get(CLAU_DTEXT).getAsString();
            	String tipus = menu.get(CLAU_TIPUS).getAsString();
            	
            	JsonObject grup = menu.getAsJsonObject(CLAU_GRUP);
            	String gid = grup.get(CLAU_GID).getAsString();
            	String gdescripcio = grup.get(CLAU_GDESCRIPCIO).getAsString();
            	String gtipus = grup.get(CLAU_GTIPUS).getAsString();
            	
                System.out.println(dtext+" | "+dcodi+" | "
                +dpreu+" Euros |"+tipus+" |( "+gid+" - "+gdescripcio+" - "+gtipus+") ");
            }
          
            // 3B) Modificar un valor (primer llibre → canviar any de publicació)
            JsonObject primerComida = menus.get(0).getAsJsonObject();
            primerComida.addProperty(CLAU_DPREU, 100);
            /*	
            // 3C) Afegir un nou llibre
            JsonObject nouLlibre = new JsonObject();
            // Afegir propietats al nou llibre
            nouLlibre.addProperty(CLAU_TITULO, "DOM i JSON");
            nouLlibre.addProperty(CLAU_AUTOR, "Maria Dom");
            nouLlibre.addProperty(CLAU_PUBLICADO_EN, 2025);
            // Afegir el nou llibre a l'array de llibres
            menus.add(nouLlibre);
            System.out.println("Llistat actualitzat de llibres");

            // 4) Escriure el JSON modificat a un nou fitxer
            try (Writer writer = new OutputStreamWriter(
                    new FileOutputStream(FITXER_SORTIDA), StandardCharsets.UTF_8)) {
                gson.toJson(arrel, writer);
            }

            System.out.println("Fitxer actualitzat correctament: data/Libros_modificat.json");
			*/
        } catch (IOException e) {
            System.err.println("Error de lectura o escriptura: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Error de format JSON: " + e.getMessage());
        }
			
		} 
	}
	


