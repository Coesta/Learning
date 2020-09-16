import 'dart:convert';

import 'package:flutter/foundation.dart';
import 'package:simple_tmdb_app/models/movie.dart';
import 'package:simple_tmdb_app/models/popular_movies.dart';
import 'package:http/http.dart' as http;
import 'package:simple_tmdb_app/utils/constants.dart';

class Movies with ChangeNotifier {
  PopularMovies _popularMovies = PopularMovies();

  List<Movie> get popularMovies => _popularMovies.results;
  int get itemsCount => popularMovies.length;

  Future<void> loadMovies() async {
    _popularMovies = PopularMovies();

    final String baseUrl = Constants.BASE_API_URL;
    final String query = Constants.MOST_POPULAR_MOVIES;
    final String key = Constants.API_KEY;
    final url = "$baseUrl$query$key";

    final response = await http.get(url);
    final Map<String, dynamic> data = json.decode(response.body);
    data.forEach((key, value) {
      _popularMovies.page = data['page'];

      List<Movie> results = [];

      data['results'].forEach((element) {
        results.add(
          Movie(
            title: element['title'],
            overview: element['overview'],
            releaseDate: element['release_date'],
            backdropPath: element['backdrop_path'],
            voteAverage: element['vote_average'].toString(),
          ),
        );
      });

      _popularMovies.results = results;
    });

    notifyListeners();
  }
}
