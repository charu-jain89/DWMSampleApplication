/**
 * Created by charu.jain on 02-03-2017.
 */

import grails.plugin.dropwizard.metrics.meters.Metered

class SomeOtherClass {
  @Metered('some meter')
  void someAction() {
    // ...
  }
  @Metered(value='some other meter', useClassPrefix = true)
  void someOtherAction() {
    // ...
  }
  @Metered(value='yet another meter', useClassPrefix = false)
  void yetAnotherAction() {
    // ...
  }
}