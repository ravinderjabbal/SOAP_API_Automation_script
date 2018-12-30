package Project_Files;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.iface.Submit.Status;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;

public class Employee {
	@Test
	public void Testing_using_Java() throws XmlException, IOException, SoapUIException {
		// TODO Auto-generated method stub
		
		WsdlProject project = new WsdlProject("./data/Employee-Portal-soapui-project.xml");
		//WsdlTestSuite testSuite =  project.getTestSuiteByName("LibraryTesting");
		for (int j = 0; j < project.getTestSuiteCount(); j++) {
			WsdlTestSuite testSuite = project.getTestSuiteAt(j);
			for(int i=0; i<testSuite.getTestCaseCount();i++) {
				WsdlTestCase testCase = testSuite.getTestCaseAt(i);
				//Run the TestCase
				TestRunner testRunner =testCase.run(new PropertiesMap(),false);
				Assert.assertEquals(String.valueOf(Status.FINISHED),String.valueOf(testRunner.getStatus()).trim());
			}
		}
		
	}
}
