package org.wahlzeit;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.wahlzeit.services.EmailServiceTestSuite;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({EmailServiceTestSuite.class,
					 HandlersTestSuite.class,
					 ModelTestSuite.class})
public class AllTests {
}
