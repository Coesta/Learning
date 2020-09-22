import 'package:dio/dio.dart';
import 'package:meta/meta.dart';
import 'package:simple_tmdb_app_with_cubit/app/core/utils/constants.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/data/models/movie_model.dart';

import 'package:simple_tmdb_app_with_cubit/app/modules/home/data/models/popular_movies.dart';

abstract class HomeDataSourceInterface {
  Future<PopularMoviesModel> fetchPopularMovies();
}

class HomeDataSourceImpl implements HomeDataSourceInterface {
  final Dio dio;

  HomeDataSourceImpl({@required this.dio});

  @override
  Future<PopularMoviesModel> fetchPopularMovies() async {
    try {
      final String baseUrl = Constants.BASE_API_URL;
      final String query = Constants.MOST_POPULAR_MOVIES;
      final String key = Constants.API_KEY;
      final url = "$baseUrl$query$key";

      print(url);

      final response = await dio.get(url);

      final page = response.data['page'];
      final totalResults = response.data['total_results'];
      final totalPages = response.data['total_pages'];
      final results = List<MovieModel>.of(
        response.data['results'].map<MovieModel>(
          (json) => MovieModel.fromMap(json),
        ),
      );

      final popularMovies = PopularMoviesModel(
        page: page,
        totalResults: totalResults,
        totalPages: totalPages,
        movies: results,
      );

      return popularMovies;
    } catch (error) {
      throw Exception("Error on fecht popular movies: ${error.toString()}");
    }
  }
}
