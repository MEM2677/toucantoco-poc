/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptoucantoco.aps;


import org.entando.entando.plugins.jptoucantoco.JptoucantocoConfigTestUtils;

import com.agiletec.ConfigTestUtils;
import com.agiletec.aps.BaseTestCase;

public class JptoucantocoBaseTestCase extends BaseTestCase {

	@Override
	protected ConfigTestUtils getConfigUtils() {
		return new JptoucantocoConfigTestUtils();
	}

	
}
