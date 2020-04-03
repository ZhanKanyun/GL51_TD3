package gl51.movie.service.impl

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MovieRegistryImplTest extends Specification {

    @Inject
    MovieRegistryImpl registry

    void "injection should work"() {
        expect:
        registry != null
    }

    void "favorites should be empty"() {
        expect:
        registry.listFavorites() == []
    }

    void "adding a facovite should fill in the database"() {
        when:
        registry.addMovieToFavorites("aaaaa")
        then:
        registry.listFavorites().size() == 1
    }
}