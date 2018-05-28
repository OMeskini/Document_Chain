package com.example.demo;

import java.io.File;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.demo.dao.DocumentsRepository;
import com.example.demo.dao.MappingRepository;
import com.example.demo.dao.ParamsRepository;
import com.example.demo.entities.Documents;
import com.example.demo.entities.Mapping;
import com.example.demo.entities.Params;

@SpringBootApplication
public class TpSpringMvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(TpSpringMvcApplication.class, args);
		DocumentsRepository docRepo =ctx.getBean(DocumentsRepository.class ) ;
		//docRepo.save(new Documents(new Long(3),"visa_card","numvisa","selct* from VISA","GAT",3,1));
		String type_name= null;
        String idType = null;
		 try {

	        	File fXmlFile = new File("C:\\Users\\ASUS\\Documents\\cin_doc.xml");
	        	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        	Document doc = dBuilder.parse(fXmlFile);
	        			
	        	//optional, but recommended
	        	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	        	doc.getDocumentElement().normalize();

//		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
	        	NodeList ntype = doc.getElementsByTagName("type");
				
		System.out.println("----------------------------");

		for (int temp = 0; temp < ntype.getLength(); temp++) {

			Node nNode = ntype.item(temp);
					
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
	               type_name=eElement.getAttribute("id");
	               idType=eElement.getElementsByTagName("numCin").item(0).getTextContent();
	               }
		}
			 } catch (Exception e) {
					e.printStackTrace();
				    }
				
		
		/*docRepo.save(new Documents(new Long(3),"visa_card","numvisa","selct* from VISA","GAT",3,1));*/
		Documents docs=docRepo.chercherDoc(type_name);
	System.out.println(docs.getQuery());
	ParamsRepository paramRepo =ctx.getBean(ParamsRepository.class ) ;
	Params parameters=paramRepo.chercherParams(docs.getParams());
	System.out.println(parameters.getUser());
	DataSource dataSource=null;
	dataSource = createDataSource(parameters.getDb_name(),
			parameters.getUser(), parameters.getPassword());
	JdbcTemplate vJdbcTemplate ;
	vJdbcTemplate	= new JdbcTemplate(dataSource);
int vNbrTicket = vJdbcTemplate.queryForObject(

        "SELECT id_cl FROM cin where cin.id_card="+idType,

        Integer.class);
System.out.println(vNbrTicket);
	
	}

	
	public static DataSource createDataSource(String url, String username,
			String password) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url,
				username, password);
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource;
	}
}
