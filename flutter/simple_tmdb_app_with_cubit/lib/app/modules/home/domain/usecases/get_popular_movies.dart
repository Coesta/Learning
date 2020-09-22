import 'package:dartz/dartz.dart';
import 'package:simple_tmdb_app_with_cubit/app/core/errors/failures/failure.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/entities/popular_movies.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/repositories/home_repository_interface.dart';
import 'package:meta/meta.dart';

class GetPopularMovies {
  final HomeRepositoryInterface repository;

  GetPopularMovies({@required this.repository});

  Future<Either<Failure, PopularMovies>> execute() {
    return repository.getPopularMovies();
  }
}
