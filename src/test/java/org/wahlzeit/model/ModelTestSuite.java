package org.wahlzeit.model;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.wahlzeit.model.persistence.PersistenceTestSuite;
import org.wahlzeit.model.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({AccessRightsTest.class,
					 FlagReasonTest.class,
					 GenderTest.class,
					 GuestTest.class,
					 PersistenceTestSuite.class,
					 PhotoFilterTest.class,
					 TagsTest.class,
					 UserStatusTest.class,
					 ValueTest.class})
public class ModelTestSuite {

}
