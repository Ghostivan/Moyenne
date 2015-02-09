package esgi.class_utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class JsonUtils {

	/**
	 * Lecture d'un fichier json
	 * @param monFichier
	 */
//	public String read(File monFichier) {
//
//		String donneesFichier;
//		JSONStringer parser = new JSONStringer();
//		String path = monFichier.getAbsolutePath();
//		
//		try {
//
//			Object obj = ((Object) parser).parse(new FileReader(path));
//
//			JSONObject jsonObject = (JSONObject) obj;
//
//			String name = (String) jsonObject.get("name");
//			System.out.println(name);
//
//			long age = (Long) jsonObject.get("age");
//			System.out.println(age);
//
//			// loop array
//			JSONArray msg = (JSONArray) jsonObject.get("messages");
//			Iterator<String> iterator = msg.iterator();
//			while (iterator.hasNext()) {
//				System.out.println(iterator.next());
//			}
//			
//			return donneesFichier;
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * Ecriture des données dans un fichier json
	 * @param jsonContent
	 */
	public void write(String pathFichier, String jsonContent){
		
		File file = new File(pathFichier);

		try {
			if (!file.exists()){
				file.createNewFile();	
			}
			
			FileWriter writer = new FileWriter(file);
			writer.write(jsonContent);
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			System.out.println("Erreur: impossible de créer le fichier '"
					+ pathFichier + "'");
		}
	}
	
	/**
	 * test json
	 */
	public void write2(){
		
		//ecriture
		JSONObject json = new JSONObject();
		try {
			json.put("key1", "coucou");
			json.put("key2", new Integer(3));
			
			String str = "{\"json1\" : \"lol\", \"json2\" : \"lol\", \"json3\" : \"lol\"}";
			JSONObject obj = new JSONObject(str);
			json.put("putObject", obj);
			
			//lecture
			System.out.println(json);
			System.out.println(json.optString("key1", ""));
			System.out.println(json.optInt("key2", 0));
			System.out.println(json.getJSONObject("putObject"));
			
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
	}
}
