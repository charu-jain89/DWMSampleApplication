/**
 * Created by charu.jain on 02-03-2017.
 */

import grails.plugin.dropwizard.metrics.timers.Timed

class SomeTimedClass {
  @Timed('some timer')
  void someAction() {
    // ...
  }

  @Timed(value='some other timer', useClassPrefix = true)
  void someOtherAction() {
    // ...
  }

  @Timed(value='yet other timer', useClassPrefix = false)
  void yetAnotherAction() {
    // ...
  }
}
