import grails.plugin.dropwizard.metrics.timers.Timed

class User {

  @Timed('some timer')
  void action() {
    println 'hello'
  }
}
