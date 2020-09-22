import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/presentation/controllers/home_controller_cubit.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/presentation/widgets/movie_item.dart';

class HomePage extends StatefulWidget {
  final HomeControllerCubit controller;

  const HomePage({Key key, this.controller}) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  void initState() {
    widget.controller.fetchPopularMovies();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Most Popular Movies'),
      ),
      body: SafeArea(
        child: BlocBuilder<HomeControllerCubit, HomeControllerState>(
          cubit: widget.controller,
          builder: (context, state) {
            if (state is HomeLoadingState) {
              return Center(child: CircularProgressIndicator());
            }
            if (state is HomeErrorLoaded) {
              return Container(
                child: Column(
                  children: [
                    Text(state.message),
                    RaisedButton(
                      color: Colors.red[200],
                      child: Text(
                        "Tentar novamente",
                        style: TextStyle(
                          color: Colors.white,
                        ),
                      ),
                      onPressed: () => widget.controller.getPopularMovies,
                    ),
                  ],
                ),
              );
            }
            if (state is HomeSuccessLoaded) {
              final movies = state.popularMovies.movies;
              return ListView.builder(
                itemCount: movies.length,
                itemBuilder: (context, index) => MovieItem(
                  key: ValueKey(movies[index].id),
                  movie: movies[index],
                ),
              );
            }
          },
        ),
      ),
    );
  }
}
