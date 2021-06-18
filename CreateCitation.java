import org.w3c.dom.*;

public class CreateCitation
{
	public static Node createCitation(Document doc, String author, String y_o_p, 
									   String DIO, String title,String location) {

		Element cite = doc.createElement("cite");
		cite.appendChild(createCitationElement(doc, "Author", author));
		cite.appendChild(createCitationElement(doc, "Year_of_Publication",y_o_p));
		cite.appendChild(createCitationElement(doc, "DIO", DIO));
		Element node=doc.createElement("type_of_publication");
		node.appendChild(createCitationElement(doc,"Publication_Name_Title",title));
		node.appendChild(createCitationElement(doc,"Location",location));
		cite.appendChild(node);

		return cite;
	}

	private static Node createCitationElement(Document doc, String name, 
											  String value) {

		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));

		return node;
	}
}
