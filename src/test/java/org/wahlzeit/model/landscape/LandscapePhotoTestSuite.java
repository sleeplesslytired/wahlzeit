package org.wahlzeit.model.landscape;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.wahlzeit.model.persistence.PersistenceTestSuite;
import org.wahlzeit.model.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({LandscapePhotoTest.class,
					 LandscapePhotoFactoryTest.class})
public class LandscapePhotoTestSuite {

}
