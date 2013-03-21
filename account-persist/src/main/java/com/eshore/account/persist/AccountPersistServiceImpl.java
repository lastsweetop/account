package com.eshore.account.persist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class AccountPersistServiceImpl implements AccountPersistService {
	
	private String file;
	
	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}

	private SAXReader reader=new SAXReader();

	private final static String ELEMENT_ROOT="account-persist";
	private final static String ELEMENT_ACCOUNTS="accounts";
	private final static String ELEMENT_ACCOUNT_ID="id";
	private final static String ELEMENT_ACCOUNT_NAME="name";
	private final static String ELEMENT_ACCOUNT_EMAIL="email";
	private final static String ELEMENT_ACCOUNT_PASSWORD="password";
	private final static String ELEMENT_ACCOUNT_ACTIVATED="activated";
	
	public Account createAccount(Account account)
			throws AccountPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Account readAccount(String id) throws AccountPersistException {
		Document doc=readDocument();
		
		Element accountsEle=doc.getRootElement().element(ELEMENT_ACCOUNTS);
		
		for (Element accountEle : (List<Element>)accountsEle.elements()) {
			if(accountEle.elementText(ELEMENT_ACCOUNT_ID).equals(id)){
				return buildAccount(accountEle);
			}
		}
		return null;
	}

	private Account buildAccount(Element element) {
		Account account=new Account();
		
		account.setId(element.elementText(ELEMENT_ACCOUNT_ID));
		account.setName(element.elementText(ELEMENT_ACCOUNT_NAME));
		account.setEmail(element.elementText(ELEMENT_ACCOUNT_EMAIL));
		account.setPassword(element.elementText(ELEMENT_ACCOUNT_PASSWORD));
		account.setActivated("true".equals(element.elementText(ELEMENT_ACCOUNT_ACTIVATED))?true:false);
		return account;
	}


	public Account updateAccount(Account account)
			throws AccountPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAccount(String id) throws AccountPersistException {
		// TODO Auto-generated method stub

	}

	private Document readDocument() throws AccountPersistException{
		File dataFile=new File(file);
		
		if(!dataFile.exists()){
			dataFile.getParentFile().mkdirs();
			Document doc=DocumentFactory.getInstance().createDocument();
			Element rootEle=doc.addElement(ELEMENT_ROOT);
			rootEle.addElement(ELEMENT_ACCOUNTS);
			writeDocument(doc);
		}
		
		try {
			return reader.read(new File(file));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			throw new AccountPersistException("Unable to read persist data xml", e);
		}
	}

	private void writeDocument(Document doc) throws AccountPersistException {
		Writer out=null;
		
		try {
			out=new OutputStreamWriter(new FileOutputStream(file),"utf-8");
			XMLWriter writer=new XMLWriter(out, OutputFormat.createPrettyPrint());
			writer.write(doc);
		} catch (IOException e) {
			throw new AccountPersistException("Unable to write persist data xml", e);
		}finally{
			try {
				if(out!=null){
					out.close();
				}
			} catch (IOException e) {
				throw new AccountPersistException("Unable to close persist data xml writer", e);
			}
		}
		
	}
}
