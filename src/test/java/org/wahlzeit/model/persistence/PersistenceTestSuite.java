package org.wahlzeit.model.persistence;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.wahlzeit.model.persistence.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({AbstractAdapterTest.class,
					 DatastoreAdapterTest.class})
public class PersistenceTestSuite {

}
