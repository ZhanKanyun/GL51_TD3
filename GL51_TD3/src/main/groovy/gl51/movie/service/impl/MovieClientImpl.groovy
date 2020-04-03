package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import gl51.movie.service.MovieRegistry

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieClientImpl implements MovieClient {
    @Inject MovieRegistry registry

    @Override
    Movie getMovieDetail(String imdbID) {
        if(!registry.listFavorites().isEmpty()) {
            for(Movie movie : registry.listFavorites()) {
                if(imdbID == movie.getImdbID()) {
                    return movie
                }
            }
        }
        return null
    }
}