package servicios;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;
import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import controlador.RegistroControlador;
import modelo.Registro;
import modelo.Ciudad;

public class RESTEasyClientGet {

	public String cliente(String e) throws Exception {
		
		
		String url="http://api.openweathermap.org/data/2.5/weather?id=", codigo="",key="&APPID=617114929ea17380864e4250795e40f3";
		BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
		codigo= bf.readLine();
		ClientRequest request = new ClientRequest(url+codigo+key);
		request.accept("application/json");
		ClientResponse<String> response = request.get(String.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			new ByteArrayInputStream(response.getEntity().getBytes())));

		String output;
		StringBuffer a = new StringBuffer();
		System.out.println("Clima:...");
		while ((output = br.readLine()) != null) {
			a.append(output);
		}
			output=a.toString();
			System.out.println(output);
			JSONObject respuesta = new JSONObject(output);
			JSONObject res = new JSONObject(respuesta.getJSONObject("main").toString());
			Double temp=res.getDouble("temp")-273,hum=res.getDouble("humidity");	
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");
			LocalDateTime now = LocalDateTime.now();
			String fecha =dtf.format(now);//2016/11/16 
			String hora = dtf2.format(now);//12:08:43
			String cad="La temperatura es: "+temp+"La humedad es: "+hum;				
			int cod=Integer.parseInt(codigo);
			Registro nuevo_registro= new Registro(cod,true,fecha,hora,hum,temp);
			Boolean l;
			RegistroControlador bd = new RegistroControlador();
			l=bd.create(cod,nuevo_registro);
			return cad;
	  
	}
}




