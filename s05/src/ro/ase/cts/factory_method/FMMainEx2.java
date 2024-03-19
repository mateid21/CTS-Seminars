package ro.ase.cts.factory_method;

interface Document{
    void open();
    void save();
}

class TextDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening a text document");
    }
    @Override
    public void save() {
        System.out.println("Saving a text document");
    }
}

class ImageDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening an image document");
    }
    @Override
    public void save() {
        System.out.println("Saving an image document");
    }
}

interface DocumentFactory{
    Document createDocument();
}

class TextDocumentFactory implements DocumentFactory{
    @Override
    public Document createDocument() {
        return new TextDocument();
    }
}
class ImageDocumentFactory implements DocumentFactory{
    @Override
    public Document createDocument() {
        return new ImageDocument();
    }
}

public class FMMainEx2 {
    public static void main(String[] args) {
        DocumentFactory textFactory = new TextDocumentFactory();
        Document textDocument = textFactory.createDocument();
        textDocument.open();
        textDocument.save();

        DocumentFactory imageFactory = new ImageDocumentFactory();
        Document imageDocument = imageFactory.createDocument();
        imageDocument.open();
        imageDocument.save();

    }
}
