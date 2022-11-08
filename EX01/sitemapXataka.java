package sitemapXataka;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class sitemapXataka{
    public static void main(String[] args) {
    	//clase que permite trabajar con xml
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
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
            for (int i = 0; i < list.getLength(); i++) {
            	
                System.out.println(list.item(i).getTextContent());
                
            }
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
        	
            e.printStackTrace();
        }
    }
    }