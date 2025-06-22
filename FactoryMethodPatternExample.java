interface Document 
{
    void create();
    void save();
}

class WordDocument implements Document 
{
    @Override
    public void create() 
    {
        System.out.println("Creating Word document...");
    }
    
    @Override
    public void save() 
    {
        System.out.println("Saving Word document...");
    }
}

class PdfDocument implements Document 
{
    @Override
    public void create() 
    {
        System.out.println("Creating PDF document...");
    }
    
    @Override
    public void save() 
    {
        System.out.println("Saving PDF document...");
    }
}

class ExcelDocument implements Document 
{
    @Override
    public void create() 
    {
        System.out.println("Creating Excel document...");
    }
    
    @Override
    public void save() 
    {
        System.out.println("Saving Excel document...");
    }
}

abstract class DocumentFactory 
{
    public abstract Document createDocument();
    
    public void processDocument() 
    {
        Document doc = createDocument();
        doc.create();
        doc.save();
    }
}

class WordDocumentFactory extends DocumentFactory 
{
    @Override
    public Document createDocument() 
    {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory 
{
    @Override
    public Document createDocument() 
    {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory 
{
    @Override
    public Document createDocument() 
    {
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample
{
    public static void main(String[] args) 
    {
        System.out.println("Testing Word Document Factory:");
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.processDocument();
        
        System.out.println("\nTesting PDF Document Factory:");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.processDocument();
        
        System.out.println("\nTesting Excel Document Factory:");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.processDocument();
        
        System.out.println("\nTesting direct document creation:");
        Document wordDoc = new WordDocumentFactory().createDocument();
        wordDoc.create();
        wordDoc.save();
    }
}