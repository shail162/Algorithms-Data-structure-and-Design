package moderate.Q16_12_XML_Encoding;

/**
 * Since XML is very verbose, you are given a way of encoding it where each tag gets mapped to pre-defined integer value.
 * The language/grammar is as follows:
 * Element --> Tag Attributes END Children END
 * Attribute --> Tag Value
 * END --> 0
 * Tag --> Some predefined mapping to int
 * Value -> string value
 *
 * For example, the following XML might be converted into compressed string below (assuming a mapping of family -->1,
 * person-->2, firstname->, lastname-->4, state -->5)
 *
 * <family lastname="McDowell", state ="CA>
 * 	<person firstName ="GAyle"> some message</person>
 * </family>"
 *
 * Becomes
 * 1 4 McDowell 5 CA 0 2 3 Gayle 0 Some message 0 0
 *
 * Write code to print the encoded version of an XML element(passed in element and attribute objects)
 */
public class QuestionOO {
	
	public static void encode(String v, StringBuilder sb) {
		v = v.replace("0", "\\0");
		sb.append(v);
		sb.append(" ");
	}
	
	public static void encodeEnd(StringBuilder sb) {
		sb.append("0");
		sb.append(" ");
	}
	
	public static void encode(Attribute attr, StringBuilder sb) {
		encode(attr.getTagCode(), sb);
		encode(attr.value, sb);
	}
	
	public static void encode(Element root, StringBuilder sb) {
		encode(root.getNameCode(), sb);
		for (Attribute a : root.attributes) {
			encode(a, sb);
		}
		encodeEnd(sb);
		if (root.value != null && root.value != "") {
			encode(root.value, sb);
		} else {
			for (Element e : root.children) {
				encode(e, sb);
			}
		}
		encodeEnd(sb);
	}
	
	public static String encodeToString(Element root) {
		StringBuilder sb = new StringBuilder();
		encode(root, sb);
		return sb.toString();
	}
	
	public static void main(String args[]) {
		Element root = new Element("family");
		Attribute a1 = new Attribute("lastName", "mcdowell");
		Attribute a2 = new Attribute("state", "CA");
		root.insert(a1);
		root.insert(a2);
		
		Element child = new Element("person", "Some Message");
		Attribute a3 = new Attribute("firstName", "Gayle");
		child.insert(a3);
		
		root.insert(child);
		
		String s = encodeToString(root);
		System.out.println(s);
	}
}
