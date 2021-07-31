import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.transform.*;
import java.util.*;



 class JavaXmlDomReadEx {

    public static void main(String argv[]) throws SAXException,
	IOException, ParserConfigurationException, TransformerConfigurationException {

        File xmlFile = new File("citations.xml");
		xmlFile.createNewFile();
		FileWriter fw = null;
		InputStream fis = null;
		try{
		fw = new FileWriter(xmlFile);
		fis=new FileInputStream(xmlFile);
		if(fis.available()==0)
		fw.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n<citations></citations>");
		else if(fis.available()>0){}
		}finally{
			if(fw!=null)
			fw.close();
			if(fis!=null)
			fis.close();
		}
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
		Scanner in =new Scanner(System.in);
		 while(true){
		 System.out.println();
		 System.out.println("                  Academic References");
		 System.out.println("1.Add Citation");
		 System.out.println("2.Display saved citations");
		 System.out.println("3.Exit");
		 System.out.print("Enter choice?");
		 int choice=in.nextInt();
		 switch(choice){
			 case 1:
				 new AddCitation(doc,xmlFile);
				 break;
			 case 2:
				 
				 new DisplayXml(doc);
				 break;
			 case 3:
				System.exit(0);
			 break;
			 default:
			 break;
		 }
		 
        }
		
    }
	
}
