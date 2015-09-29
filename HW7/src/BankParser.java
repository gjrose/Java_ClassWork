import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
   An XML parser for a bank.
*/
public class BankParser
{
   private DocumentBuilder builder;
   private XPath path;

   /**
      Constructs a parser that can parse a bank.
   */
   public BankParser() 
         throws ParserConfigurationException
   {
      DocumentBuilderFactory factory 
            = DocumentBuilderFactory.newInstance();
      //factory.setValidating(true);
      factory.setIgnoringElementContentWhitespace(true);
      builder = factory.newDocumentBuilder();
      XPathFactory xpfactory = XPathFactory.newInstance();
      path = xpfactory.newXPath();
   }

   /**
      Parses an XML file containing a bank.
      @param fileName the name of the file
      @return a Bank object containing all coins in the XML file
   */
   public Bank parse(String fileName) 
         throws SAXException, IOException, XPathExpressionException
   {
      File f = new File(fileName);
      Document doc = builder.parse(f);

      // get the bank
      
      Bank b = new Bank();
      
      // Get all of the accounts from the document and add each of them
      // to the Bank b.

      ...

      // Get and apply each type of transactions from the document:
      // deposit, withdraw, and transfer

      ...

      return b;

   }
}