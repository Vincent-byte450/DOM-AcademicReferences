import org.w3c.dom.*;

public class DisplayXml
{
	DisplayXml(Document doc){
		NodeList nList = doc.getElementsByTagName("cite");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                Node node1 = elem.getElementsByTagName("Author").item(0);
                String author = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("Year_of_Publication").item(0);
                String Y_O_P = node2.getTextContent();

				Node node3 = elem.getElementsByTagName("DIO").item(0);
                String DIO = node3.getTextContent();

				Node node4= elem.getElementsByTagName("type_of_publication").item(0);
                String titlename = node4.getChildNodes().item(0).getTextContent();
				String clocation=node4.getChildNodes().item(1).getTextContent();
				System.out.println();
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Citation "+(++i));
                System.out.println("Author: "+author);
				System.out.println("Year_of_Publication: "+Y_O_P);
				System.out.println("DIO: "+DIO);
				System.out.println("Title: "+titlename);
				System.out.println("Location: "+clocation);
            }
        }
	}
}
