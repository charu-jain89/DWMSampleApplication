import com.codahale.metrics.MetricRegistry
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

@TestMixin(GrailsUnitTestMixin)
class MeteredAnnotationSpec extends Specification {

  static doWithSpring = {
    metricRegistry MetricRegistry
    someMeteredBean SomeOtherClass
  }

  void 'test the @Metered annotation'() {
    setup:
    def registry = applicationContext.metricRegistry
    def obj = applicationContext.someMeteredBean

    when:
    obj.someAction()
    obj.someAction()
    obj.someAction()

    then:
    registry.meter('some meter').count == 3
  }

  void 'test the @Metered annotation with useClassPrefix set to true'() {
    setup:
    def registry = applicationContext.metricRegistry
    def obj = applicationContext.someMeteredBean

    when:
    obj.someOtherAction()
    obj.someOtherAction()
    obj.someOtherAction()

    then:
    registry.meter('grails.plugin.dropwizard.metrics.meters.SomeOtherClass.some other meter').count == 3
  }

  void 'test the @Metered annotation with useClassPrefix set to false'() {
    setup:
    def registry = applicationContext.metricRegistry
    def obj = applicationContext.someMeteredBean

    when:
    obj.yetAnotherAction()
    obj.yetAnotherAction()
    obj.yetAnotherAction()

    then:
    registry.meter('yet another meter').count == 3
  }
}