/**
 * Created by charu.jain on 02-03-2017.
 */
import grails.plugin.dropwizard.metrics.meters.Meterable

class SomeClass implements Meterable {

  def someAction() {
    markMeter 'some meter'

    // ...
  }
}