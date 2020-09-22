import 'package:meta/meta.dart';
import 'dart:convert';

import 'package:simple_tmdb_app_with_cubit/app/modules/home/data/models/movie_model.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/entities/popular_movies.dart';

class PopularMoviesModel extends PopularMovies {
  PopularMoviesModel({
    @required this.page,
    @required this.totalResults,
    @required this.totalPages,
    @required this.movies,
  });

  final int page;
  final int totalResults;
  final int totalPages;
  final List<MovieModel> movies;

  PopularMoviesModel copyWith({
    int page,
    int totalResults,
    int totalPages,
    List<MovieModel> movies,
  }) =>
      PopularMoviesModel(
        page: page ?? this.page,
        totalResults: totalResults ?? this.totalResults,
        totalPages: totalPages ?? this.totalPages,
        movies: movies ?? this.movies,
      );

  factory PopularMoviesModel.fromJson(String str) =>
      PopularMoviesModel.fromMap(json.decode(str));

  String toJson() => json.encode(toMap());

  factory PopularMoviesModel.fromMap(Map<String, dynamic> json) =>
      PopularMoviesModel(
        page: json["page"],
        totalResults: json["total_results"],
        totalPages: json["total_pages"],
        movies: List<MovieModel>.from(
            json["movies"].map((x) => MovieModel.fromMap(x))),
      );

  Map<String, dynamic> toMap() => {
        "page": page,
        "total_results": totalResults,
        "total_pages": totalPages,
        "movies": List<dynamic>.from(movies.map((x) => x.toMap())),
      };

  @override
  List<Object> get props => [
        page,
        totalResults,
        totalPages,
        movies,
      ];
}
