import 'package:dartz/dartz.dart';
import 'package:simple_tmdb_app_with_cubit/app/core/errors/failures/failure.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/entities/popular_movies.dart';

abstract class HomeRepositoryInterface {
  Future<Either<Failure, PopularMovies>> getPopularMovies();
}
