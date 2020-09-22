part of 'home_controller_cubit.dart';

abstract class HomeControllerState extends Equatable {
  const HomeControllerState();
}

class HomeControllerInitial extends HomeControllerState {
  @override
  List<Object> get props => [];
}

class HomeLoadingState extends HomeControllerState {
  const HomeLoadingState();
  @override
  List<Object> get props => [];
}

class HomeSuccessLoaded extends HomeControllerState {
  final PopularMovies popularMovies;

  const HomeSuccessLoaded({@required this.popularMovies});
  @override
  List<Object> get props => [popularMovies];
}

class HomeErrorLoaded extends HomeControllerState {
  final String message;

  const HomeErrorLoaded({@required this.message});
  @override
  List<Object> get props => [message];
}
