package org.wahlzeit.model;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.wahlzeit.model.persistence.PersistenceTestSuite;
import org.wahlzeit.model.landscape.LandscapePhotoTestSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({AccessRightsTest.class,
					 FlagReasonTest.class,
					 GenderTest.class,
					 GuestTest.class,
					 PhotoFilterTest.class,
					 TagsTest.class,
					 UserStatusTest.class,
					 ValueTest.class,
					 LandscapePhotoTestSuite.class})
public class ModelTestSuite {

}
