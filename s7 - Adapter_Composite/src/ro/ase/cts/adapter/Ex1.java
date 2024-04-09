package ro.ase.cts.adapter;

//Cerinta: nu avem acces la codul sursa

//Target interface
interface DataReader {
    String readData();
}

//Adaptee 1
class XMLDataReader{
    String readXML(){
        return "Data from XML";
    }
}

//Adaptee 2
class JSONDataReader{
    String readJSON(){
        return "Data from JSON";
    }
}

//Adapter for XML
class XMLAdapter implements DataReader{
    private XMLDataReader xmlReader;

    public XMLAdapter(XMLDataReader xmlReader){
        this.xmlReader = xmlReader;
    }

    @Override
    public String readData() {
        return xmlReader.readXML();
    }
}

//Adapter for JSON
class JSONAdapter implements DataReader{
    private JSONDataReader jsonReader;

    public JSONAdapter(JSONDataReader jsonReader){
        this.jsonReader = jsonReader;
    }

    @Override
    public String readData() {
        return jsonReader.readJSON();
    }
}

//Client code
public class Ex1 {
    public static void main(String[] args) {
        DataReader xmlAdapter = new XMLAdapter(new XMLDataReader());
        DataReader jsonAdapter = new JSONAdapter(new JSONDataReader());
        System.out.println(xmlAdapter.readData());
        System.out.println(jsonAdapter.readData());
    }
}