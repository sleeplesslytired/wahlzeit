package org.wahlzeit.services;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.wahlzeit.services.*;
import org.wahlzeit.services.mailing.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({EmailAddressTest.class,
					 EmailServiceTest.class,
					 LogBuilderTest.class})
public class EmailServiceTestSuite {
}
