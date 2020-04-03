package gl51.movie.service.impl

import gl51.movie.service.MovieClient
import gl51.movie.service.MovieRegistry
import io.micronaut.test.annotation.MockBean

import io.micronaut.test.annotation.MicronautTest

import spock.lang.Specification
import javax.inject.Inject

@MicronautTest
class MovieClientImplTest extends Specification {
    @Inject MovieClientImpl client
    @Inject MovieRegistry registry

    void "injection should work"() {
        expect:
        registry != null
        client != null
    }

    void "favorites should be empty"() {
        expect:
        registry.listFavorites() == []
    }

    void "get the movie by the imdbID should work"() {
        when:
        registry.addMovieToFavorites("abac")
        then:
        registry.listFavorites().size() == 1
        client.getMovieDetail("abac") != null
        client.getMovieDetail("aaaa") == null
    }

    @MockBean(MovieClientImpl)
    MovieClient client() {
        Mock(MovieClient)
    }

}
