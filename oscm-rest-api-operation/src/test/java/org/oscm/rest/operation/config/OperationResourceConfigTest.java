/**
 * *****************************************************************************
 *
 * <p>Copyright FUJITSU LIMITED 2019
 *
 * <p>Creation Date: 16-04-2019
 *
 * <p>*****************************************************************************
 */
package org.oscm.rest.operation.config;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.oscm.rest.common.GsonMessageProvider;
import org.oscm.rest.common.OSCMExceptionMapper;
import org.oscm.rest.common.VersionFilter;
import org.oscm.rest.operation.SettingsResource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class OperationResourceConfigTest {

  @Test
  @Disabled("Not implemented")
  public void shouldGetClasses() {
    OperationResourceConfig resourceConfig = new OperationResourceConfig();

//    Set<Class<?>> classes = resourceConfig.getClasses();
//
//    assertThat(classes.size()).isEqualTo(4);
//    assertThat(classes.contains(SettingsResource.class)).isEqualTo(true);
//    assertThat(classes.contains(OSCMExceptionMapper.class)).isEqualTo(true);
//    assertThat(classes.contains(GsonMessageProvider.class)).isEqualTo(true);
//    assertThat(classes.contains(VersionFilter.class)).isEqualTo(true);
  }
}
