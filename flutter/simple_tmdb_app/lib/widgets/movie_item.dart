import 'package:flutter/material.dart';
import 'package:simple_tmdb_app/models/movie.dart';
import 'package:simple_tmdb_app/utils/app_routes.dart';
import 'package:simple_tmdb_app/utils/constants.dart';

class MovieItem extends StatelessWidget {
  final Movie movie;

  const MovieItem({Key key, this.movie}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: InkWell(
        onTap: () => Navigator.of(context)
            .pushNamed(AppRoutes.MOVIE_DETAIL, arguments: movie),
        child: Column(
          children: [
            Image.network(
                "${Constants.BASE_API_URL_IMAGES}${movie.backdropPath}"),
            ListTile(
              title: Text(movie.title),
            ),
          ],
        ),
      ),
    );
  }
}
