package org.wahlzeit.testEnvironmentProvider;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.wahlzeit.testEnvironmentProvider.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({LocalDatastoreServiceTestConfigProvider.class,
					 RegisteredOfyEnvironmentProvider.class,
					 SysConfigProvider.class,
					 UserServiceProvider.class,
					 UserSessionProvider.class,
					 WebFormHandlerProvider.class})
public class TestEnvironmentProviderTestSuite {

}
