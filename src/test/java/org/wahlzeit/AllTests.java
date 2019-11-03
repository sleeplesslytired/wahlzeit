package org.wahlzeit;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.wahlzeit.services.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({EmailServiceTestSuite.class})
public class AllTests {
}
