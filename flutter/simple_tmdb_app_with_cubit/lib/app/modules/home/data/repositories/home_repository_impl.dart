import 'package:dartz/dartz.dart';
import 'package:meta/meta.dart';
import 'package:simple_tmdb_app_with_cubit/app/core/errors/failures/failure.dart';

import 'package:simple_tmdb_app_with_cubit/app/modules/home/data/datasources/home_datasource.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/entities/popular_movies.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/repositories/home_repository_interface.dart';

class HomeRepositoryImpl implements HomeRepositoryInterface {
  final HomeDataSourceInterface homeDataSource;

  HomeRepositoryImpl({@required this.homeDataSource});

  @override
  Future<Either<Failure, PopularMovies>> getPopularMovies() async {
    try {
      PopularMovies fetchedPopularMovies =
          await homeDataSource.fetchPopularMovies();
      return Right(fetchedPopularMovies);
    } on Exception {
      return Left(null);
    }
  }
}
