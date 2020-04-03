package gl51.movie.service

import gl51.movie.data.Movie

/**
 * stores movie
 */
// Alt + Enter => implement interface
interface MovieRegistry {
    /**
     * adds a film to favorites
     * @param imdbID the id of the film
     */
    void addMovieToFavorites(String imdbID)

    /**
     * return a list of my movies with their details
     * @return
     */
    List<Movie> listFavorites()
}