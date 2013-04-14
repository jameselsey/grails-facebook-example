import com.jameselsey.demos.grailsfacebookexample.AppRole

class BootStrap {

    def init = { servletContext ->
        ['ROLE_FACEBOOK', 'ROLE_USER', 'ROLE_ADMIN'].each { roleStr ->
            if ( !AppRole.findByAuthority(roleStr) ) {
                new AppRole(authority: roleStr).save(flush: true)
            }
        }
    }
    def destroy = {
    }
}
