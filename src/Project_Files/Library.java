package Project_Files;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.support.SoapUIException;



import com.eviware.soapui.model.iface.Submit.Status;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;


public class Library {
	@Test
	public void Testing_using_Java() throws XmlException, IOException, SoapUIException {
		// TODO Auto-generated method stub
		
		WsdlProject project = new WsdlProject("D:\\Projects\\Projects(Soap_UI)\\REST\\Library_Example-soapui-project.xml");
		WsdlTestSuite testSuite =  project.getTestSuiteByName("LibraryTesting");
		for(int i=0; i<testSuite.getTestCaseCount();i++) {
			WsdlTestCase testCase = testSuite.getTestCaseAt(i);
			TestRunner testRunner =testCase.run(new PropertiesMap(),false);
			Assert.assertEquals(Status.FINISHED,testRunner.getStatus());
		}
	}
}

 