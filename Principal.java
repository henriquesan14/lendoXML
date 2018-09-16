import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Principal {
	public static void main(String[] args) {
		File f=new File("C:/Users/ricog/Desktop/PIBMunicipiosPE.xml"); //Substitui pelo o diretorio que o arquivo está
		
		SAXBuilder sb=new SAXBuilder();
		
		Document d = null;
		try {
			d= sb.build(f); //aqui a variavel Document "d" recebe o arquivo convertido pelo SAXBuilder
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element root = d.getRootElement(); //captura o elemento raiz do XML
		String titulo = root.getChild("cabecalho").getChild("titulo").getAttributeValue("principal"); //captura o titulo principal do XML
		List<Element> registros=root.getChild("corpo").getChild("registros").getChildren(); //captura os registros
		
		System.out.println("--"+titulo+"--");
		for(Element element: registros){  //for pra iterar os registros
			System.out.println(element.getAttributeValue("campo1")+" - "+element.getAttributeValue("campo2"));
		}
		
	}
}
