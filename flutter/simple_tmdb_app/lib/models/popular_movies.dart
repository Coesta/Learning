import 'package:simple_tmdb_app/models/movie.dart';

class PopularMovies {
  int page;
  List<Movie> results;

  PopularMovies([this.page, this.results = const []]);
}
