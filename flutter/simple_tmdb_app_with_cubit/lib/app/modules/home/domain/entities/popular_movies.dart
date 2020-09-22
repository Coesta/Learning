import 'package:equatable/equatable.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/entities/movie.dart';

class PopularMovies extends Equatable {
  final int page;
  final List<Movie> movies;

  PopularMovies([
    this.page,
    this.movies = const [],
  ]);

  @override
  List<Object> get props => [
        page,
        movies,
      ];
}
