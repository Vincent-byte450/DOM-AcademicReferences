import java.io.*;
import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

public class AddCitation
{
	AddCitation(Document doc,File xmlFile) throws TransformerConfigurationException{
		
		CreateCitation c=new CreateCitation();
		Scanner in=new Scanner(System.in);
        doc.getDocumentElement().normalize();
		System.out.print("Authors:");
		String Author=in.next();
		System.out.print("Year of Publication:");
		String y_o_p=in.next();
		System.out.print("DIO:");
		String dio=in.next();
		System.out.print("Publication Name/Title:");
		String title=in.next();
		System.out.print("Location/Book Chapters:");
	    String location=in.next();
		doc.getDocumentElement().appendChild(c.createCitation(doc, Author,y_o_p, dio,title,location));

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transf = transformerFactory.newTransformer();
		transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transf.setOutputProperty(OutputKeys.INDENT, "yes");
		transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		DOMSource source = new DOMSource(doc);
		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(xmlFile);
		try
		{
			transf.transform(source, file);
		}
		catch (TransformerException e)
		{}
	}
}
