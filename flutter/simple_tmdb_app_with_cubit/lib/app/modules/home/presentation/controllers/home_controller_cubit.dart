import 'package:bloc/bloc.dart';
import 'package:equatable/equatable.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/entities/popular_movies.dart';
import 'package:meta/meta.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/usecases/get_popular_movies.dart';

part 'home_controller_state.dart';

class HomeControllerCubit extends Cubit<HomeControllerState> {
  // uses cases
  final GetPopularMovies getPopularMovies;

  HomeControllerCubit({@required this.getPopularMovies})
      : super(HomeControllerInitial());

  void fetchPopularMovies() async {
    try {
      emit(HomeLoadingState());
      var _fetchedPopularMovies = await getPopularMovies.execute();
      _fetchedPopularMovies.fold(
        (failure) =>
            emit(HomeErrorLoaded(message: "Erro ao tentar buscar a lista")),
        (success) => emit(HomeSuccessLoaded(popularMovies: success)),
      );
    } catch (erro) {
      emit(
        HomeErrorLoaded(message: "Erro ao tentar buscar a lista"),
      );
    }
  }
}
