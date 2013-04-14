package grails.facebook.example

import grails.plugins.springsecurity.Secured

class SecureController {

    @Secured(['ROLE_USER'])
    def index() {
        render "this is a secure page for Facebook users"
    }
}
