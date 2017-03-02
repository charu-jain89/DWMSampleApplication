package yammer

import grails.plugin.dropwizard.metrics.timers.Timed

class TestController {

    @Timed('some timer1')
    def index() {
        render 'ok'
    }
}