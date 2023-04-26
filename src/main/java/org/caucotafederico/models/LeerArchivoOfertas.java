package org.caucotafederico.models;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.caucotafederico.exceptions.NroColumnasInvalidoException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.dataformat.xml.*;

import com.opencsv.CSVReader;

public class LeerArchivoOfertas {
	public List<Oferta> leerArchivoCsv(String rutaArchivo) throws Exception{
		List<Oferta> listadoOfertas = new ArrayList<>();
		Oferta oferta;
		Producto producto;
		Descuento descuento;
		Peso peso;
		DateTimeFormatter formatFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha1, fecha2;
		
	    try (Reader reader = Files.newBufferedReader(Paths.get(rutaArchivo)) ) 
	    {
	        try (CSVReader csvReader = new CSVReader(reader))
	        {
	            String[] lineaLeida;
	            int nroLinea = 0;
	            while ((lineaLeida = csvReader.readNext()) != null) {
	            	nroLinea++;
	            	if (nroLinea == 1) {
	            		continue;
	            	}
	            	if(lineaLeida.length != 10) { /// controlamos cantidad de columnas
	            		throw new NroColumnasInvalidoException(lineaLeida.length , nroLinea);
	            	};
	            	descuento = new Descuento();
	            	descuento.setTipo(lineaLeida[7]);
	            	descuento.setCantidad(Double.parseDouble(lineaLeida[8].replace(',', '.')));
	            	descuento.setTope(Double.parseDouble(lineaLeida[9].replace(',', '.')));
	            	
	            	peso = new Peso(Double.parseDouble(lineaLeida[4].replace(',', '.')), lineaLeida[5]);
	            	
	            	producto = new Producto();
	            	producto.setNombre(lineaLeida[3]);
	            	producto.setPeso(peso);
	            	producto.setPrecio(Double.parseDouble(lineaLeida[6].replace(',', '.')));
	            	
	            	
	            	
	            	fecha1 = LocalDate.parse(lineaLeida[1], formatFecha);
	            	fecha2 = LocalDate.parse(lineaLeida[2], formatFecha);
	            	oferta = new Oferta(Integer.parseInt(lineaLeida[0]), fecha1, fecha2);
	            	oferta.setProducto(producto);
	            	oferta.setDescuento(descuento);
	            	
	            	listadoOfertas.add(oferta);
	            }
	        }
	    } catch (IOException e1) {
	    	e1.printStackTrace();
	    }
		return listadoOfertas;
	    
	}
	
	public void ofertasToJson_or_XML(List<Oferta> ofertas, String formatoSalida) {
		String jsonText = "";
		boolean formatoCorrecto = false;
		if (formatoSalida.equalsIgnoreCase("JSON")) {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());
			try {
				jsonText = objectMapper.writeValueAsString( ofertas);
				System.out.println(jsonText);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formatoCorrecto = true;
		}
		if (formatoSalida.equalsIgnoreCase("XML")) {
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.registerModule(new JavaTimeModule());
			try {
				jsonText = xmlMapper.writeValueAsString(ofertas);
				System.out.println(jsonText);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formatoCorrecto = true;
		}
		if (!formatoCorrecto) {
			System.out.println("ERROR: " + formatoSalida + " no es un formato soportado por esta aplicación. Sólo se permite formato JSON Y XML");
		}
	}
	
}