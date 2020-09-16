import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:simple_tmdb_app/providers/movies.dart';
import 'package:simple_tmdb_app/widgets/movie_item.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Most Popular Movies'),
      ),
      body: SafeArea(
        child: FutureBuilder(
          future: Provider.of<Movies>(context, listen: false).loadMovies(),
          builder: (context, snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
              return Center(child: CircularProgressIndicator());
            } else if (snapshot.error != null) {
              return Center(
                  child: Text("Ocorreu um erro ao carregar os filmes"));
            } else {
              return Consumer<Movies>(
                builder: (context, movies, child) {
                  return ListView.builder(
                    itemCount: movies.itemsCount,
                    itemBuilder: (context, index) => MovieItem(
                      key: ValueKey(movies.popularMovies[index].id),
                      movie: movies.popularMovies[index],
                    ),
                  );
                },
              );
            }
          },
        ),
      ),
    );
  }
}
