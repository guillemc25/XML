package sitemapXataka;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class sitemapEj2 {

	public static void main(String[] args) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//fabrica de XML
        try {
        	//con esto evitamos ataques XXE
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            //declaramos el URL(Sitemmap)
            URL ficheroUrl = new URL("https://www.xataka.com/sitemap_index.xml");
            //inicializamos el archivo XML CON DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();
            //abrimos el xml y lo analizamos con el metodo parse(DENT
            Document doc = db.parse(ficheroUrl.openStream());//este método abre la conexión con la url y nos permitirá leer el archivo
            
     
            //imprimimos el nodo raiz
            System.out.println("Elemento raiz :" + doc.getDocumentElement().getNodeName());
            
            System.out.println("------");
            //obtenemos todos los datos de loc(las URLS)
            NodeList list = doc.getElementsByTagName("loc");
            
            //recoremos todos los nodos loc del xml
            
            //
            for (int i = 0; i < list.getLength(); i++) {
            System.out.println("URL:" + list.item(i).getTextContent());//imprimiremos la primera url 
            System.out.println("------");
            	DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();//creamos nueva fabrica de XML
                try {
                	
                    dbf2.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);//Evitamos ataques XXE
                    URL ficheroUrl2 = new URL(list.item(i).getTextContent());//instanciamos las urls de la primera URL 
                    DocumentBuilder db2= dbf2.newDocumentBuilder();//Analizamos el arhcivo XML
                    Document doc2 = db2.parse(ficheroUrl2.openStream());//Abrimos stream de las URLS del primer sitemap
                    System.out.println("Elemento raiz :" + doc2.getDocumentElement().getNodeName());//Imprimimos noda raiz
                    System.out.println("------");
                    NodeList list2 = doc2.getElementsByTagName("loc");//Nuevo NodeList para referencia que Nodo del XML imprimiremos
                    
                    for (int y = 0; y < list2.getLength(); y++) {//imprimos los sitemaps del primer sitemap
                    	
                    	System.out.println(list2.item(y).getTextContent());

                    }  
                    
                    
                    
                    
                } catch (ParserConfigurationException | SAXException | IOException e) {
                	
                    e.printStackTrace();
                }
               
                
            }
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
        	
            e.printStackTrace();
        }
	}

}
