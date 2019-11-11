package org.wahlzeit;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.wahlzeit.services.EmailServiceTestSuite;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.testEnvironmentProvider.TestEnvironmentProviderTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({EmailServiceTestSuite.class,
					 HandlersTestSuite.class,
					 ModelTestSuite.class,
					 TestEnvironmentProviderTestSuite.class,
					 UtilsTestSuite.class})
public class AllTests {
}
