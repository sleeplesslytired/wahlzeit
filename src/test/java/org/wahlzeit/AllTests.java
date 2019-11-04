package org.wahlzeit;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.wahlzeit.services.*;
import org.wahlzeit.handlers.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({EmailServiceTestSuite.class,
					 HandlersTestSuite.class})
public class AllTests {
}
