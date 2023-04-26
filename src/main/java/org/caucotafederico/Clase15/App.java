package org.caucotafederico.Clase15;

import java.util.ArrayList;
import java.util.List;

import org.caucotafederico.models.*; 

public class App 
{
    public static void main( String[] args )
    {
        String archivoOfertas = "src\\resources\\Ofertas.csv";
        String formatoSalida = "JSON";
        
        if(args.length == 0) {
        //	System.out.print("Faltan las rutas de los archivos");
        //	System.exit(88);
        }else {
        	archivoOfertas = args[0];
        	if (args.length > 1) {
        		formatoSalida = args[1];
        	}
        		
        }
        
        List<Oferta> listadoOfertas = new ArrayList<Oferta>();
        LeerArchivoOfertas lectorOferta = new LeerArchivoOfertas();
        try {
			listadoOfertas = lectorOferta.leerArchivoCsv(archivoOfertas);
			lectorOferta.ofertasToJson_or_XML(listadoOfertas, formatoSalida);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
