/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadormoda;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author admin
 */
public class importarExcel {
    
     public static void main(String args[]) throws IOException{
	
         
      //  ArrayList<NumerosVO> numeros = new ArrayList<NumerosVO()>;
         ArrayList<String> lista = new ArrayList<String>();
	FileInputStream file = new FileInputStream(new File("C:\\ultimosResultados3_final.xls"));
	// Crear el objeto que tendra el libro de Excel
	HSSFWorkbook workbook = new HSSFWorkbook(file);
	
    

	/*
	
	 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
	
	 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator
	
	 * que nos permite recorrer cada una de las filas que contiene.
	
	 */
	
	HSSFSheet sheet = workbook.getSheetAt(0);
	
	Iterator<Row> rowIterator = sheet.iterator();
	
 
	
	Row row;
	
	// Recorremos todas las filas para mostrar el contenido de cada celda
	
	while (rowIterator.hasNext()){
	
	    row = rowIterator.next();
 
	    // Obtenemos el iterator que permite recorres todas las celdas de una fila
	
	    Iterator<Cell> cellIterator = row.cellIterator();
	
	    Cell celda;
	
            
	
	    while (cellIterator.hasNext()){
	
		celda = cellIterator.next();
                
		// Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
	
		switch(celda.getCellType()) {
	
		case Cell.CELL_TYPE_NUMERIC:
	
		    if( HSSFDateUtil.isCellDateFormatted(celda) ){
	
		       System.out.println("date: "+celda.getDateCellValue());
	
		    }else{
	
		       System.out.println("numeric: "+celda.getNumericCellValue());
                        
		    }
	
		    System.out.println("num: "+celda.getNumericCellValue());
                   
                    
                    
		    break;
	
		case Cell.CELL_TYPE_STRING:
	
                    
		    System.out.println("Numeros:"+celda.getStringCellValue().trim());
                    
                    lista.add(celda.getStringCellValue().trim().substring(0,34));

		    break;

		case Cell.CELL_TYPE_BOOLEAN:

		    System.out.println(celda.getBooleanCellValue());
                    
		    break;

		}
            }

	}

        
        
        System.out.println("Recorrer Collection con simple for:");
        for (String nombre : lista) {
            //System.out.println("Convinacion"+nombre.trim().substring(0,15));
            System.out.println("Convinacion"+nombre.trim());
        }
        
        int maximaVecesQueSeRepite = 0;
        String moda = "";
                
        for(int i=0; i<lista.size(); i++){
            
            
        int vecesQueSeRepite = 0;
            for(int j=0; j<lista.size(); j++){
                if(lista.get(i).equals(lista.get(j))){
                   
                vecesQueSeRepite++;
           }
            if(vecesQueSeRepite > maximaVecesQueSeRepite){
                moda = lista.get(i);
                maximaVecesQueSeRepite = vecesQueSeRepite;
            }
        }
        }
        
        System.out.println("La moda es "+moda+" y se repitió "+maximaVecesQueSeRepite+" veces.");
        
        
        
        System.out.println("Tamaño Lista:"+lista.size());
        
        
        
        //System.out.println(contenedor.length);
	// cerramos el libro excel
	workbook.close();
        
        

    }
    
}
